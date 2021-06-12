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


public class Giocatore {
    
  private int altezza;
  private int larghezza;
  private int x;
  private int y;
  private final int velocita = 10;
  Livello1 game;
  Livello2 game2;
  Livello3 game3;
  public int healt = 100;
  
  BufferedImage giocatore;

    public int getAltezza() {
        return altezza;
    }

    public void setAltezza(int altezza) {
        this.altezza = altezza;
    }

    public int getLarghezza() {
        return larghezza;
    }

    public void setLarghezza(int larghezza) {
        this.larghezza = larghezza;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
  
    
    public Giocatore (BufferedImage image, int x, int larghezza, int altezza, Livello1 game){
        
        this.x = x;
        this.altezza = altezza;
        this.larghezza = larghezza;
        this.giocatore = image;
        y = 400;
        this.game = game;
        
    }
    
    public Giocatore (BufferedImage image, int x, int larghezza, int altezza, Livello2 game2){
        
        this.x = x;
        this.altezza = altezza;
        this.larghezza = larghezza;
        this.giocatore = image;
        y = 500;
        this.game2 = game2;
        
    }
    
    public Giocatore (BufferedImage image, int x, int larghezza, int altezza, Livello3 game3){
        
        this.x = x;
        this.altezza = altezza;
        this.larghezza = larghezza;
        this.giocatore = image;
        y = 500;
        this.game2 = game2;
        
    }
    
    public void muovidx(){
       if (x < 930){
        x += velocita;
       }
    }
    
    public void muovisx(){
        
        if (x>220){
        x -= velocita;
    }
    }
    
    public void disegna(Graphics g){
        
        g.drawImage(giocatore, x, y, larghezza, altezza, game);
    }
    
    public Rectangle getBordi(){
        
        
      return new Rectangle (x,y,larghezza,altezza);
        
        
    }
    
}