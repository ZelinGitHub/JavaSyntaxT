package com.company.java.datasecurity;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class SecretKeyTest {

    public void generateSecretKey() {
        try {
            KeyGenerator keyGen = KeyGenerator.getInstance("AES");
            //密钥长度默认128，获得无政策权限后可为192或256
            keyGen.init(128);
            //生成密钥
            SecretKey secretKey = keyGen.generateKey();
            //得到密钥的字节码
            byte[] keyByte = secretKey.getEncoded();
            //使用密钥字节码，创建密钥
            SecretKey secretKey1 = new SecretKeySpec(keyByte, "AES");
        } catch (NoSuchAlgorithmException pE) {
            pE.printStackTrace();
        }
    }


}
