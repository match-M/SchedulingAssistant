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
public class SelectSaveRuleFileDialog {

    private String[] fileList;

    private String fileName;
    private IRuleSettingPresenter ruleSettingPresenter;

    public SelectSaveRuleFileDialog(String[] fileList, IRuleSettingPresenter ruleSettingPresenter){
        this.fileList = fileList;
        this.ruleSettingPresenter = ruleSettingPresenter;
    }

    public void showSelectSaveRuleFileDialog(Activity activity){

        AlertDialog.Builder alertDialog = new AlertDialog.Builder(activity);
        alertDialog.setTitle("请选择一个规则吧");

        if(fileList.length > 0) {
            alertDialog.setItems(this.fileList, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    fileName = fileList[i];
                    System.out.println(fileList[i]);
                    ruleSettingPresenter.usingFile(fileList[i]);
                }
            });
        }

        if(fileList.length == 0 ){
            /*TextView textView = new TextView(activity);
            textView.setText("没有文件哦~");
            textView.setGravity(Gravity.CENTER_HORIZONTAL);
            alertDialog.setView(textView);*/
            alertDialog.setMessage("没有文件哦~");
        }

        alertDialog.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                fileName = "0";
            }
        });

        alertDialog.show();

    }

    public String getFileName(){
        return this.fileName;
    }

}
