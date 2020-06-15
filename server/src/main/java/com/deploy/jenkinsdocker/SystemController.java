package com.deploy.jenkinsdocker;

import com.deploy.jenkinsdocker.service.SystemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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
@Slf4j
public class SystemController {

    @Autowired
    private SystemService service;

    @GetMapping("/userList")
    public List<String> getUserList(HttpServletResponse response) throws IOException {
        List<String> userList = service.getUserList();
        ServletOutputStream outputStream = response.getOutputStream();
        outputStream.write(userList.toString().getBytes());
        return null;
    }

}
