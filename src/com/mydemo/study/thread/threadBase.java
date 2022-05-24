package com.mydemo.study.thread;

import com.mydemo.model.DoSomething2;

public class threadBase {

    /**
     * 在java中，线程指两件不同的事情
     * 1.java.lang.Thread类中的一个实例
     * 2.线程的执行
     * 使用java.lang.Thread类和java.lang.Runnable接口来定义，实例化和启动新线程
     * Thread类是一个线程的实例对象，与java中其他实例对象一样，具有变量和方法，生死于堆上。
     * 在java中，每一个线程都有一个调用栈，即使不在程序中创建任何新线程，线程也在后台运行。
     * 一个java应用总是从main（）方法开始运行，main（）方法运行在线程中，被叫做主线程。
     * 一但创建一个线程，就会产生一个新的调用栈
     * 线程总体分为：用户线程和守护线程
     * 当所有用户线程执行完毕后JVM会自动关闭。守护线程一般有操作系统和用户自己创建，单元测试下的测试方法就是守护线程。
     *
     *===============================
     *
     * Thread类常用方法
     *      *      * start():启动当前线程，调用当前线程的run方法（main method thread or "system"不会调用此方法），该方法中核心是start0()方法，实现线程的启动
     *      *      * Run():通常需要重写Thread类中的此方法，将创建的线程要执行的操作声明在此方法中.
     *      *      * currentThread():静态方法，返回执行当前代码的线程
     *      *      * yield():让步方法，释放对当前CPU的执行权
     *      *      * join():在线程a中调用b的join（），此时线程a进入阻塞状态，直到b线程执行完后a结束阻塞，继续执行
     *      *      * sleep():当前执行线程以指定的毫秒数暂停
     *      *      * isAlive():查看这个线程是否存活
     *
     *===============================
     * 常见的线程问题
     * 1、线程的名字，一个运行中的线程总是有名字的，名字有两个来源，一个是虚拟机自己给的名字，一个是你自己的定的名字。在没有指定线程名字的情况下，虚拟机总会为线程指定名字，并且主线程的名字总是mian，非主线程的名字不确定。
     * 2、线程都可以设置名字，也可以获取线程的名字，连主线程也不例外。
     * 3、获取当前线程的对象的方法是：Thread.currentThread()。
     * 4.除非加入特定设置，对于任何一组启动的线程来说，调度程序不能保证其执行次序，持续时间也无法保证。每个线程都将启动，每个线程都将运行直到完成。
     * 5、当线程目标run()方法结束时该线程完成。
     * 6.线程一但被启动 就无法被重新启动，知道运行完成。只有新线程能被启动，并且只能一次，一个可运行（就绪状态）或死线程可以被重新启动
     */



    /**
     * 扩展java.lang.Thread类
     * Run（）方法
     * 1.Thread类实现了Runnable方法 --> class Thread implements Runnable{}
     * 2.Thread类中的run（）方法
     * 如果线程使用独立的Runnable接口运行构造对象，就调用Runnable对象中的run方法，否则该方法不执行任何操作的返回。
     *
     * private Runnable target;
     * Thread->public void run() {
     *         if (target != null) {
     *             target.run();
     *         }
     *     }
     *3.Thread 的子类应该重写该方法。
     * ===================
     * 实现java.lang.Runnable接口
     * 使用实现接口 Runnable 的对象创建一个线程时，启动该线程将导致在独立执行的线程中调用对象的 run 方法。
     *
     *
     */

    //实例化线程的两种方式：
    /**
     * 1.如果是扩展java.lang.Thread类的线程，直接new（继承Thread类）
     * 2.如果是实现了java.lang.Runnable接口的类，则用Thread的构造方法去是实例化线程（实现Runable接口）：
     * Thread(Runnable target)
     * Thread(Runnable target,String name)
     * Thread(Runnable target,ThreadGroup group)
     * Thread(Runnable target,ThreadGroup group,String name)
     * Thread(Runnable Target,ThreadGroup group,String name,long stackSize)
     */

    public static void main(String[] args) {
        System.out.println("currentThread()返回执行当前代码的线程:"+Thread.currentThread());
        Thread.currentThread().setName("MainThread");
        System.out.println("currentThread()返回执行当前代码的线程名:"+Thread.currentThread().getName());
        //Run()
        DoSomething2 doSomething2 = new DoSomething2("MyThread");
        DoSomething2 doSomething3 = new DoSomething2("MyThread2");
        doSomething2.start();

        doSomething3.start();
        //设置线程优先级别
        doSomething2.setPriority(10);
        System.out.println("isAlive()"+doSomething2.isAlive());

    }

}
