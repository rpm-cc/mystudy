package com.rpm.demo.spring.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.PathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

/**
 * Created by renpiming on 2017/12/18.
 */
@Configuration
@PropertySource("classpath:application.properties")
public class SpringConfig {
    @Autowired
    private Environment env;

//    @Bean
//    public BasicDataSource dataSource() {
//        BasicDataSource dataSource = new BasicDataSource();
//        dataSource.setDriverClassName(env.getProperty("jdbc.driver"));
//        dataSource.setUrl(env.getProperty("jdbc.url"));
//        dataSource.setUsername(env.getProperty("jdbc.username"));
//        dataSource.setPassword(env.getProperty("jdbc.password"));
//        return dataSource;
//
//    }
//
//    @Bean
//    public SqlSessionFactoryBean sessionFactor(){
//        SqlSessionFactoryBean sqlSession = new SqlSessionFactoryBean();
//        sqlSession.setDataSource(dataSource());
//        Resource resource = new PathResource("classpath::mybatis.xml");
//        sqlSession.setConfigLocation(resource);
//        return sqlSession;
//    }
//    @Bean
//    public MapperScannerConfigurer mybatisBasePackage(){
//        MapperScannerConfigurer mapperScannerConfigure = new MapperScannerConfigurer();
//        mapperScannerConfigure.setBasePackage("com.rpm.demo.spring.dao");
//        return   mapperScannerConfigure;
//    }
//    @Bean
//    public DataSourceTransactionManager transactionManager(){
//        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
//        transactionManager.setDataSource(dataSource());
//        return  transactionManager;
//    }


}