package com.rpm.demo.designpattern.prototype;

interface Prototype<T>{
    T cloneSelf();//克隆自身的方法
}