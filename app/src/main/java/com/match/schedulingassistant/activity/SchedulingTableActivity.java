package com.match.schedulingassistant.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.bin.david.form.annotation.SmartTable;
import com.match.schedulingassistant.R;

public class SchedulingTableActivity extends AppCompatActivity {

    SmartTable smartTable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scheduling_table);

        smartTable = findViewById(R.id.scheduling_table);
    }
}