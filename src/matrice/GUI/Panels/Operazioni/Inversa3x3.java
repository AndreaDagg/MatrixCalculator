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

public class Inversa3x3 extends JPanel{
    
    private MainFrame mainFrame;
    
    private JButton calcola;
    private JButton reset;
    private JButton indietro;
    
    private JTextField[][] matrice = new JTextField[3][3];
    private double matrTrasposta[][] = new double[3][3];
    private double matrAggiunta[][] = new double[3][3];
    private double matrInversa[][] = new double[3][3];
    private double matrInversaDec[][] = new double[3][3];
    
    private double n1, n2, n3, n4, n5, n6, n7, n8, n9, det;
    private double t00, t01, t02, t10, t11, t12, t20, t21, t22;
    
    private boolean attivaInv = false;
    private boolean errore = false;
    
    public Inversa3x3(MainFrame pMainFrame){
        this.setSize(MainFrame.LARGHEZZA, MainFrame.ALTEZZA);
        this.setLayout(null);
        this.mainFrame = pMainFrame;
        
        mouseListner listner = new mouseListner();
        
        this.calcola = new JButton("CALCOLA");
        this.calcola.setBounds(545, 30, 180, 60);
        this.calcola.addMouseListener(listner);
        this.calcola.setForeground(Color.WHITE);
        this.calcola.setBackground(Color.BLACK);
        this.add(this.calcola);
        
        this.reset = new JButton("RESET");
        this.reset.setBounds(545, 120, 180, 60);
        this.reset.addMouseListener(listner);
        this.reset.setForeground(Color.WHITE);
        this.reset.setBackground(Color.BLACK);
        this.add(this.reset);
        
        this.indietro = new JButton("INDIETRO");
        this.indietro.setBounds(545, 210, 180, 60);
        this.indietro.addMouseListener(listner);
        this.indietro.setForeground(Color.BLACK);
        this.indietro.setBackground(Color.WHITE);
        this.add(this.indietro);
        
        int spazioX = 140, spazioY = 80; 
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
        
    }
    
    @Override
    protected void paintComponent(Graphics g){
        Color c = new Color(255, 200, 0);
        g.setColor(c);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        
        g.setColor(Color.WHITE);
        g.fillRect(20, 10, 460, 280);
        
        //parentesi sx
        g.setColor(Color.BLACK);
        g.fillRect(40, 30, 5, 240);  //verticale
        g.fillRect(40, 30, 20, 5);  
        g.fillRect(40, 265, 20, 5);  
        
        //parentesi dx
        g.fillRect(455, 30, 5, 240);  //verticale
        g.fillRect(440, 30, 20, 5);  
        g.fillRect(440, 265, 20, 5);
               
        
        //griglia
        g.setColor(Color.GRAY);
        
        int spazioX = 20;
        
        for(int i = 0; i < 15; i ++){
            g.fillRect(20, 10 + (spazioX * i), 460, 1);   //orizzontali
        }
        for(int i = 0; i < 24; i ++){
            g.fillRect(20 + (spazioX * i), 10, 1, 280);     //verticali
        }
        
        
        Color c1 = new Color(255, 150, 0);
        g.setColor(c1);
        g.fillRect( 0, 380, this.getWidth(), 230);
        
        g.setColor(Color.BLACK);
        
        int spX = 180, spY = 60; 
        if(attivaInv == true){
            g.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
            g.drawString("L'inversa e': ", 20, 400);
            for(int i = 0; i < 3; i ++){
                for(int j = 0; j < 3; j ++){
                    g.setFont(new Font(Font.DIALOG, Font.PLAIN, 18));
                    g.drawString("" + matrInversaDec[i][j], 180 + (spX * i), 430 + (spY * j) );
                }
            }
        }
        g.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
        if(errore == true){
            g.drawString("La matrice non e' invertibile!", 20, 400);
        }
    }
    
