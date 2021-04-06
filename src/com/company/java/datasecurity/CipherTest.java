package com.company.java.datasecurity;

import javax.crypto.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class CipherTest {

    public void fuckCipher(SecretKey secretKey) {
        try {
            //参数传入转换模式
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            int blockSize = cipher.getBlockSize();

            byte[] inBytes = new byte[blockSize];

            int outputSize = cipher.getOutputSize(blockSize);
            byte[] outBytes = new byte[outputSize];

            int outLength = cipher.update(inBytes, 0, outputSize, outBytes);
        } catch (
                NoSuchAlgorithmException
                        | NoSuchPaddingException
                        | InvalidKeyException
                        | ShortBufferException pE
        ) {
            pE.printStackTrace();
        }
    }


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
