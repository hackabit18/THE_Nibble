package com.example.aj.dar;

import android.view.View;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.*;
import java.util.Enumeration;

/**
 * Created by AJ on 10/27/2018.
 */

public class Server {

    ServerActivity activity;
    ServerSocket serverSocket;
    String message = "";
    static final int socketServerPORT = 4444;

    public Server(View.OnClickListener activity){
        //this.activity = activity;
        Thread serverSocketThread = new Thread(new serverSocketThread());
        serverSocketThread.start();
    }

    public static int getPort() {
        return socketServerPORT;
    }

    public void onDestroy(){
        if (serverSocket != null) {
            try {
                serverSocket.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    private class serverSocketThread extends Thread
    {
        int count = 0;

        public void run()
        {
            try{

                ServerSocket server = new ServerSocket(socketServerPORT);
                Socket socket = null;
                while(true)
                {
                    socket = server.accept();
                    count++;
                    message += "#" + count + " from "
                            + socket.getInetAddress() + ":"
                            + socket.getPort() + "\n";

                    activity.runOnUiThread(new Runnable() {

                        @Override
                        public void run() {
                            activity.ipPort.setText(message);
                        }
                    });

                    SocketServerReply socketServerReplyThread = new SocketServerReply(socket, count);
                    socketServerReplyThread.run();
                }

            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public class SocketServerReply extends Thread{

        private Socket hostThreadSocket;
        int cnt;

        SocketServerReply(Socket socket, int c)
        {
            hostThreadSocket = socket;
            cnt = c;
        }

        public void run(){

            DataOutputStream dos;
            DataInputStream dis;
            String replyMessage = "Your Attendence is marked";
            final String Errormsg = "Something went wrong";
            try{
                dos = new DataOutputStream(hostThreadSocket.getOutputStream());
                dis = new DataInputStream(hostThreadSocket.getInputStream());

               final String received =  dis.readUTF();

                if(received != null && !received.isEmpty())
                {
                    dos.writeUTF(replyMessage);
                } else {
                    dos.writeUTF("Try Again");
                }

                activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        activity.message.setText(received);
                    }
                });
            } catch(Exception e){
                e.printStackTrace();
            }

            activity.runOnUiThread(new Runnable() {

                @Override
                public void run() {
                    activity.message.setText(Errormsg);
                }
            });
        }
    }

    public String getIpAddress() {
        String ip = "";
        try {
            Enumeration<NetworkInterface> enumNetworkInterfaces = NetworkInterface
                    .getNetworkInterfaces();
            while (enumNetworkInterfaces.hasMoreElements()) {
                NetworkInterface networkInterface = enumNetworkInterfaces
                        .nextElement();
                Enumeration<InetAddress> enumInetAddress = networkInterface
                        .getInetAddresses();
                while (enumInetAddress.hasMoreElements()) {
                    InetAddress inetAddress = enumInetAddress
                            .nextElement();

                    if (inetAddress.isSiteLocalAddress()) {
                        ip += ""+ inetAddress.getHostAddress();
                    }
                }
            }

        } catch (SocketException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            ip += "Something Wrong! " + e.toString() + "\n";
        }
        return ip;
    }

}
