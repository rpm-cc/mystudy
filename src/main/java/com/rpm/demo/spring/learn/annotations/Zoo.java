package com.rpm.demo.spring.learn.annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by gc-rise on 2017/8/11.
 */
@Service
public class Zoo {

    @Autowired Tiger tiger;
    @Autowired Monkey monkey;

    @Override
    public String toString() {

        return "Zoo{" +
                "tiger=" + tiger +
                ", monkey=" + monkey +
                '}';
    }
}
