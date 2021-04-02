package com.company.java.datasecurity;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MessageDigestTest {
    public void gSenerateDigest(byte[] pBytes) {
        try {
            //传入散列算法名
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            //传入原始数据
            md.update(pBytes);
            //得到消息摘要
            byte[] hash = md.digest();
        } catch (NoSuchAlgorithmException pE) {
            pE.printStackTrace();
        }
    }
}
