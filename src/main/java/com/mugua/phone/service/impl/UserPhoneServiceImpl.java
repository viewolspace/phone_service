package com.mugua.phone.service.impl;

import com.mugua.phone.dao.IUserPhoneDAO;
import com.mugua.phone.pojo.UserPhone;
import com.mugua.phone.service.IUserPhoneService;
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
