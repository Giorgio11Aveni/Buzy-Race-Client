
package com.buzyrace;
/**
 *
 * @author aveni & miligi
 */
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class Livello1 extends Canvas implements Runnable, KeyListener, InterfacciaLivello{
    
    

    //Costanti d'istanza
    private final int larghezza = 1280;
    private final int altezza = 720;
    private final String nome_gioco = "Buzy Race";
    
    //Variabili d'istanza
    private BufferedImage sfondo = null;
    private BufferedImage auto = null;
    private BufferedImage img_giocatore = null;
    private BufferedImage moto1 = null;
    private BufferedImage alberi1 = null;
    private BufferedImage hole = null;
    private BufferedImage camion = null;
    private boolean attivo = false;
    private Giocatore giocatore;
    private OstacoliLivello1 ostacoli;
    private Alberi alberi;
    private int punteggio = 0;
    public static int punt = 0; 
    private boolean completato = false;
    JFrame finestra = new JFrame();
    JLabel label = new JLabel();
    private int idLivello = 1;
    private Thread ostacolilivello1;
    private DataOutputStream dos;


    //Costruttore
    public Livello1(){
 
    
        init();
 
    }
    
    private void init(){
        
      

        String nomeFinestra = "Livello 1";
      
        //Setting del JFrame
        finestra.setSize(larghezza,altezza);
	finestra.setLocationRelativeTo(null);
        finestra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	finestra.setTitle(nomeFinestra);
        finestra.add(this);
        finestra.addKeyListener(this);

        finestra.setVisible(true);

        finestra.pack();

        caricaRisorse();

        IniziaGioco();
       
    }
    

    @Override
    public void IniziaGioco(){

        giocatore = new Giocatore(img_giocatore, 800, 100, 150, this);
        ostacoli = new OstacoliLivello1(auto, moto1, hole, camion, this);
        ostacolilivello1 = new Thread (ostacoli);
        ostacolilivello1.start();
        alberi= new Alberi(alberi1, this);
        Thread alberilivello1 = new Thread(alberi);
        alberilivello1.start();
 
    }
    
    @Override
    public void caricaRisorse(){
        
        String posizione = "/Immagini/Livello1/macchina.png";
       
        Caricatore_Immagini loader = new Caricatore_Immagini();
        sfondo = loader.CaricaImmagine("/Immagini/Livello1/sfondo.jpg" );
        auto = loader.CaricaImmagine(posizione);
        img_giocatore = loader.CaricaImmagine("/Immagini/Livello1/giocatore.png");
        alberi1 = loader.CaricaImmagine("/Immagini/Livello1/albero.png");
        moto1 = loader.CaricaImmagine("/Immagini/Livello1/moto.png");
        hole = loader.CaricaImmagine("/Immagini/Livello1/buco.png");
        camion = loader.CaricaImmagine("/Immagini/Livello1/camion.png");
        
    }
  
    @Override
    public void aggiorna() throws IOException {
        
        ArrayList <Oggetto> ostacoli1 = ostacoli.getOstacoli();
        Iterator<Oggetto> itr = ostacoli1.iterator();
        
        
        while(itr.hasNext()){
            Oggetto oggetto = itr.next();

            if (Gestore_Collisioni.Controlla_collisione(giocatore, oggetto)){
                if (oggetto instanceof Auto && giocatore.healt != 10){ //AUTO E VITE > 1
                    
                   
                   this.giocatore.healt = 10 ;
                   itr.remove();
                   break;
                    
                }

                if (oggetto instanceof Auto && giocatore.healt == 10){ //AUTO E VITE = 1
                       
                       this.giocatore.healt -= 10;
                       itr.remove();
                       break;
                }
                
                if (oggetto instanceof Moto){ // MOTO
                    
                    itr.remove();
                    this.giocatore.healt -= 30;
                    break;
                    
                }
                
                if (oggetto instanceof Hole){ // BUCO
                    
                    this.giocatore.healt -= 10;
                    itr.remove();
                    break;
                }
                
                if (oggetto instanceof Camion){ // CAMION
                    
                    itr.remove();
                    this.giocatore.healt = -1;
                    break;
                }
            }
        }
  
            punteggio++; //AUMENTO GRADUALE DEL PUNTEGGIO
            
            Vittoria(); //METODO CHE MOSTRA LO SCENARIO DELLA VITTORIA
            Sconfitta(); //METODO CHE MOSTRA LO SCENARIO DELLA SCONFITTA
            
            
            
 
        }
    
    
    
    @Override
    public void Sconfitta() throws IOException { //METODO CHE PERMETTE DI FERMARE IL GIOCO IN CASO DI SCONFITTA E MOSTRARE LO SCENARIO DELLA SCONFITTA TRAMITE IL METODO DISEGNA
        
        if (controllaSconfitta()) {
           
            this.attivo = false;
            
            disegna();
            
        }
    }
    
        
    @Override
    public void Vittoria() throws IOException { //METODO CHE PERMETTE DI FERMARE IL GIOCO  IN CASO DI VITTORIA E MOSTRARE LO SCENARIO DELLA SCONFITTA TRAMITE IL METODO DISEGNA
        
        
        if (controllaVittoria()){
            
            
            this.attivo = false;
            
          
            disegna();
            
        }
    }
    
    @Override
     public boolean controllaVittoria(){ //METODO CHE CONTROLLA SE SI VINCE
         
         if (this.punt >= 500){
             
             return true;
         }
         return false;
     }       
  
        
    
    @Override
    public boolean controllaSconfitta() { //METODO CHE CONTROLLA SE SI PERDE
        
        if (giocatore.healt <=0){
            
           return true; 
        }
        return false ;
        
        
    }

      @Override
    public void run() { //PRIMO METODO CHE VIENE RICHIAMATO DAL THREAD_GIOCO
        
       
        attivo = true;
        while (attivo){

            try {
                aggiorna();
                disegna();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
        
    }

    
    @Override
    public void disegna() throws IOException { //METODO CHE PERMETTE DI VISUALIZZARE TUTTI GLI OGGETTI DEL GIOCO E LO SFONDO
        
        /*Creo due buffer su cui lavorare in modo da avere sempre l'immagine sempre disegnata*/
        
        
        BufferStrategy buffer = this.getBufferStrategy(); 
        
        if (buffer == null){
            
            createBufferStrategy(2);
            return;
            
        }

        Graphics g = buffer.getDrawGraphics();  //OTTENGO LE IMMAGINI DAL BUFFER
        g.drawImage(sfondo, 0, 0, larghezza, altezza, this);  

        
        //DISEGNO GLI OGGETTI DEL GIOCO 
        
        giocatore.disegna(g);
        ostacoli.disegna(g);
        alberi.disegna(g);
        
        //DISEGNO LE STATISTICHE DELLA VITA E DEL PUNTEGGIO
        g.setFont(new Font("Comic Sans", Font.ITALIC, 40 ));
        g.setColor(Color.white);
        g.drawString("Vite: " + this.giocatore.healt/10, 770, 657);
        punt = this.punteggio / 10;
        g.setFont(new Font("Comic Sans", Font.ITALIC, 35 ));
        g.drawString("Punteggio: " + punt + "/500", 265, 657);
        
        //AGGIUNGO UNA VITA OGNI 200 PUNTI
        if (punt %200 == 0 && punt != 0){

            this.giocatore.healt ++;
        }
       
      
    
        //DISEGNO LO SCENARIO DI SCONFITTA
        if (!attivo && controllaSconfitta() == true){
         
            g.setColor(Color.RED);
            g.fillRect(440, 260, 400, 200);
            g.setColor(Color.BLACK);
            g.setFont(new Font("Comic Sans", Font.ITALIC, 50));
            
            g.drawString("HAI PERSO!", 510, 320);
            
            g.setFont(new Font("Comic Sans", Font.ITALIC,15));
            g.drawString("Premi la barra spaziatrice per giocare di nuovo!", 480, 390);
            g.drawString("Premi esc per tornare al menù principale", 510, 420);
            g.drawString("Punteggio: " + punt+ " su 500", 555, 450);
            
         
        }
        
        //DISEGNO LO SCENARIO DI VITTORIA
        if (!attivo && controllaVittoria() == true){
            
            g.setColor(Color.GREEN);
            g.fillRect(440, 260, 400, 200);
            g.setColor(Color.BLACK);
            g.setFont(new Font("Comic Sans", Font.ITALIC, 37));
            
            g.drawString("LIVELLO SUPERATO!", 455, 300);
            
            ricompensa();
            
           
            
            if (punt == 600){
                
                g.setFont(new Font("Comic Sans", Font.ITALIC, 20));
                g.drawString("Bonus vite extra : 100 punti", 520,355);
                g.drawString("Punteggio: " + punt , 580, 385);
                g.setFont(new Font("Comic Sans", Font.ITALIC, 15));
                g.drawString("Premi spazio per giocare il prossimo livello", 490, 420);
                g.drawString("Premi esc per tornare al menù principale", 500, 440);
            }
            if (punt == 550){
                
                g.setFont(new Font("Comic Sans", Font.ITALIC, 20));
                g.drawString("Bonus vite extra : 50 punti" , 520, 355);
                g.drawString("Punteggio: " + punt , 580, 385);
                g.setFont(new Font("Comic Sans", Font.ITALIC, 15));
                g.drawString("Premi invio per giocare il prossimo livello", 490, 420);
                g.drawString("Premi spazio per giocare di nuovo", 490, 420);
                g.drawString("Premi esc per tornare al menù principale", 500, 440);
            }
            
            if (giocatore.healt <= 100){
                g.setFont(new Font("Comic Sans", Font.ITALIC, 20));
                g.drawString("Bonus vite extra : 0 punti", 520,355);
                g.drawString("Punteggio: " + punt , 580, 385);
                g.setFont(new Font("Comic Sans", Font.ITALIC, 15));
                g.drawString("Premi spazio per giocare il prossimo livello", 490, 420);
                g.drawString("Premi esc per tornare al menù principale", 500, 440);
            
            }
            /*
            Gestore_File file = new Gestore_File();
            
            try {
                file.aggiornaPunteggio(this.idLivello);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Livello1.class.getName()).log(Level.SEVERE, null, ex);
            }
            */

            //Invio al server il punteggio del livello appena superato

            String tosend = punt + "\n" + this.idLivello;
            dos.writeUTF(tosend);

            
        }

        buffer.show();
        
    }
    
    @Override
    public void ricompensa(){
        
        if (giocatore.healt == 110){
            
            this.punt += 50;
            
        }
        
        if (giocatore.healt == 120){
            
            this.punt += 100;
     
          
        }
        
    }
    

    //RISCRITTURA DEL METODO KEYPRESSED DELLA CLASSE KEY LISTENER (SE IL TASTO PIGIATO E' LA FRECCETTA A DESTRA IL GIOCATORE SI SPOSTA A DESTRA, SE IL TASTO PIGIATO E' LA FRECCETTA A SINISTRA MI SPOSTO A SINISTRA  
    //IL TUTTO E' VALIDO SOLO SE STO GIOCANDO 
    @Override
    public void keyPressed(KeyEvent ke) {
       
        int codice_tasto = ke.getKeyCode();
        
        if (attivo){

            switch (codice_tasto){
            
                case KeyEvent.VK_LEFT -> giocatore.muovisx();
                    
                case KeyEvent.VK_RIGHT -> giocatore.muovidx();
                
                
               
            }   

        }else // SE IL GIOCO NON E' ATTIVO QUINDI HO VINTO OPPURE HO PERSO 
    
                if(ke.getKeyCode() == KeyEvent.VK_SPACE ){
    
                     Livello1 livello1= new Livello1();
                        
                    Thread thread1 = new Thread(livello1);
                        
                    thread1.start();
                        
                    finestra.setVisible(false);
    
                    
                  
                        
                    }
                    
       
                 
                
                else if(ke.getKeyCode() == KeyEvent.VK_ENTER && controllaVittoria()){
    
                    Livello2 livello2= new Livello2();
                        
                    Thread thread1 = new Thread(livello2);
                        
                    thread1.start();
                        
                    finestra.setVisible(false);
    
                } 
                
                else if (ke.getKeyCode() == KeyEvent.VK_ESCAPE){
                    
                    try {
                        Menu_Livelli menu = new Menu_Livelli();
                        finestra.setVisible(false);
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(Livello1.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                
              
                    
                    
                
                }                

    
    public  int getLarghezza(){

        return this.larghezza; 
    }
    
    public int getidLivello(){
        
        return this.idLivello;
    }
    
    public int getpunt(){
        
        return this.punt;
    }
    
    
    @Override
    public void keyTyped(KeyEvent ke) {
    }

    @Override
    public void keyReleased(KeyEvent ke) {
    }
    
   
  
}
