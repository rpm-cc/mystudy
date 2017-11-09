package com.rpm.demo.spring.commons;

import sun.security.provider.MD5;

/**
 * Created by renpiming on 2017/11/1.
 */
public class Signature {

    public  static final String SECRETKEY="DD0KK0QSas18dncbsmoJHGJbfhkkn";


    public String  postSignature(String accessKey,String secretKey){


        return MD5Util.encode(accessKey+"renpiming"+secretKey);



    }
}
