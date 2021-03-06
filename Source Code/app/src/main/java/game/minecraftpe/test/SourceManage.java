package game.minecraftpe.test;

import android.app.*;
import android.content.*;
import android.net.*;
import android.text.*;
import java.io.*;
import java.util.*;
import android.util.*;

public class SourceManage
{
    private IOTool io = new IOTool();
    private Context ctx;

    public void add(Context ctx, String str)
    {
        this.ctx = ctx;
        try
        {
            String[] list_file = ctx.getAssets().list("Source");
            for (int i = 0;i < list_file.length ;i++)
            {
                if (list_file.length == 0)
                {
                    break;
                }
                if (!io.unZip(ctx,"Source"+"/"+list_file[i],str))
                {
                    io.show(ctx,ctx.getString(R.string.file_no_export));
                    break;
                }
                else
                {
                    io.show(ctx,ctx.getString(R.string.source_export_ok));
                }
            }
        }
        catch (IOException e)
        {
            io.show(ctx, ctx.getString(R.string.file_no_found));
        }
    }
    
}
