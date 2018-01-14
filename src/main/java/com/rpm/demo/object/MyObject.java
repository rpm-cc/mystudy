package com.rpm.demo.object;

import java.io.Serializable;

/**
 * Created by renpiming on 2017/12/18.
 */
public class MyObject implements Serializable {
    private static final long serialVersionUID = -803541663625483898L;

    public static final String TEST_IO="test io";

    transient  String descr="this is only descr";

    public void doSomting(){
        String doSometing="the method do somethind, but nothing to do ";

    }

}
