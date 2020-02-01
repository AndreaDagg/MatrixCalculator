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

public class Prodotto3x3Panel extends JPanel{
    
    private MainFrame mainFrame;
    
    private JButton buttonProdotto;
    private JButton reset1;
    private JButton reset2;
    private JButton home;
    
    private boolean attivaProdotto = false;
    
    private JTextField[][] matrice = new JTextField[3][3];
    private JTextField[][] matrice1 = new JTextField[3][3];
    
    private double n1, n2, n3, n4, n5, n6, n7, n8, n9;
    private double n10, n11, n12, n13, n14, n15, n16, n17, n18;
    
    private double[][] matrRisult = new double[3][3];
    
    public Prodotto3x3Panel(MainFrame pMainFrame){
        this.setSize(MainFrame.LARGHEZZA, MainFrame.ALTEZZA);
        this.setLayout(null);
        this.mainFrame = pMainFrame;
        
        mouseListner listner = new mouseListner();
        
        this.buttonProdotto = new JButton("PRODOTTO");
        this.buttonProdotto.setBounds(20, 306, 145, 60);
        this.buttonProdotto.addMouseListener(listner);
        this.buttonProdotto.setForeground(Color.WHITE);
        this.buttonProdotto.setBackground(Color.BLACK);
        this.add(this.buttonProdotto);
        
        this.reset1 = new JButton("RESET 1");
        this.reset1.setBounds(225, 306, 145, 60);
        this.reset1.addMouseListener(listner);
        this.reset1.setForeground(Color.WHITE);
        this.reset1.setBackground(Color.BLACK);
        this.add(this.reset1);
        
        this.reset2 = new JButton("RESET 2");
        this.reset2.setBounds(430, 306, 145, 60);
        this.reset2.addMouseListener(listner);
        this.reset2.setForeground(Color.WHITE);
        this.reset2.setBackground(Color.BLACK);
        this.add(this.reset2);
        
        this.home = new JButton("INDIETRO");
        this.home.setBounds(635, 306, 145, 60);
        this.home.addMouseListener(listner);
        this.home.setForeground(Color.BLACK);
        this.home.setBackground(Color.WHITE);
        this.add(this.home);
        
        
        int spazioX = 110, spazioY = 80; 
        for(int i = 0; i < 3; i ++){
            for(int j = 0; j < 3; j ++){
                this.matrice[i][j] = new JTextField();
                this.matrice[i][j].setBounds(60 + (spazioX * i), 50 + (spazioY * j), 102, 42);
                this.matrice[i][j].setBackground(Color.WHITE);
                this.matrice[i][j].setFont(new Font(Font.DIALOG, Font.ITALIC, 16));
                this.matrice[i][j].setForeground(Color.BLACK);
                this.add(matrice[i][j]);
            }
        }
        
        for(int i = 0; i < 3; i ++){
            for(int j = 0; j < 3; j ++){
                this.matrice1[i][j] = new JTextField();
                this.matrice1[i][j].setBounds(420 + (spazioX * i), 50 + (spazioY * j), 102, 42);
                this.matrice1[i][j].setBackground(Color.WHITE);
                this.matrice1[i][j].setFont(new Font(Font.DIALOG, Font.ITALIC, 16));
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
        g.fillRect(40, 30, 5, 240);  //verticale
        g.fillRect(40, 30, 20, 5);  
        g.fillRect(40, 265, 20, 5);  
        
        //parentesi dx
        g.fillRect(392, 30, 5, 240);  //verticale
        g.fillRect(376, 30, 20, 5);  
        g.fillRect(376, 265, 20, 5);
               
        //seconde parentesi
        //parentesi sx
        g.setColor(Color.BLACK);
        g.fillRect(404, 30, 5, 240);  //verticale
        g.fillRect(406, 30, 20, 5);  
        g.fillRect(406, 265, 20, 5);  
        
        //parentesi dx
        g.fillRect(756, 30, 5, 240);  //verticale
        g.fillRect(740, 30, 20, 5);  
        g.fillRect(740, 265, 20, 5);
        
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
        
        int spX = 180, spY = 60; 
        if(attivaProdotto == true){
            g.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
            g.drawString("Il prodotto e': ", 20, 400);
            for(int i = 0; i < 3; i ++){
                for(int j = 0; j < 3; j ++){
                    g.setFont(new Font(Font.DIALOG, Font.PLAIN, 18));
                    g.drawString("" + matrRisult[i][j], 180 + (spX * i), 430 + (spY * j) );
                }
            }
        }
                
    }
    
    private void prodotto(){
        n1 = Double.parseDouble(matrice[0][0].getText());
        n2 = Double.parseDouble(matrice[1][0].getText());
        n3 = Double.parseDouble(matrice[2][0].getText());
        n4 = Double.parseDouble(matrice[0][1].getText());
        n5 = Double.parseDouble(matrice[1][1].getText());
        n6 = Double.parseDouble(matrice[2][1].getText());
        n7 = Double.parseDouble(matrice[0][2].getText());
        n8 = Double.parseDouble(matrice[1][2].getText());
        n9 = Double.parseDouble(matrice[2][2].getText());
        
        n10 = Double.parseDouble(matrice1[0][0].getText());
        n11 = Double.parseDouble(matrice1[1][0].getText());
        n12 = Double.parseDouble(matrice1[2][0].getText());
        n13 = Double.parseDouble(matrice1[0][1].getText());
        n14 = Double.parseDouble(matrice1[1][1].getText());
        n15 = Double.parseDouble(matrice1[2][1].getText());
        n16 = Double.parseDouble(matrice1[0][2].getText());
        n17 = Double.parseDouble(matrice1[1][2].getText());
        n18 = Double.parseDouble(matrice1[2][2].getText());
        
        matrRisult[0][0] = (n1*n10) + (n2*n13) + (n3*n16);
        matrRisult[1][0] = (n1*n11) + (n2*n14) + (n3*n17);
        matrRisult[2][0] = (n1*n12) + (n2*n15) + (n3*n18);
        matrRisult[0][1] = (n4*n10) + (n5*n13) + (n6*n16);
        matrRisult[1][1] = (n4*n11) + (n5*n14) + (n6*n17);
        matrRisult[2][1] = (n4*n12) + (n5*n15) + (n6*n18);
        matrRisult[0][2] = (n7*n10) + (n8*n13) + (n9*n16);
        matrRisult[1][2] = (n7*n11) + (n8*n14) + (n9*n17);
        matrRisult[2][2] = (n7*n12) + (n8*n15) + (n9*n18);
        
        attivaProdotto = true;
    }
    
    private void reset1(){
        attivaProdotto = false;
        for(int i = 0; i < 3; i ++){
                for(int j = 0; j < 3; j ++){
                    this.matrice[i][j].setText(null);
                }
        }
    }
    
    private void reset2(){
        attivaProdotto = false;
        for(int i = 0; i < 3; i ++){
                for(int j = 0; j < 3; j ++){
                    this.matrice1[i][j].setText(null);
                }
        }
    }
    
    private class mouseListner extends MouseAdapter{
        @Override
        public void mouseClicked(MouseEvent e){
            try{
                JButton btn = (JButton) e.getSource();
            
                if(btn.equals(buttonProdotto)){
                    prodotto();
                    repaint();
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
                    mainFrame.switchPanel(mainFrame.prodotto3x3, mainFrame.managementPanelOper);
                    reset1();
                    reset2();
                    repaint();
                }
                
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "INSERIRE DEI VALORI VALIDI!");
            }
        }
    }
    
}
