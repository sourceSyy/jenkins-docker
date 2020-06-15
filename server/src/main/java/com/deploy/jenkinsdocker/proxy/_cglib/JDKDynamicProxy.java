package com.deploy.jenkinsdocker.proxy._cglib;

import com.deploy.jenkinsdocker.proxy._static.TxManager;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 　　* @Description:
 * 　　* @param
 * 　　* @return
 * 　　* @throws
 * 　　* @author YY Shen
 * 　　* @date $ $
 *
 */
//这是一个工具类（作用就是实现InvocationHandler 接口， 通过这个接口的方法，实现动态代理）
public class JDKDynamicProxy implements InvocationHandler {

    private TxManager txManager;

    private Object target;

    public JDKDynamicProxy(TxManager txManager, Object target) {
        this.txManager = txManager;
        this.target = target;
    }

    //这个方发是用于获取被JDK代理的对象，作用是用于获取后执行接口中的方法
    public Object createProxyObject(){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    //这个真正的意义是在我们的接口方法前后执行一些我们自己想要执行的东西
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object invoke = null;
        try {
            txManager.begin();
            invoke = method.invoke(target, args);
            txManager.commit();

        }catch (Exception e){
            txManager.rollback();
        }finally {
            txManager.close();
        }
        return invoke;
    }

    public static void main(String[] args) {
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5);

        List<String> collect = integerStream.filter(a -> a < 1).map(Object::toString).collect(Collectors.toList());
        System.out.println(collect);
    }



}
