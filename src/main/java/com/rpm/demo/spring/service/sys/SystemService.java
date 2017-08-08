package com.rpm.demo.spring.service.sys;

import com.rpm.demo.spring.beans.Menue;
import com.rpm.demo.spring.beans.UserMenue;

import java.util.List;
import java.util.Map;

/**
 * Created by gc-rise on 2017/7/25.
 */
public interface SystemService {

    UserMenue getMenues(int userId) throws  Exception;


}
