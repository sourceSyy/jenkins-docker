package com.deploy.jenkinsdocker.file;

import java.io.File;
import java.io.IOException;

/**
 * 　　* @Description:
 * 　　* @param
 * 　　* @return
 * 　　* @throws
 * 　　* @author YY Shen
 * 　　* @date $ $
 *
 */
public class FileTest {

    //文件相关内容常识
    public static void main(String[] args) {
        String baseDirectory = "/Users/zibingya/files/test/a";
        File file = new File(baseDirectory);
        System.out.println(file.isFile());
        System.out.println(file.isDirectory());
        System.out.println(file.exists());
        if (!file.exists()){
            file.mkdirs();
        }
        File file1 = new File(baseDirectory+"/touch.txt");
        if (!file1.exists()){
            try {
                boolean newFile = file1.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
