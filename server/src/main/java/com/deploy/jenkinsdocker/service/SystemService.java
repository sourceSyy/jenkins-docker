package com.deploy.jenkinsdocker.service;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * 　　* @Description:
 * 　　* @param
 * 　　* @return
 * 　　* @throws
 * 　　* @author YY Shen
 * 　　* @date $ $
 *
 */
@Service
public class SystemService {
    public List<String> getUserList(){
        System.out.println("业务逻辑");
        return Arrays.asList("张三", "李四", "王五", "赵柳");
    }
}
