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
public class TxManager {

    public void begin(){
        System.out.println("开始事务");
    }
    public void commit(){
        System.out.println("提交事务");
    }
    public void rollback(){
        System.out.println("回顾事务");
    }
    public void close(){
        System.out.println("关闭资源");
    }

}
