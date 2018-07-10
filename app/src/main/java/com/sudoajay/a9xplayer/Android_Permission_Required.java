package com.sudoajay.a9xplayer;

import android.Manifest;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.Button;
import android.support.v7.widget.Toolbar;

public class Android_Permission_Required {

    private final int My_Permission_Request = 1;
    private Context context;
    private Activity activity;
    private Handler handler;
    private Toolbar bottom_Toolbar;
    public Android_Permission_Required( Toolbar bottom_Toolbar){
       this.bottom_Toolbar=bottom_Toolbar;
    }

    //  Get permission
    private   void Storage_Permission_Granted() {
        if (Build.VERSION.SDK_INT >= 23) {
            if (ContextCompat.checkSelfPermission(context,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                if (ActivityCompat.shouldShowRequestPermissionRationale(activity,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE)) {

                    ActivityCompat.requestPermissions(activity,
                            new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, My_Permission_Request);

                } else {

                    ActivityCompat.requestPermissions(activity,
                            new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, My_Permission_Request);


                }
            }

        }
    }
    // call after 1800 ms
    public void call_Thread(){
        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
               Call_Custom_Permission_Dailog();

            }
        },600);
    }
    private void Call_Custom_Permission_Dailog() {
        final Dialog dialog = new Dialog(context);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.activity_custom_dialog_permission);
        Button button_Learn_More = dialog.findViewById(R.id.learn_More_button);
        Button button_Continue = dialog.findViewById(R.id.continue_Button);
        // if button is clicked, close the custom dialog

        button_Learn_More.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String url = "https://developer.android.com/training/permissions/requesting.html";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                activity.startActivity(i);

            }
        });
        button_Continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Storage_Permission_Granted();
                dialog.dismiss();
            }
        });

        dialog.show();
    }

    public boolean isExternalStorageWritable() {
        String permission = Manifest.permission.READ_EXTERNAL_STORAGE;
        int res = activity.checkCallingOrSelfPermission(permission);
        return (res == PackageManager.PERMISSION_GRANTED);
    }

}
