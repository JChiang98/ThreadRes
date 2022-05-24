package com.mydemo.study.thread;

import com.mydemo.model.Foo;

public class MyRunnable implements Runnable{
    private Foo foo =new Foo();

    @Override
    public void run() {

        for (int i = 0; i < 3; i++) {
            this.fix(30);
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " : 当前foo对象的x值= " + foo.getX());
        }
    }

    public int fix(int y) {
        return foo.fix(y);
    }

    public static void main(String[] args) {
        MyRunnable runnable=new MyRunnable();
        Thread t1=new Thread(runnable,"t1");
        Thread t2=new Thread(runnable,"t2");
        t1.start();
        t2.start();
    }


}
