package com.example.brightness;


import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.provider.Settings;
import android.widget.TextView;

class MyObserver extends ContentObserver {

    private final Context context;
    private TextView textView;

    public MyObserver(Handler handler, Context context, TextView textView) {
        super(handler);
        this.context = context;
        this.textView = textView;
    }






    @Override
    public void onChange(boolean selfChange, Uri uri) {
        // do s.th.
        // depending on the handler you might be on the UI
        // thread, so be cautious!
        String brightnes = String.valueOf(Settings.System.getInt(context.getContentResolver(),
                Settings.System.SCREEN_BRIGHTNESS, -1));
        textView.setText(brightnes);


    }
}
