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
     */
    void setPeople(int viewId);

    /**
     * 设置天数
     * @param viewId 控件id
     */
    void setDays(int viewId);

    /**
     * 设置开始日期
     * @param viewId 控件id
     */
    void setStartPosition(int viewId);

    /**
     * 设置最大出勤量
     * @param attendance 出勤量
     */
    void setMaxAttendance(int attendance);

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
     * 使用保存的规则
     * @param ruleFileName 规则文件名字
     */
    void useSaveRule(String ruleFileName);

}
