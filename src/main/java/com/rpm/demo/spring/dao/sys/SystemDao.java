package com.rpm.demo.spring.dao.sys;

import com.rpm.demo.spring.beans.Menue;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by gc-rise on 2017/7/25.
 */
@Repository
public interface SystemDao {

    List<Menue> getMenues(int userId) throws  Exception;
}
