package com.match.schedulingassistant.presenter;

import android.view.View;
import android.widget.Button;

import com.match.schedulingassistant.activity.RuleSettingActivity;
import com.match.schedulingassistant.api.presenter.IRuleSettingPresenter;
import com.match.schedulingassistant.api.view.IRuleSettingView;
import com.match.schedulingassistant.constant.IdAndRuleName;
import com.match.schedulingassistant.constant.RuleName;
import com.match.schedulingassistant.constant.Week;
import com.match.schedulingassistant.dialog.SelectDaysDialog;
import com.match.schedulingassistant.dialog.SelectFloorDialog;
import com.match.schedulingassistant.dialog.SelectMaxAttendanceDialog;
import com.match.schedulingassistant.dialog.SelectPeopleDialog;
import com.match.schedulingassistant.dialog.SelectSaveRuleFileDialog;
import com.match.schedulingassistant.dialog.SelectStartPositionDialog;
import com.match.schedulingassistant.exception.NotInitException;
import com.match.schedulingassistant.file.FileBasicOperations;
import com.match.schedulingassistant.file.FileInfo;
import com.match.schedulingassistant.file.SchedulingFileResolver;
import com.match.schedulingassistant.file.SettingFileResolver;

import java.util.HashMap;
import java.util.Set;

/**
 * @author match
 */
public class RuleSettingPresenter implements IRuleSettingPresenter {

    private final String _basePath;
    private SettingFileResolver settingFileResolver;
    private RuleSettingActivity ruleSettingActivity;
    private IRuleSettingView iRuleSettingView;
    private SelectFloorDialog selectFloorDialog;
    private SelectPeopleDialog selectPeopleDialog;
    private SelectDaysDialog selectDaysDialog;
    private SelectStartPositionDialog selectStartPositionDialog;
    private SelectMaxAttendanceDialog selectMaxAttendanceDialog;
    private SelectSaveRuleFileDialog selectSaveRuleFileDialog;
    private FileBasicOperations fileBasicOperations;
    private HashMap<String, Object> rules;

    public RuleSettingPresenter(RuleSettingActivity ruleSettingActivity,
                                IRuleSettingView iRuleSettingView){
        this.rules = new HashMap<>();
        this.iRuleSettingView = iRuleSettingView;
        this.ruleSettingActivity = ruleSettingActivity;
        this.settingFileResolver = new SettingFileResolver();
        this._basePath = ruleSettingActivity.getFilesDir().getAbsolutePath();
        this.fileBasicOperations = new FileBasicOperations(_basePath+"/setting/");

        //初始化选择弹窗
        this.selectFloorDialog = new SelectFloorDialog();
        this.selectPeopleDialog = new SelectPeopleDialog();
        this.selectDaysDialog = new SelectDaysDialog();
        this.selectStartPositionDialog = new SelectStartPositionDialog();
        this.selectMaxAttendanceDialog = new SelectMaxAttendanceDialog();

        //设置文件路径
        this.settingFileResolver.setFileDirPath(_basePath+"/setting/");
    }

    /**
     * 设置楼层
     *
     * @param viewId 控件id
     * @param view 控件
     */
    @Override
    public void setFloor(int viewId, View view) {
        String ruleName = IdAndRuleName.getRuleName(viewId);

        this.selectFloorDialog.showSelectFloorDialogAndSetRule(this.ruleSettingActivity,
                view, rules, ruleName);
    }

    /**
     * 设置人数
     *
     * @param viewId 控件id
     * @param view 控件
     */
    @Override
    public void setPeople(int viewId, View view) {
        String ruleName = IdAndRuleName.getRuleName(viewId);
        this.selectPeopleDialog.showSelectPeopleDialogAndSetRule(this.ruleSettingActivity,
                view, rules, ruleName);


    }

    /**
     * 设置天数
     *
     * @param viewId 控件id
     * @param view 控件
     */
    @Override
    public void setDays(int viewId, View view) {
        String ruleName = IdAndRuleName.getRuleName(viewId);
        this.selectDaysDialog.showSelectDaysDialogAndSetRule(this.ruleSettingActivity,
                view, rules, ruleName);
    }

