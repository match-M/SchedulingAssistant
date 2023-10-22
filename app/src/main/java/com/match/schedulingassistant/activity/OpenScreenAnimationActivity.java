package com.match.schedulingassistant.activity;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.match.schedulingassistant.R;

public class OpenScreenAnimationActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_screen_animation);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        startActivity(new Intent(OpenScreenAnimationActivity.this, StartActivity.class));
    }
}