package com.sudoajay.a9xplayer;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.util.Log;
import android.widget.Toast;

import java.io.InputStream;

public class Grab_The_Cover {
    private Context mContext;
    public Grab_The_Cover(Context mContext){
        this.mContext = mContext;
    }

    public Bitmap Get_Audio_Album_Image_ContentUri(long song_Id,int max_Size) {
        try {
            Uri sArtworkUri = Uri.parse("content://media/external/audio/albumart");
            Uri uri = ContentUris.withAppendedId(sArtworkUri, song_Id);
            ContentResolver res = mContext.getContentResolver();
            InputStream in = res.openInputStream(uri);
            return getResizedBitmap(BitmapFactory.decodeStream(in), max_Size);

        } catch (Exception e){
            Log.e("Exception",e.getMessage());
        }
        return null;
    }
    public Bitmap getResizedBitmap(Bitmap image, int maxSize) {
        int width = image.getWidth();
        int height = image.getHeight();

        float bitmapRatio = (float)width / (float) height;
        if (bitmapRatio > 1) {
            width = maxSize;
            height = (int) (width / bitmapRatio);
        } else {
            height = maxSize;
            width = (int) (height * bitmapRatio);
        }

        return Bitmap.createScaledBitmap(image, width, height, true);
    }

}
