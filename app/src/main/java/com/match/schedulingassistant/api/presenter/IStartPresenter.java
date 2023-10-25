package com.match.schedulingassistant.api.presenter;

/**
 * @author match
 */
public interface IStartPresenter {

    /**
     * 获取所有的排班文件
     */
    void getSchedulingFileList();

    /**
     * 添加新的排班文件
     * @param fileName 文件的名字
     */
    void addSchedulingFile(String fileName);

}
