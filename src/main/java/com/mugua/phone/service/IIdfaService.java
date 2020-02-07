package com.mugua.phone.service;

import com.mugua.phone.pojo.Idfa;

/**
 * describe:
 *
 * @author: shi_lei@suixingpay.com
 * @date: 2019/07/20 17:12:17:12
 * @version: V1.0
 * @review:
 */
public interface IIdfaService {
    int addIdfa(String idfa,String os);

    Idfa getIdfa(String idfa);
}
