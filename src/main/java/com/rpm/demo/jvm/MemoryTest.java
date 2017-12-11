package com.rpm.demo.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by renpiming on 2017/12/10.
 */
public class MemoryTest {


    public static void main(String[] args) {
         String[] arr = new String[1000];
         for (int i=0;i<100;i++){

             arr[i]="outmemory";

         }
        List<String[]> list  = new ArrayList<>();
        while (true){
            list.add(arr);
        }
    }
}
