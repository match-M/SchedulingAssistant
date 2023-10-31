package com.match.schedulingassistant.dialog;

import android.app.Activity;
import android.view.View;

import com.match.schedulingassistant.dialog.ListDialog;

import java.util.HashMap;

/**
 *选择检查的天数
 * @author match
 */
public class SelectDaysDialog {
    final String[] days = new String[]{"1", "2", "3", "4", "5"};

    private ListDialog listDialog;

    public SelectDaysDialog(){
        this.listDialog = new ListDialog(days);
    }

    public void showSelectDaysDialogAndSetRule(Activity activity, View view,
                                               HashMap<String, Object> rules, String ruleName){
        this.listDialog.showDialogAndSetRule(activity, view, "选择需要检查的天数", rules, ruleName);

    }

}
