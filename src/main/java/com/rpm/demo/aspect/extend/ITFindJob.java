package com.rpm.demo.aspect.extend;

import java.util.Date;

/**
 * Created by renpiming on 2017/11/10.
 */
public class ITFindJob implements FindJob{
    @Override
    public void sendResume(String company) {
        System.out.println("准备一份IT相关的简历，投递到"+company);
    }

    @Override
    public void goToInterview(Date date) {
        System.out.println("请在[" + date + "]参加面试");
    }

    @Override
    public String result() {
        return "success";
    }
}
