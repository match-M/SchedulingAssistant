package com.match.schedulingassistant.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.match.schedulingassistant.R;
import com.match.schedulingassistant.api.presenter.IRuleSettingPresenter;
import com.match.schedulingassistant.api.view.IRuleSettingView;
import com.match.schedulingassistant.file.FileInfo;
import com.match.schedulingassistant.file.SchedulingFileResolver;
import com.match.schedulingassistant.presenter.RuleSettingPresenter;

public class RuleSettingActivity extends Activity implements View.OnClickListener, IRuleSettingView {


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

    private Button nextBtn;
    private Button cancelBtn;

    private RadioButton saveFileBtn;
    private RadioGroup saveFileBtnGroup;


    private IRuleSettingPresenter ruleSettingPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rule_setting);

        //初始化

        this.ruleSettingPresenter = new RuleSettingPresenter(RuleSettingActivity.this,
                RuleSettingActivity.this);

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

        this.nextBtn = findViewById(R.id.next_btn);
        this.cancelBtn = findViewById(R.id.cancel_btn);

        this.saveFileBtnGroup = findViewById(R.id.save_file_btn_group);
        this.saveFileBtn = findViewById(R.id.save_file_btn);


        //绑定事件
        this.cancelBtn.setOnClickListener(this);

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


        this.nextBtn.setOnClickListener(this);
        this.cancelBtn.setOnClickListener(this);


    }
    //按钮点击事件
    @Override
    public void onClick(View view) {
        int id = view.getId();
        //设置各项检查的需要的楼层数
        if (id == R.id.morning_floor_btn || id == R.id.afternoon_floor_btn ||
                id == R.id.night_floor_btn || id == R.id.night_4_floor_btn) {
            this.ruleSettingPresenter.setFloor(id, view);
        }
        //设置各项检查的人数
        if (id == R.id.morning_people_btn || id == R.id.afternoon_people_btn ||
                id == R.id.night_people_btn || id == R.id.night_4_people_btn) {
            this.ruleSettingPresenter.setPeople(id, view);
        }
        //设置各项检查需要检查的天数
        if (id == R.id.morning_days_btn || id == R.id.afternoon_days_btn ||
                id == R.id.night_days_btn || id == R.id.night_4_days_btn) {
            this.ruleSettingPresenter.setDays(id, view);
        }
        //设置各项检查的开始日期
        if (id == R.id.morning_start_position_btn || id == R.id.afternoon_start_position_btn ||
                id == R.id.night_start_position_btn || id == R.id.night_4_start_position_btn) {
            this.ruleSettingPresenter.setStartPosition(id, view);
        }
        //设置一个人一天最多的班数
        if (id == R.id.not_more_than_btn) {
            this.ruleSettingPresenter.setMaxAttendance(id, view);
        }
        //使用已保存的规则
        if (id == R.id.select_file_btn){
            this.ruleSettingPresenter.selectSaveRule();
        }
        //勾选了保存选项并点击了下一步
        if(saveFileBtnGroup.getCheckedRadioButtonId() == R.id.save_file_btn &&
                id == R.id.next_btn){
            this.ruleSettingPresenter.doSave();
        }
        //取消返回开始页面
        if (id == R.id.cancel_btn){
            this.ruleSettingPresenter.doCancel();
            startActivity(new Intent(RuleSettingActivity.this, StartActivity.class));
        }
        //单点击了下一步
        if (id == R.id.next_btn){
            this.goNext();
        }


    }

    @Override
    public void goNext() {
        startActivity(new Intent(RuleSettingActivity.this,
                PersonnelSettingsActivity.class));
    }

    /**
     * @param isDelete true-文件删除成功，false-文件删除失败
     */
    @Override
    public void cancel(boolean isDelete) {
        String result = "相关文件删除失败";
        if(isDelete) result = "相关文件已为您删除";
        Toast.makeText(RuleSettingActivity.this,
                result, Toast.LENGTH_LONG).show();
    }


}