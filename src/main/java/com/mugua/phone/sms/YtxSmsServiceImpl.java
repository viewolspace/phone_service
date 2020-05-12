package com.mugua.phone.sms;

import com.alibaba.fastjson.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by lenovo on 2020/2/4.
 */
public class YtxSmsServiceImpl implements ISmsService{

    private int appId = 3;

    public YtxSmsServiceImpl(){
        super();
    }
    public YtxSmsServiceImpl(int appId){
        super();
        this.appId = appId;
    }

    @Override
    public int sendRand(String phone, String rand) {

        String account = "N9182057";
        String password = "q1Mhpo2Ks";
        String msg = "【柠檬电话】您的短信验证码是"+rand+"。您的手机号正在使用随机密码登录服务。请勿告知他人";
//        if(appId==4){
//            account = "N6534274";
//            password = "7kwQ3bhgm";
//            msg =  "【暖阳兼职】您的短信验证码是"+rand+"。您的手机号正在使用随机密码登录服务。请勿告知他人";
//        }else if(appId==6){
//            account = "N6534274";
//            password = "7kwQ3bhgm";
//            msg =  "【松鼠兼职】您的短信验证码是"+rand+"。您的手机号正在使用随机密码登录服务。请勿告知他人";
//        }else if(appId==5){
//            account = "N9182057";
//            password = "q1Mhpo2Ks";
//            msg =  "【蜜桔兼职】您的短信验证码是"+rand+"。您的手机号正在使用随机密码登录服务。请勿告知他人";
//        }else if(appId==7){
//            account = "N9182057";
//            password = "q1Mhpo2Ks";
//            msg =  "【快乐兼职】您的短信验证码是"+rand+"。您的手机号正在使用随机密码登录服务。请勿告知他人";
//        }else if(appId==8){
//            account = "N9182057";
//            password = "q1Mhpo2Ks";
//            msg =  "【蜜桔兼职】您的短信验证码是"+rand+"。您的手机号正在使用随机密码登录服务。请勿告知他人";
//        }
        //短信下发
        String sendUrl = "http://smssh1.253.com/msg/send/json";
        Map map = new HashMap();
        map.put("account",account);//API账号
        map.put("password",password);//API密码
        map.put("msg",msg);//短信内容
        map.put("phone",phone);//手机号
        map.put("report","true");//是否需要状态报告
//        map.put("extend",rand);//自定义扩展码
        JSONObject js1 = (JSONObject) JSONObject.toJSON(map);
        System.out.println(sendSmsByPost(sendUrl,js1.toString()));
        return 0;
    }

    public static void main(String[] args) {
        YtxSmsServiceImpl sms = new YtxSmsServiceImpl(7);
        sms.sendRand("13810436365","1234");

    }
    @Override
    public int sendRand(String phone, String rand, String sign, String skin) {
        return 0;
    }

    public static String sendSmsByPost(String path, String postContent) {
        URL url = null;
        try {
            url = new URL(path);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setConnectTimeout(10000);
            httpURLConnection.setReadTimeout(10000);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setRequestProperty("Charset", "UTF-8");
            httpURLConnection.setRequestProperty("Content-Type", "application/json");
            httpURLConnection.connect();
            OutputStream os=httpURLConnection.getOutputStream();
            os.write(postContent.getBytes("UTF-8"));
            os.flush();
            StringBuilder sb = new StringBuilder();
            int httpRspCode = httpURLConnection.getResponseCode();
            if (httpRspCode == HttpURLConnection.HTTP_OK) {
                BufferedReader br = new BufferedReader(
                        new InputStreamReader(httpURLConnection.getInputStream(), "utf-8"));
                String line = null;
                while ((line = br.readLine()) != null) {
                    sb.append(line);
                }
                br.close();
                return sb.toString();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