    public double getDeterminante(){
        double det, determinante;
        
        n1 = Double.parseDouble(matrice[0][0].getText());
        n2 = Double.parseDouble(matrice[0][1].getText());
        n3 = Double.parseDouble(matrice[0][2].getText());
        n4 = Double.parseDouble(matrice[1][0].getText());
        n5 = Double.parseDouble(matrice[1][1].getText());
        n6 = Double.parseDouble(matrice[1][2].getText());
        n7 = Double.parseDouble(matrice[2][0].getText());
        n8 = Double.parseDouble(matrice[2][1].getText());
        n9 = Double.parseDouble(matrice[2][2].getText());
        
        det =  n1*(n5*n9 - n6*n8) - n2*(n4*n9 - n6*n7) + n3*(n4*n8 - n5*n7);
        
        det = det * 100;
        determinante = Math.floor(det);
        determinante = determinante / 100;
        return determinante;
    }
    
    private void resetCampi(){
        errore = false;
        attivaInv = false;
        for(int i = 0; i < 3; i ++){
            for(int j = 0; j < 3; j ++){
                this.matrice[i][j].setText(null);
            }
        }
    }
    
    private void getTrasposta(){
        matrTrasposta[0][0] = n1;
        matrTrasposta[0][1] = n4;
        matrTrasposta[0][2] = n7;
        matrTrasposta[1][0] = n2;
        matrTrasposta[1][1] = n5;
        matrTrasposta[1][2] = n8;
        matrTrasposta[2][0] = n3;
        matrTrasposta[2][1] = n6;
        matrTrasposta[2][2] = n9;
        
        t00 = matrTrasposta[0][0];
        t01 = matrTrasposta[0][1];
        t02 = matrTrasposta[0][2];
        t10 = matrTrasposta[1][0];
        t11 = matrTrasposta[1][1];
        t12 = matrTrasposta[1][2];
        t20 = matrTrasposta[2][0];
        t21 = matrTrasposta[2][1];
        t22 = matrTrasposta[2][2];
                
    }
    
    private void aggiunta(){
        getTrasposta();
        
        matrAggiunta[0][0] = (t11*t22 - t21*t12);
        matrAggiunta[0][1] = -(t10*t22 - t20*t12);
        matrAggiunta[0][2] = (t10*t21 - t20*t11);
        matrAggiunta[1][0] = -(t01*t22 - t21*t02);
        matrAggiunta[1][1] = (t00*t22 - t20*t02);
        matrAggiunta[1][2] = -(t00*t21 - t20*t01);
        matrAggiunta[2][0] = (t01*t12 - t11*t02);
        matrAggiunta[2][1] = -(t00*t12 - t10*t02);
        matrAggiunta[2][2] = (t00*t11 - t10*t01);
    }
    
    private void inversa(){
        aggiunta();
        
        matrInversa[0][0] = matrAggiunta[0][0] / det;
        matrInversa[0][1] = matrAggiunta[0][1] / det;
        matrInversa[0][2] = matrAggiunta[0][2] / det;
        matrInversa[1][0] = matrAggiunta[1][0] / det;
        matrInversa[1][1] = matrAggiunta[1][1] / det;
        matrInversa[1][2] = matrAggiunta[1][2] / det;
        matrInversa[2][0] = matrAggiunta[2][0] / det;
        matrInversa[2][1] = matrAggiunta[2][1] / det;
        matrInversa[2][2] = matrAggiunta[2][2] / det;
        
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j ++){
                matrInversa[i][j] = matrInversa[i][j] * 100;
                matrInversaDec[i][j] = Math.floor(matrInversa[i][j]);
                matrInversaDec[i][j] = matrInversaDec[i][j] / 100;
            }
        }
    }
        
    
    private class mouseListner extends MouseAdapter{
        @Override
        public void mouseClicked(MouseEvent e){
            try{
                JButton btn = (JButton) e.getSource();
            
                if(btn.equals(calcola)){
                    det = getDeterminante();
                    if(det == 0){
                        attivaInv = false;
                        errore = true;
                        repaint();
                    }
                    else{
                    errore = false;
                    inversa();
                    attivaInv = true;
                    repaint();
                    }
                }
                if(btn.equals(reset)){
                    resetCampi();
                    repaint();
                }
                if(btn.equals(indietro)){
                    mainFrame.switchPanel(mainFrame.inversa3x3, mainFrame.managementPanelOper);
                    resetCampi();
                    attivaInv = false;
                }
                
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "INSERIRE DEI VALORI VALIDI!");
            }
        }
    }
    
}

