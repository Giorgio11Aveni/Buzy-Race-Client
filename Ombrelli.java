package com.buzyrace;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.awt.image.BufferedImage;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aveni & miligi
 */


public class Ombrelli extends Bordi implements Runnable {
    
   
    BufferedImage ombrelli;
    Livello2 game;
    

    public Ombrelli(BufferedImage ombrelli, Livello2 game) {
       
        super(1,4000);
        this.ombrelli = ombrelli;
        this.game = game;
        
    }
    
    @Override
    public void run(){
        
        attivo = true;
        while(attivo){
            
            for (int i = 0; i<numero; i++){
                
                bordi.add(new Ombrello(ombrelli,game,10));
                bordi.add(new Ombrello(ombrelli,game,1100));
            }
            
            try {
                Thread.sleep(attesa);
            } catch (InterruptedException ex) {
                Logger.getLogger(Ostacoli.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
   
}

    

