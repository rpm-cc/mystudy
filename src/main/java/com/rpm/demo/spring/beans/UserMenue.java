package com.rpm.demo.spring.beans;

import java.io.Serializable;
import java.util.List;

/**
 * Created by gc-rise on 2017/7/25.
 * 将用户的menues进行组装，存放在mogodb中。可以直接获取 。
 */

public class UserMenue implements Serializable {

    private static final long serialVersionUID = -4121947125346441568L;
    int userId ;
    List<Menue> menues;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public List<Menue> getMenues() {
        return menues;
    }

    public void setMenues(List<Menue> menues) {
        this.menues = menues;
    }
}
