package com.match.schedulingassistant.presenter;

import android.os.Build;
import android.view.View;
import android.widget.Button;

import com.match.schedulingassistant.activity.RuleSettingActivity;
import com.match.schedulingassistant.api.presenter.IRuleSettingPresenter;
import com.match.schedulingassistant.dialog.SelectFloorDialog;
import com.match.schedulingassistant.enumeration.RuleNameFloor;
import com.match.schedulingassistant.file.SettingFileResolver;
import com.match.schedulingassistant.file.SettingFileResolverForAndroid;

import java.util.HashMap;

/**
 * @author match
 */
public class RuleSettingPresenter implements IRuleSettingPresenter {

    private SettingFileResolverForAndroid settingFileResolverForAndroid;
    private RuleSettingActivity ruleSettingActivity;
    private SelectFloorDialog selectFloorDialog;
    private HashMap<String, Object> rules;

    public RuleSettingPresenter(RuleSettingActivity ruleSettingActivity){
        this.rules = new HashMap<>();
        this.selectFloorDialog = new SelectFloorDialog();
        this.ruleSettingActivity = ruleSettingActivity;
        this.settingFileResolverForAndroid = new SettingFileResolverForAndroid(
                this.ruleSettingActivity.getApplicationContext());
    }

    /**
     * 设置楼层
     *
     * @param viewId 控件id
     * @param view 控件
     */
    @Override
    public void setFloor(int viewId, View view) {
        Object result;
        String ruleName = RuleNameFloor.getRuleName(viewId);
        result = this.selectFloorDialog.showSelectFloorDialog(this.ruleSettingActivity, view);
        //判断是否点了取消
        if (result instanceof  Integer && (int) result == 0) return;
        //添加或者更新规则
        rules.put(ruleName, result);
    }

    /**
     * 设置人数
     *
     * @param viewId 控件id
     */
    @Override
    public void setPeople(int viewId) {

    }

    /**
     * 设置天数
     *
     * @param viewId 控件id
     */
    @Override
    public void setDays(int viewId) {

    }

    /**
     * 设置开始日期
     *
     * @param viewId        控件id
     */
    @Override
    public void setStartPosition(int viewId) {

    }

    /**
     * 设置最大出勤量
     *
     * @param attendance 出勤量
     */
    @Override
    public void setMaxAttendance(int attendance) {

    }

    /**
     * 保存规则
     */
    @Override
    public void doSave() {

    }

    /**
     * 保存规则
     *
     * @param rules 规则集合
     */
    @Override
    public void doSave(HashMap<String, Object> rules) {

    }

    /**
     * 使用保存的规则
     *
     * @param ruleFileName 规则文件名字
     */
    @Override
    public void useSaveRule(String ruleFileName) {

    }
}
