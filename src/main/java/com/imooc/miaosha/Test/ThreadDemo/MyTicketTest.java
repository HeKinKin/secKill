package com.imooc.miaosha.Test.ThreadDemo;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName MyTicketTest
 * @Description TODO
 * @Author HeX
 * @Date 2020/9/4 10:40
 * @Version 1.0
 **/
public class MyTicketTest {

    public static int ticket = 4;

    static ReentrantLock reentrantLock = new ReentrantLock();
    public static void main(String[] args) {

        for (int i=0;i<5;i++) {
            new Thread(new Runnable() {

                @Override
                public void run() {
                    handTicketWithLock();
                }
            }).start();
        }
    }

    private static void handTicket() {
        synchronized (MyTicketTest.class) {
            while (ticket>0) {
                System.out.println(Thread.currentThread().getName()+"抢到了第"+ticket+"张票");
                ticket--;
            }
        }

    }

    /**
     * reentrantLock
     */
    private static void handTicketWithLock() {
        reentrantLock.lock();
        try {
            while (ticket>0) {
                System.out.println(Thread.currentThread().getName()+"抢到了第"+ticket+"张票");
                ticket--;
            }
        }finally {
            reentrantLock.unlock();
        }

    }

}
