package com.match.schedulingassistant.api.presenter;

/**
 * @author match
 */
public interface IPersonnelSettingsPresenter {

    /**
     * 添加成员
     * @param name 成员名字
     */
    void doAdd(String name);

    /**
     * 更新人员列表
     */
    void upList();

}
