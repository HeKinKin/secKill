package com.imooc.miaosha.Test.ThreadDemo;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.stream.Stream;

/**
 * @ClassName MyTest
 * @Description 最近在实际项目中遇到了需要多线程来处理的一个实际问题：
 * 一堆视频资源需要上传到一个cc平台，如果串行处理，显然不能很好实用多核的cpu处理器，
 * 于是考虑到实用线程的方式进行上传，但是创建多少个线程了？如果一个资源对应一个线程去处理，
 * 当资源数目过多的时候，创建的线程过多，同时执行处理资源显然会把服务器搞崩。经过思考，
 * 和同事进行讨论，也是同事的提醒，建议说一次性最多创建5个线程，进行对资源进行处理比较好，创建5个
 *
 *
 * 1.线程安全的集合存放资源
 *
 * ArrayList ：
 * LinkedList：
 * HashMap：
 * HashSet：
 * TreeMap：
 * TreeSet：
 * StringBulider：
 * 以上都是线程不安全的，最后选择使用ConcurrentLinkedQueue，
 * 它是线程安全的集合，允许并发的访问数据结构的不同部分来使竞争极小化。
 * 这些集合返回弱一致性的迭代器。这意味着迭代器不一定能反映出他们被构造之后的所有的修改，但是，他们不会将同一个值返回两次。
 *
 * @Author HeX
 * @Date 2020/9/4 10:02
 * @Version 1.0
 **/
public class MyTest {
    public static void main(String[] args) {
        // 队列是一种特殊的线性表，它只允许在表的前端进行删除操作，而在表的后端进行插入操作。
        final Queue<String> queue = new ConcurrentLinkedQueue<String>();
        queue.add("11111111111");
        queue.add("22222222222");
        queue.add("33333333333");
        queue.add("44444444444444");
        queue.add("555555555555555");
        queue.add("666666666666666");
        queue.add("7777777777777");
        Stream.of(queue).forEach(value->{
            System.out.println(value);
        });

        for (int i=0;i<5;i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (queue.size()>0) {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        String value = queue.poll();
                        if(value != "" && null != value)
                            System.out.println(Thread.currentThread().getName()+"-------------"+value);
                    }
                    queue.poll();
                }
            }).start();

        }
        // 这种写法，既不会出现漏掉资源的情况，同时也不会出现将同一个资源同时执行的情况！

    }



}
