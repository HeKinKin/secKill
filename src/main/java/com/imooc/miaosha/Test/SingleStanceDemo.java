package com.imooc.miaosha.Test;

/**
 * @ClassName Singlenstance
 * @Description TODO
 * @Author HeX
 * @Date 2020/8/28 9:13
 * @Version 1.0
 **/
public class SingleStanceDemo {

    public static SingleStanceDemo instance;

    // 不允许new
    private SingleStanceDemo(){
    }

    public static SingleStanceDemo getInstance() {
        if (instance == null) {
            try {
               Thread.sleep(1);
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
            instance = new SingleStanceDemo();
        }
        return instance;
    }


    public static void main(String[] args) {
        for (int i=0;i<100;i++) {
            new Thread(()->
                    System.out.println(SingleStanceDemo.getInstance().hashCode())
            ).start();
        }
    }
}
