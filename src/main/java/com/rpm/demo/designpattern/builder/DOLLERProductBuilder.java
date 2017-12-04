package com.rpm.demo.designpattern.builder;

/**
 * Created by renpiming on 2017/12/4.
 */
public class DOLLERProductBuilder implements ProductBuilder {


    private Product product;

    public DOLLERProductBuilder() {
        this.product = new Product();
    }

    @Override
    public ProductBuilder builder(int code, String name, int price, String descr) {
        product.code = code;
        product.name = name;
        product.price = new Double(price / HuiLv.DOULLER).intValue();
        product.descr = descr;
        return this;
    }


    @Override
    public int price() {
        return product.price;
    }
}
