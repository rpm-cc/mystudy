package com.rpm.demo.spring.learn.annotations;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

/**
 * Created by gc-rise on 2017/8/11.
 */
//@Configuration
//@PropertySource("classpath:application.properties")
public class DataSourceConfiguration {



    //@Autowired
   // private Environment env;

  //  @Bean(name="dataSource")
    public BasicDataSource dataSource(){
        BasicDataSource dataSource = new BasicDataSource();
//         <property name="driverClassName" value="${jdbc.driver}"/>
//        <property name="url" value="${jdbc.url}"/>
//        <property name="username" value="${jdbc.username}"/>
//        <property name="password" value="${jdbc.password}"/>
//        <property name="maxActive" value="${jdbc.maxActive}"/>
//        <property name="minIdle" value="${jdbc.minIdle}"/>
//        <property name="maxIdle" value="${jdbc.maxIdle}"/>
//        <property name="initialSize" value="${jdbc.initialSize}"/>
       // dataSource.setDriverClassName(env.getProperty("jdbc.driver"));
       // dataSource.setUrl(env.getProperty("jdbc.url"));
       // dataSource.setUsername(env.getProperty("jdbc.username"));
       // dataSource.setPassword(env.getProperty("jdbc.password"));

        return dataSource;
    }



}
