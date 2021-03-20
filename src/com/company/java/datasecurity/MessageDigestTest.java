package com.company.java.datasecurity;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MessageDigestTest {
    public void generateDigest(byte[] pBytes) {
        try {
            //参数传入散列算法名
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            //参数传入字节数组
            md.update(pBytes);
            //得到消息摘要
            byte[] hash = md.digest();
        } catch (NoSuchAlgorithmException pE) {
            pE.printStackTrace();
        }
    }
}
