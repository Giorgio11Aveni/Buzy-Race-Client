/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.buzyrace;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;

/**
 *
 * @author aveni
 */
public class Aereoplano extends Oggetto implements Runnable {
    
    
    private BufferedImage aereoplano = null;
    private Livello3 game;
    private int x;
    

  

    Aereoplano(BufferedImage aereoplano, Livello3 game, int x) {
        super(80,100,-200,8);
        this.game = game;
        this.aereoplano = aereoplano;
        this.x = x;
    }

    @Override
    void aggiorna() {
        
        y+=velocita;
       
    }
    

    @Override
    void disegna(Graphics g) {
        
        g.drawImage(aereoplano, x, y, larghezza, altezza, game);
    }

    @Override
    public Rectangle getBordi() {
       return new Rectangle (x,y,larghezza,altezza);
    }

     @Override
    public void run(){
        
        attivo = true;
        while (attivo){
                aggiorna();
                
            try {
                Thread.sleep(20);
            } catch (InterruptedException ex) {
                java.util.logging.Logger.getLogger(Auto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
                	
            
        }
       
        
    }
}
