/**
 * @author Hunter
 * TopSpaceMaven
 * 2017-12-22 下午11:07:42
 * TODO //
 */
package com.topspace.core.utils.encrypt;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class HMACEncrypt extends AbstractEncrypt{

    /**
     * MAC算法可选以下多种算法 *
     * 
     * <pre>
     * HmacMD5   
     * HmacSHA1   
     * HmacSHA256   
     * HmacSHA384   
     * HmacSHA512
     * </pre>
     */
    public static final String ALGORITHM = "HmacMD5";

    public String encrypt(String data, String keyStr) {
        SecretKey sk = new SecretKeySpec(base64Decode(keyStr), ALGORITHM);
        try{
            Mac mac = Mac.getInstance(sk.getAlgorithm());
            mac.init(sk);
            byte[] b = mac.doFinal(data.getBytes());
            return base64Encode(b);
        }catch(Exception ex){
            // TODO Auto-generated catch block
            ex.printStackTrace();
            throw new RuntimeException();
        }
    }
    
    public String decrypt(String encode, String keyStr) {
        throw new RuntimeException("Don't Support this method!");
    }
}


