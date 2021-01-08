package com.company.java.net;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class NetAddressTest {

    public void fuck() {
        try {
            InetAddress inetAddress = InetAddress.getByName("www.google.com");
            String hostName = inetAddress.getHostName();
            byte[] addressBytes = inetAddress.getAddress();
            String addressStr = inetAddress.getHostAddress();
        } catch (UnknownHostException pE) {
            pE.printStackTrace();
        }
    }

    public void lick() {
        try {
            InetAddress[] addresses = InetAddress.getAllByName("www.google.com");
        } catch (UnknownHostException pE) {
            pE.printStackTrace();
        }
    }

    public void kick() {
        try {
            InetAddress localHost = InetAddress.getLocalHost();
        } catch (UnknownHostException pE) {
            pE.printStackTrace();
        }
    }
}
