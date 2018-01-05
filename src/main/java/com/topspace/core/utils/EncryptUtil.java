/**
 * @author Hunter
 * TopSpaceMaven
 * 2017-12-22 下午10:33:32
 * TODO //
 */
package com.topspace.core.utils;

import com.topspace.core.utils.encrypt.AESEncrypt;
import com.topspace.core.utils.encrypt.Based64Encrypt;
import com.topspace.core.utils.encrypt.DESEncrypt;
import com.topspace.core.utils.encrypt.HMACEncrypt;
import com.topspace.core.utils.encrypt.IEncrypt;
import com.topspace.core.utils.encrypt.MD5Encrypt;



public class EncryptUtil {


    private static final IEncrypt md5 = new MD5Encrypt();
    private static final IEncrypt sha = new MD5Encrypt(MD5Encrypt.ALRIGOTHM_SHA1);
    private static final IEncrypt base64 = new Based64Encrypt();
    private static final IEncrypt des = new DESEncrypt();
    private static final IEncrypt aes = new AESEncrypt();
    private static final IEncrypt hmac = new HMACEncrypt();
    private static final String DES_KEY = "@vtoone@";// decryptBase64("fiEkIyV0b29uZV8oKSomMTIzK14/ ");
    private static final String AES_KEY = "1234asdf5678qwer"; // 必须是16位长度.

    public static final String encryptMD5(String data) {
        return md5.encrypt(data, null);
    }

    public static final String encryptSHA1(String data) {
        return sha.encrypt(data, null);
    }

    public static final String encryptBase64(String data) {
        return base64.encrypt(data, null);
    }

    public static final String decryptBase64(String encode) {
        return base64.decrypt(encode, null);
    }

    public static final String encryptDES(String data) {
        return des.encrypt(data, DES_KEY);
    }

    public static final String decryptDES(String encode) {
        return des.decrypt(encode, DES_KEY);
    }

    public static final String encryptDES(String data, String key) {
        return des.encrypt(data, key);
    }

    public static final String decryptDES(String encode, String key) {
        return des.decrypt(encode, key);
    }

    public static final String encryptHMAC(String data) {
        return hmac.encrypt(data, DES_KEY);
    }

    public static final String encryptURL(String url) {
        String en = encryptAES(url);
        return URLUtil.encodeBase64SafeURL(en);
    }

    public static final String decryptURL(String encode) {
        if(StringUtil.isEmpty(encode)){
            return "";
        }
        String en = URLUtil.decodeBase64SafeURL(encode);
        return decryptAES(en);
    }

    public static final String encryptAES(String data) {
        return aes.encrypt(data, AES_KEY);
    }

    public static final String decryptAES(String encode) {
        return aes.decrypt(encode, AES_KEY);
    }

    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        // String data = "jdbc:mysql://10.1.40.117:3306/power_test";
        // String en = EncryptUtil.encryptBase64(ENC_KEY);
        // System.out.println(en + "  length=" + en.length());
        // String de = EncryptUtil.decryptBase64(en);
        // System.out.println(de + "  length=" + de.length());
        // String str = "account_id=luohc";
        // String token = encryptURL(str);
        // System.out.println("  token=" + token);

        String ticket = "hDzQ3w15YS+KK+aRzcZxeQ==";
   
        System.out.println(EncryptUtil.decryptAES("hDzQ3w15YS+KK+aRzcZxeQ=="));
    }

}


