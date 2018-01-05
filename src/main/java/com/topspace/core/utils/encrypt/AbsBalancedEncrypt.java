/**
 * @author Hunter
 * TopSpaceMaven
 * 2017-12-22 下午11:04:30
 * TODO //
 */
package com.topspace.core.utils.encrypt;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public abstract class AbsBalancedEncrypt extends AbstractEncrypt {



    private String algorithm;
    private Cipher cipher = null;

    protected AbsBalancedEncrypt(String algorithm) {
        this.algorithm = algorithm;
        try{
            cipher = Cipher.getInstance(algorithm);
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

	// 加密.
	public String encrypt(String data, String keyStr) {
		try {
			Key k = toKey(keyStr);
			if (k != null) {
				cipher.init(Cipher.ENCRYPT_MODE, k);
				byte[] b = cipher.doFinal(data.getBytes());
				return base64Encode(b);
			} else {
				return "";
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException();
		}
	}

	// 解密.
	public String decrypt(String encode, String keyStr) {
		try {
			Key k = toKey(keyStr);
			if (k != null) {
				cipher.init(Cipher.DECRYPT_MODE, k);
				byte[] b = cipher.doFinal(base64Decode(encode));
				return new String(b);
			} else {
				return "";
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException();
		}
	}

    private SecretKey toKey(String seed) {
        if(checkKey(seed)){
            SecretKeySpec skeySpec = new SecretKeySpec(seed.getBytes(), algorithm);
            return skeySpec;
        }else{
            return null;
        }

        // try{
        // DESKeySpec k = new DESKeySpec(seed.getBytes());
        // SecretKeyFactory keyFactory =
        // SecretKeyFactory.getInstance(algorithm);
        // SecretKey secretKey = keyFactory.generateSecret(k);
        // return secretKey;
        // }catch(Exception ex){
        // ex.printStackTrace();
        // throw new RuntimeException();
        // }

    }

    protected boolean checkKey(String key) {
        return true;
    }
}


