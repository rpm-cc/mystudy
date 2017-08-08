package com.rpm.demo.spring.service.user.impl;

import com.rpm.demo.spring.beans.User;
import com.rpm.demo.spring.dao.user.UserDao;
import com.rpm.demo.spring.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Created by gc-rise on 2017/7/13.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao dao;

    public String getNameById(int id) throws Exception {
        return dao.getNameById(id);
    }

    public User getUserInfoByid(int id) throws Exception {
        return dao.getUserInfoByid(id);
    }

    public User auth(Map<String, Object> paramMap) throws Exception {


        return dao.auth(paramMap);
    }
}
