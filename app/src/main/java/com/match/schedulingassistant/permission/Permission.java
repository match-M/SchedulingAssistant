package com.match.schedulingassistant.permission;


import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 系统权限操作
 * @author match
 */
public class Permission {

    private final String[] PERMISSION = {
            Manifest.permission.MANAGE_EXTERNAL_STORAGE,
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE};

    /**
     * 申请需要的权限
     * @param activity 活动地址
     */
    public void applyForPermission(Activity activity) {
        //应用最小支持到android6.0所以不需要版本判断，肯定都需要动态申请权限
        ArrayList<String> passPerms = new ArrayList<>();
        for (String perms : PERMISSION) {
            if (perms.equals(Manifest.permission.MANAGE_EXTERNAL_STORAGE)
                    && Build.VERSION.SDK_INT < 33) continue;
            int result = ContextCompat.checkSelfPermission(activity, perms);
            if (result != PackageManager.PERMISSION_GRANTED) {
                passPerms.add(perms);
            }
        }

        if(passPerms.size() > 0) {
            String[] permsList = passPerms.toArray(new String[0]);
            System.out.println(Arrays.toString(permsList));
            ActivityCompat.requestPermissions(activity, permsList, 0);
        }

    }

}
