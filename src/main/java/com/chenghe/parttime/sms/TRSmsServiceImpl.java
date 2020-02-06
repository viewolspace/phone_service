package com.chenghe.parttime.sms;


import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.*;

/**
 * Created by lenovo on 2020/1/17.
 */
public class TRSmsServiceImpl implements ISmsService{

    @Override
    public int sendRand(String phone, String rand) {
        return 0;
    }

    @Override
    public int sendRand(String phone, String rand, String sign, String skin) {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("accesskey","accesskey");
        paramMap.put("secret","secret");
        paramMap.put("sign",sign);
        paramMap.put("templateId",skin);
        paramMap.put("mobile",phone);
        paramMap.put("content",rand);
        TRSmsServiceImpl.doPost("http://api.1cloudsp.com/api/v2/single_send",paramMap);
        return 0;
    }

    //普通短信
    private void sendsms() throws Exception {


//        HttpClient httpClient = new H
//        PostMethod postMethod = new PostMethod("http://api.1cloudsp.com/api/v2/single_send");
//        postMethod.getParams().setContentCharset("UTF-8");
//        postMethod.getParams().setParameter(HttpMethodParams.RETRY_HANDLER,new DefaultHttpMethodRetryHandler());
//
//        String accesskey = "xxxxxxxxxx"; //用户开发key
//        String accessSecret = "yyyyyyyyyy"; //用户开发秘钥
//
//        NameValuePair[] data = {
//                new NameValuePair("accesskey", accesskey),
//                new NameValuePair("secret", accessSecret),
//                new NameValuePair("sign", "123"),
//                new NameValuePair("templateId", "100"),
//                new NameValuePair("mobile", "13900000001"),
//                new NameValuePair("content", URLEncoder.encode("先生##9:40##快递公司##1234567", "utf-8"))//（示例模板：{1}您好，您的订单于{2}已通过{3}发货，运单号{4}）
//        };
//        postMethod.setRequestBody(data);
//
//        int statusCode = httpClient.executeMethod(postMethod);
//        System.out.println("statusCode: " + statusCode + ", body: "
//                + postMethod.getResponseBodyAsString());
    }



    public static String doPost(String url, Map<String, Object> paramMap) {
        CloseableHttpClient httpClient = null;
        CloseableHttpResponse httpResponse = null;
        String result = "";
        // 创建httpClient实例
        httpClient = HttpClients.createDefault();
        // 创建httpPost远程连接实例
        HttpPost httpPost = new HttpPost(url);
        // 配置请求参数实例
        RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(35000)// 设置连接主机服务超时时间
                .setConnectionRequestTimeout(35000)// 设置连接请求超时时间
                .setSocketTimeout(60000)// 设置读取数据连接超时时间
                .build();
        // 为httpPost实例设置配置
        httpPost.setConfig(requestConfig);
        // 设置请求头
        httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded");
        // 封装post请求参数
        if (null != paramMap && paramMap.size() > 0) {
            List<NameValuePair> nvps = new ArrayList<NameValuePair>();
            // 通过map集成entrySet方法获取entity
            Set<Map.Entry<String, Object>> entrySet = paramMap.entrySet();
            // 循环遍历，获取迭代器
            Iterator<Map.Entry<String, Object>> iterator = entrySet.iterator();
            while (iterator.hasNext()) {
                Map.Entry<String, Object> mapEntry = iterator.next();
                nvps.add(new BasicNameValuePair(mapEntry.getKey(), mapEntry.getValue().toString()));
            }

            // 为httpPost设置封装好的请求参数
            try {
                httpPost.setEntity(new UrlEncodedFormEntity(nvps, "UTF-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        try {
            // httpClient对象执行post请求,并返回响应参数对象
            httpResponse = httpClient.execute(httpPost);
            // 从响应对象中获取响应内容
            HttpEntity entity = httpResponse.getEntity();
            result = EntityUtils.toString(entity);
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            if (null != httpResponse) {
                try {
                    httpResponse.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != httpClient) {
                try {
                    httpClient.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }
}
