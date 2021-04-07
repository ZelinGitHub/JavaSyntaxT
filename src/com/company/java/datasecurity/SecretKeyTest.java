package com.company.java.datasecurity;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class SecretKeyTest {

    public void generateSecretKey1() {
        try {
            //得到指定加密算法的密钥生成器实例
            KeyGenerator keyGen = KeyGenerator.getInstance("AES");
            SecureRandom secureRandom = new SecureRandom();
            //使用随机源来初始化密钥生成器
            keyGen.init(secureRandom);
            //生成密钥
            SecretKey secretKey = keyGen.generateKey();
        } catch (NoSuchAlgorithmException pE) {
            pE.printStackTrace();
        }
    }
    //生成指定加密算法的密钥字节码
    public void generateSecretKey2() {
        try {
            //得到指定加密算法的密钥生成器实例
            KeyGenerator keyGen = KeyGenerator.getInstance("AES");
            //密钥长度默认128，获得无政策权限后可为192或256
            keyGen.init(128);
            //生成密钥
            SecretKey secretKey = keyGen.generateKey();
            //得到密钥的字节码
        } catch (NoSuchAlgorithmException pE) {
            pE.printStackTrace();
        }
    }


    //使用密钥字节码，创建密钥
    public void generateSecretKeyFromByte() {
        byte[] keyByte = new byte[]{1, 2, 3};
        //使用密钥字节码，创建密钥
        SecretKey secretKey1 = new SecretKeySpec(keyByte, "AES");
    }


    public void secretKeyToByte(SecretKey pSecretKey) {
        byte[] keyByte = pSecretKey.getEncoded();
    }
}
