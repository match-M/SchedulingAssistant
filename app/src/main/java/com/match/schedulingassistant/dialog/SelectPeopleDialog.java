package com.match.schedulingassistant.dialog;

import android.app.Activity;
import android.view.View;

import java.util.HashMap;

/**
 * 选择检查需要的人数的弹窗
 * @author match
 */
public class SelectPeopleDialog {

    final String[] peopleNumber = new String[]{"3", "4", "5"};
    private ListDialog listDialog;
    public SelectPeopleDialog(){
        this.listDialog = new ListDialog(peopleNumber);
    }

    public void showSelectPeopleDialogAndSetRule(Activity activity, View view,
                                                   HashMap<String, Object> rules, String ruleName){

        this.listDialog.showDialogAndSetRule(activity, view, "请选择需要检查的人数",
                rules, ruleName);
    }


}
