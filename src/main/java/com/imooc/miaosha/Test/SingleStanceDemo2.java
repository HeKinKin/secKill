package com.imooc.miaosha.Test;

/**
 * @ClassName SingleStanceDemo2
 * @Description TODO
 * @Author HeX
 * @Date 2020/8/28 11:45
 * @Version 1.0
 **/
public class SingleStanceDemo2 {

    public volatile static  SingleStanceDemo2 instance;

    // 不允许new
    private SingleStanceDemo2(){
    }

    public static SingleStanceDemo2 getInstance() {
        if (instance == null) {
            synchronized (SingleStanceDemo2.class) {
                if (instance == null) {
                    try {
                        Thread.sleep(1);
                    }catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    instance = new SingleStanceDemo2();
                }
            }
        }
        return instance;
    }


    public static void main(String[] args) {
        for (int i=0;i<100;i++) {
            new Thread(()->
                    System.out.println(SingleStanceDemo2.getInstance().hashCode())
            ).start();
        }
    }
}
