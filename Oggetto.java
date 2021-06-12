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
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.logging.Level;
import java.util.logging.Logger;
    
    public abstract class Oggetto extends Thread {
    
    int larghezza;
    int altezza;
    boolean attivo;
    int y;
    int velocita;
   
    
    
    
    public Oggetto( int larghezza, int altezza, int y, int velocita){
        
        this.larghezza = larghezza;
        this.altezza = altezza;
        this.y = y;
        attivo = true;
        this.velocita = velocita;
        this.start();  
       
    }
    
    
    abstract void aggiorna() ;

    abstract void disegna(Graphics g);
    
    public abstract Rectangle getBordi();

}

