/**
 * @author Hunter
 * TopSpaceMaven
 * 2017-12-22 下午10:57:19
 * TODO //
 */
package com.topspace.core.utils.encrypt;

public class DESEncrypt extends AbsBalancedEncrypt {

    public DESEncrypt() {
        super("DES");
    }

    protected boolean checkKey(String key) {
        if(key != null && key.length() == 8){
            return true;
        }else{
            throw new RuntimeException("DES加解密key的长度必须是8位。");
        }
    }

    public static void main(String[] args) {
        String md = "luohc|2015-07-15 10:41:13|f001|zbpt";
        String key = "aaaaaaaaa123";
        DESEncrypt des = new DESEncrypt();
        String encode = des.encrypt(md, key);
        // System.out.println(des.decryptBASE64(encode));
        System.out.println(encode);
        encode = "/r/NWxEpzeRrv12TJhq35fgStCoeTjnhL6c+cYVw7Yy+S9FhP12YqQ==";
        String decode = des.decrypt(encode, key);
        System.out.println(decode);
    }

}


