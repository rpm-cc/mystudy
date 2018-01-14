package com.rpm.demo.function;

import java.util.ArrayList;
import java.util.List;

public class AinB {
    //控制台输出时候显示会有一定缓存，所有结果不一定对，但是算法一定对的
    public static int MAX_ = 6;
    public static int NUM_ = 30;
    public static int num[] = new int[NUM_];
    public static int lottey[] = new int[MAX_];

    public static void conbine(int nUM_2, int mAX_2) {
        // TODO Auto-generated method stub
        System.out.println(mAX_2);
        for (int i = nUM_2; i >= mAX_2; i--) {
            lottey[mAX_2 - 1] = num[i - 1];
            if (mAX_2 > 1) {
                conbine(i - 1, mAX_2 - 1);
            } else {
                for (int c = MAX_ - 1; c >= 0; c--)
                    System.out.print(lottey[c] + " ");
                System.out.println();

            }
        }
    }


    public static void main(String[] args) throws InterruptedException {
        List<String> list  = new ArrayList<>();

        while(true){
            list.add("abcd");
            Thread.sleep(100);
            System.out.printf(list.toString());
        }
//        for (int i = 0; i < NUM_; i++) {
//            num[i] = i + 1;
//        }
//        for (int i = 0; i < MAX_; i++) {
//            lottey[i] = 0;
//        }
//        conbine(NUM_, MAX_);
    }
}