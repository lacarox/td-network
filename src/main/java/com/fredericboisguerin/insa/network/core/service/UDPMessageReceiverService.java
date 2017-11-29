package com.fredericboisguerin.insa.network.core.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Socket;

public class UDPMessageReceiverService implements MessageReceiverService {
    @Override
    public void listenOnPort(int port, IncomingMessageListener incomingMessageListener) throws Exception {

        DatagramSocket receiverSocket = new DatagramSocket(port);
        DatagramPacket receiverPacket = new DatagramPacket(new byte[20],20);
        receiverSocket.receive(receiverPacket);

        byte[] data = receiverPacket.getData();
        String msg = new String(data);


        incomingMessageListener.onNewIncomingMessage(msg);
    }
}
