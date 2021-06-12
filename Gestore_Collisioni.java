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
public class Gestore_Collisioni {
    
   public static boolean Controlla_collisione(Giocatore giocatore, Oggetto ostacolo){
       
      return giocatore.getBordi().intersects(ostacolo.getBordi());
   }  
}
