package com.mugua.phone.dao;

import com.mugua.phone.pojo.Idfa;

/**
 * describe:
 *
 * @author: shi_lei@suixingpay.com
 * @date: 2019/07/20 17:09:17:09
 * @version: V1.0
 * @review:
 */
public interface IIdfaDAO {

    Idfa get(String idfa);

    int addIdfa(Idfa idfa);
}
