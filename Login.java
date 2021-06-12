package com.buzyrace;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Login extends JFrame implements ActionListener {

    private DataOutputStream dos;
    private DataInputStream dis;
    private JFrame regFrame;
    private JFrame logFrame;

    public static void main(String [] args) {
        Login login = new Login();
    }


    //Begin

    JRadioButton reg = new JRadioButton();
    JRadioButton log = new JRadioButton();
    ButtonGroup G1 = new ButtonGroup();

    //Panel

    JTextField user = new JTextField();
    JPasswordField pass = new JPasswordField();
    JButton send = new JButton("Invia");
    JButton logSend = new JButton("Log");
    JButton regSend = new JButton("Register");
    private String login;
    private String password;

    public Login() {

        //Creazione pannello scelta Registrazione/Login

        JPanel panel = new JPanel();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Authentication");
        this.setSize(280, 280);
        this.setLocationRelativeTo(null);

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        reg.setText("Registrazione");
        log.setText("Login");
        panel.add(reg);
        panel.add(log);

        panel.add(send);

        G1.add(reg);
        G1.add(log);

        send.addActionListener(this);

        this.getContentPane().add(panel, BorderLayout.CENTER);
        this.setVisible(true);

    }

            @Override
            public void actionPerformed(ActionEvent send) {
                if (reg.isSelected()) {

                    try {
                        //Ottengo l'indirizzo IP
                        InetAddress ip = InetAddress.getByName("localhost");
                        //Stabilizzo la connessione con il server sulla porta 7964
                        Socket s = new Socket(ip, 7964);
                        DataInputStream dis = new DataInputStream(s.getInputStream());
                        DataOutputStream dos = new DataOutputStream(s.getOutputStream());


                        this.setVisible(false);

                        while (true) {

                            String tosend = "Registrazione";
                            dos.writeUTF(tosend);


                            break;
                        }

                        handleRegFrame();

                        regSend.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                regFrame.setVisible(false);
                                login = user.getText();
                                password = pass.getText();

                                while (true) {
                                    String credenziali = login + " " + password;
                                    try {
                                        dos.writeUTF(credenziali);
                                        String received = dis.readUTF();

                                        while (received.equals("L'username non è disponibile.\nInserisci nuovi dati:")) {
                                            regFrame.setVisible(true);
                                            regSend.addActionListener(new ActionListener() {
                                                @Override
                                                public void actionPerformed(ActionEvent e) {
                                                    regFrame.setVisible(false);
                                                    login = user.getText();
                                                    password = pass.getText();
                                                }
                                            });
                                            credenziali = login + " " + password;
                                            dos.writeUTF(credenziali);
                                            received = dis.readUTF();
                                        }

                                        Home home = new Home();

                                    } catch (IOException ioException) {
                                        ioException.printStackTrace();
                                    }
                                    break;
                                }
                            }
                        });


                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else if (log.isSelected()) {

                    try {
                        //Ottengo l'indirizzo IP
                        InetAddress ip = InetAddress.getByName("localhost");
                        //Stabilizzo la connessione con il server sulla porta 7964
                        Socket s = new Socket(ip, 7964);
                        DataInputStream dis = new DataInputStream(s.getInputStream());
                        DataOutputStream dos = new DataOutputStream(s.getOutputStream());


                        this.setVisible(false);

                        while (true) {

                            String tosend = "Login";
                            dos.writeUTF(tosend);


                            break;
                        }

                        handleLogFrame();

                        logSend.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                logFrame.setVisible(false);
                                login = user.getText();
                                password = pass.getText();

                                while (true) {
                                    String credenziali = login + " " + password;
                                    try {
                                        dos.writeUTF(credenziali);
                                        String received = dis.readUTF();

                                        while(received.equals("Le credenziali sono sbagliate. Riprova:")) {
                                            logSend.setVisible(true);
                                            logSend.addActionListener(new ActionListener() {
                                                @Override
                                                public void actionPerformed(ActionEvent e) {
                                                    logFrame.setVisible(false);
                                                    login = user.getText();
                                                    password = pass.getText();
                                                }
                                            });
                                            credenziali = login + " " + password;
                                            dos.writeUTF(credenziali);
                                            received = dis.readUTF();
                                        }

                                        Home home = new Home();

                                    } catch (IOException ioException) {
                                        ioException.printStackTrace();
                                    }
                                    break;
                                }
                            }
                        });
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }


    public String getUserValue(){
        return login;
    }

    public String getPasswordValue(){
        return password;
    }

    public void handleRegFrame(){

        regFrame = new JFrame();
        regFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        regFrame.setTitle("Registrazione");
        regFrame.setSize(280, 280);
        regFrame.setLocationRelativeTo(null);
        JPanel regPanel = new JPanel();
        regPanel.setSize(280, 280);

        regPanel.setLayout(new BoxLayout(regPanel, BoxLayout.Y_AXIS));
        regPanel.add(user);
        regPanel.add(pass);
        regPanel.add(regSend);

        regFrame.getContentPane().add(regPanel, BorderLayout.CENTER);
        regFrame.setVisible(true);

    }

    private void handleLogFrame() {

        logFrame = new JFrame();
        logFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        logFrame.setTitle("Login");
        logFrame.setSize(280, 280);
        logFrame.setLocationRelativeTo(null);
        JPanel logPanel = new JPanel();
        logPanel.setSize(280, 280);

        logPanel.setLayout(new BoxLayout(logPanel, BoxLayout.Y_AXIS));
        logPanel.add(user);
        logPanel.add(pass);
        logPanel.add(logSend);

        logFrame.getContentPane().add(logPanel, BorderLayout.CENTER);
        logFrame.setVisible(true);

    }
}
