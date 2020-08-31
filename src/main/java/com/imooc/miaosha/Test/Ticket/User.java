package com.imooc.miaosha.Test.Ticket;

/**
 * @ClassName User
 * @Description TODO
 * @Author HeX
 * @Date 2020/8/31 10:30
 * @Version 1.0
 **/
public class User implements Runnable{
    private int num;        //抢到的第几张票
    private int count= 20;    //余票

    /**
     *     抢票
     */
    public void run() {
        // break是结束daowhile循环，return 是就是 程序duzhi，，continue是结束当次循环
        while(true) {
            try {
                Thread.sleep(300);                    //模拟网络延迟
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (this) {                    //同步代码块    一次只能有一个线程使用代码块
                if(count<=0) {
                    break;
                }
                num++;
                count--;
                System.out.println(Thread.currentThread().getName()+"抢到了第"+num+"张票,还剩"+count+"张票");
                if(Thread.currentThread().getName().equals("黄牛")) {
                    return;
                }
            }
        }
    }
}
