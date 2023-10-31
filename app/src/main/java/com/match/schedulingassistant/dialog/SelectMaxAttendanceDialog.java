package com.match.schedulingassistant.dialog;

import android.app.Activity;
import android.view.View;

import com.match.schedulingassistant.dialog.ListDialog;

import java.util.HashMap;

/**
 * 选择一个人最多可以有几个班的弹窗
 * @author match
 */
public class SelectMaxAttendanceDialog {
    final String[] attendance = new String[]{"2", "3", "4"};

    private ListDialog listDialog;

    public SelectMaxAttendanceDialog(){
        this.listDialog = new ListDialog(attendance);
    }

    public void showSelectMaxAttendanceDialogAndRule(Activity activity, View view,
                                                     HashMap<String, Object> rules, String rule){
        this.listDialog.showDialogAndSetRule(activity, view,
                "选择一个一天最多可以有几个班", rules, rule);
    }
}
