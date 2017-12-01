package com.rpm.demo.aspect.extend;

import java.util.Date;

/**
 * Created by renpiming on 2017/11/10.
 */
public interface FindJob {

    public void sendResume(String company);
    public void goToInterview(Date date);
    public String result();
}
