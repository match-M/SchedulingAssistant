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
     * 执行添加操作
     * @param fileName 文件的名字
     */
    void doAdd(String fileName);

    /**
     * 执行删除操作
     * @param fileName 要删除文件的名字
     */
    void doDelete(String fileName);

}
