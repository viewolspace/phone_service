package com.chenghe.parttime.dao.impl;

import com.chenghe.parttime.dao.BaseDAO;
import com.chenghe.parttime.dao.IUserPhoneDAO;
import com.chenghe.parttime.pojo.UserPhone;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lenovo on 2020/1/20.
 */
@Repository("userPhoneDAO")
public class UserPhoneDAOImpl extends BaseDAO<UserPhone> implements IUserPhoneDAO {
    @Override
    public int addUserPhone(UserPhone userPhone) {
        userPhone.setcTime(new Date());
        userPhone.setmTime(new Date());
        return super.insert(userPhone);
    }

    @Override
    public UserPhone getUserPhone(int userId) {
        return super.get(userId);
    }

    @Override
    public List<UserPhone> listUserPhone(int userId, int maxId , int pageSize) {

        if(maxId==0){
            maxId=Integer.MAX_VALUE;
        }

        Map<String,Object> map = new HashMap<>();
        map.put("userId",userId);
        map.put("maxId",maxId);
        map.put("pageSize",pageSize);

        return super.findBy("selectList",map);
    }
}
