package com.rpm.demo.function;

/**
 * Created by gc-rise on 2017/9/13.
 */
public class JavaOne {
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



    public static void main(String[] args) {



        JavaOne one = new JavaOne();
        one.bubbleSort();
    }

}
