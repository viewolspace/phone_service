package com.chenghe.parttime.pojo;

import java.util.Date;

/**
 * describe:
 *
 * @date: 2019/07/20 16:10:16:10
 * @version: V1.0
 * @review:
 */
public class Idfa {
    private String idfa;
    private String os;
    private Date cTime;
    private Date mTime;

    public String getIdfa() {
        return idfa;
    }

    public void setIdfa(String idfa) {
        this.idfa = idfa;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
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
}
