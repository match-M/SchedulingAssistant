package com.match.schedulingassistant.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

import com.match.schedulingassistant.R;

public class RuleSettingActivity extends Activity implements View.OnClickListener {


    private Button selectFileBtn;
    private Button morningDaysBtn;
    private Button morningFloorBtn;
    private Button morningPeopleBtn;
    private Button morningStartPositionBtn;

    private Button afternoonDaysBtn;
    private Button afternoonFloorBtn;
    private Button afternoonPeopleBtn;
    private Button afternoonStartPositionBtn;

    private Button nightDaysBtn;
    private Button nightFloorBtn;
    private Button nightPeopleBtn;
    private Button nightStartPositionBtn;

    private Button night_4_daysBtn;
    private Button night_4_floorBtn;
    private Button night_4_peopleBtn;
    private Button night_4_startPositionBtn;

    private Button notMoreThanBtn;

    private RadioButton useSaveRule;
    private RadioButton createRule;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rule_setting);

        //绑定按钮
        this.selectFileBtn = findViewById(R.id.select_file_btn);

        this.morningDaysBtn = findViewById(R.id.morning_days_btn);
        this.morningFloorBtn = findViewById(R.id.morning_floor_btn);
        this.morningPeopleBtn = findViewById(R.id.morning_people_btn);
        this.morningStartPositionBtn = findViewById(R.id.morning_start_position_btn);

        this.afternoonDaysBtn = findViewById(R.id.afternoon_days_btn);
        this.afternoonFloorBtn = findViewById(R.id.afternoon_floor_btn);
        this.afternoonPeopleBtn = findViewById(R.id.afternoon_people_btn);
        this.afternoonStartPositionBtn = findViewById(R.id.afternoon_start_position_btn);

        this.nightDaysBtn = findViewById(R.id.night_days_btn);
        this.nightFloorBtn = findViewById(R.id.night_floor_btn);
        this.nightPeopleBtn = findViewById(R.id.night_people_btn);
        this.nightStartPositionBtn = findViewById(R.id.night_start_position_btn);

        this.night_4_daysBtn = findViewById(R.id.night_4_days_btn);
        this.night_4_floorBtn = findViewById(R.id.night_4_floor_btn);
        this.night_4_peopleBtn = findViewById(R.id.night_4_people_btn);
        this.night_4_startPositionBtn = findViewById(R.id.night_4_start_position_btn);

        this.notMoreThanBtn = findViewById(R.id.not_more_than_btn);

        this.useSaveRule = findViewById(R.id.use_save_rule);
        this.createRule = findViewById(R.id.create_rule);

        //绑定事件
        this.selectFileBtn.setOnClickListener(this);

        this.morningDaysBtn.setOnClickListener(this);
        this.morningFloorBtn.setOnClickListener(this);
        this.morningPeopleBtn.setOnClickListener(this);
        this.morningStartPositionBtn.setOnClickListener(this);

        this.afternoonDaysBtn.setOnClickListener(this);
        this.afternoonFloorBtn.setOnClickListener(this);
        this.afternoonPeopleBtn.setOnClickListener(this);
        this.afternoonStartPositionBtn.setOnClickListener(this);

        this.nightDaysBtn.setOnClickListener(this);
        this.nightFloorBtn.setOnClickListener(this);
        this.nightPeopleBtn.setOnClickListener(this);
        this.nightStartPositionBtn.setOnClickListener(this);

        this.night_4_daysBtn.setOnClickListener(this);
        this.night_4_floorBtn.setOnClickListener(this);
        this.night_4_peopleBtn.setOnClickListener(this);
        this.night_4_startPositionBtn.setOnClickListener(this);

        this.notMoreThanBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        

    }
}