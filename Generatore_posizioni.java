/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.buzyrace;

import java.util.Random;

/**
 *
 * @author aveni & miligi
 */
public class Generatore_posizioni {
    
    private final int bordodx = 950; 
    private final int bordosx = 245;
    private final int bordo = (bordodx-bordosx + 1);
    private int a = 0;
 
    public int randInt() {
  
        Random rand = new Random();
        int randomNum = rand.nextInt(5) + 0;

      
        
        switch (randomNum){
            
            case 0:
                
               a = 290;
                               
                break;
                
            case 1:
                
                a = 450;
                
                break;
                
            case 2 :
                
               a = 600;
                
                break;
                
            case 3 :
                
                a = 750 ;
                
                break;
                
            case 4 :
                
                
               a = 900;
             
        }
        
        return a;
  
    }
    
    
    
}

