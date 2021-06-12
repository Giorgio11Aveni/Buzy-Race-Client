/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.buzyrace;
/**
 *
 * @author aveni & miligi
 */


import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Home extends JFrame implements ActionListener {

    JPanel panel;
    JLabel label;
    JLabel label3;
	JButton new_game;
	JButton save;
	JButton online;
	JButton info;
	final int larghezza = 1290;
	final int altezza = 760;
	ImageIcon img = new ImageIcon("C:\\Users\\aveni\\IdeaProjects\\BuzyRaceCS\\Client\\sfondo1.png");
	ImageIcon img2 = new ImageIcon("C:\\Users\\aveni\\IdeaProjects\\BuzyRaceCS\\Client\\info.png");
	//String path = "C:\\Users\\dario\\IdeaProjects\\BuzyRaceCS\\Client\\src\\SaveFile\\Save.txt";

	int totale;
	int punteggio1;
	int punteggio2;
	int punteggio3;
    private String line;
    private String[] data;
    private DataInputStream dis;
    private DataOutputStream dos;


    //Costruttore
        public Home () {
		
            init();
        
        }
         
         
	public void init() {
		
		//Setting JFrame
		String nomeFinestra = "Buzy Race";
			
			
		this.setSize(larghezza, altezza);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle(nomeFinestra);
				

		//setting Label		
		label = new JLabel("", img, JLabel.CENTER);
		label.setSize(1280, 720);
                label.setBounds(0,0,1280,720);
		this.add(label);
				

		//Setting buttons "new game"
		new_game = new JButton("New Game");
		new_game.setBounds(100,400,300, 150);
		new_game.setBackground(Color.lightGray);
		new_game.setFocusable(false);
		new_game.setFont(new Font("Comic Sans", Font.BOLD,25));
		new_game.setBorder(BorderFactory.createEtchedBorder());
		label.add(new_game);
                new_game.addActionListener(this);

		
                //Setting buttons "caricamento salvataggio"
                
                //File f = new File(path);
                
                    
		save = new JButton("Carica salvataggio");
		save.setBounds(900,400,300, 150);
		save.setBackground(Color.lightGray);
		save.setFocusable(false);
		save.setFont(new Font("Comic Sans", Font.BOLD,25));
                save.setBorder(BorderFactory.createEtchedBorder());
                label.add(save);
                save.addActionListener(this);

                /*
                if(!f.exists() && !f.isDirectory()){
                    
                    save.setEnabled(false);
                }
                 */
                    
                //Setting buttons Partita Classificata    
                online = new JButton("Partita Classificata");
		online.setBounds(500,400,300, 150);
		online.setBackground(Color.lightGray);
		online.setFocusable(false);
		online.setFont(new Font("Comic Sans", Font.BOLD,25));
                online.setBorder(BorderFactory.createEtchedBorder());
                label.add(online);
                online.addActionListener(this);
                
		
		//Setting buttons info;
			
		info = new JButton();
		info.setBounds(1200,100,75, 84 );
		info.setFocusable(false);
		info.setText("Info");
		info.setFont(new Font("Comic Sans",Font.BOLD,15));
		info.setHorizontalTextPosition(JButton.CENTER);
		info.setVerticalTextPosition(JButton.BOTTOM);
		info.setForeground(Color.black);
		info.setBackground(Color.lightGray);
		info.setIcon(img2);
                info.setBorder(BorderFactory.createEtchedBorder());
		label.add(info);
                info.addActionListener(this);

		this.setVisible(true);


	
	
        }

	@Override
	public void actionPerformed(ActionEvent ex) {
		
            if (ex.getSource() == info){
                
                Info info = new Info();
                this.setVisible(false);
            }

            /*
            if (ex.getSource() == logoff){

                try {
                    dis.close();
                    dos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

             */


            if (ex.getSource() == new_game) {

                try {
                    Menu_Livelli menu = new Menu_Livelli();

                } catch (FileNotFoundException ex2) {
                    Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex2);
                }

                this.setVisible(false);

            }
                
                else if (ex.getSource() == save) {

                try {
                    line = dis.readUTF();
                    data = line.split("\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }

                punteggio1 = Integer.parseInt(data[1]);
                punteggio2 = Integer.parseInt(data[2]);
                punteggio3 = Integer.parseInt(data[3]);
                totale = punteggio1 + punteggio2 + punteggio3;

                    try {
                        Menu_Livelli menu = new Menu_Livelli();
                        
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                    
                   
             
                    this.setVisible(false);

                }
                
	}
}
        
