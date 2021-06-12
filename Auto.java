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
public class Auto extends Oggetto implements Runnable {
    
    
    private BufferedImage auto = null;
    private Livello1 game;
    private int x;
    
    

    public Auto(BufferedImage auto, Livello1 game, int x) {
        
        super(100,150,-200,3);
        this.game = game;
        this.auto = auto;
        this.x = x;
    }

    @Override
    void aggiorna() {
        
        y+=velocita;
       
    }
    

    @Override
    void disegna(Graphics g) {
        
        g.drawImage(auto, x, y, larghezza, altezza, game);
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
