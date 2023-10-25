package com.match.schedulingassistant.activity;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.match.schedulingassistant.R;
import com.match.schedulingassistant.permission.Permission;

public class OpenScreenAnimationActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_screen_animation);

    }

    @Override
    protected void onResume() {
        super.onResume();
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        startActivity(new Intent(OpenScreenAnimationActivity.this, StartActivity.class));
    }
}