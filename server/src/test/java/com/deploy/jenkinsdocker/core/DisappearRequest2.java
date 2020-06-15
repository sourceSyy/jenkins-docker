package com.deploy.jenkinsdocker.core;

/**
 * 　　* @Description:
 * 　　* @param
 * 　　* @return
 * 　　* @throws
 * 　　* @author YY Shen
 * 　　* @date $ $
 *
 */
public class DisappearRequest2 implements Runnable {

    static int i = 0;

    static DisappearRequest2 disappearRequest1 = new DisappearRequest2();

    static Object lock1 = new Object();
    static Object lock2 = new Object();

    public static void main(String[] args) {
            Thread thread1 = new Thread(disappearRequest1);
            Thread thread2 = new Thread(disappearRequest1);
            thread1.start();
            thread2.start();

        System.out.println(i);
    }


    // I++ 这个操作不具备原子性，首先从内存读取i的值，然后进行+1 然后写会内存
    @Override
    public void run() {

        show();
    }

    public synchronized void show(){
        System.out.println(Thread.currentThread().getName());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
