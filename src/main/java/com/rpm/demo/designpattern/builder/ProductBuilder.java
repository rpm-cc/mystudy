package com.rpm.demo.designpattern.builder;

/**
 * Created by renpiming on 2017/12/4.
 */
public interface ProductBuilder {


    ProductBuilder builder(int code,String name,int price,String descr );
    int price();

}
