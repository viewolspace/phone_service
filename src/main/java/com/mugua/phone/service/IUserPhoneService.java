package com.mugua.phone.service;

import com.mugua.phone.pojo.UserPhone;

import java.util.List;

/**
 * Created by lenovo on 2020/1/20.
 */
public interface IUserPhoneService {
    int addUserPhone(UserPhone userPhone);

    UserPhone getUserPhone(int userId);

    List<UserPhone> listUserPhone(int userId, int maxId, int pageSize);
}
