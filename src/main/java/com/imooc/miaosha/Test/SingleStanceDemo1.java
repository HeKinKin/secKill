package com.imooc.miaosha.Test;

/**
 * @ClassName SingleStanceDemo1
 * @Description TODO
 * @Author HeX
 * @Date 2020/8/28 11:44
 * @Version 1.0
 **/
public class SingleStanceDemo1 {
    public static SingleStanceDemo1 instance;

    // 不允许new
    private SingleStanceDemo1(){
    }

    public static synchronized SingleStanceDemo1 getInstance() {
        if (instance == null) {
            try {
                Thread.sleep(1);
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
            instance = new SingleStanceDemo1();
        }
        return instance;
    }


    public static void main(String[] args) {
        for (int i=0;i<100;i++) {
            new Thread(()->
                    System.out.println(SingleStanceDemo1.getInstance().hashCode())
            ).start();
        }
    }
}
