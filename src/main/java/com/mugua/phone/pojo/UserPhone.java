package com.mugua.phone.pojo;

import java.util.Date;

/**
 * Created by lenovo on 2020/1/17.
 */
public class UserPhone {
    private int id;
    private int userId;
    private Date cTime;
    private Date mTime;
    private String content;
    private String des;
    private int num;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getcTime() {
        return cTime;
    }

    public void setcTime(Date cTime) {
        this.cTime = cTime;
    }

    public Date getmTime() {
        return mTime;
    }

    public void setmTime(Date mTime) {
        this.mTime = mTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "UserPhone{" +
                "id=" + id +
                ", userId=" + userId +
                ", cTime=" + cTime +
                ", mTime=" + mTime +
                ", content='" + content + '\'' +
                ", des='" + des + '\'' +
                ", num=" + num +
                '}';
    }
}
