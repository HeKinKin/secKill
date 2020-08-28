package com.imooc.miaosha.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;

/**
 * @ClassName Test
 * @Description TODO
 * @Author HeX
 * @Date 2020/8/28 14:16
 * @Version 1.0
 **/
public class Test {


    public  static HashMap hashMap = new HashMap();
    public static void main(String[] args) {
        Collections.synchronizedMap(hashMap);

        Hashtable hashtable = new Hashtable();
    }
}
