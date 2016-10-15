package com.rajeshpatkar.client;

import javax.swing.*;
import java.io.*;
import java.net.*;
import java.util.*;

class Reader extends Thread {
    JTextArea clientText;
    Socket soc;

    Reader(Socket soc) {
        this.soc = soc;
    }

    Reader(Socket soc, JTextArea clientText){
        this.soc = soc;
        this.clientText = clientText;
    }

    public void run() {
        try {
            BufferedReader nis = new BufferedReader(
                            new InputStreamReader(
                            soc.getInputStream()
                            )
             );
            String str = nis.readLine();
            while( !str.equals("End") )
            {
             System.out.println("Message from Server >> " +str );
             clientText.append("Message from Server >> "+ str+"\n");
             str = nis.readLine();
            }
        } catch (Exception e) {
        }
    }
}