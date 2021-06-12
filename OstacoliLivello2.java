/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.buzyrace;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aveni
 */
public class OstacoliLivello2 extends Ostacoli implements Runnable{
    
    BufferedImage gommone;
    BufferedImage zattera;
    BufferedImage scoglio;
    BufferedImage barca;
    Livello2 game;
    
    public OstacoliLivello2(BufferedImage gommone, BufferedImage zattera,BufferedImage scoglio,BufferedImage barca,Livello2 game){
        
        super(1,5000);
        this.gommone = gommone;
        this.zattera = zattera;
        this.scoglio = scoglio;
        this.barca = barca;
        this.game = game;
    }
    
    @Override
    public void run(){
        
        int x1 =0;
        int x2 =0;
        int x3=0;
        int x4 = 0;
                
        super.attivo = true;
        while(attivo){
            
            for (int i = 0; i<numero; i++){
                
                Generatore_posizioni bordi= new Generatore_posizioni();
                
                x1 = bordi.randInt();
                this.x = x1;
            
                
                traffico_auto.add(new Gommone(gommone,game,x));
                
                x2 = bordi.randInt();
                while (x1 == x2){ 
                x2 = bordi.randInt();
                }
                
                this.x = x2;
                traffico_auto.add(new Zattera(zattera,game,x));
                
                x3 = bordi.randInt();
                while ((x1 == x3) || (x2 == x3 )){
                x3 = bordi.randInt();
                }

                this.x = x3;
                traffico_auto.add(new Scoglio(scoglio,game,x));
                
                x4 = bordi.randInt();
                while (x1 == x4 || x2 == x4 || x3 ==x4){
                    x4=bordi.randInt();
                }
                
                this.x=x4;
                traffico_auto.add(new Barca(barca,game,x));
   
            }
            
            try {
                Thread.sleep(attesa);
            } catch (InterruptedException ex) {
                Logger.getLogger(OstacoliLivello2.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }

    @Override
    public void disegna(Graphics g) {
        super.disegna(g); //To change body of generated methods, choose Tools | Templates.
    }
    
   
   
}

