package com.rpm.demo.spring.dao.user;

import com.rpm.demo.spring.beans.User;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * Created by gc-rise on 2017/7/13.
 */
@Repository
public interface UserDao {

    String getNameById(int id) throws Exception;

    User getUserInfoByid(int id) throws Exception;

    User auth(Map<String, Object> paramMap) throws Exception;

}
