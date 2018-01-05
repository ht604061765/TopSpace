/**
 * @author Hunter
 * TopSpaceMaven
 * 2017-12-22 下午11:07:00
 * TODO //
 */
package com.topspace.core.utils.encrypt;

public class AESEncrypt extends AbsBalancedEncrypt {


    public AESEncrypt() {
        super("AES");
    }

    protected boolean checkKey(String key) {
        if(key != null && key.length() == 16){
            return true;
        }else{
            throw new RuntimeException("AES加解密key的长度必须是16位。");
        }
    }

    public static void main(String[] args) {
        String md = "aaaaaaaaaa";
        String key = "12345678123456781234567812345678";
        AESEncrypt des = new AESEncrypt();
        String encode = des.encrypt(md, key);
        // System.out.println(des.decryptBASE64(encode));
        System.out.println(encode);
        String decode = des.decrypt(encode, key);
        System.out.println(decode);
    }

}


