package com.match.schedulingassistant.presenter;


import android.content.Context;
import android.widget.ArrayAdapter;

import com.match.schedulingassistant.R;
import com.match.schedulingassistant.activity.PersonnelSettingsActivity;
import com.match.schedulingassistant.api.presenter.IPersonnelSettingsPresenter;
import com.match.schedulingassistant.api.view.IPersonnelSettingsView;
import com.match.schedulingassistant.dialog.SelectSaveMemberFileDialog;
import com.match.schedulingassistant.dialog.SelectSaveRuleFileDialog;
import com.match.schedulingassistant.file.FileBasicOperations;
import com.match.schedulingassistant.file.FileInfo;
import com.match.schedulingassistant.file.MemberFileResolver;
import com.match.schedulingassistant.scheduling.Scheduling;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PersonnelSettingsPresenter implements IPersonnelSettingsPresenter {

    private final String _basePath;
    private IPersonnelSettingsView iPersonnelSettingsView;
    private FileBasicOperations fileBasicOperations;
    private PersonnelSettingsActivity personnelSettingsActivity;
    private SelectSaveMemberFileDialog selectSaveMemberFileDialog;
    private MemberFileResolver memberFileResolver;
    private List<String> peoples;
    private Scheduling scheduling;

    public PersonnelSettingsPresenter(IPersonnelSettingsView iPersonnelSettingsView,
                                      PersonnelSettingsActivity personnelSettingsActivity){
        this.scheduling = new Scheduling();
        this.peoples = new LinkedList<>();
        this._basePath =  personnelSettingsActivity.getFilesDir().getAbsolutePath();
        this.fileBasicOperations = new FileBasicOperations(_basePath+"/member/");
        this.memberFileResolver = new MemberFileResolver();
        this.iPersonnelSettingsView = iPersonnelSettingsView;
        this.personnelSettingsActivity = personnelSettingsActivity;

        this.memberFileResolver.setFileDirPath(_basePath+"/member/");
    }

    /**
     * 添加成员
     *
     * @param name 成员名字
     */
    @Override
    public void doAdd(String name) {
        boolean isNotAdd = false;
        //判断是否已经添加过了和名字是不是空
        name = name.trim(); //去空格
        if(!peoples.contains(name) && !(name.length() == 0)){
            this.scheduling.addPeople(name);
            this.peoples.add(name);
            this.upList();
            isNotAdd = true;
        }
        this.iPersonnelSettingsView.addPeople(isNotAdd);
    }

    /**
     * 更新人员列表
     */
    @Override
    public void upList() {
        //判空
        if(this.peoples.isEmpty()) return;
        ArrayAdapter<String> arrayAdapter =
                new ArrayAdapter<>(this.personnelSettingsActivity,
                        android.R.layout.simple_list_item_1,
                        this.peoples.toArray(new String[0]));
        this.iPersonnelSettingsView.upPeopleList(arrayAdapter);
    }

    /**
     * 删除成员
     * @param index 要删除成员的索引
     */
    @Override
    public void doDelete(int index) {
        peoples.remove(index);
        this.upList();
    }

    /**
     * 保存新的文件
     */
    @Override
    public void doSave() {
        this.memberFileResolver.open(new FileInfo().getFileName()+"Member");
        this.memberFileResolver.addFileContent(this.peoples);
        this.memberFileResolver.writer();
    }

    /**
     * @param members 成员列表
     */
    @Override
    public void doSave(List<String> members) {
        this.peoples = members;
        this.doSave();
    }

    /**
     * 选择保存的成员信息文件
     */
    @Override
    public void selectSaveMemberFile() {
        String[] fileList = this.fileBasicOperations.getAllFileName().toArray(new String[0]);
        this.selectSaveMemberFileDialog = new SelectSaveMemberFileDialog(fileList,
                this);
        this.selectSaveMemberFileDialog.showSelectSaveMemberFileDialog(this.personnelSettingsActivity);
    }

    /**
     * 使用选择的文件
     * @param fileName 要使用的文件名字
     */
    @Override
    public void usingFile(String fileName) {
        System.out.println(fileName);
        this.memberFileResolver.open(fileName);
        try {
            this.peoples = this.memberFileResolver.readFile();
            System.out.println(this.peoples);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        this.upList();
    }

    /**
     * 实现完成时的逻辑
     */
    @Override
    public void doFinish() {
        iPersonnelSettingsView.finishAndGoNext(this.scheduling);
    }
}
