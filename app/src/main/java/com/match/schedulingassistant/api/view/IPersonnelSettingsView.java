package com.match.schedulingassistant.api.view;

import android.view.View;
import android.widget.ArrayAdapter;

import com.match.schedulingassistant.scheduling.Scheduling;

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
     * 显示长按菜单
     */
    void showPopupMenu(View view, int position);

    /**
     * 完成
     */
    void finishAndGoNext(Scheduling scheduling);

    /**
     * 取消
     */
    void cancel();

}
