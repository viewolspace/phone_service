package com.chenghe.parttime.query;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by lenovo on 2018/7/5.
 */
public class UserStatQuery {
    private Date statDate;


    private int pageIndex = 1;

    private int pageSize = 20;

    public Date getStatDate() {
        return statDate;
    }

    public void setStatDate(Date statDate) {
        this.statDate = statDate;
    }

    public Map getMap() {
        Map<String, Object> map = new HashMap<>();
        if (statDate != null) {
            map.put("statDate", statDate);
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
