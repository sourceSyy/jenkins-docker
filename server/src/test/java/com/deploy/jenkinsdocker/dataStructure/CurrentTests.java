package com.deploy.jenkinsdocker.dataStructure;

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
public class CurrentTests {

    public static void main(String[] args) {
        CurrentTest currentTest = new CurrentTest();
        currentTest.addFirst("123");
        currentTest.addFirst("456");
        currentTest.addFirst("789");
        System.out.println(currentTest);
        currentTest.remove(1);
        System.out.println(currentTest);

    }

}
