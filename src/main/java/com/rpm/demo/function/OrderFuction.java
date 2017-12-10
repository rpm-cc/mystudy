package com.rpm.demo.function;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by gc-rise on 2017/9/13.
 */
public class OrderFuction {
    //从最简单的开始。排序

    int [] arr = {3,8,3,5,2,8,12,1,4,6};



    public  void bubbleSort()
    {
        int [] arr = {3,8,3,5,2,8,12,1,4,6};
        int temp = 0;
        for (int i = arr.length - 1; i > 0; --i)
        {
            for (int j = 0; j < i; ++j)
            {
                if (arr[j + 1] < arr[j])
                {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            for (int k=0;k<arr.length;k++){
                System.out.printf("--"+arr[k]);
            }
            System.out.println("");
        }




    }

    public void  mapOpration(){
        Map map = new HashMap<>();
    }

    public static void main(String[] args) {



        OrderFuction one = new OrderFuction();
        one.bubbleSort();
    }

}
