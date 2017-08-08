package com.rpm.demo.spring.service.sys.impl;

import com.rpm.demo.spring.beans.Menue;
import com.rpm.demo.spring.beans.UserMenue;
import com.rpm.demo.spring.commons.JsonUtil;
import com.rpm.demo.spring.dao.sys.SystemDao;
import com.rpm.demo.spring.service.sys.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * Created by gc-rise on 2017/7/25.
 */
@Service
@Transactional
public class SystemServiceImpl implements SystemService {

    @Autowired
    SystemDao dao;
    @Autowired
    MongoOperations operations;

    public UserMenue getMenues(int userId) throws Exception {

        List<Menue> menues = dao.getMenues(userId);
        menues = get(menues, 0);
        UserMenue userMenue = new UserMenue();
        userMenue.setUserId(userId);
        userMenue.setMenues(menues);

        //operations.save(userMenue);



        return userMenue;
    }

     //递归
    public List<Menue> get(List<Menue> menues, int fatherId) {

        List<Menue> subMenues = new ArrayList<Menue>();

        for (Menue menue : menues) {
            int pid = menue.getPid();
            int id = menue.getId();
            if (fatherId == pid) {
                List<Menue> subMenue = get(menues, id);
                menue.setSubMenues(subMenue);
                subMenues.add(menue);
            }


        }
        return subMenues;

    }

}
