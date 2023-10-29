package com.match.schedulingassistant.file;

import android.content.Context;
import android.content.SharedPreferences;

import com.match.schedulingassistant.api.file.SettingFile;
import com.match.schedulingassistant.adapter.FileOperationAdapter;
import com.match.schedulingassistant.constant.SettingException;
import com.match.schedulingassistant.exception.NotInitException;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class SettingFileResolverForAndroid extends FileOperationAdapter implements SettingFile{

    private String fileName;
    private Context context;
    private SharedPreferences sp;
    private HashMap<String, Object> settingInfos;
    private Pattern pattern;


    public SettingFileResolverForAndroid(String fileName, Context context){
        this.context = context;
        this.fileName = fileName;
        this.settingInfos = new HashMap<>();
        pattern = Pattern.compile("^[-\\+]?[\\d]*$"); //正则表达式

    }

    public SettingFileResolverForAndroid(Context context){
        this.context = context;
        this.settingInfos = new HashMap<>();
        pattern = Pattern.compile("^[-\\+]?[\\d]*$"); //正则表达式
    }

    @Override
    public void open(String fileName){
        if(fileName == null) fileName = this.fileName;
        this.sp = this.context.getSharedPreferences(fileName, Context.MODE_PRIVATE);
    }


    @Override
    public void writer() {
        SharedPreferences.Editor editor = this.sp.edit();
        for(String key : this.settingInfos.keySet()){
            editor.putString(key, String.valueOf(this.settingInfos.get(key)));
        }
        editor.apply();
        this.settingInfos.clear(); //清空设置集合
    }

    @Override
    public void addSetting(String key, Object value) {
        this.settingInfos.put(key, value);
    }

    @Override
    public void addSetting(HashMap<String, Object> settingInfo) throws NotInitException {
        if(settingInfo == null) throw new NotInitException(SettingException.SETTING_NOT_INIT);
        this.settingInfos = settingInfo;
    }

    @Override
    public void up() {
        this.writer();
    }

    @Override
    public void up(String key, Object value) {
        SharedPreferences.Editor editor = this.sp.edit();
        editor.putString(key, (String) value);
        editor.apply();
    }

    @Override
    public void up(HashMap<String, Object> settingInfo) throws NotInitException {
        if(settingInfo == null) throw new NotInitException(SettingException.SETTING_NOT_INIT);
        this.settingInfos = settingInfo;
        this.up();
    }

    @Override
    public HashMap<String, Object> get() {
        Object value;
        Map<String, ?> settingInfo = this.sp.getAll();
        HashMap<String, Object> setting = new HashMap<>();
        for (String key : settingInfo.keySet()) {
            value = settingInfo.get(key);
            //通过正则表达式判断是不是整数
            if(value == null) continue;
            if(pattern.matcher((String) value).matches()) value = Integer.parseInt((String) value);
            setting.put(key, value);
        }

        return setting;
    }

    @Override
    public Object get(String key) {
        HashMap<String, Object> setting = this.get();
        return setting.get(key);
    }
}
