package com.match.schedulingassistant.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import com.match.schedulingassistant.R;

public class StartActivity extends Activity {

    private ListView schedulingFiles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        schedulingFiles = findViewById(R.id.scheduling_file_list);


    }
}