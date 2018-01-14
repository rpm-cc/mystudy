package com.rpm.demo.thread.blockqueue;

public class ShortCircuit {
    static boolean test1(int val) {
        System.out.println("test1(" + val + ")");
        System.out.println("result: " + (val < 1));
        return val < 1;
    }

    static boolean test2(int val) {
        System.out.println("test2(" + val + ")");
        System.out.println("result: " + (val < 2));
        return val < 2;
    }

    static boolean test3(int val) {
        System.out.println("test3(" + val + ")");
        System.out.println("result: " + (val < 3));
        return val < 3;
    }


    public  static  long recursion(int n) { //补充代码


        if(n==1){
            return  1;
        }

        return n*recursion(n-1);

    }
    public static void main(String[] args) {
        //boolean b = test1(0) && test2(2) && test3(2);
        //System.out.println("expression is " + b);


        int i = 5;

        System.out.println(recursion(i));
    }
}


