package com.deploy.jenkinsdocker.proxy._static;



import org.springframework.web.bind.annotation.RestController;

/**
 * 　　* @Description:
 * 　　* @param
 * 　　* @return
 * 　　* @throws
 * 　　* @author YY Shen
 * 　　* @date $ $
 *
 */
@RestController
public class ProxyController {

    private final TxManager txManager = new TxManager();

    public void test1(){
        IUserService userService = new IUserServiceImpl();  //目标类

        IUserService proxyService = new IUserServiceProxy(userService, txManager);  //代理类 -> 代理的是目标类
        IUserService proxyService2 = new IUserServiceProxy(proxyService, txManager); //代理类 -> 代理的是代理类
        User user = new User(1, 20);
        proxyService2.save(user);
    }

}