    /**
     * 设置开始日期
     *
     * @param viewId        控件id
     * @param view 控件
     */
    @Override
    public void setStartPosition(int viewId, View view) {
        String ruleName = IdAndRuleName.getRuleName(viewId);
        this.selectStartPositionDialog.showSelectStartPositionDialogAndSetRule(
                this.ruleSettingActivity, view, rules, ruleName);
    }

    /**
     * 设置最大出勤量
     *
     * @param view 控件
     * @param viewId 控件id
     */
    @Override
    public void setMaxAttendance(int viewId, View view) {
        String ruleName = IdAndRuleName.getRuleName(viewId);
        this.selectMaxAttendanceDialog.showSelectMaxAttendanceDialogAndRule(
                this.ruleSettingActivity, view, rules, ruleName);
    }

    /**
     * 保存规则
     */
    @Override
    public void doSave(){
        this.settingFileResolver.open(new FileInfo().getFileName());
        try {
            this.settingFileResolver.addSetting(this.rules);
        } catch (NotInitException e) {
            throw new RuntimeException(e);
        }
        this.settingFileResolver.writer();
        this.iRuleSettingView.goNext();
    }

    /**
     * 保存规则
     *
     * @param rules 规则集合
     */
    @Override
    public void doSave(HashMap<String, Object> rules) {
        this.rules = rules;
        doSave();
    }

    /**
     * 使用保存的规则
     *
     */
    @Override
    public void selectSaveRule() {
        this.selectSaveRuleFileDialog = new SelectSaveRuleFileDialog(
                this.fileBasicOperations.getAllFileName().toArray(new String[0]),
                RuleSettingPresenter.this);
        this.selectSaveRuleFileDialog.showSelectSaveRuleFileDialog(this.ruleSettingActivity);
    }

    /**
     * 打开文件
     *
     * @param fileName 文件名字
     */
    @Override
    public void usingFile(String fileName) {
        int id;
        Object value;
        Button button;
        String buttonText;
        //防止出现null错误
        if(fileName == null) return;
        this.settingFileResolver.open(fileName);
        //获取规则
        this.rules = this.settingFileResolver.get();
        Set<String> setKey = this.rules.keySet();
        //遍历规则集合
        for (String key : setKey) {
            id = IdAndRuleName.getButtonId(key);
            //找不到控件的情况
            if(id == 404) continue;
            //根据id找到对应的button控件
            button = this.ruleSettingActivity.findViewById(id);
            //获取控件上的文本
            buttonText = (String) button.getText();
            //判断之前是否显示过数据
            if(buttonText.contains(":"))
                buttonText = buttonText.substring(0, buttonText.indexOf(":"));
            //获取RuleValue
            value = this.rules.get(key);
            //判断是否为空
            if(value == null) continue;
            //把开始位置采用日期的方式输出
            if(key.equals(RuleName.MORNING_START_POSITION) ||
                    key.equals(RuleName.AFTERNOON_START_POSITION) ||
                    key.equals(RuleName.NIGHT_START_POSITION) ||
                    key.equals(RuleName.NIGHT_4_START_POSITION)){

                value = Week.week.get((Integer) value);
            }
            //根据id来显示保存的规则数据, id与ruleName一一对应， ruleName与ruleValue一一对应
            buttonText = buttonText+":"+value;
            //重新设置文本
            button.setText(buttonText);
        }

    }

    /**
     * 执行取消操作
     */
    @Override
    public void doCancel() {
        String fileName = new FileInfo().getFileName();
        SchedulingFileResolver deleteFile = new SchedulingFileResolver(fileName);
        deleteFile.setFileDirPath(_basePath+"/scheduling/");
        boolean isDelete = deleteFile.delete(null); //删除文件
        this.iRuleSettingView.cancel(isDelete);
    }

}
