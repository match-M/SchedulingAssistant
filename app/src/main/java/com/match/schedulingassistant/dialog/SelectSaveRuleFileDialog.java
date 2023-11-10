package com.match.schedulingassistant.dialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.Gravity;
import android.widget.TextView;

import com.match.schedulingassistant.R;
import com.match.schedulingassistant.api.presenter.IRuleSettingPresenter;

/**
 * 选择已经保存的规则弹窗
 * @author match
 */
public class SelectSaveRuleFileDialog extends SelectFileDialog {


    private String fileName;
    private IRuleSettingPresenter ruleSettingPresenter;

    public SelectSaveRuleFileDialog(String[] fileList, IRuleSettingPresenter ruleSettingPresenter){
        super(fileList);
        this.ruleSettingPresenter = ruleSettingPresenter;
    }

    public void showSelectSaveRuleFileDialog(Activity activity){
        super.showSelectFileDialog(activity, "请选择一个规则吧");
        if(super.fileList.length > 0) {
            super.alertDialog.setItems(super.fileList, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    fileName = fileList[i];
                    ruleSettingPresenter.usingFile(fileName);
                }
            });
        }
        super.alertDialog.show();



    }

}
