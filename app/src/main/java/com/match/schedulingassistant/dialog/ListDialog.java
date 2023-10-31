package com.match.schedulingassistant.dialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.match.schedulingassistant.R;

import java.util.HashMap;

public class ListDialog {

    private String[] items;

    public ListDialog(){}

    public ListDialog(String[] items){
        this.items = items;
    }


    public Object showDialogAndSetRule(Activity activity, View view, String title,
                                       HashMap<String, Object> rules, String ruleName) {
        final Button[] button = new Button[1];

        final Object[] result = new Object[1]; //选择的楼层数量
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(activity);
        alertDialog.setTitle(title);
        alertDialog.setItems(this.items, new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String text;
                result[0] = items[i];
                button[0] = (Button) view;
                text = (String) button[0].getText();
                if(text.contains(":"))
                    text = text.substring(0, text.indexOf(":"));
                text = text+":"+result[0];
                button[0].setText(text);
                rules.put(ruleName, items[i]);
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
}
