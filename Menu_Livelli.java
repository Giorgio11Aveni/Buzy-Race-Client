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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.ActionListener;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;




public class Menu_Livelli extends JFrame implements ActionListener {
    
    
        Container label;
        JButton livello1;
        JButton livello2;
        JButton livello3;
        JButton menu_principale;
        JLabel statistiche1;
        JLabel statistiche2;
        JLabel statistiche3;
        JLabel titolo;
        JLabel punteggio_totale;
	final int larghezza = 1290;
	final int altezza = 760;
	ImageIcon img = new ImageIcon("sfondo1.png");
        ImageIcon img2 = new ImageIcon("freccia.png");
        int totale;
        int punteggio1;
        int punteggio2;
        int punteggio3;
        private String line;
        private String[] data;
    private DataInputStream dis;

    //Costruttore
        public Menu_Livelli () throws FileNotFoundException {
		
            init();
        
        }
 
         
	public void init() throws FileNotFoundException {

        /*
                    Gestore_File file = new Gestore_File();
                    try {
                        file.readFile();
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
                    }
                
                
                    punteggio1 = file.getPunteggio1() ;
                    punteggio2 = file.getPunteggio2() ;
                    punteggio3 = file.getPunteggio3() ;
                    totale = punteggio1 + punteggio2 + punteggio3;

         */

        //Ricevo dal server i nuovi punteggi aggiornati

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
				

		//setting button livello1
                livello1 = new JButton("Livello 1");
		livello1.setBounds(300,250,200, 75);
		livello1.setBackground(Color.lightGray);
		livello1.setFocusable(false);
		livello1.setFont(new Font("Comic Sans", Font.ROMAN_BASELINE,30));
                livello1.setBorder(BorderFactory.createEtchedBorder());
		label.add(livello1);
                livello1.addActionListener(this); 
                
                //setting button livello2
                
                livello2 = new JButton("Livello 2");
		livello2.setBounds(300,400,200, 75);
		livello2.setBackground(Color.lightGray);
		livello2.setFocusable(false);
		livello2.setFont(new Font("Comic Sans", Font.ROMAN_BASELINE,30));
                livello2.setBorder(BorderFactory.createEtchedBorder());
		label.add(livello2);
                livello2.addActionListener(this);
                if (punteggio1 < 500){
                    
                    livello2.setEnabled(false);
                }
                
                //setting button livello3
                livello3 = new JButton("Livello 3");
		livello3.setBounds(300,550,200, 75);
		livello3.setBackground(Color.lightGray);
		livello3.setFocusable(false);
		livello3.setFont(new Font("Comic Sans", Font.ROMAN_BASELINE,30));
                livello3.setBorder(BorderFactory.createEtchedBorder());
		label.add(livello3);
                livello3.addActionListener(this);
                if (punteggio2 < 1000){
                    
                    livello3.setEnabled(false);
                }
                
                //setting button menu_principale
                menu_principale = new JButton("Menu");
                menu_principale.setBounds(20,100,75, 84 );
                menu_principale.setFocusable(false);
		        menu_principale.setText("Menù");
		        menu_principale.setFont(new Font("Comic Sans",Font.BOLD,15));
		        menu_principale.setHorizontalTextPosition(JButton.CENTER);
		        menu_principale.setVerticalTextPosition(JButton.BOTTOM);
		        menu_principale.setForeground(Color.black);
		        menu_principale.setBackground(Color.lightGray);
		        menu_principale.setIcon(img2);
                menu_principale.setBorder(BorderFactory.createEtchedBorder());
                label.add(menu_principale);
                menu_principale.addActionListener(this);
                
                
                //setting label livello1
                
                statistiche1 = new JLabel();
                statistiche1.setBounds(700, 210, 400, 100);
                statistiche1.setFont(new Font("Comic Sans", Font.ROMAN_BASELINE, 30));
                statistiche1.setForeground(Color.white);
                if (punteggio1 >= 500){
                    
                    statistiche1.setText("<html>Livello superato! <br>  Punteggio : " + punteggio1 + "< / 500" + "</html>");
                }
                
                else{
                    
                statistiche1.setText("<html>Livello non superato! <br>  Punteggio : " + punteggio1 + "< / 500" + "</html>");
                
                }
                
                statistiche1.setBackground(Color.white);
                label.add(statistiche1);
                
                // setting label livello2
                statistiche2 = new JLabel();
                statistiche2.setBounds(700, 370, 400, 100);
                statistiche2.setFont(new Font("Comic Sans", Font.ROMAN_BASELINE, 30));
                statistiche2.setForeground(Color.white);
                if (punteggio2 >= 1000){
                    
                    statistiche2.setText("<html>Livello superato! <br>  Punteggio : " + punteggio2 + " / 1000" + "</html>");
                }
                
                else{
                    
                statistiche2.setText("<html>Livello non superato! <br>  Punteggio : " + punteggio2 + "< / 1000" + "</html>");
                
                }
                statistiche2.setBackground(Color.white);
                label.add(statistiche2);
                
                //setting label livello3
                statistiche3 = new JLabel();
                statistiche3.setBounds(700, 520, 400, 100);
                statistiche3.setFont(new Font("Comic Sans", Font.ROMAN_BASELINE, 30));
                statistiche3.setForeground(Color.white);if (punteggio2 >= 1000){
                    
                    statistiche3.setText("<html>Livello superato! <br>  Punteggio : " + punteggio3 + "< / 1500" + "</html>");
                }
                
                else{
                    
                statistiche3.setText("<html>Livello non superato! <br>  Punteggio : " + punteggio3 + "< / 1500" + "</html>");
                
                }
                
                statistiche3.setBackground(Color.red);
                
                label.add(statistiche3);
                
                 //setting label punteggio totale
                punteggio_totale = new JLabel();
                punteggio_totale.setBounds(600, 620, 400, 100);
                punteggio_totale.setFont(new Font("Comic Sans", Font.ROMAN_BASELINE, 30));
                punteggio_totale.setForeground(Color.white);
                punteggio_totale.setText("Punteggio Totale : " + totale);
                punteggio_totale.setBackground(Color.red);
               
                
                label.add(punteggio_totale);
                
                titolo = new JLabel();
                titolo.setBounds(330, 100, 800, 100);
                titolo.setFont(new Font("Comic Sans", Font.ROMAN_BASELINE, 50));
                titolo.setForeground(Color.white);
                titolo.setText("SELEZIONA    LIVELLO");
                titolo.setBackground(Color.red);
                label.add(titolo);
                
		this.setVisible(true);

        }

	@Override
	public void actionPerformed(ActionEvent e) {
	
            if (e.getSource() == livello1){
                
                
                Livello1 gioco = new Livello1();  
                Thread thread_gioco = new Thread(gioco);
		thread_gioco.start();
                this.setVisible(false);
                
            }
            
             if (e.getSource() == livello2){
                
                
                Livello2 gioco = new Livello2();  
                Thread thread_gioco = new Thread(gioco);
		thread_gioco.start();
                this.setVisible(false);
                
            }
             
            if (e.getSource() == livello3){
                
                
                Livello3 gioco = new Livello3();  
                Thread thread_gioco = new Thread(gioco);
		thread_gioco.start();
                this.setVisible(false);
                
            }
             
            if (e.getSource() == menu_principale){
                
                
                Home home = new Home();  
                this.setVisible(false);
                
            }


	}
        
}

        

