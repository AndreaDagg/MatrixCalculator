package matrice.GUI.Panels.AlgebraMatrici;

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

public class Prodotto4x4Panel extends JPanel{
    
    private MainFrame mainFrame;
    
    private JButton buttonProdotto;
    private JButton reset1;
    private JButton reset2;
    private JButton home;
    
    private boolean attivaProdotto = false;
    
    private JTextField[][] matrice = new JTextField[4][4];
    private JTextField[][] matrice1 = new JTextField[4][4];
    
    private double[][] matrRisult = new double[4][4];
    
    private double n1, n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, n12, n13, n14, n15, n16;
    private double n17, n18, n19, n20, n21, n22, n23, n24, n25, n26, n27, n28, n29 ,n30, n31, n32;
    
    public Prodotto4x4Panel(MainFrame pMainFrame){
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
        Color c = new Color(129, 200, 132);
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


        Color c1 = new Color(129, 200, 132);
        g.setColor(c1);
        g.fillRect( 0, 380, this.getWidth(), 230);
        
        g.setColor(Color.BLACK);
        g.setFont(new Font(Font.DIALOG, Font.ITALIC, 16));
        
        int spX = 180, spY = 40; 
        if(attivaProdotto == true){
            g.setFont(new Font(Font.DIALOG, Font.BOLD, 18));
            g.drawString("Il prodotto e': ", 20, 400);
            for(int i = 0; i < 4; i ++){
                for(int j = 0; j < 4; j ++){
                    g.setFont(new Font(Font.DIALOG, Font.PLAIN, 14));
                    g.drawString("" + matrRisult[i][j], 25 + (spX * i), 430 + (spY * j) );
                }
            }
        }
        
    }
    
    private void prodotto(){
        n1 = Double.parseDouble(matrice[0][0].getText());
        n2 = Double.parseDouble(matrice[1][0].getText());
        n3 = Double.parseDouble(matrice[2][0].getText());
        n4 = Double.parseDouble(matrice[3][0].getText());
        n5 = Double.parseDouble(matrice[0][1].getText());
        n6 = Double.parseDouble(matrice[1][1].getText());
        n7 = Double.parseDouble(matrice[2][1].getText());
        n8 = Double.parseDouble(matrice[3][1].getText());
        n9 = Double.parseDouble(matrice[0][2].getText());
        n10 = Double.parseDouble(matrice[1][2].getText());
        n11 = Double.parseDouble(matrice[2][2].getText());
        n12 = Double.parseDouble(matrice[3][2].getText());
        n13 = Double.parseDouble(matrice[0][3].getText());
        n14 = Double.parseDouble(matrice[1][3].getText());
        n15 = Double.parseDouble(matrice[2][3].getText());
        n16 = Double.parseDouble(matrice[3][3].getText());
        
        n17 = Double.parseDouble(matrice1[0][0].getText());
        n18 = Double.parseDouble(matrice1[1][0].getText());
        n19 = Double.parseDouble(matrice1[2][0].getText());
        n20 = Double.parseDouble(matrice1[3][0].getText());
        n21 = Double.parseDouble(matrice1[0][1].getText());
        n22 = Double.parseDouble(matrice1[1][1].getText());
        n23 = Double.parseDouble(matrice1[2][1].getText());
        n24 = Double.parseDouble(matrice1[3][1].getText());
        n25 = Double.parseDouble(matrice1[0][2].getText());
        n26 = Double.parseDouble(matrice1[1][2].getText());
        n27 = Double.parseDouble(matrice1[2][2].getText());
        n28 = Double.parseDouble(matrice1[3][2].getText());
        n29 = Double.parseDouble(matrice1[0][3].getText());
        n30 = Double.parseDouble(matrice1[1][3].getText());
        n31 = Double.parseDouble(matrice1[2][3].getText());
        n32 = Double.parseDouble(matrice1[3][3].getText());
        
        
        matrRisult[0][0] = (n1*n17) + (n2*n21) + (n3*n25) + (n4*n29);
        matrRisult[1][0] = (n1*n18) + (n2*n22) + (n3*n26) + (n4*n30);
        matrRisult[2][0] = (n1*n19) + (n2*n23) + (n3*n27) + (n4*n31);
        matrRisult[3][0] = (n1*n20) + (n2*n24) + (n3*n28) + (n4*n32);
        
        matrRisult[0][1] = (n5*n17) + (n6*n21) + (n7*n25) + (n8*n29);
        matrRisult[1][1] = (n5*n18) + (n6*n22) + (n7*n26) + (n8*n30);
        matrRisult[2][1] = (n5*n19) + (n6*n22) + (n7*n27) + (n8*n31);
        matrRisult[3][1] = (n5*n20) + (n6*n23) + (n7*n28) + (n8*n32);
        
        matrRisult[0][2] = (n9*n17) + (n10*n21) + (n11*n25) + (n12*n29);
        matrRisult[1][2] = (n9*n18) + (n10*n22) + (n11*n26) + (n12*n30);
        matrRisult[2][2] = (n9*n19) + (n10*n23) + (n11*n27) + (n12*n31);
        matrRisult[3][2] = (n9*n20) + (n10*n24) + (n11*n28) + (n12*n32);
        
        matrRisult[0][3] = (n13*n17) + (n14*n21) + (n15*n25) + (n16*n29);
        matrRisult[1][3] = (n13*n18) + (n14*n22) + (n15*n26) + (n16*n30);
        matrRisult[2][3] = (n13*n19) + (n14*n23) + (n15*n27) + (n16*n31);
        matrRisult[3][3] = (n13*n20) + (n14*n24) + (n15*n28) + (n16*n32);
        
        attivaProdotto = true;
    }
    
    private void reset1(){
        attivaProdotto = false;
        for(int i = 0; i < 4; i ++){
                for(int j = 0; j < 4; j ++){
                    this.matrice[i][j].setText(null);
                }
        }
    }
    
    private void reset2(){
        attivaProdotto = false;
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
                    mainFrame.switchPanel(mainFrame.prodotto4x4Panel, mainFrame.managementPanelOper);
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
