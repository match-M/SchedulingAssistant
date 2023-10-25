package com.match.schedulingassistant.api.view;

import android.widget.ArrayAdapter;

import java.util.List;

/**
 * @author match
 */
public interface IStartView {

    /**
     * 新建排班文件
     * @param fileName 排班文件名字
     */
    void newSchedulingFile(String fileName);


    /**
     * 更新排班文件列表
     */
    void updateSchedulingFileList(ArrayAdapter<String> arrayAdapter);
}
