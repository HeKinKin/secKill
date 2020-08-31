package com.imooc.miaosha.Test.Ticket;

/**
 * @ClassName Ticket
 * @Description TODO
 * @Author HeX
 * @Date 2020/8/31 10:32
 * @Version 1.0
 **/
public class Ticket {
    public static void main(String[] args) {
        //抢票的对象
        User u=new User();                //同一个线程
        Thread t1=new Thread(u,"小红");
        Thread t2=new Thread(u,"小强");
        Thread t3=new Thread(u,"黄牛");
        t1.start();
        t2.start();
        t3.start();
    }
}
