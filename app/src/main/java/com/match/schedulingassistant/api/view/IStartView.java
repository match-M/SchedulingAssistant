package com.match.schedulingassistant.api.view;

import android.widget.ArrayAdapter;

import com.match.schedulingassistant.adapter.list.SchedulingFileListAdapter;

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
    void updateSchedulingFileList(SchedulingFileListAdapter<String> stringSchedulingFileListAdapter);

    /**
     * 删除排班文件
     * @param isDelete true - 删除成功, false - 删除失败
     */
    void deleteSchedulingFile(boolean isDelete);
}
