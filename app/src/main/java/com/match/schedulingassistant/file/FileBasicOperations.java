package com.match.schedulingassistant.file;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * 文件的基本操作
 * @author match
 */
public class FileBasicOperations {

    private String fileDirPath; //文件目录路径

    public FileBasicOperations(String fileDirPath){
        this.fileDirPath = fileDirPath;
    }

    /**
     * 获取路径下所有文件名
     * @return 以列表方式返回所有的文件名， null说明没有文件
     */
    public List<String> getAllFileName(){
        List<String> fileList = new ArrayList<>();

        File file = new File(this.fileDirPath);
        File[] tempList = file.listFiles();

        if (tempList == null)  return null;
        for (File value : tempList) {
            String fileName = value.getName();
            fileName = fileName.substring(0, fileName.indexOf("."));
            fileList.add(fileName);
        }

        return fileList;

    }
}
