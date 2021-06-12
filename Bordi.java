/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.buzyrace;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author aveni
 */
public abstract class Bordi {
    
    int numero;
    int attesa;
    
    boolean attivo = false;
    ArrayList <Oggetto> bordi;
    Random rand;
    final int bordodx = 965; 
    final int bordosx = 245;
    final int bordo = (bordodx-bordosx + 1);
    
    public Bordi(int numero, int attesa){
        
        this.numero = numero;
        this.attesa = attesa;
        bordi = new ArrayList();
        rand = new Random();

    }
    
     public void disegna (Graphics g){
        
        for(int i = 0; i<bordi.size(); i++){
            
            Oggetto tmp = bordi.get(i);
            
            
            
            tmp.disegna(g);
        }
    }
    
}
