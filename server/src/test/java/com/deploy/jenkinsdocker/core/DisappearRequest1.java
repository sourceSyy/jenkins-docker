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
public class DisappearRequest1 implements Runnable {

    static int i = 0;

    static DisappearRequest1 disappearRequest1 = new DisappearRequest1();

    static Object lock1 = new Object();
    static Object lock2 = new Object();

    public static void main(String[] args) {
        try {
            Thread thread1 = new Thread(disappearRequest1);
            Thread thread2 = new Thread(disappearRequest1);
            thread1.start();
            thread2.start();
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(i);
    }


    // I++ 这个操作不具备原子性，首先从内存读取i的值，然后进行+1 然后写会内存
    @Override
    public void run() {
        synchronized (lock1){
            for (int j =0; j<10000; j++){
                i ++;
            }
        }
    }
}
