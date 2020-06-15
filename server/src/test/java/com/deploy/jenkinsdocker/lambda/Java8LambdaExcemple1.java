package com.deploy.jenkinsdocker.lambda;


import java.util.function.*;

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

        // 静态方法的引用 ： 类名::staticMethod
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


        // 对象方法的引用   &&   构造方法的引用
        Function<Too, String> fun8 = (too) -> {return new Too().echo();};
        Function<Too, String> fun9 = too -> {return new Too().echo();};
        Function<Too, String> fun10 = Too::echo;

        //对象方法的引用
        Consumer<Too> c1 = Too::echo;
        Consumer<Too> c2 = Too::show;

        UnaryOperator<Too> u1 = (too) -> too;
        UnaryOperator<Too> u2 = too -> too;

        //构造方法的引用
        Supplier<Too> s1 = Too::new;
        Function<String, Too> fu11 = (String too) -> {return new Too();};
        //有参数的构造
        Function<String, Too> fu12 = Too::new;

    }
}


//提供使用的接口
class Too{

    public Too() {
    }

    public Too(String name){

    }

    public String echo(){
        return "echo";
    }

    public void show(){}

}

class UserDTO{
    private com.deploy.jenkinsdocker.proxy._static.User user;

    public UserDTO(com.deploy.jenkinsdocker.proxy._static.User user) {
        this.user = user;
    }
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

