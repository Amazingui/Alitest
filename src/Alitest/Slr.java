package Alitest;

import javax.swing.*;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Slr extends Thread {
    @Override
    public void run() {
        try {
            int i=0;
            ServerSocket serverSocket = new ServerSocket(10241);
            while(true){
                i++;
                Socket socket = serverSocket.accept();
                System.out.println("Recent，kt Online count:"+i);
                Chat cs = new Chat(socket);
                cs.start();
                ChatManager.getCm().add(cs);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
