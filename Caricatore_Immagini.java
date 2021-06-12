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

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Logger;
import java.util.logging.Level;

import javax.imageio.ImageIO;


public class Caricatore_Immagini {

	BufferedImage image;

	public BufferedImage CaricaImmagine(String posizione){

            try {
                image = ImageIO.read(getClass().getResource(posizione));
            } catch (IOException ex) {
                Logger.getLogger(Caricatore_Immagini.class.getName()).log(Level.SEVERE, null, ex);
            }
            return image;
        }



}
