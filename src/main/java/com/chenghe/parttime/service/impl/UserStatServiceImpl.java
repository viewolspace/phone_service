package com.chenghe.parttime.service.impl;

import com.chenghe.parttime.dao.IUserStatDAO;
import com.chenghe.parttime.pojo.UserStat;
import com.chenghe.parttime.query.UserStatQuery;
import com.chenghe.parttime.service.IUserStatService;
import com.youguu.core.util.PageHolder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * describe:
 *
 * @date: 2019/07/20 17:22:17:22
 * @version: V1.0
 * @review:
 */
@Service("userStatService")
public class UserStatServiceImpl implements IUserStatService {

    private String statDate;

    @Resource
    private IUserStatDAO userStatDAO;


    @Override
    public int addUserStat(UserStat userStat) {
        return userStatDAO.addUserStat(userStat);
    }

    @Override
    public int updateUserStat(UserStat userStat) {
        return userStatDAO.updateUserStat(userStat);
    }

    @Override
    public UserStat findByStatDate(String statDate) {
        return userStatDAO.findByStatDate(statDate);
    }

    @Override
    public PageHolder<UserStat> queryUserStat(UserStatQuery query) {
        return userStatDAO.queryUserStat(query);
    }


    private void dateDecide() throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String nowDate = sdf.format(new Date());
        if(statDate==null || !nowDate.equals(statDate)){
            synchronized (this){
                if(statDate==null || !nowDate.equals(statDate)){
                    UserStat userStat =  userStatDAO.findByStatDate(nowDate);
                    if(userStat==null){
                        //新建
                        userStat = new UserStat();
                        userStat.setStatDate(sdf.parse(nowDate));
                        userStat.setBrowseNum(0);
                        userStat.setCopyNum(0);
                        userStat.setJoinNum(0);
                        userStat.setUserActive(0);
                        userStat.setUserIdfa(0);
                        userStat.setBrowseUserNum(0);
                        userStat.setUserRegister(0);
                        userStatDAO.addUserStat(userStat);
                    }
                    statDate = nowDate;
                }

            }
        }
    }

    @Override
    public int incIdfaNum() {
        try{
            this.dateDecide();
        }catch (Exception e){
            e.printStackTrace();
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        UserStat userStat = new UserStat();
        try{
            userStat.setStatDate(sdf.parse(statDate));
        }catch (Exception e){
            e.printStackTrace();
        }
        userStat.setUserIdfa(1);

        return userStatDAO.updateUserStat(userStat);
    }

    @Override
    public int incActiveNum() {
        try{
            this.dateDecide();
        }catch (Exception e){
            e.printStackTrace();
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        UserStat userStat = new UserStat();
        try{
            userStat.setStatDate(sdf.parse(statDate));
        }catch (Exception e){
            e.printStackTrace();
        }
        userStat.setUserActive(1);

        return userStatDAO.updateUserStat(userStat);
    }

    @Override
    public int incRegistNum() {
        try{
            this.dateDecide();
        }catch (Exception e){
            e.printStackTrace();
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        UserStat userStat = new UserStat();
        try{
            userStat.setStatDate(sdf.parse(statDate));
        }catch (Exception e){
            e.printStackTrace();
        }
        userStat.setUserRegister(1);

        return userStatDAO.updateUserStat(userStat);
    }

    @Override
    public int incBrowseNum(int num,int userNum) {
        try{
            this.dateDecide();
        }catch (Exception e){
            e.printStackTrace();
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        UserStat userStat = new UserStat();
        try{
            userStat.setStatDate(sdf.parse(statDate));
        }catch (Exception e){
            e.printStackTrace();
        }
        userStat.setBrowseNum(1);
        userStat.setBrowseUserNum(userNum);

        return userStatDAO.updateUserStat(userStat);
    }

    @Override
    public int incJoinNum() {
        try{
            this.dateDecide();
        }catch (Exception e){
            e.printStackTrace();
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        UserStat userStat = new UserStat();
        try{
            userStat.setStatDate(sdf.parse(statDate));
        }catch (Exception e){
            e.printStackTrace();
        }
        userStat.setJoinNum(1);

        return userStatDAO.updateUserStat(userStat);
    }

    @Override
    public int incCopyNum() {
        try{
            this.dateDecide();
        }catch (Exception e){
            e.printStackTrace();
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        UserStat userStat = new UserStat();
        try{
            userStat.setStatDate(sdf.parse(statDate));
        }catch (Exception e){
            e.printStackTrace();
        }
        userStat.setCopyNum(1);

        return userStatDAO.updateUserStat(userStat);
    }
}
