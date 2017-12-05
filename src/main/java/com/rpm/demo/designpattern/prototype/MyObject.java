package com.rpm.demo.designpattern.prototype;


//java 自己可以动过重写clone方法来进行复制。
class MyObject implements Cloneable{
    int i;
    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }
}//结果会输出 500