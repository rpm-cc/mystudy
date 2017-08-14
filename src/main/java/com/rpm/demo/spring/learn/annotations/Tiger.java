package com.rpm.demo.spring.learn.annotations;

import org.springframework.stereotype.Service;

/**
 * Created by gc-rise on 2017/8/11.
 */
@Service
public class Tiger {
    public  String tigerName;

    @Override
    public String toString() {
        return "Tiger{" +
                "tigerName='" + tigerName + '\'' +
                '}';
    }
}
