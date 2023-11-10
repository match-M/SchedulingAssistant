package com.match.schedulingassistant.dialog;


import android.app.Activity;
import android.content.DialogInterface;

import com.match.schedulingassistant.api.presenter.IPersonnelSettingsPresenter;

public class SelectSaveMemberFileDialog extends SelectFileDialog {

    private IPersonnelSettingsPresenter iPersonnelSettingsPresenter;

    public SelectSaveMemberFileDialog(){}

    public SelectSaveMemberFileDialog(String[] fileList,
                                      IPersonnelSettingsPresenter iPersonnelSettingsPresenter) {
        super(fileList);
        this.iPersonnelSettingsPresenter = iPersonnelSettingsPresenter;
    }

    public void showSelectSaveMemberFileDialog(Activity activity){
        super.showSelectFileDialog(activity, "选择一组成员吧");
        if(super.fileList.length > 0) {
            super.alertDialog.setItems(super.fileList, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    fileName = fileList[i];
                    iPersonnelSettingsPresenter.usingFile(fileName);
                }
            });
        }
        super.alertDialog.show();
    }

}
