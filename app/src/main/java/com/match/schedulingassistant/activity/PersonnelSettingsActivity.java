package com.match.schedulingassistant.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.match.schedulingassistant.R;
import com.match.schedulingassistant.api.presenter.IPersonnelSettingsPresenter;
import com.match.schedulingassistant.api.view.IPersonnelSettingsView;
import com.match.schedulingassistant.presenter.PersonnelSettingsPresenter;
import com.match.schedulingassistant.scheduling.Scheduling;

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
    private Button selectSaveFileBtn;
    private ListView peopleList;
    private RadioGroup radioGroup;
    private RadioButton saveMemberBtn;
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
        radioGroup = findViewById(R.id.radio_group);
        saveMemberBtn = findViewById(R.id.save_member_btn);
        selectSaveFileBtn = findViewById(R.id.select_save_file_btn);

        //绑定监听事件
        addPeopleBtn.setOnClickListener(this);
        finishBtn.setOnClickListener(this);
        cancelBtn.setOnClickListener(this);
        saveMemberBtn.setOnClickListener(this);
        selectSaveFileBtn.setOnClickListener(this);

        iPersonnelSettingsPresenter = new PersonnelSettingsPresenter(
                PersonnelSettingsActivity.this,
                PersonnelSettingsActivity.this);

        //listView长按事件
        peopleList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                showPopupMenu(view, position);
                return true;
            }
        });

    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        if(id == R.id.add_btn){
            String name = String.valueOf(addPeopleEt.getText()); //获取输入的名字
            iPersonnelSettingsPresenter.doAdd(name);
        }

        if(radioGroup.getCheckedRadioButtonId() == R.id.save_member_btn && id == R.id.finish_btn){
            iPersonnelSettingsPresenter.doSave();
        }

        if(id == R.id.finish_btn){
            iPersonnelSettingsPresenter.doFinish();
        }

        if(id == R.id.select_save_file_btn){
            iPersonnelSettingsPresenter.selectSaveMemberFile();
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

    /**
     * 显示长按菜单
     */
    @Override
    public void showPopupMenu(View view, int position) {
        //定义PopupMenu对象
        PopupMenu popupMenu = new PopupMenu(PersonnelSettingsActivity.this.getApplicationContext(),
                view);
        //设置PopupMenu对象的布局
        popupMenu.getMenuInflater().inflate(R.menu.list_item_menu, popupMenu.getMenu());
        //设置PopupMenu的点击事件
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                //删除成员
                iPersonnelSettingsPresenter.doDelete(position);
                return true;
            }
        });

        //显示菜单
        popupMenu.show();
    }

    @Override
    public void finishAndGoNext(Scheduling scheduling){
        Bundle bundle = new Bundle();
        Intent intent = new Intent(PersonnelSettingsActivity.this,
                SchedulingTableActivity.class);
        bundle.putSerializable("scheduling", scheduling);
        intent.putExtras(bundle);
        startActivity(intent);
        finish(); //结束这个Activity
    }

    /**
     * 取消
     */
    @Override
    public void cancel() {
        startActivity(new Intent(PersonnelSettingsActivity.this,
                RuleSettingActivity.class));
        finish();
    }
}