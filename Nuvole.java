
package com.buzyrace;


import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aveni
*/

public class Nuvole extends Bordi implements Runnable {
    
   
    BufferedImage nuvola;
    Livello3 game;
    

    public Nuvole(BufferedImage nuvola, Livello3 game) {
       
        super(1,1200);
        this.nuvola = nuvola;
        this.game = game;
        
    }
    
    @Override
    public void run(){
        
        attivo = true;
        while(attivo){
            
            for (int i = 0; i<numero; i++){
                
                bordi.add(new Nuvola(nuvola, game, 50));
                bordi.add(new Nuvola (nuvola, game, 1100));
            }
            
            try {
                Thread.sleep(attesa);
            } catch (InterruptedException ex) {
                Logger.getLogger(Ostacoli.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
   
}

    

