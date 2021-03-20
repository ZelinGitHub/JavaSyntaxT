package com.company.java.datasecurity;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class MacTest {
    public void fuckHMac(SecretKey pSecretKey,byte[] pContent) {
        try {
            Mac mac = Mac.getInstance(pSecretKey.getAlgorithm());
            //初始化HMAC
            mac.init(pSecretKey);
            //生成消息摘要
            mac.doFinal(pContent);
        } catch (
                NoSuchAlgorithmException
                        | InvalidKeyException pE
        ) {
            pE.printStackTrace();
        }
    }
}
