/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.buzyrace;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author aveni & miligi
 */
public class Info extends JFrame implements ActionListener {
    
    final int larghezza = 1290;
    final int altezza = 760;
    ImageIcon img = new ImageIcon("sfondo2.png");
    ImageIcon img2 = new ImageIcon("freccia.png");
    JLabel label;
    JLabel text;
    JLabel text2;
    JButton menu_principale;
    JButton gioca;
    
    public Info(){
        
        init();
    }
    
    public void init() {
		
		//Setting JFrame
		String nomeFinestra = "Info";
		
                
			
		this.setSize(larghezza, altezza);
                this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle(nomeFinestra);
                this.setVisible(true);
                
                //setting Label		
		label = new JLabel("", img, JLabel.CENTER);
		label.setSize(1280, 720);
                label.setBounds(0,0,1280,720);
		this.add(label);
                
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
                
                text = new JLabel();
                text.setBounds(420, 150, 550, 50);
                text.setFont(new Font("Comic Sans", Font.ROMAN_BASELINE, 60));
                text.setForeground(Color.black);
                text.setText("COME GIOCARE");
                label.add(text);
                
                text2 = new JLabel();
                text2.setBounds(193, 50, 1150, 700);
                text2.setFont(new Font("Comic Sans", Font.ROMAN_BASELINE, 17));
                text2.setText("<html><br>Benvenuto su Buzy Race! In questo gioco dovrai superare tre livelli con tre diversi scenari: in strada, in mare ed in cielo!" 
                        + "<br>Per superare il primo livello dovrai evitare macchine, moto, buche e camion."
                        + "<br>Una volta totalizzati 500 punti (incrementati gradualmente durante il livello), avrai superato il livello!"
                        + "<br>Per superare il secondo livello dovrai evitare barche, zattere scogli e gommoni."
                        + "<br>Una volta totalizzati 1000 punti avrai superato il livello!"
                        + "<br>Per superare il terzo livello dovrai evitare barche, zattere, scogli e gommoni."
                        + "<br>Una volta totalizzati 1500 punti avrai superato il livello!"
                        + "<br>Durante il livello guadagnerai delle vite extra."
                        + "<br>Guadagnerai punti extra in base al numero di vite con cui finirai il livello."
                        + "<br>Buche, scogli, ed uccelli ti toglieranno una vita in caso di incidente!"
                        + "<br>Moto, Zattere, ed aereoplani ti toglieranno tre vite in caso di incidente!"
                        + "<br>Auto, gommoni ed elicotteri ti lasceranno un unica vita in caso di incidente!"
                        + "<br>Camion, barche ed aerei ti faranno perdere in caso di incidente!"
                        + "<br>Premi la freccetta a sinistra per spostarti a sinistra."
                        + "<br>Premi la freccetta a destra per spostarti a destra.</html>");
                label.add(text2);
                
                gioca = new JButton("Gioca");
                gioca.setBounds(550,600,175, 84 );
                gioca.setFocusable(false);
		gioca.setText("Gioca");
		gioca.setFont(new Font("Comic Sans",Font.BOLD,15));
		gioca.setHorizontalTextPosition(JButton.CENTER);
		gioca.setVerticalTextPosition(JButton.BOTTOM);
		gioca.setForeground(Color.black);
		gioca.setBackground(Color.lightGray);
                gioca.setBorder(BorderFactory.createEtchedBorder());
                label.add(gioca);
                gioca.addActionListener(this);
          
                
                
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == menu_principale){
            
            Home home = new Home();
            
            this.setVisible(false);
        }
        
        if (e.getSource() == gioca){
            
            try {
                Menu_Livelli menu = new Menu_Livelli();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Info.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.setVisible(false);
        }
    }
    
}
