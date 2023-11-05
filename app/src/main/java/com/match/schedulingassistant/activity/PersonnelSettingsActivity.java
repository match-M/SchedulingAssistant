package com.match.schedulingassistant.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;

import com.match.schedulingassistant.R;
import com.match.schedulingassistant.api.presenter.IPersonnelSettingsPresenter;
import com.match.schedulingassistant.api.view.IPersonnelSettingsView;
import com.match.schedulingassistant.presenter.PersonnelSettingsPresenter;
import com.match.schedulingassistant.presenter.RuleSettingPresenter;

/**
 * 人员设置
 * @author match
 */
public class PersonnelSettingsActivity extends Activity implements View.OnClickListener,
        IPersonnelSettingsView {

    private EditText addPeopleEt;
    private Button addPeopleBtn;
    private Button finishBtn;
    private Button cancelBtn;
    private ListView peopleList;
    private IPersonnelSettingsPresenter iPersonnelSettingsPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personnel_settings);

        //绑定控件
        addPeopleEt = findViewById(R.id.input_name);
        addPeopleBtn = findViewById(R.id.add_btn);
        finishBtn = findViewById(R.id.finish_btn);
        peopleList = findViewById(R.id.people_list);
        cancelBtn = findViewById(R.id.cancel_btn);

        //绑定监听事件
        addPeopleBtn.setOnClickListener(this);
        finishBtn.setOnClickListener(this);
        cancelBtn.setOnClickListener(this);

        iPersonnelSettingsPresenter = new PersonnelSettingsPresenter(
                PersonnelSettingsActivity.this,
                PersonnelSettingsActivity.this);
    }




    @Override
    public void onClick(View view) {
        int id = view.getId();

        if(id == R.id.add_btn){
            String name = String.valueOf(addPeopleEt.getText()); //获取输入的名字
            iPersonnelSettingsPresenter.doAdd(name);

        }

        if(id == R.id.finish_btn){
            Toast.makeText(PersonnelSettingsActivity.this, "ok", Toast.LENGTH_SHORT).show();
        }
        if(id == R.id.cancel_btn){
            this.cancel();
        }
    }

    /**
     * 添加人员
     *
     * @param isSuccess ture-添加成功，false-添加失败
     */
    @Override
    public void addPeople(boolean isSuccess) {
        String result = getString(R.string.add_fail);
        if(isSuccess){
            result = getString(R.string.add_success);
            addPeopleEt.setText(""); //清除上次输入的内容
        }
        Toast.makeText(PersonnelSettingsActivity.this, result, Toast.LENGTH_SHORT).show();

    }

    /**
     * 更新人员列表
     *
     * @param arrayAdapter 列表数据
     */
    @Override
    public void upPeopleList(ArrayAdapter<String> arrayAdapter) {
        this.peopleList.setAdapter(arrayAdapter);
    }

    @Override
    public void finish(){

    }

    /**
     * 取消
     */
    @Override
    public void cancel() {
        startActivity(new Intent(PersonnelSettingsActivity.this, RuleSettingActivity.class));
    }
}