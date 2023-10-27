package com.match.schedulingassistant.api.presenter;

/**
 * @author match
 */
public interface IRuleSettingPresenter {


    /**
     * 设置楼层
     * @param viewId 控件id
     * @param floor 楼层
     */
    void setFloor(int viewId, Object floor);

    /**
     * 设置人数
     * @param viewId 控件id
     * @param people 人数
     */
    void setPeople(int viewId, int people);

    /**
     * 设置天数
     * @param viewId 控件id
     * @param days 需要的天数
     */
    void setDays(int viewId, int days);

    /**
     * 设置开始日期
     * @param viewId 控件id
     * @param startPosition 开始的日期
     */
    void setStartPosition(int viewId, int startPosition);

    /**
     * 设置最大出勤量
     * @param attendance 出勤量
     */
    void setMaxAttendance(int attendance);

}
