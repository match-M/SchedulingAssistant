package com.match.schedulingassistant.dialog;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.match.schedulingassistant.R;
import com.match.schedulingassistant.api.presenter.IStartPresenter;

/**
 * 创建排班文件时弹出的输入框，输入文件名
 * @author match
 */
public class CreateSchedulingFileDialog  {



    public AlertDialog.Builder inputFileNameDialog(Activity activity, IStartPresenter startPresenter){
        EditText fileName_et = new EditText(activity);
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(activity);
        alertDialog.setTitle(R.string.input_file_name);
        alertDialog.setView(fileName_et);
        alertDialog.setPositiveButton(R.string.finish, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int id) {
                String fileName = String.valueOf(fileName_et.getText());
                if(fileName.trim().length() == 0) return;
                startPresenter.addSchedulingFile(fileName);
            }
        });
        alertDialog.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialogInterface, int id) {

            }
        });
        return alertDialog;
    }

}
