package com.match.schedulingassistant.api.presenter;

import android.view.View;

import java.util.HashMap;

/**
 * @author match
 */
public interface IRuleSettingPresenter {


    /**
     * 设置楼层
     * @param viewId 控件id
     * @param view 控件
     */
    void setFloor(int viewId, View view);

    /**
     * 设置人数
     * @param viewId 控件id
     * @param view  控件
     */
    void setPeople(int viewId, View view);

    /**
     * 设置天数
     * @param viewId 控件id
     */
    void setDays(int viewId, View view);

    /**
     * 设置开始日期
     * @param viewId 控件id
     */
    void setStartPosition(int viewId, View view);

    /**
     * 设置最大出勤量
     *
     * @param view 控件
     * @param viewId 控件id
     */
    public void setMaxAttendance(int viewId, View view);

    /**
     * 保存规则
     */
    void doSave();

    /**
     * 保存规则
     * @param rules 规则集合
     */
    void doSave(HashMap<String, Object> rules);

    /**
     * 选择保存的规则
     *
     */
    public void selectSaveRule();

    /**
     * 打开文件
     * @param fileName 文件名字
     */
    public void usingFile(String fileName);
}
