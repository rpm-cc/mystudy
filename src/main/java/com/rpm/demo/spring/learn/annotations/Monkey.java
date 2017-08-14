package com.rpm.demo.spring.learn.annotations;

import org.springframework.stereotype.Service;

/**
 * Created by gc-rise on 2017/8/11.
 */
@Service
public class Monkey {
    public String monkerName;

    @Override
    public String toString() {
        return "Monkey{" +
                "monkerName='" + monkerName + '\'' +
                '}';
    }
}
