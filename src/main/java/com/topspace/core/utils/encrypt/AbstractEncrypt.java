/**
 * @author Hunter
 * TopSpaceMaven
 * 2017-12-22 下午10:49:54
 * TODO //
 */
package com.topspace.core.utils.encrypt;

import org.apache.commons.codec.binary.Base64;

public abstract class AbstractEncrypt implements IEncrypt {


    /*
     * (non-Javadoc)
     * @see
     * java.lang.String)
     * @Override
    */
    public abstract String encrypt(String data, String keyStr);

    /*
     * (non-Javadoc)
     * @see
     * java.lang.String)
     * @Override
    */
    public abstract String decrypt(String encode, String keyStr);

    protected String base64Encode(byte[] bytes) {
        // return encoder.encodeBuffer(bytes);
        return Base64.encodeBase64String(bytes);
    }

    protected byte[] base64Decode(String encode) {
        return Base64.decodeBase64(encode);
        /*
         * try{ return decoder.decodeBuffer(encode); }catch(IOException ex){ //
         * TODO Auto-generated catch block ex.printStackTrace(); throw new
         * RuntimeException(); }
         */
    }

}


