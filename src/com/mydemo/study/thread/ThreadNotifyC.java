package com.mydemo.study.thread;

public class ThreadNotifyC extends Thread{

    ThreadNotifyB c;
    public ThreadNotifyC(ThreadNotifyB c) {
        this.c = c;
    }
    public void run() {
        synchronized (c) {
            try {
                System.out.println(Thread.currentThread() + "等待计算结果。。。");
                c.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread() + "计算结果为：" + c.total);
        }
    }
    public static void main(String[] args) {
        ThreadNotifyB calculator = new ThreadNotifyB();
        //启动三个线程，分别获取计算结果
        new ThreadNotifyC(calculator).start();
        new ThreadNotifyC(calculator).start();
        new ThreadNotifyC(calculator).start();
        //启动计算线程
        calculator.start();
    }
}
