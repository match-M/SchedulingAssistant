package com.match.schedulingassistant.dialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.View;
import android.widget.Button;

import com.match.schedulingassistant.R;
import com.match.schedulingassistant.constant.Week;
import com.match.schedulingassistant.dialog.ListDialog;

import java.util.HashMap;

/**
 * 这项检查从星期几开始
 * @author match
 */
public class SelectStartPositionDialog extends ListDialog{
    public String[] date =  Week.week.toArray(new String[0]);


    @Override
    public Object showDialogAndSetRule(Activity activity, View view, String title,
                                       HashMap<String, Object> rules, String ruleName) {
        //return super.showDialogAndSetRule(activity, view, title, rules, ruleName);
        final Button[] button = new Button[1];

        final Object[] result = new Object[1]; //选择的楼层数量
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(activity);
        alertDialog.setTitle(title);
        alertDialog.setItems(this.date, new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String text;
                result[0] = i;
                button[0] = (Button) view;
                text = (String) button[0].getText();
                if(text.contains(":"))
                    text = text.substring(0, text.indexOf(":"));
                text = text+":"+date[i];
                button[0].setText(text);
                rules.put(ruleName, result[0]);
                System.out.println(rules);
            }
        });

        alertDialog.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                result[0] = 0;
            }
        });

        alertDialog.show();

        return result[0];
    }

    public void showSelectStartPositionDialogAndSetRule(Activity activity, View view,
                                                        HashMap<String, Object> rules,
                                                        String ruleName){
        this.showDialogAndSetRule(activity, view, "这项检查从星期几开始", rules, ruleName);

    }
}
