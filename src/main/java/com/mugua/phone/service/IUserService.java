package com.mugua.phone.service;

import com.mugua.phone.pojo.User;
import com.mugua.phone.query.UserQuery;
import com.youguu.core.util.PageHolder;

/**
 * describe:
 *
 * @date: 2019/07/20 17:11:17:11
 * @version: V1.0
 * @review:
 */
public interface IUserService {
    int addUser(User user);

    int updateUser(User user);

    int updatePwd(Integer userId, String oldPwd, String newPwd);

    User getUser(int id);

    User getUser(String phone);

    PageHolder<User> queryUser(UserQuery query);

    int delete(int id);
}
