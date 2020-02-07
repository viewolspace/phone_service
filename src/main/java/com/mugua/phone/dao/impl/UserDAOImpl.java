package com.mugua.phone.dao.impl;

import com.mugua.phone.dao.BaseDAO;
import com.mugua.phone.dao.IUserDAO;
import com.mugua.phone.pojo.User;
import com.mugua.phone.query.UserQuery;
import com.youguu.core.util.PageHolder;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.HashMap;

/**
 * describe:
 *
 * @author: shi_lei@suixingpay.com
 * @date: 2019/07/20 17:18:17:18
 * @version: V1.0
 * @review:
 */
@Repository("userDAO")
public class UserDAOImpl extends BaseDAO<User> implements IUserDAO {
    @Override
    public int addUser(User user) {
        Date d = new Date();
        user.setcTime(d);
        user.setmTime(d);
        return super.insert(user);
    }

    @Override
    public int updateUser(User user) {
        return super.update(user);
    }

    @Override
    public int updatePwd(Integer userId, String oldPwd, String newPwd) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("userId", userId);
        hashMap.put("oldPwd", oldPwd);
        hashMap.put("newPwd", newPwd);
        return super.updateBy("updatePwd", hashMap);
    }

    @Override
    public User getUser(int id) {
        return super.get(id);
    }

    @Override
    public PageHolder<User> queryUser(UserQuery query) {
        return super.pagedQuery("findByParams", query.getMap(), query.getPageIndex(), query.getPageSize());
    }

    @Override
    public int delete(int id) {
        return super.delete(id);
    }

    @Override
    public User getUser(String phone) {
        return super.findUniqueBy("selectByPhone", phone);
    }
}
