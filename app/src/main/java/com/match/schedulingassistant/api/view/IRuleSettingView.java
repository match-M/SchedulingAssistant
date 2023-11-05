package com.match.schedulingassistant.api.view;

/**
 * @author macth
 */
public interface IRuleSettingView {



    void goNext();


    /**
     *
     * @param isDelete true-文件删除成功，false-文件删除失败
     */
    void cancel(boolean isDelete);


}
