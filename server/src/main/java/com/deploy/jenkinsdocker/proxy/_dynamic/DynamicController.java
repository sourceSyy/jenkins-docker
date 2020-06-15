package com.deploy.jenkinsdocker.proxy._dynamic;

import com.deploy.jenkinsdocker.proxy._cglib.IUserServiceImpl;
import com.deploy.jenkinsdocker.proxy._static.TxManager;
import com.deploy.jenkinsdocker.proxy._static.User;

/**
 * 　　* @Description:
 * 　　* @param
 * 　　* @return
 * 　　* @throws
 * 　　* @author YY Shen
 * 　　* @date $ $
 *
 * 这个是JDK 动态代理
 *
 *
 */
public class DynamicController {

    private static final IUserService userService = new IUserServiceImpl();

    private static final TxManager txManager = new TxManager();

    public static void main(String[] args) {
        User user = new User(10, 20);
        JDKDynamicProxy jdkDynamicProxy = new JDKDynamicProxy(txManager, userService);
        IUserService proxyObject = (IUserService)jdkDynamicProxy.createProxyObject();
        proxyObject.save(user);
        User user1 = proxyObject.getUser();
        System.out.println(user1);
    }


}
