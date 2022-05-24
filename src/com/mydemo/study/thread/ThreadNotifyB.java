package com.mydemo.study.thread;

public class ThreadNotifyB extends Thread{

    int total;

    @Override
    public void run() {
        synchronized (this){
            System.out.println("开始------wait time = " + System.currentTimeMillis());
            for (int i = 0; i < 101; i++) {
                total += i;
            }

            notifyAll();
        }
        System.out.println(total);

    }
}
