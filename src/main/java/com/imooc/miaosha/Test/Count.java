package com.imooc.miaosha.Test;

/**
 * @ClassName Count
 * @Description TODO
 * @Author HeX
 * @Date 2020/8/31 10:21
 * @Version 1.0
 **/
public class Count implements Runnable{
    private static int count = 10;


    @Override
    public void run() {
        handleCount();
    }

    private  synchronized void handleCount() {
        while (true) {
            if (count<=0) {
                break;
            }
            System.out.println(Thread.currentThread().getName()+"count是"+count--);
            try {
                Thread.sleep(100);
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new Thread(new Count()).start();
        new Thread(new Count()).start();
        new Thread(new Count()).start();
        new Thread(new Count()).start();
        new Thread(new Count()).start();
        new Thread(new Count()).start();
        new Thread(new Count()).start();

    }
}
