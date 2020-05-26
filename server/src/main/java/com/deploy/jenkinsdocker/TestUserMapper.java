package com.deploy.jenkinsdocker;

import java.util.function.Function;

/**
 * 　　* @Description:
 * 　　* @param
 * 　　* @return
 * 　　* @throws
 * 　　* @author YY Shen
 * 　　* @date $ $
 *
 */
// 自定义接口
public interface TestUserMapper<T1> {

    //切换类型 - 转换类型返回原来接口
    public <U> TestUserMapper<U> map(Function<? super T1, ? extends U> converter);


}
