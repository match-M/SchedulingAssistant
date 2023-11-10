package com.match.schedulingassistant.dialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;

import com.match.schedulingassistant.R;

public class SelectFileDialog {
    public String[] fileList;

    public String fileName;
    public AlertDialog.Builder alertDialog;

    public SelectFileDialog(){}

    public SelectFileDialog(String[] fileList){
        this.fileList = fileList;
    }

    public void showSelectFileDialog(Activity activity, String title){

        this.alertDialog = new AlertDialog.Builder(activity);
        alertDialog.setTitle(title);


        if(fileList.length == 0 ){
            alertDialog.setMessage("没有文件哦~");
        }

        alertDialog.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                fileName = "0";
            }
        });

    }
}
