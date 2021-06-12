/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.buzyrace;
/**
 *
 * @author aveni
 */


import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;



public abstract class Ostacoli{
    
    int numero;
    int attesa;
    
    boolean attivo = false;
    ArrayList <Oggetto> traffico_auto;
    Random rand;
    
    int larghezza;
    int altezza;
    int x;
    int y;
    int velocita;
    

    public Ostacoli(int numero, int attesa) {
        this.numero = numero;
        this.attesa = attesa;
        traffico_auto = new ArrayList();
        rand = new Random();
    }
    
    
    
     public void disegna (Graphics g){
        
        for(int i = 0; i<traffico_auto.size(); i++){
            
            Oggetto tmp = traffico_auto.get(i);

            tmp.disegna(g);
        }
    }
     
     public ArrayList getOstacoli(){
         
         return traffico_auto;
     }
}