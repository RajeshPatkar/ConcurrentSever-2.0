package com.rajeshpatkar.client;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.*;
import java.util.*;

public class Client {

    public static void main(String[] args) throws Exception {

        JFrame clientFrame = new JFrame("client");
        JPanel clientPanel = new JPanel();
        JTextArea clientTextArea = new JTextArea(20,20);
        JTextField clientTextField = new JTextField(10);
        JButton clientButton = new JButton("send");
        clientPanel.add(clientTextField);
        clientPanel.add(clientButton);
        clientFrame.add(BorderLayout.CENTER,clientTextArea);
        clientFrame.add(BorderLayout.SOUTH,clientPanel);
        clientFrame.setSize(400,400);
        clientFrame.setVisible(true);
        clientFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        System.out.println("Client Signing on");
        clientTextArea.append("Client Signing on\n");
          try {
            Socket soc = new Socket("127.0.0.1", 8096);
            Reader r = new Reader(soc);
            r.start();
            System.out.println("Client says connection establised");

            OutputStream out = soc.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(out);
            BufferedWriter br = new BufferedWriter(osw);
            PrintWriter nos = new PrintWriter(br, true);
            BufferedReader kin = new BufferedReader(
                    new InputStreamReader(
                            System.in
                    )
            );
            String n = kin.readLine();
            while (!n.equals("End")) {
                nos.println(n);
                n = kin.readLine();
            }
            nos.println("End");

            System.out.println("Client Signing off");

        } catch (ConnectException e) {

        }
    }

}