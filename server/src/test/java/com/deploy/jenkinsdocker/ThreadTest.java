package com.deploy.jenkinsdocker;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 　　* @Description:
 * 　　* @param
 * 　　* @return
 * 　　* @throws
 * 　　* @author YY Shen
 * 　　* @date $ $
 *
 */
public class ThreadTest implements Callable<String> {

    private String name = null;

    @Override
    public String call() throws Exception {
        Thread.sleep(5000);
        name =  "大家都是中国人";
        return name;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        String name1 = null;
        FutureTask<String> futureTask = new FutureTask(new ThreadTest());
        Thread thread = new Thread(futureTask);
        thread.start();
        name1 = futureTask.get();
        System.out.println(name1);
    }
}
