package com.rpm.demo.designpattern.builder;

public class Derector {
    private ProductBuilder builder;

    public Derector(ProductBuilder builder) {
        this.builder = builder;
    }

    public int getPrice(int code, String name, int price, String descr) {
        builder.builder(code, name, price, descr);
        return builder.price();
    }

    //应用不同实现，就可以得到响应的结果。比如此处我们粗略的实现一个汇率转化的方法。输入人民币的分值。获得美元的分值。
    public static void main(String[] args) {
        Derector derector = new Derector(new DOLLERProductBuilder());
        int price = derector.getPrice(123,"",3898,"");
        System.out.println(price);
    }

}