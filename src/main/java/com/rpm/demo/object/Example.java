package com.rpm.demo.object;

import java.util.*;

/**
 * Created by renpiming on 2017/12/11.
 */
public class Example {



    public static void main(String[] args) {
        List arrayList =new ArrayList();
        List linkedList = new LinkedList();
        //System.out.println("ArrayList 数组最大值"+Integer.MIN_VALUE);

        bitOperation();

    }



    public  static  void  bitOperation(){

        System.out.println(1<<2);
        System.out.println(8>>2);
        System.out.println(8>>>2);
        System.out.println((-8)>>>2);

    }

}
