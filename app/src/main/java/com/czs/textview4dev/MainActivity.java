package com.czs.textview4dev;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.czs.textview4dev.widget.TextView4Dev;

public class MainActivity extends AppCompatActivity
{

    private TextView4Dev textView4Dev;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView4Dev = new TextView4Dev(this);
    }

    public void go(View view)
    {
        startActivity(new Intent(MainActivity.this, Main2Activity.class));
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
        {
            if (Settings.canDrawOverlays(this))
            {
                textView4Dev.hideInfoText();
            } else
            {

            }
        } else
        {
            textView4Dev.hideInfoText();
        }
    }
}
