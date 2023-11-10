package com.match.schedulingassistant.api.presenter;

import java.util.List;

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

    /**
     * 删除成员
     * @param index 要删除成员的索引
     */
    void doDelete(int index);

    /**
     * 保存新的文件
     */
    void doSave();

    /**
     * @param members 成员列表
     */
    void doSave(List<String> members);

    /**
     * 选择保存的成员信息文件
     */
    void selectSaveMemberFile();

    /**
     * 使用选择的文件
     * @param fileName 要使用文件的名字
     */
    void usingFile(String fileName);
}
