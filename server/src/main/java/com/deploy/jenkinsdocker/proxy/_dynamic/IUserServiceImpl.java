package com.deploy.jenkinsdocker.proxy._dynamic;

import com.deploy.jenkinsdocker.proxy._static.User;

/**
 * 　　* @Description:
 * 　　* @param
 * 　　* @return
 * 　　* @throws
 * 　　* @author YY Shen
 * 　　* @date $ $
 *
 */
public class IUserServiceImpl implements IUserService {
    @Override
    public void save(User user) {
        System.out.println(user.toString());
    }

    @Override
    public User getUser() {
        System.out.println("这里是get方法");
        return new User(2, 200);
    }
}
