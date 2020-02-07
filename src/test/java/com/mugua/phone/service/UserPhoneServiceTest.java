package com.mugua.phone.service;

import com.mugua.phone.base.BaseTestClass;
import com.mugua.phone.pojo.UserPhone;
import org.junit.Test;

/**
 * Created by lenovo on 2020/1/20.
 */
public class UserPhoneServiceTest extends BaseTestClass {
    IUserPhoneService userPhoneService = (IUserPhoneService)getInstance("userPhoneService");

    @Test
    public void addUserPhone(){
        UserPhone userPhone = new UserPhone();
        userPhone.setUserId(1);
        userPhone.setContent("12");
        userPhone.setDes("");
        userPhone.setNum(2);
        userPhoneService.addUserPhone(userPhone);
    }

    @Test
    public void getUserPhone(){
        System.out.println(userPhoneService.getUserPhone(1));
    }

    @Test
    public void listUserPhone(){
        System.out.println(userPhoneService.listUserPhone(1,1000,10));
    }
}
