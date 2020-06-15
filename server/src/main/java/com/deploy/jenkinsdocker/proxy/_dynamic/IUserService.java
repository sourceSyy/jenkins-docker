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
public interface IUserService {

    void save(User user);

    User getUser();

}
