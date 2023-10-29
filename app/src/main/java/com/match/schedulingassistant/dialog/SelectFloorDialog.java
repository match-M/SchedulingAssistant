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

public class SelectFloorDialog {
    final String[] floor = new String[]{"1", "2", "3", "4", "5", "ALL"};

    /**
     * 显示选择楼层弹窗
     * @param activity 活动
     * @return 返回选择的楼层, 0-代表错误码点击了取消按钮
     */
    public Object showSelectFloorDialog(Activity activity, View view){
        //更改按钮的文件
        final Button[] button = new Button[1];

        final Object[] selectFloorNumber = new Object[1]; //选择的楼层数量
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(activity);
        alertDialog.setTitle("选择需要的楼层数量");
        alertDialog.setItems(floor, new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String buttonText;
                selectFloorNumber[0] = floor[i];
                button[0] = (Button) view;
                buttonText = (String) button[0].getText();
                if(buttonText.contains(":"))
                    buttonText = buttonText.substring(0, buttonText.indexOf(":"));
                button[0].setText(buttonText+":"+floor[i]);
            }
        });

        alertDialog.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                selectFloorNumber[0] = 0;
            }
        });

        alertDialog.show();

        return selectFloorNumber[0];
    }
}
