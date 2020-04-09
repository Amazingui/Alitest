package Alitest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;

public class Chat extends Thread {
    Socket socket;
    public Chat(Socket s){
        this.socket=s;
    }
    public void out(String out){
        try {
            socket.getOutputStream().write(out.getBytes("UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public InetAddress getip(){
        return socket.getInetAddress();
    }
    @Override
    public void run(){
        try {
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(
                            socket.getInputStream(),"UTF-8"));
            String line = null;
            while((line = br.readLine())!=null){
                ChatManager.getCm().pub(this,this.getip()+": "+line);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
