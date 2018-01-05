/**
 * @author Hunter
 * TopSpaceMaven
 * 2017-12-22 下午10:56:25
 * TODO //
 */
package com.topspace.core.utils.encrypt;

public class Based64Encrypt extends AbstractEncrypt {


    /*
     * (non-Javadoc)
     * @see
     */
    @Override
    public String encrypt(String data, String keyStr) {
        return super.base64Encode(data.getBytes());
    }

    /*
     * (non-Javadoc)
     * @see
     */
    @Override
    public String decrypt(String encode, String keyStr) {
        return new String(super.base64Decode(encode));
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        String data = "qweqweqwe";
        Based64Encrypt base64 = new Based64Encrypt();
        String encode = base64.encrypt(data, null);
        System.out.println(encode);
        String decode = base64.decrypt(encode, null);
        System.out.println(decode);
    }

}


