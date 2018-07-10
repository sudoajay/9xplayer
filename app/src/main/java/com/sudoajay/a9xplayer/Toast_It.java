package com.sudoajay.a9xplayer;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

public class Toast_It {
    private Toast toast;
    public  Toast_It(String message , Context context , Toast toast_TextView , View layout) {
        if (toast == null || toast.getView().getWindowVisibility() != View.VISIBLE) {
            toast = new Toast(context);
            toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
            toast.setDuration(Toast.LENGTH_LONG);
            toast.setView(layout);
            toast_TextView.setText(message);
            toast.show();
        } else {
            toast.cancel();
        }

    }
}
