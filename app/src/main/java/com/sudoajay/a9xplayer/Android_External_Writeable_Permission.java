package com.sudoajay.a9xplayer;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;

import java.io.File;

public class Android_External_Writeable_Permission {
    private Uri sdCard_Uri;
    private Activity activity;
    private Context context;
    private String sd_Card_Path_URL = "",string_URI;
    private final int REQUEST_CODE_OPEN_DOCUMENT_TREE =42;
    private Sd_Card_DataBase sd_card_dataBase;
    private Handler handler;

    public Android_External_Writeable_Permission(Activity activity , Context context){
        this.context = context;
        this.activity=activity;
        Grab();
        if(isGetting())
           call_Thread();

    }

    public void call_Thread(){
        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                    Call_Custom_Dailog_Changes();


            }
        },1800);
    }
    public void Storage_Access_FrameWork(){
        final Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT_TREE);
        activity.startActivityForResult(intent, REQUEST_CODE_OPEN_DOCUMENT_TREE);

    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode != activity.RESULT_OK)
            return;
        sdCard_Uri = data.getData();
        activity.grantUriPermission(activity.getPackageName(), sdCard_Uri, Intent.FLAG_GRANT_READ_URI_PERMISSION | Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
        activity.getContentResolver().takePersistableUriPermission(sdCard_Uri, Intent.FLAG_GRANT_READ_URI_PERMISSION | Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
        sd_Card_Path_URL = Sd_Card_Path.getFullPathFromTreeUri(sdCard_Uri,context);
        if(sd_card_dataBase.check_For_Empty()) {
            sd_card_dataBase.Fill_It(sd_Card_Path_URL,sdCard_Uri.toString());
        }else {
            sd_card_dataBase.Update_The_Table("1",sd_Card_Path_URL , sdCard_Uri.toString());
        }
        File file = new File(sd_Card_Path_URL);
        if(!isGetting()){
            string_URI  = Split_The_URI(sdCard_Uri.toString());
        }

    }
    public String Split_The_URI(String url){
        String save[] = url.split("%3A");
        return save[0]+"%3A";
    }
    public void Call_Custom_Dailog_Changes() {

        FragmentTransaction ft = ((FragmentActivity)activity).getSupportFragmentManager().beginTransaction();
        Sd_Card_dialog sd_card_dialog=new Sd_Card_dialog(this);

        sd_card_dialog.show(ft, "dialog");

    }
    public boolean isGetting(){
        Log.i("Get" , ""+sd_Card_Path_URL + " asdasdasd");
        return (sd_Card_Path_URL.equals(Environment.getExternalStorageDirectory().getAbsolutePath())) || (!new File(sd_Card_Path_URL).exists());
    }
    public void Grab(){
        sd_card_dataBase = new Sd_Card_DataBase(context);
        if(!sd_card_dataBase.check_For_Empty()){
            Cursor cursor= sd_card_dataBase.Get_All_Data();
            cursor.moveToNext();
            sd_Card_Path_URL = cursor.getString(1);
            string_URI =cursor.getString(2);
        }
    }

    public String getSd_Card_Path_URL() {
        return sd_Card_Path_URL;
    }
}
