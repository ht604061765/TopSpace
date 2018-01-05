/**
 * @author Hunter
 * TopSpaceMaven
 * 2017-12-22 下午10:49:27
 * TODO //
 */
package com.topspace.core.utils.encrypt;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.topspace.core.utils.StringUtil;


public class MD5Encrypt extends AbstractEncrypt {


    public final static String ALRIGOTHM_MD5 = "MD5";
    public final static String ALRIGOTHM_SHA1 = "SHA-1";

    private String alrigothm = ALRIGOTHM_MD5;

    public MD5Encrypt(String alrigothm) {
        this.alrigothm = alrigothm;
    }

    public MD5Encrypt() {

    }

    // 转换字节数组为16进制字串
    private static String bytesToHexString(byte[] bByte) {
        return StringUtil.bytesToHexString(bByte);
    }

    @Override
    public String encrypt(String data, String keyStr) {
        MessageDigest md5;
        try{
            md5 = MessageDigest.getInstance(alrigothm);
            byte[] bytes = md5.digest(data.getBytes());
            return bytesToHexString(bytes);
        }catch(NoSuchAlgorithmException ex){
            ex.printStackTrace();
            throw new RuntimeException("MD5 加密出错.");
        }
    }

    @Override
    public String decrypt(String encode, String keyStr) {
        throw new RuntimeException("MD5 不支持解密");
    }

    public static void main(String[] args) {
        String alri = "MD5";
        // String alri = "SHA";
        MD5Encrypt md5 = new MD5Encrypt(alri);
        String secret = md5.encrypt("45c3175db277419a8d622a2a5718dc57", null);
        String prnt = String.format("45c3175db277419a8d622a2a5718dc57 结过%s加密后是: %s", alri, secret);
        System.out.println(prnt);
    }

}


