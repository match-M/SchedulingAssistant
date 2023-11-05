package com.match.schedulingassistant.api.view;

import android.widget.ArrayAdapter;

/**
 * @author match
 */
public interface IPersonnelSettingsView {

    /**
     * 添加人员
     * @param result ture-添加成功，false-添加失败
     */
    void addPeople(boolean result);

    /**
     * 更新人员列表
     * @param arrayAdapter 列表数据
     */
    void upPeopleList(ArrayAdapter<String> arrayAdapter);

    /**
     * 完成
     */
    void finish();

    /**
     * 取消
     */
    void cancel();

}
