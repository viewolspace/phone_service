package com.chenghe.parttime.dao.impl;

import com.chenghe.parttime.dao.BaseDAO;
import com.chenghe.parttime.dao.IUserStatDAO;
import com.chenghe.parttime.pojo.UserStat;
import com.chenghe.parttime.query.UserStatQuery;
import com.youguu.core.util.PageHolder;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.HashMap;

/**
 * describe:
 *
 * @date: 2019/07/20 17:19:17:19
 * @version: V1.0
 * @review:
 */
@Repository("userStatDAO")
public class UserStatDAOImpl extends BaseDAO<UserStat> implements IUserStatDAO {
    @Override
    public int addUserStat(UserStat userStat) {
        Date d = new Date();
        userStat.setcTime(d);
        userStat.setmTime(d);
        return super.insert(userStat);
    }

    @Override
    public int updateUserStat(UserStat userStat) {
        userStat.setmTime(new Date());
        return super.update(userStat);
    }

    @Override
    public UserStat findByStatDate(String statDate) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("statDate", statDate);
        return super.findUniqueBy("findByStatDate", hashMap);
    }

    @Override
    public PageHolder<UserStat> queryUserStat(UserStatQuery query) {
        return super.pagedQuery("findByParams", query.getMap(), query.getPageIndex(), query.getPageSize());
    }
}
