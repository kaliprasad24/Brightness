package com.example.brightness;

import androidx.appcompat.app.AppCompatActivity;
import com.example.brightness.MyObserver;

import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    MyObserver yourObserver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.b);


        Handler handler = new Handler();


        yourObserver = new MyObserver(handler,this,textView);

        getContentResolver().
                registerContentObserver(
                        Settings.System.getUriFor(Settings.System.SCREEN_BRIGHTNESS),
                        true,
                        yourObserver);
        String brightnes = String.valueOf(Settings.System.getInt(this.getContentResolver(),
                Settings.System.SCREEN_BRIGHTNESS, -1));
        textView.setText(brightnes);


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        getContentResolver().
                unregisterContentObserver(yourObserver);

    }
}