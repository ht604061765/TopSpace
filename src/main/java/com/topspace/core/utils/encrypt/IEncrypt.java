/**
 * @author Hunter
 * TopSpaceMaven
 * 2017-12-22 下午10:35:14
 * TODO //
 */
package com.topspace.core.utils.encrypt;

public interface IEncrypt {
    public String encrypt(String data, String keyStr);

    public String decrypt(String encode, String keyStr);
}


