package com.rpm.demo.function;

/**
 * Created by renpiming on 2017/12/14.
 */
public class Father {

    public String str= "father String ";
    //public static  final String staticStr = "father static String";
    protected  String protectStr = "fahter protect String";
    private String privateStr = "father private String ";

    public Father(){
        System.out.println("fahter constructor");
    }

    public void publicMethod(){
        System.out.println("father public method");
    }

    protected void protectedMethod(){

        System.out.println("father protected method");
    }
    private void  privateMethod(){
        System.out.println("father private method");
    }



    public void toPrint() {
        System.out.println( "Father{" +
                "str='" + str + '\'' +
                ", protectStr='" + protectStr + '\'' +
                ", privateStr='" + privateStr + '\'' +
                '}');
    }
}
