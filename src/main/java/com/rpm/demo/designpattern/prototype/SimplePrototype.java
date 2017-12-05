package com.rpm.demo.designpattern.prototype;


public class SimplePrototype implements Prototype<SimplePrototype>,Cloneable {
    int value;
    //clone()实现
    @Override
    public SimplePrototype cloneSelf() {
        SimplePrototype self = new SimplePrototype();
        self.value = value;
        return self;
    }
    //使用
    public static void main(String args[]){
        SimplePrototype simplePrototype = new SimplePrototype();
        simplePrototype.value = 500;
        SimplePrototype simplePrototypeClone = (SimplePrototype) simplePrototype.cloneSelf();
        System.out.println(simplePrototypeClone.value);
    }
}