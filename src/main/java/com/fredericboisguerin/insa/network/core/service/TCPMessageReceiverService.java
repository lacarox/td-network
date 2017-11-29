package com.fredericboisguerin.insa.network.core.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPMessageReceiverService implements MessageReceiverService {
    @Override
    public void listenOnPort(int port, IncomingMessageListener incomingMessageListener) throws Exception {
        ServerSocket ss = new ServerSocket(port);

        Socket s = ss.accept();
        InputStreamReader isp = new InputStreamReader(s.getInputStream());

        BufferedReader br = new BufferedReader(isp);
        String msg = br.readLine();
        incomingMessageListener.onNewIncomingMessage(msg);

        ss.close();
    }
}
