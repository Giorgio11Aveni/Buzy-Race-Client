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


import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Alberi extends Bordi implements Runnable {
    
   
    BufferedImage cespuglio;
    Livello1 game;
    

    public Alberi(BufferedImage cespuglio, Livello1 game) {
       
        super(1,500);
        this.cespuglio = cespuglio;
        this.game = game;
        
    }
    
    @Override
    public void run(){
        
        super.attivo = true;
        while(super.attivo){
            
            for (int i = 0; i<super.numero; i++){
                
                super.bordi.add(new Albero (cespuglio, game, 50));
                super.bordi.add(new Albero (cespuglio, game, 1100));
            }
            
            try {
                Thread.sleep(super.attesa);
            } catch (InterruptedException ex) {
                Logger.getLogger(Ostacoli.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
   
}

    

