package com.match.schedulingassistant.api.view;

import android.widget.ArrayAdapter;

import java.util.List;

/**
 * @author match
 */
public interface IStartView {

    /**
     * 添加排班文件
     * @param result ture-创建成功， false-创建失败
     */
    void addSchedulingFile(boolean result);

    /**
     * 更新排班文件列表
     */
    void updateSchedulingFileList(ArrayAdapter<String> arrayAdapter);
}
