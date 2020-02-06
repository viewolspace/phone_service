package com.chenghe.parttime.dao;

import com.chenghe.parttime.pojo.User;
import com.chenghe.parttime.query.UserQuery;
import com.youguu.core.util.PageHolder;

/**
 * describe:
 *
 * @author: shi_lei@suixingpay.com
 * @date: 2019/07/20 17:09:17:09
 * @version: V1.0
 * @review:
 */
public interface IUserDAO {
    int addUser(User user);

    int updateUser(User user);

    int updatePwd(Integer userId, String oldPwd, String newPwd);

    User getUser(int id);

    PageHolder<User> queryUser(UserQuery query);

    int delete(int id);


    User getUser(String phone);
}
