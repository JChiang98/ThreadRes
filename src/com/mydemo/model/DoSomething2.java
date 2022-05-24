package com.mydemo.model;

public class DoSomething2 extends Thread{

    private String threadName;

    public DoSomething2(String threadName){
        super(threadName);
    }

    @Override
    public void run() {

        for(int i = 0; i <= 10; i++){

            if(i%2==0){
                //this.yield();

//                try {
//                    sleep(10000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                System.out.println(Thread.currentThread().getName()+"-----"+i);
            }

        }
    }
}
