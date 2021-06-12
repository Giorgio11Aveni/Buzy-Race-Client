/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.buzyrace;

import java.io.IOException;

/**
 *
 * @author aveni & miligi
 */
public interface InterfacciaLivello {
    
    public abstract void IniziaGioco();
    
    public abstract void caricaRisorse();
    
    public abstract void aggiorna() throws IOException;
    
    public abstract void Sconfitta() throws IOException;
    
    public abstract void Vittoria() throws IOException;
    
    public abstract boolean controllaSconfitta();
    
    public abstract boolean controllaVittoria();
    
    public abstract void disegna() throws IOException;
    
    public abstract void ricompensa();
    
}
