/**
 * @author Hunter
 * TopSpaceMaven
 * 2017-12-22 下午11:09:01
 * TODO //
 */
package com.topspace.core.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;

import org.apache.commons.codec.binary.Base64;

public class URLUtil {
	
	public static InputStream getInputStreamByGet(String url) {
        try {
            HttpURLConnection conn = (HttpURLConnection) new URL(url)
                    .openConnection();
            conn.setReadTimeout(5000);
            conn.setConnectTimeout(5000);
            conn.setRequestMethod("GET");

            if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                InputStream inputStream = conn.getInputStream();
                return inputStream;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

	
	 public static void saveData(InputStream is, File file) {
	        try (BufferedInputStream bis = new BufferedInputStream(is);
	                BufferedOutputStream bos = new BufferedOutputStream(
	                        new FileOutputStream(file));) {
	            byte[] buffer = new byte[1024];
	            int len = -1;
	            while ((len = bis.read(buffer)) != -1) {
	                bos.write(buffer, 0, len);
	                bos.flush();
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }


    /**
     * URL编码，对防止浏览器解释出错或出现乱码.
     * 
     * @param url
     * @return
     */
    public static String encodeSafeURL(String url) {
        try{
            return URLEncoder.encode(url, "utf-8");
        }catch(UnsupportedEncodingException ex){
            return url;
        }
    }

    public static String decodeSafeURL(String url) {
        try{
            return URLDecoder.decode(url, "utf-8");
        }catch(UnsupportedEncodingException ex){
            return url;
        }
    }

    public static String encodeBase64SafeURL(String url) {
        return Base64.encodeBase64URLSafeString(url.getBytes());
    }

    public static String decodeBase64SafeURL(String encode) {
        return new String(Base64.decodeBase64(encode));
    }

    /**
     * 给url添加参数。主要解决问号“？”的问题。
     * 
     * @param url
     * @param params
     *            形如 key=value
     * @return
     */
    public static String urlAddParams(String url, String param) {
        if(url.indexOf("?") >= 0){
            return url + "&" + param;
        }else{
            return url + "?" + param;
        }
    }
    
    
    public static void main(String[] args) {
        String url = "goods.do?p=toShowGoods";
        String en = encodeSafeURL(url);
        System.out.println(en);
        en = Base64.encodeBase64URLSafeString(url.getBytes());
        System.out.println(en);
        String den = decodeBase64SafeURL(en);
        System.out.println(den);
        den = decodeSafeURL(en);
        System.out.println(den);

    }

}


