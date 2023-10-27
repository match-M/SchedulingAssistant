package com.match.schedulingassistant.presenter;

import android.app.Activity;
import android.content.Intent;
import android.widget.ArrayAdapter;

import com.match.schedulingassistant.activity.RuleSettingActivity;
import com.match.schedulingassistant.activity.StartActivity;
import com.match.schedulingassistant.api.presenter.IStartPresenter;
import com.match.schedulingassistant.api.view.IStartView;
import com.match.schedulingassistant.file.FileBasicOperations;
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
        this._path = startActivity.getFilesDir().getAbsolutePath();
        this.fileBasicOperations = new FileBasicOperations(_path);
    }

    /**
     * 获取所有的排班文件
     */
    @Override
    public void getSchedulingFileList() {
        this.allFileName = this.fileBasicOperations.getAllFileName();
        this.iStartView.updateSchedulingFileList( new ArrayAdapter<String>(startActivity,
                android.R.layout.simple_list_item_1,
                this.fileBasicOperations.getAllFileName().toArray(new String[0])));
    }

    /**
     * 添加新的排班文件
     *
     * @param fileName 文件的名字
     */
    @Override
    public void addSchedulingFile(String fileName) {
        //判断是否存在文件
        boolean result = this.allFileName.contains(fileName);
        //不存在才能创建
        if(!result) {
            this.fileResolver = new SchedulingFileResolver(fileName);
            this.fileResolver.setFileDirPath(_path + "/");
            this.fileResolver.open(null);
        }
        startActivity.addSchedulingFile(!result);

    }
}
