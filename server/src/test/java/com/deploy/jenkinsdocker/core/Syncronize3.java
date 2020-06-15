package com.deploy.jenkinsdocker.core;

/**
 * 　　* @Description: 两个线程同时访问Synchronize的静态同步方法
 * 　　* @param
 * 　　* @return
 * 　　* @throws
 * 　　* @author YY Shen
 * 　　* @date $ $
 *
 */
public class Syncronize3 implements Runnable {

    static Syncronize3 syncronize3 = new Syncronize3();

    @Override
    public void run() {
        show();
    }

    public synchronized void show(){
        System.out.println("开始"+Thread.currentThread().getName());
        info();
        System.out.println("结束"+Thread.currentThread().getName());

    }

    public void info(){
        System.out.println("开始info"+ Thread.currentThread().getName());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("结束info"+ Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(syncronize3);
        Thread thread2 = new Thread(syncronize3);
        thread1.start();
        thread2.start();
        while (thread1.isAlive() || thread2.isAlive()){}
        System.out.println("此时所有线程结束");
    }



}
