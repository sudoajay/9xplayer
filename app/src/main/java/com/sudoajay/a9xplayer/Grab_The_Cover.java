package com.sudoajay.a9xplayer;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.util.Log;
import java.io.InputStream;

public class Grab_The_Cover {
    private Context mContext;
    public Grab_The_Cover(Context mContext){
        this.mContext = mContext;
    }

    public Bitmap Get_Audio_Album_Image_ContentUri(long song_Id) {
        try {
            Uri sArtworkUri = Uri.parse("content://media/external/audio/albumart");
            Uri uri = ContentUris.withAppendedId(sArtworkUri, song_Id);
            ContentResolver res = mContext.getContentResolver();
            InputStream in = res.openInputStream(uri);
            return BitmapFactory.decodeStream(in);

        } catch (Exception e){
            Log.e("Exception",e.getMessage());
        }
        return null;
    }
}
