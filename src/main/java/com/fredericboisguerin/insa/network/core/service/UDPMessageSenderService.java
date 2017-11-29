package com.fredericboisguerin.insa.network.core.service;

import java.io.PrintWriter;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;

public class UDPMessageSenderService implements MessageSenderService {
    @Override
    public void sendMessageOn(String ipAddress, int port, String message) throws Exception {

        DatagramSocket senderSocket = new DatagramSocket();

        byte[] data = message.getBytes();

        DatagramPacket senderPacket = new DatagramPacket(data, data.length);
        senderPacket.setAddress(InetAddress.getByName(ipAddress));
        senderPacket.setPort(port);
        senderSocket.send(senderPacket);
        senderSocket.close();

    }
}
