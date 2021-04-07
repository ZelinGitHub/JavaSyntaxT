package com.company.java.datasecurity;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class MacTest {
    public void fuckHMac1(byte[] pContent) {
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("HmacSHA1");
            SecretKey secretKey = keyGenerator.generateKey();
            //创建指定Mac算法的Mac实例
            Mac mac = Mac.getInstance("HmacSHA1");
            //初始化HMAC
            mac.init(secretKey);
            //生成消息摘要
            mac.doFinal(pContent);
        } catch (
                NoSuchAlgorithmException
                        | InvalidKeyException pE
        ) {
            pE.printStackTrace();
        }
    }

    public void fuckHMac2(byte[] key, byte[] pContent) {
        try {
            SecretKey secretKey =new SecretKeySpec(key,"HmacSHA1");
            //创建指定Mac算法的Mac实例
            Mac mac = Mac.getInstance("HmacSHA1");
            //初始化HMAC
            mac.init(secretKey);
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
