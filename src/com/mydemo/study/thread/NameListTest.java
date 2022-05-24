package com.mydemo.study.thread;

/**
 * 线程同步：
 * 线程同步的目的是为了保护多个线程访问同一个资源时对资源的一个破坏。
 * 线程同步的方式是通过锁来实现的，每个对象都有且仅有一个锁，这个锁与一个特定的对象关联，线程一但获取了对象锁，其他访问该对象的线程就无法再访问该对象的其他同步方法。
 * 对于静态同步方法，锁是针对这个类的，锁对象就是该类的Class对象。静态和非静态方法的锁互不干预，一个线程获得锁，当在一个同步方法中访问另外一个对象上的同步方法时，会获取这两个锁对象。
 * 对于同步 要时刻清醒在哪个对象上同步。
 * 编写一个线程安全的类，要时刻注意多个线程竞争访问资源的逻辑和安全，做出正确的判断，对“原子操作”做出正确的判断，保证原子操作期间别的线程无法竞争资源。
 * 多线程竞争锁资源时，未获取到资源的线程会进入阻塞态
 */
public class NameListTest {

    /**
     * 线程安全类：当一个线程已经很好的同步用以保护它的数据时 这个类就是线程安全的。但是就算是线程安全类也要小心，因为对其进行操作的线程间仍然不一定是线程安全的。
     * 如下：NameList是一个线程安全的集合类，但是有两个线程在操作同一个集合对象，当一个线程查询到集合非空时，做删除操作时，线程二也来执行和线程一一样的操作，在线程
     * 一查出还未删除这一时间节点中，线程二查出集合非空。但是当第一个执行清除后，第二个再执行删除显然是不对的，
     * 根据代码内容控制台出现的结果是：
     * 线程一：test
     * 线程二：null。
     *
     * 出现以上结果是因为虽然集合对象private List nameList = Collections.synchronizedList(new LinkedList());是同步的，但程序不是线程安全的，上述其中一个线程操作集合列表中
     * 无法阻止另外一个线程对同一个集合对象的操作，故需要在操作集合对象的方法add（）方法上再做一个同步锁。
     *
     * @param args
     */
    public static void main(String[] args) {

        final NameList n = new NameList();
        n.add("test");
        class  nameListThread extends Thread{

            @Override
            public void run() {
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                String name = n.removeFirst();
                System.out.println(name);
            }
        }

        nameListThread nameListThread = new nameListThread();
        nameListThread nameListThread1 =new nameListThread();
        nameListThread.start();

        nameListThread1.start();
    }
}
