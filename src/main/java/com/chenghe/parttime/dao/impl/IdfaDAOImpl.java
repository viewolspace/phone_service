package com.chenghe.parttime.dao.impl;

import com.chenghe.parttime.dao.BaseDAO;
import com.chenghe.parttime.dao.IIdfaDAO;
import com.chenghe.parttime.pojo.Idfa;
import org.springframework.stereotype.Repository;

import java.util.Date;

/**
 * describe:
 *
 * @author: shi_lei@suixingpay.com
 * @date: 2019/07/20 17:17:17:17
 * @version: V1.0
 * @review:
 */
@Repository("idfaDAO")
public class IdfaDAOImpl extends BaseDAO<Idfa> implements IIdfaDAO {
    @Override
    public Idfa get(String idfa) {
        return super.get(idfa);
    }

    @Override
    public int addIdfa(Idfa idfa) {
        Date d = new Date();
        idfa.setcTime(d);
        idfa.setmTime(d);
        return super.insert(idfa);
    }
}
