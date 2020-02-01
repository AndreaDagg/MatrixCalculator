package matrice.GUI.Panels.Operazioni;

import matrice.GUI.Frame.MainFrame;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SumDiff4x4Panel extends JPanel{
    
    private MainFrame mainFrame;
    
    private JButton buttonSomma;
    private JButton buttonDiff;
    private JButton reset1;
    private JButton reset2;
    private JButton home;
    
    private boolean attivaSomma = false;
    private boolean attivaDiff = false;
    
    private JTextField[][] matrice = new JTextField[4][4];
    private JTextField[][] matrice1 = new JTextField[4][4];
    
    private double[][] matrRisult = new double[4][4];
    
    public SumDiff4x4Panel(MainFrame pMainFrame){
        this.setSize(MainFrame.LARGHEZZA, MainFrame.ALTEZZA);
        this.setLayout(null);
        this.mainFrame = pMainFrame;
        
        mouseListner listner = new mouseListner();
        
        this.buttonSomma = new JButton("SOMMA");
        this.buttonSomma.setBounds(20, 306, 145, 60);
        this.buttonSomma.addMouseListener(listner);
        this.buttonSomma.setForeground(Color.WHITE);
        this.buttonSomma.setBackground(Color.BLACK);
        this.add(this.buttonSomma);
        
        this.buttonDiff = new JButton("DIFFERENZA");
        this.buttonDiff.setBounds(173, 306, 145, 60);
        this.buttonDiff.addMouseListener(listner);
        this.buttonDiff.setForeground(Color.WHITE);
        this.buttonDiff.setBackground(Color.BLACK);
        this.add(this.buttonDiff);
        
        this.reset1 = new JButton("RESET 1");
        this.reset1.setBounds(328, 306, 145, 60);
        this.reset1.addMouseListener(listner);
        this.reset1.setForeground(Color.WHITE);
        this.reset1.setBackground(Color.BLACK);
        this.add(this.reset1);
        
        this.reset2 = new JButton("RESET 2");
        this.reset2.setBounds(483, 306, 145, 60);
        this.reset2.addMouseListener(listner);
        this.reset2.setForeground(Color.WHITE);
        this.reset2.setBackground(Color.BLACK);
        this.add(this.reset2);
        
        this.home = new JButton("INDIETRO");
        this.home.setBounds(638, 306, 145, 60);
        this.home.addMouseListener(listner);
        this.home.setForeground(Color.BLACK);
        this.home.setBackground(Color.WHITE);
        this.add(this.home);
        
        
        int spazioX = 86, spazioY = 60; 
        for(int i = 0; i < 4; i ++){
            for(int j = 0; j < 4; j ++){
                this.matrice[i][j] = new JTextField();
                this.matrice[i][j].setBounds(40 + (spazioX * i), 40 + (spazioY * j), 84, 42);
                this.matrice[i][j].setBackground(Color.WHITE);
                this.matrice[i][j].setFont(new Font(Font.DIALOG, Font.ITALIC, 13));
                this.matrice[i][j].setForeground(Color.BLACK);
                this.add(matrice[i][j]);
            }
        }
        
        for(int i = 0; i < 4; i ++){
            for(int j = 0; j < 4; j ++){
                this.matrice1[i][j] = new JTextField();
                this.matrice1[i][j].setBounds(420 + (spazioX * i), 40 + (spazioY * j), 84, 42);
                this.matrice1[i][j].setBackground(Color.WHITE);
                this.matrice1[i][j].setFont(new Font(Font.DIALOG, Font.ITALIC, 13));
                this.matrice1[i][j].setForeground(Color.BLACK);
                this.add(matrice1[i][j]);
            }
        }
                
    }
    
    
    @Override
    protected void paintComponent(Graphics g){
        Color c = new Color(255, 200, 0);
        g.setColor(c);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        
        g.setColor(Color.WHITE);
        g.fillRect(20, 10, 760, 280);
        
        //parentesi sx
        g.setColor(Color.BLACK);
        g.fillRect(20, 30, 5, 240);  //verticale
        g.fillRect(20, 30, 20, 5);  
        g.fillRect(20, 265, 20, 5);  
        
        //parentesi dx
        g.fillRect(395, 30, 5, 240);  //verticale
        g.fillRect(380, 30, 20, 5);  
        g.fillRect(380, 265, 20, 5);
               
        //seconde parentesi
        //parentesi sx
        g.setColor(Color.BLACK);
        g.fillRect(400, 30, 5, 240);  //verticale
        g.fillRect(401, 30, 20, 5);  
        g.fillRect(401, 265, 20, 5);  
        
        //parentesi dx
        g.fillRect(776, 30, 5, 240);  //verticale
        g.fillRect(760, 30, 20, 5);  
        g.fillRect(760, 265, 20, 5);
        
        //griglia
        g.setColor(Color.GRAY);
        
        int spazioX = 20;
        
        for(int i = 0; i < 15; i ++){
            g.fillRect(20, 10 + (spazioX * i), 760, 1);   //orizzontali
        }
        for(int i = 0; i < 40; i ++){
            g.fillRect(20 + (spazioX * i), 10, 1, 280);     //verticali
        }        
        
        
        Color c1 = new Color(255, 150, 0);
        g.setColor(c1);
        g.fillRect( 0, 380, this.getWidth(), 230);
        
        g.setColor(Color.BLACK);
        g.setFont(new Font(Font.DIALOG, Font.ITALIC, 16));
        
        int spX = 180, spY = 40; 
        if(attivaSomma == true){
            g.setFont(new Font(Font.DIALOG, Font.BOLD, 18));
            g.drawString("La somma e': ", 20, 400);
            for(int i = 0; i < 4; i ++){
                for(int j = 0; j < 4; j ++){
                    g.setFont(new Font(Font.DIALOG, Font.PLAIN, 14));
                    g.drawString("" + matrRisult[i][j], 25 + (spX * i), 430 + (spY * j) );
                }
            }
        }
        if(attivaDiff == true){
            g.setFont(new Font(Font.DIALOG, Font.BOLD, 18));
            g.drawString("La differenza e': ", 20, 400);
            for(int i = 0; i < 4; i ++){
                for(int j = 0; j < 4; j ++){
                    g.setFont(new Font(Font.DIALOG, Font.PLAIN, 14));
                    g.drawString("" + matrRisult[i][j], 25 + (spX * i), 430 + (spY * j) );
                }
            }
        }
        
    }
    
    private void somma(){
        for(int i = 0; i < 4; i ++){
            for(int j = 0; j < 4; j ++){
                matrRisult[i][j] = Double.parseDouble(matrice[i][j].getText()) + Double.parseDouble(matrice1[i][j].getText());
            }
        }
        attivaSomma = true;
    }
    
    private void differenza(){
        for(int i = 0; i < 4; i ++){
            for(int j = 0; j < 4; j ++){
                matrRisult[i][j] = Double.parseDouble(matrice[i][j].getText()) - Double.parseDouble(matrice1[i][j].getText());
            }
        }
        attivaDiff = true;
    }
    
    private void reset1(){
        attivaSomma = false;
        attivaDiff = false;
        for(int i = 0; i < 4; i ++){
                for(int j = 0; j < 4; j ++){
                    this.matrice[i][j].setText(null);
                }
        }
    }
    
    private void reset2(){
        attivaDiff = false;
        attivaSomma = false;
        for(int i = 0; i < 4; i ++){
                for(int j = 0; j < 4; j ++){
                    this.matrice1[i][j].setText(null);
                }
        }
    }
    
    private class mouseListner extends MouseAdapter{
        @Override
        public void mouseClicked(MouseEvent e){
            try{
                JButton btn = (JButton) e.getSource();
            
                if(btn.equals(buttonSomma)){
                    //if(attivaDiff == false){
                        attivaDiff = false;
                        somma();
                        repaint();
                    //}
                }
                if(btn.equals(buttonDiff)){
                    //if(attivaSomma == false){
                        attivaSomma = false;
                        differenza();
                        repaint();
                    //}
                }
                if(btn.equals(reset1)){
                    reset1();
                    repaint();
                }
                if(btn.equals(reset2)){
                    reset2();
                    repaint();
                }
                if(btn.equals(home)){
                    reset1();
                    reset2();
                    mainFrame.switchPanel(mainFrame.sumDiff4x4Panel, mainFrame.managementPanelOper);
                }
                
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "INSERIRE DEI VALORI VALIDI!");
            }
        }
    }
    
}
