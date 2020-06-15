package com.deploy.jenkinsdocker.header;

import org.openjdk.jol.info.ClassLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * 　　* @Description:
 * 　　* @param
 * 　　* @return
 * 　　* @throws
 * 　　* @author YY Shen
 * 　　* @date $ $
 *
 */
public class ObjectHeader {


    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            list.add(i);
        }

        long lambdaStart = System.currentTimeMillis();
        list.forEach(i -> {
            // 不用做事情，循环就够了
            list.get(i);
        });
        long lambdaEnd = System.currentTimeMillis();
        System.out.println("lambda循环运行毫秒数===" + (lambdaEnd - lambdaStart));
        /*
        long normalStart = System.currentTimeMillis();
        for (int i = 0; i < list.size(); i++) {
            // 不用做事情，循环就够了
            list.get(i);
        }
        long normalEnd = System.currentTimeMillis();
        System.out.println("普通循环运行毫秒数===" + (normalEnd - normalStart));*/
    }






}
