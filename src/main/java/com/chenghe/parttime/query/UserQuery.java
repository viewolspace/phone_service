package com.chenghe.parttime.query;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lenovo on 2018/7/5.
 */
public class UserQuery {
    private Integer userId;
    private String phone;
    private String nickName;
    private String realName;

    private int pageIndex = 1;

    private int pageSize = 20;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public Map getMap() {
        Map<String, Object> map = new HashMap<>();
        if (userId != null) {
            map.put("userId", userId);
        }
        if (phone != null) {
            map.put("phone", phone);
        }
        if (nickName != null) {
            map.put("nickName", nickName);
        }
        if (realName != null) {
            map.put("realName", realName);
        }
        return map;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }


}
