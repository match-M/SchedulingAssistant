package com.match.schedulingassistant.presenter;

import android.content.Context;
import android.widget.ArrayAdapter;

import com.match.schedulingassistant.R;
import com.match.schedulingassistant.activity.PersonnelSettingsActivity;
import com.match.schedulingassistant.api.presenter.IPersonnelSettingsPresenter;
import com.match.schedulingassistant.api.view.IPersonnelSettingsView;
import com.match.schedulingassistant.scheduling.Scheduling;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PersonnelSettingsPresenter implements IPersonnelSettingsPresenter {

    private IPersonnelSettingsView iPersonnelSettingsView;
    private PersonnelSettingsActivity personnelSettingsActivity;
    private List<String> peoples;
    private Scheduling scheduling;

    public PersonnelSettingsPresenter(IPersonnelSettingsView iPersonnelSettingsView,
                                      PersonnelSettingsActivity personnelSettingsActivity){
        this.scheduling = new Scheduling();
        this.peoples = new LinkedList<>();
        this.iPersonnelSettingsView = iPersonnelSettingsView;
        this.personnelSettingsActivity = personnelSettingsActivity;
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
        if(!peoples.contains(name) && !(name.trim().length() == 0)){
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
        ArrayAdapter<String> arrayAdapter =
                new ArrayAdapter<>(this.personnelSettingsActivity,
                        android.R.layout.simple_list_item_1,
                        this.peoples.toArray(new String[0]));
        this.iPersonnelSettingsView.upPeopleList(arrayAdapter);
    }
}
