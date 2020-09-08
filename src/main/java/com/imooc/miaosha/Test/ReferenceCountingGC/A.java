package com.imooc.miaosha.Test.ReferenceCountingGC;

/**
 * @ClassName A
 * @Description TODO
 * @Author HeX
 * @Date 2020/9/7 14:40
 * @Version 1.0
 **/
public class A {
    B b;
    public A() {
        b = new B();
    }

    public B getB() {return b;}
}
