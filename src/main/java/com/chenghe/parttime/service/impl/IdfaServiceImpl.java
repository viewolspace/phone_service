package com.chenghe.parttime.service.impl;

import com.chenghe.parttime.dao.IIdfaDAO;
import com.chenghe.parttime.pojo.Idfa;
import com.chenghe.parttime.service.IIdfaService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * describe:
 *
 * @author: shi_lei@suixingpay.com
 * @date: 2019/07/20 17:20:17:20
 * @version: V1.0
 * @review:
 */
@Service("idfaService")
public class IdfaServiceImpl implements IIdfaService {

    @Resource
    private IIdfaDAO iIdfaDAO;

    @Override
    public int addIdfa(String idfa, String os) {
        Idfa idfa1 = iIdfaDAO.get(idfa);
        if(idfa1 == null){
            idfa1 = new Idfa();
            idfa1.setIdfa(idfa);
            idfa1.setOs(os);
            int result = iIdfaDAO.addIdfa(idfa1);



            return result;
        }
        return 0;
    }

    @Override
    public Idfa getIdfa(String idfa) {
        return iIdfaDAO.get(idfa);
    }
}
