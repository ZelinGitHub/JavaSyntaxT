package com.company.java.datasecurity;

import javax.crypto.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class CipherTest {
    public void encrypt(SecretKey secretKey, byte[] originData) {
        try {
            //参数传入转换模式
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            byte[] safeData = cipher.doFinal(originData);
        } catch (
                NoSuchAlgorithmException
                        | NoSuchPaddingException
                        | InvalidKeyException
                        | BadPaddingException
                        | IllegalBlockSizeException pE
        ) {
            pE.printStackTrace();
        }
    }
    public void decrypt(SecretKey secretKey, byte[] safeData) {
        try {
            //参数传入转换模式
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            byte[] originData = cipher.doFinal(safeData);
        } catch (
                NoSuchAlgorithmException
                        | NoSuchPaddingException
                        | InvalidKeyException
                        | BadPaddingException
                        | IllegalBlockSizeException pE
        ) {
            pE.printStackTrace();
        }
    }
}
