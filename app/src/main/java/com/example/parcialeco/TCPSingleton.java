package com.example.parcialeco;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPSingleton extends Thread {


    private static TCPSingleton unicainstancia;


    public static TCPSingleton getInstance() {
    if (unicainstancia == null){
        unicainstancia = new TCPSingleton();
    }
return unicainstancia;
    }

    private TCPSingleton(){



    }

    private Socket socket;
    BufferedWriter writer;
    BufferedReader reader;


public void run(){
    try {
        System.out.println("Connecting to server...");
        socket = new Socket("192.168.39.156", 8080);
        System.out.println("Established connection to server");

        InputStream is = socket.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        reader = new BufferedReader(isr);

        OutputStream os = socket.getOutputStream();
        OutputStreamWriter osw = new OutputStreamWriter(os);
        writer = new BufferedWriter(osw);

        while(true)
        {
            System.out.println("Awaiting message...");
            String line = reader.readLine();
            System.out.println("Received message: " + line);


        }
    } catch (UnknownHostException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }

}
public void enviarMensaje(){
    new Thread(
            () ->
            {
                try {
                    writer.write("Hola Mundo" + "\n");
                    writer.flush();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }).start();
}
}

