package com.match.schedulingassistant.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.match.schedulingassistant.R;
import com.match.schedulingassistant.api.presenter.IStartPresenter;
import com.match.schedulingassistant.file.FileBasicOperations;
import com.match.schedulingassistant.file.SchedulingFileResolver;
import com.match.schedulingassistant.permission.Permission;
import com.match.schedulingassistant.api.view.IStartView;
import com.match.schedulingassistant.presenter.StartPresenter;

public class StartActivity extends Activity implements IStartView, View.OnClickListener {
    private ListView schedulingFiles;
    private FloatingActionButton addSchedulingFile;

    private IStartPresenter startPresenter;
    private ArrayAdapter<String> fileLists;
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
     * 新建排班文件
     *
     * @param fileName 排班文件名字
     */
    @Override
    public void newSchedulingFile(String fileName) {
        //this.fileResolver.open(fileName); //打开文件
    }


    /**
     * 更新排班文件列表
     * @param arrayAdapter listview适配器
     */
    @Override
    public void updateSchedulingFileList(ArrayAdapter<String> arrayAdapter) {
        this.fileLists = arrayAdapter;
        this.schedulingFiles.setAdapter(arrayAdapter);
    }

    @Override
    public void onClick(View view) {
        //根据id来判断
        if(view.getId() == R.id.new_scheduling_file_fab){

        }
    }
}