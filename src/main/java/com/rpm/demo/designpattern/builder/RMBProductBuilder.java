package com.rpm.demo.designpattern.builder;

import com.rpm.demo.spring.commons.HttpUtil;

/**
 * Created by renpiming on 2017/12/4.
 */
public class RMBProductBuilder implements ProductBuilder{


    private Product product;

    public RMBProductBuilder() {
        this.product = new Product();
    }

    @Override
    public ProductBuilder builder(int code, String name, int price, String descr) {
        product.code=code;
        product.name=name;
        product.price=new Double(price/HuiLv.RPM).intValue();
        product.descr=descr;
        return this;
    }



    @Override
    public int price() {
        return product.price;
    }
}
