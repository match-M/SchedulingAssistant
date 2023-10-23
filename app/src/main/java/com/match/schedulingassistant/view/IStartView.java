package com.match.schedulingassistant.view;

import java.util.List;

/**
 * @author match
 */
public interface IStartView {

    /**
     * 获取本地的排班文件
     * @return 以列表的形式返回文件名字
     */
    List<String> getSchedulingFiles();

    /**
     * 新建排班文件
     * @param fileName 排班文件名字
     */
    void newSchedulingFile(String fileName);
}
