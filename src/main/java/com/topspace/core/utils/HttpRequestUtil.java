/**
 * @author Hunter
 * TopSpace
 * 2018-3-29 下午9:44:33
 * TODO //
 */
package com.topspace.core.utils;

import java.net.ConnectException;
import java.net.URLEncoder;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Map;

import javax.net.ssl.SSLContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContextBuilder;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class HttpRequestUtil {

    private static Log log = LogFactory.getLog(HttpRequestUtil.class);

    public static Map<String, Object> httpsRequest(String url, String postOrGet, String content) {
        HttpResponse resp = https(url, postOrGet, content);
        if(resp != null && resp.getStatusLine().getStatusCode() == 200){
            String result = getStringForResponse(resp);
            log.debug("返回结果：" + result);
            return JsonUtils.fromJson(result);
        }else{
            return null;
        }
    }

    public static String httpsRequestString(String url, String postOrGet, String content) {
        HttpResponse resp = https(url, postOrGet, content);
        if(resp != null && resp.getStatusLine().getStatusCode() == 200){
            String result = getStringForResponse(resp);
            log.debug("返回结果：" + result);
            return result;
        }else{
            return null;
        }
    }

    private static HttpResponse https(String url, String postOrGet, String content) {
        try{
            SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(null, new MyTrustStrategy()).build();
            SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslContext);
            HttpClient httpclient = HttpClients.custom().setSSLSocketFactory(sslsf).build();

            HttpUriRequest method = null;
            if(StringUtil.equalsIgnoreCase("GET", postOrGet)){
                HttpGet get = new HttpGet(url);
                method = get;
            }else{
                HttpPost post = new HttpPost(url);
                // post.setHeader("Content-Type",
                // "application/json;charset=UTF-8");

                post.setEntity(new StringEntity(content, "UTF-8"));
                method = post;
            }
            HttpResponse res = httpclient.execute(method);
            return res;
        }catch(ConnectException ce){
            log.warn("=====请求连接失败，url=" + url);
            log.warn(ce.getMessage(), ce);
        }catch(Exception e){
            log.warn("=====请求失败，url=" + url);
            log.warn(e.getMessage(), e);
        }
        return null;
    }

    // 发送请求，处理返回结果。
    public static Map<String, Object> httpRequest(String url, String method, String content) {
        HttpResponse response = request(url, method, content);
        // 200即正确的返回码
        if(response != null && response.getStatusLine().getStatusCode() == 200){
            String result = getStringForResponse(response);
            log.debug("返回结果：" + result);
            return JsonUtils.fromJson(result);
        }
        return null;
    }

    // 发送请求，无返回结果。
    public static boolean httpRequestBoolean(String url, String method, String content) {
        HttpResponse response = request(url, method, content);
        // 200即正确的返回码
        if(response != null && response.getStatusLine().getStatusCode() == 200){
            return true;
        }else{
            return false;
        }
    }

    public static String httpRequestString(String url, String method, String content) {
        HttpResponse response = request(url, method, content);
        // 200即正确的返回码
        if(response != null && response.getStatusLine().getStatusCode() == 200){
            return getStringForResponse(response);
        }else{
            return null;
        }
    }

    private static HttpResponse request(String url, String method, String content) {
        try{
            HttpUriRequest m = null;
            if(StringUtil.equalsIgnoreCase(method, "GET")){
                String info = URLEncoder.encode(content, "utf-8");
                String requesturl = url + info;
                HttpGet request = new HttpGet(requesturl);
                m = request;
            }else{
                HttpPost post = new HttpPost(url);
                post.setEntity(new StringEntity(content, "UTF-8"));
                m = post;
            }
            HttpResponse response = HttpClients.createDefault().execute(m);
            return response;
        }catch(Exception ex){
            log.error("发送请求异常: url=" + url, ex);
        }
        return null;
    }

    private static String getStringForResponse(HttpResponse response) {
        try{
            String result = EntityUtils.toString(response.getEntity(), "UTF-8");
            log.debug("返回结果：" + result);
            return result;
        }catch(Exception ex){
            log.error("处理请求返回内容失败", ex);
        }
        return null;
    }

}

class MyTrustStrategy implements TrustStrategy {

    @Override
    public boolean isTrusted(X509Certificate[] chain, String authType) throws CertificateException {
        return true;
    }

}


