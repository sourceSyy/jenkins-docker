package com.deploy.jenkinsdocker;

import org.junit.Assert;
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
public class JenkinsDocker extends JenkinsDockerApplicationTests {

    @Test
    public void test(){
        String str1 = "123";
        String str2 = "234";
        Assert.assertEquals(str1, str2);
    }

}
