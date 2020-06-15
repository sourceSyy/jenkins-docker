package com.deploy.jenkinsdocker.lambda;

import com.deploy.jenkinsdocker.proxy._static.ProxyController;
import org.junit.jupiter.api.Test;
/**
 * 　　* @Description:
 * 　　* @param
 * 　　* @return
 * 　　* @throws
 * 　　* @author YY Shen
 * 　　* @date $ $
 *
 */
public class JenkinsDocker {

    ProxyController proxyController = new ProxyController();

    @Test
    public void test(){
        proxyController.test1();
    }

}
