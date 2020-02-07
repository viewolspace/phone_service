package com.mugua.phone.service.impl;

import com.mugua.phone.dao.IUserDAO;
import com.mugua.phone.pojo.User;
import com.mugua.phone.query.UserQuery;
import com.mugua.phone.service.IUserService;
import com.mugua.phone.service.IUserStatService;
import com.youguu.core.util.PageHolder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * describe:
 *
 * @date: 2019/07/20 17:21:17:21
 * @version: V1.0
 * @review:
 */
@Service("userService")
public class UserServiceImpl implements IUserService {
    @Resource
    private IUserDAO userDAO;

    @Resource
    private IUserStatService userStatService;

    @Override
    public int addUser(User user) {
        int uid =  userDAO.addUser(user);

        //增加今日注册计数
        if(uid > 0){
            userStatService.incRegistNum();
        }
        return uid;
    }

    @Override
    public int updateUser(User user) {
        return userDAO.updateUser(user);
    }

    @Override
    public int updatePwd(Integer userId, String oldPwd, String newPwd) {
        return userDAO.updatePwd(userId, oldPwd, newPwd);
    }

    @Override
    public User getUser(int id) {
        return userDAO.getUser(id);
    }

    @Override
    public PageHolder<User> queryUser(UserQuery query) {
        return userDAO.queryUser(query);
    }

    @Override
    public int delete(int id) {
        return userDAO.delete(id);
    }

    @Override
    public User getUser(String phone) {
        return userDAO.getUser(phone);
    }
}
