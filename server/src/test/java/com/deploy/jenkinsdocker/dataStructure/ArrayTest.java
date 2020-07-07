package com.deploy.jenkinsdocker.dataStructure;

/**
 * 　　* @Description:
 * 　　* @param
 * 　　* @return
 * 　　* @throws
 * 　　* @author YY Shen
 * 　　* @date $ $
 *
 */
public class ArrayTest {

    public static void main(String[] args) {
        Array<Integer> array = new Array(10);
        array.addLast(1);
        array.addLast(2);
        array.addLast(3);
        array.addLast(4);
        array.addLast(5);
        array.addLast(6);
        array.addLast(7);
        array.addLast(8);
        array.addLast(9);
        array.addLast(10);
        array.set(2, 10);
        System.out.println(array);

    }

}
