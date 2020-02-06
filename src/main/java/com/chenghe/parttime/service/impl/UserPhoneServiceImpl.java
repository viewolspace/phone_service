package com.chenghe.parttime.service.impl;

import com.chenghe.parttime.dao.IUserPhoneDAO;
import com.chenghe.parttime.pojo.UserPhone;
import com.chenghe.parttime.service.IUserPhoneService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by lenovo on 2020/1/20.
 */
@Service("userPhoneService")
public class UserPhoneServiceImpl implements IUserPhoneService {
    @Resource
    private IUserPhoneDAO userPhoneDAO;
    @Override
    public int addUserPhone(UserPhone userPhone) {
        return userPhoneDAO.addUserPhone(userPhone);
    }

    @Override
    public UserPhone getUserPhone(int userId) {
        return userPhoneDAO.getUserPhone(userId);
    }

    @Override
    public List<UserPhone> listUserPhone(int userId, int maxId, int pageSize) {
        return userPhoneDAO.listUserPhone(userId, maxId, pageSize);
    }
}
