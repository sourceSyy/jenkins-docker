package com.deploy.jenkinsdocker.asept;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 　　* @Description:
 * 　　* @param
 * 　　* @return
 * 　　* @throws
 * 　　* @author YY Shen
 * 　　* @date $ $
 *
 */
@Aspect
@Component
public class ControllerAsept {

    @Pointcut(value = "execution(* com.deploy.jenkinsdocker.service.*.*(..))")
    public void publishController(){

    }

    @Around(value = "publishController()")
    public Object around(ProceedingJoinPoint pjp){
        Object result = null;
        try {
            Object[] args = pjp.getArgs();  // 参数列表
            Object target = pjp.getTarget(); //目标对象吧
            

            System.out.println("前置通知");
            Object proceed = pjp.proceed();
            result = proceed;
            System.out.println("后置通知");
        }catch (Throwable throwable) {
            throwable.printStackTrace();
        } finally {
            System.out.println("最终通知");
        }
        return result;
    }

}
