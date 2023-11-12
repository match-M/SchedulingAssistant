package com.match.schedulingassistant.presenter;

import android.app.Activity;
import android.content.Intent;
import android.widget.ArrayAdapter;

import com.match.schedulingassistant.activity.RuleSettingActivity;
import com.match.schedulingassistant.activity.StartActivity;
import com.match.schedulingassistant.adapter.list.SchedulingFileListAdapter;
import com.match.schedulingassistant.api.presenter.IStartPresenter;
import com.match.schedulingassistant.api.view.IStartView;
import com.match.schedulingassistant.file.FileBasicOperations;
import com.match.schedulingassistant.file.FileInfo;
import com.match.schedulingassistant.file.SchedulingFileResolver;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class StartPresenter implements IStartPresenter {

    private String _path;
    private IStartView iStartView;
    private StartActivity startActivity;
    private SchedulingFileResolver fileResolver;
    private FileBasicOperations fileBasicOperations;
    private List<String> allFileName;


    public StartPresenter(StartActivity startActivity, IStartView iStartView){
        this.iStartView = iStartView;
        this.startActivity = startActivity;
        this.fileResolver = new SchedulingFileResolver();
        this._path = startActivity.getFilesDir().getAbsolutePath()+"/scheduling/";
        this.fileBasicOperations = new FileBasicOperations(_path);

        //设置文件路径
        this.fileResolver.setFileDirPath(_path);
    }

    /**
     * 获取所有的排班文件
     */
    @Override
    public void getSchedulingFileList() {
        this.allFileName = this.fileBasicOperations.getAllFileName();
        this.iStartView.updateSchedulingFileList( new SchedulingFileListAdapter<String>(startActivity,
                StartPresenter.this, this.fileBasicOperations.getAllFileName()));
    }

    /**
     * 执行添加操作
     *
     * @param fileName 文件的名字
     */
    @Override
    public void doAdd(String fileName) {
        fileName = fileName.trim(); //去空格
        boolean result = this.allFileName.contains(fileName);
        //不存在才能创建
        if(!result) this.fileResolver.open(fileName);
        new FileInfo().setFileName(fileName);
        startActivity.addSchedulingFile(!result);
    }

    /**
     * 执行删除操作
     *
     * @param fileName 要删除文件的名字
     */
    @Override
    public void doDelete(String fileName) {
        boolean isDelete = this.fileResolver.delete(fileName);
        startActivity.deleteSchedulingFile(isDelete);
    }

}
