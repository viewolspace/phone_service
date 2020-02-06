package com.chenghe.parttime.dao;

import com.chenghe.parttime.pojo.UserStat;
import com.chenghe.parttime.query.UserStatQuery;
import com.youguu.core.util.PageHolder;

import java.util.Date;

/**
 * describe:
 *
 * @date: 2019/07/20 17:10:17:10
 * @version: V1.0
 * @review:
 */
public interface IUserStatDAO {
    int addUserStat(UserStat userStat);

    int updateUserStat(UserStat userStat);

    UserStat findByStatDate(String statDate);

    PageHolder<UserStat> queryUserStat(UserStatQuery query);
}
