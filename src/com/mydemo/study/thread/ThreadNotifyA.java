package com.mydemo.study.thread;

/**
 * 线程交互--等待/通知
 * 线程交互的知识点需要从java.lang.Object类中的三个方法学习
 * void notify():唤醒在此对象监视器上等待的单个线程
 * void notifyAll():唤醒在此对象监视器上等待的所有线程
 * void wait():设置当前线程的状态为等待状态，直到其他线程调用该对象的notify或notifyAll方法、该方法只能在同步方法或者同步块中调用
 * wait（）有两个重载方法
 * void wait(long timeout)：导致当前的线程等待，直到其他线程调用此对象的 notify() 方法或 notifyAll() 方法，或者超过指定的时间量。
 * void wait(long timeout, int nanos)：导致当前的线程等待，直到其他线程调用此对象的 notify() 方法或 notifyAll() 方法，或者其他某个线程中断当前线程，或者已超过某个实际时间量。
 *
 * 以上三个方法需要在同步环境内调用，线程不能调用对象上等待或者通知的方法，除非他拥有那个对象的锁。
 * wait()、notify()、notifyAll()都是Object的实例方法，与每个对象具有锁一样，每个对象可以有一个线程列表，他们会等待来自该通知，线程通过执行对象上的wait()方法获得这个等待列表，
 * 从那时候起，它不再执行任何其他指令，直到调用对象的notify()方法为止。如果多个线程在同一个对象上等待，则将只选择一个线程（不保证以何种顺序）继续执行。如果没有线程等待，则不采取任何特殊操作。
 */
public class ThreadNotifyA {

    public static void main(String[] args) throws InterruptedException {
        ThreadNotifyB b = new ThreadNotifyB();
        //启动计算
        b.start();

        synchronized (b){

            try {
                System.out.println("等待对象b完成计算。。。");
                //当前线程A等待
                b.wait();
                System.out.println("b对象计算的总和是：" + b.total);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("b对象计算的总和是：" + b.total);
        }
    }
}
