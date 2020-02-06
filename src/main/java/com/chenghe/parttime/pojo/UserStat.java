package com.chenghe.parttime.pojo;

import java.util.Date;

/**
 * describe:
 *
 * @date: 2019/07/20 16:12:16:12
 * @version: V1.0
 * @review:
 */
public class UserStat {
    private Date statDate;
    private Integer userActive;
    private Integer userRegister;
    private Integer userIdfa;
    private Integer browseUserNum;
    private Integer browseNum;
    private Integer copyNum;
    private Integer joinNum;
    private Date cTime;
    private Date mTime;

    public Date getStatDate() {
        return statDate;
    }

    public void setStatDate(Date statDate) {
        this.statDate = statDate;
    }

    public Integer getUserActive() {
        return userActive;
    }

    public void setUserActive(Integer userActive) {
        this.userActive = userActive;
    }

    public Integer getUserRegister() {
        return userRegister;
    }

    public void setUserRegister(Integer userRegister) {
        this.userRegister = userRegister;
    }

    public Integer getUserIdfa() {
        return userIdfa;
    }

    public void setUserIdfa(Integer userIdfa) {
        this.userIdfa = userIdfa;
    }

    public Integer getBrowseNum() {
        return browseNum;
    }

    public void setBrowseNum(Integer browseNum) {
        this.browseNum = browseNum;
    }

    public Integer getCopyNum() {
        return copyNum;
    }

    public void setCopyNum(Integer copyNum) {
        this.copyNum = copyNum;
    }

    public Integer getJoinNum() {
        return joinNum;
    }

    public void setJoinNum(Integer joinNum) {
        this.joinNum = joinNum;
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

    public Integer getBrowseUserNum() {
        return browseUserNum;
    }

    public void setBrowseUserNum(Integer browseUserNum) {
        this.browseUserNum = browseUserNum;
    }
}
