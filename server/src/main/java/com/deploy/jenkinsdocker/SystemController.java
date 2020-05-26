package com.deploy.jenkinsdocker;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
@RestController
public class SystemController {

    @GetMapping("/userList")
    public List<String> getUserList(){
        return Arrays.asList("张三", "李四", "王五", "赵柳");
    }

}
