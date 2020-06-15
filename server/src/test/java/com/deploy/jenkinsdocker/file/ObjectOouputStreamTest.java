package com.deploy.jenkinsdocker.file;

import com.deploy.jenkinsdocker.Goods;

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
public class ObjectOouputStreamTest {

    public static void main(String[] args) {
        Goods goods = new Goods("1", "手机", 10D);

        try {
            FileOutputStream fileOutputStream = new FileOutputStream("/Users/zibingya/files/test/a/touchd.txt");
            ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);

            FileInputStream fileInputStream = new FileInputStream("/Users/zibingya/files/test/a/touchd.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            outputStream.writeObject(goods);

            Goods object = (Goods) objectInputStream.readObject();
            System.out.println(object);

            fileOutputStream.close();
            outputStream.close();
            fileInputStream.close();
            objectInputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

}
