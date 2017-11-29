package com.fredericboisguerin.insa.network.core.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class TCPMessageSenderService implements MessageSenderService {
    @Override
    public void sendMessageOn(String ipAddress, int port, String message) throws Exception {
        Socket ss = new Socket(ipAddress,port);

        PrintWriter pr = new PrintWriter(ss.getOutputStream());

        pr.print(message);

        pr.close();
    }
}
