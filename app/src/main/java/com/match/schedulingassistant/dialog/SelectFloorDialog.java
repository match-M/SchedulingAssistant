package com.match.schedulingassistant.dialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.match.schedulingassistant.R;
import com.match.schedulingassistant.activity.RuleSettingActivity;
import com.match.schedulingassistant.constant.Week;

import java.util.HashMap;

/**
 * 选择需要检查的楼层数的弹窗
 * @author macth
 */
public class SelectFloorDialog {
    final String[] floor = {"1", "2", "3", "4", "5"};
    private ListDialog listDialog;

    public SelectFloorDialog(){
        this.listDialog = new ListDialog(floor);
    }

    /**
     * 显示选择楼层弹窗
     * @param activity 活动
     * @return 返回选择的楼层, 0-代表错误码点击了取消按钮
     */
    public void showSelectFloorDialogAndSetRule(Activity activity, View view,
                                        HashMap<String, Object> rules, String ruleName){

        this.listDialog.showDialogAndSetRule(activity, view, "需要检查的楼层数", rules, ruleName);
    }
}
