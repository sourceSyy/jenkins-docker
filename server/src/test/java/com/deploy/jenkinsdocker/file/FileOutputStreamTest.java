package com.deploy.jenkinsdocker.file;

import java.io.*;

/**
 * 　　* @Description:
 * 　　* @param
 * 　　* @return
 * 　　* @throws
 * 　　* @author YY Shen
 * 　　* @date $ $
 *
 */
public class FileOutputStreamTest {

    public static void main(String[] args) {
        //字节流
        try {
            FileInputStream fis = new FileInputStream("/Users/zibingya/1.jpg");
            BufferedInputStream bis = new BufferedInputStream(fis);

            FileOutputStream fos = new FileOutputStream("/Users/zibingya/files/test/a/1.jpg");
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            int n = 0;
            byte[] bytes = new byte[1024];
            while ((n = bis.read(bytes)) != -1){
                bos.write(bytes,0, n);
                bos.flush();
            }

            fis.close();
            bis.close();
            fos.close();
            bos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
