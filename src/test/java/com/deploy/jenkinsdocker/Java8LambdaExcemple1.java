package com.deploy.jenkinsdocker;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * 函数式编程案例一
 */
public class Java8LambdaExcemple1 {

    public Integer getLength(String str){
        return str.length();
    }

    public static Integer getLength(String str1, String str2){
        return str1.length() + str2.length();
    }

    public static void main(String[] args) {

        Runnable runnable = () -> System.out.println("第一个 lambda 表达式");
        runnable.run();

        /**
         * 方法的引用四种类型：
         *  1、 静态方法的引用 ： 类名::staticMethod
         *  2、 实例方法的引用 ： init::initMethod
         *  3、 对象方法的引用 ： 类名::newMethod
         *  4、 构造方法的引用 ： 类名::new
         */
        //最原始写法
        Function<String,Integer> fun1 = (String string) -> {return string.length();};
        //优化一
        Function<String,Integer> fun2 = (string) -> {return string.length();};
        //优化二
        Function<String,Integer> fun3 = string -> {return string.length();};
        //优化三
        Function<String,Integer> fun4 = string -> string.length();
        //优化四 （发现这个length方法是String类的一个实例方法，而我的lambda表达式方法体恰好可以调用一个实例方法来实现，故此叫做 方法的引用）
        Function<String,Integer> fun5 = String::length;  //对象方法
        //--- 调用输出 ---
        System.out.println(fun5.apply("method"));

        //写一个关于实例方法的引用  // 这实例方法的引用
        Function<String, Integer> fun6 = new Java8LambdaExcemple1()::getLength;
        //写一个关于静态方法的引用  // 这静态方法的引用
        BiFunction<String, String, Integer> fun7 = Java8LambdaExcemple1::getLength;
        //--- 调用输出 ---
        System.out.println(fun7.apply("java", "Python"));

        //自定义函数式接口
        User user1 = new User();
        user1.setId("123456");
        UserMapper userMapper = user -> {
            System.out.println("insert "+user);
            return true;
        };
        boolean insert = userMapper.insert(user1);
        System.out.println(insert);
    }
}

//自定义的函数式接口
@FunctionalInterface
interface UserMapper{

    boolean insert(User user);

}
class User{
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

