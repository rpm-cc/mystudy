package com.rpm.demo.spring.service.user;


import com.rpm.demo.spring.beans.User;

import java.util.List;
import java.util.Map;

/**
 * Created by gc-rise on 2017/7/13.
 */
public interface UserService {

    String  getNameById(int id) throws  Exception;
    User getUserInfoByid (int id ) throws  Exception;
    User auth(  Map<String,Object> paramMap) throws Exception;

}
