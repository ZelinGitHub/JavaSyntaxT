package com.company.java.exception;

import java.io.*;
import java.net.UnknownHostException;

public class TryCatchTest {
    public void fuckTryCatch() {
        try {
            File file=new File("/dir/fileX");
            InputStream aInputStream = new FileInputStream(file);
            int content = aInputStream.read();
        } catch (IOException  pE) {
            pE.printStackTrace();
        }
    }
    public void fuckTryCatch2() {
        try {
            Thread.sleep(1000);
            File file=new File("/dir/fileX");
            InputStream aInputStream = new FileInputStream(file);
            int content = aInputStream.read();
        } catch (IOException  pE) {
            pE.printStackTrace();
        } catch (InterruptedException pE) {
            pE.printStackTrace();
        }
    }
    public void fuckTryCatch3() {
        try {
            Thread.sleep(1000);
            File file=new File("/dir/fileX");
            InputStream aInputStream = new FileInputStream(file);
            int content = aInputStream.read();
        } catch (IOException | InterruptedException pE) {
            pE.printStackTrace();
        }
    }





}
