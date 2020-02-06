package com.chenghe.parttime.service;

import com.chenghe.parttime.pojo.UserStat;
import com.chenghe.parttime.query.UserStatQuery;
import com.youguu.core.util.PageHolder;

/**
 * describe:
 *
 * @date: 2019/07/20 17:10:17:10
 * @version: V1.0
 * @review:
 */
public interface IUserStatService {
    int addUserStat(UserStat userStat);

    int updateUserStat(UserStat userStat);

    UserStat findByStatDate(String statDate);

    PageHolder<UserStat> queryUserStat(UserStatQuery query);

    int incIdfaNum();

    int incActiveNum();

    int incRegistNum();

    int incBrowseNum(int num, int userNum);

    int incJoinNum();

    int incCopyNum();
}
