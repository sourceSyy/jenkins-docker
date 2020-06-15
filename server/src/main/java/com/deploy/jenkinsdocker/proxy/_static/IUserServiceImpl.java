package com.deploy.jenkinsdocker.proxy._static;

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

}
