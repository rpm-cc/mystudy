package com.rpm.demo.designpattern.adapter;

import java.util.Enumeration;
import java.util.Iterator;

public class IteratorAdapter implements Iterator<String> {
    Enumeration<String> myEnum;
    public IteratorAdapter(Enumeration<String> myEnum){
        this.myEnum = myEnum;
    }
    @Override
    public boolean hasNext() {
        return myEnum.hasMoreElements();
    }
    @Override
    public String next() {
        return myEnum.nextElement();
    }
}