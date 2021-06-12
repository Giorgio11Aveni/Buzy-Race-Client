package com.buzyrace;

import java.io.*;
import java.net.*;
import java.util.Scanner;


//Classe Client
public class Client {
    public static void main(String[] args) throws IOException {

        try{

        Scanner scn = new Scanner(System.in);

        //Ottengo l'indirizzo IP
        InetAddress ip = InetAddress.getByName("localhost");

        //Stabilizzo la connessione con il server sulla porta 7964
        Socket s = new Socket(ip, 7964);



            //Prima Richiesta dal server
            //System.out.println(dis.readUTF());

        }
        catch(Exception e){
            e.printStackTrace();
        }

    }

}
