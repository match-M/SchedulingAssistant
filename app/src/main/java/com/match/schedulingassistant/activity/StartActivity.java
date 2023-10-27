package com.match.schedulingassistant.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.view.View;
import android.widget.Toast;

import androidx.fragment.app.DialogFragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.match.schedulingassistant.R;
import com.match.schedulingassistant.api.presenter.IStartPresenter;
import com.match.schedulingassistant.dialog.CreateSchedulingFileDialog;
import com.match.schedulingassistant.file.FileBasicOperations;
import com.match.schedulingassistant.file.SchedulingFileResolver;
import com.match.schedulingassistant.permission.Permission;
import com.match.schedulingassistant.api.view.IStartView;
import com.match.schedulingassistant.presenter.StartPresenter;

public class StartActivity extends Activity implements IStartView, View.OnClickListener {
    private ListView schedulingFiles;
    private FloatingActionButton addSchedulingFile;

    private IStartPresenter startPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        //初始化
        this.schedulingFiles = findViewById(R.id.scheduling_file_list);
        this.addSchedulingFile = findViewById(R.id.new_scheduling_file_fab);
        this.startPresenter = new StartPresenter(this, this);
        new Permission().applyForPermission(this); //申请权限

        //绑定点击事件
        this.addSchedulingFile.setOnClickListener(this);

        //获取历史排班文件
        this.startPresenter.getSchedulingFileList();

    }

    /**
     * 添加排班文件
     * @param result ture-创建成功， false-创建失败
     */
    @Override
    public void addSchedulingFile(boolean result) {
        this.startPresenter.getSchedulingFileList(); //更新文件列表
        if(result){
            Toast.makeText(StartActivity.this, this.getString(R.string.create_success)
                    , Toast.LENGTH_SHORT).show();
            //跳转到设置页
            this.startActivity(new Intent(StartActivity.this, RuleSettingActivity.class));
            return;
        }
        Toast.makeText(StartActivity.this,  this.getString(R.string.create_fail)
                , Toast.LENGTH_SHORT).show();

    }

    /**
     * 更新排班文件列表
     * @param arrayAdapter listview适配器
     */
    @Override
    public void updateSchedulingFileList(ArrayAdapter<String> arrayAdapter) {
        this.schedulingFiles.setAdapter(arrayAdapter);
    }

    @Override
    public void onClick(View view) {
        //根据id来判断
        if(view.getId() == R.id.new_scheduling_file_fab){
            //打开对话框
            new CreateSchedulingFileDialog()
                    .inputFileNameDialog(this, this.startPresenter).show();
        }
    }
}