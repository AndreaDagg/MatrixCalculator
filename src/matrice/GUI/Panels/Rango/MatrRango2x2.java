package matrice.GUI.Panels.Rango;

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

public class MatrRango2x2 extends JPanel{
    
    private MainFrame mainFrame;
    
    private JButton calcola;
    private JButton reset;
    private JButton indietro;
        
    private JTextField[][] matrice = new JTextField[2][2];
    
    private double num1, num2, num3, num4, det;
    private boolean attivaDet = false;
    
    public MatrRango2x2(MainFrame pMainFrame){
        this.setSize(MainFrame.LARGHEZZA, MainFrame.ALTEZZA);
        this.setLayout(null);
        this.mainFrame = pMainFrame;
        
        mouseListner listner = new mouseListner();
        
        this.calcola = new JButton("CALCOLA");
        this.calcola.setBounds(540, 30, 180, 60);
        this.calcola.addMouseListener(listner);
        this.calcola.setForeground(Color.WHITE);
        this.calcola.setBackground(Color.BLACK);
        this.add(this.calcola);
        
        this.reset = new JButton("RESET");
        this.reset.setBounds(540, 120, 180, 60);
        this.reset.addMouseListener(listner);
        this.reset.setForeground(Color.WHITE);
        this.reset.setBackground(Color.BLACK);
        this.add(this.reset);
        
        this.indietro = new JButton("INDIETRO");
        this.indietro.setBounds(540, 210, 180, 60);
        this.indietro.addMouseListener(listner);
        this.indietro.setForeground(Color.BLACK);
        this.indietro.setBackground(Color.WHITE);
        this.add(this.indietro);
        
        int spazioX = 180, spazioY = 80; 
        for(int i = 0; i < 2; i ++){
            for(int j = 0; j < 2; j ++){
                this.matrice[i][j] = new JTextField();
                this.matrice[i][j].setBounds(100 + (spazioX * i), 90 + (spazioY * j), 102, 42);
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
        g.fillRect(20, 10, 440, 280);
        
        //parentesi sx
        g.setColor(Color.BLACK);
        g.fillRect(40, 70, 5, 160);  //verticale
        g.fillRect(40, 70, 20, 5);  
        g.fillRect(40, 225, 20, 5);  
        
        //parentesi dx
        g.fillRect(435, 70, 5, 160);  //verticale
        g.fillRect(420, 70, 20, 5);  
        g.fillRect(420, 225, 20, 5);
               
        
        //griglia
        g.setColor(Color.GRAY);
        
        int spazioX = 20;
        
        for(int i = 0; i < 15; i ++){
            g.fillRect(20, 10 + (spazioX * i), 440, 1);   //orizzontali
        }
        for(int i = 0; i < 23; i ++){
            g.fillRect(20 + (spazioX * i), 10, 1, 280);     //verticali
        }
        
        Color c1 = new Color(255, 150, 0);
        g.setColor(c1);
        g.fillRect( 0, 380, this.getWidth(), 230);
        
        
        g.setColor(Color.BLACK);
        g.setFont(new Font(Font.SERIF, Font.ITALIC, 30));
        if(attivaDet){
            g.drawString("Il rango e': ", 20, 420);
            if(det != 0){
                g.setColor(Color.red);
                g.drawString("2", 260, 420);
            }
            else if(num1 == 0 && num2 == 0 && num3 == 0 && num4 == 0){
                g.setColor(Color.red);
                g.drawString("0", 260, 420);
            }
            else{
                g.setColor(Color.red);
                g.drawString("1", 260, 420);
            } 
                
        }
            
    }
    
    private double getProdotto1(){
        num1 = Double.parseDouble(matrice[0][0].getText());
        num2 = Double.parseDouble(matrice[1][1].getText());
        
        return num1 * num2;
    }
    
    private double getProdotto2(){        
        num3 = Double.parseDouble(matrice[0][1].getText());
        num4 = Double.parseDouble(matrice[1][0].getText());
        
        return num3 * num4;
    }
    
    private double getDeterminante(){
        double det, determinante;
        det = getProdotto1() - getProdotto2();
        
        det = det * 100;
        determinante = Math.floor(det);
        determinante = determinante / 100;
        
        return determinante;
    }
    
    
    private void resetCampi(){
        for(int i = 0; i < 2; i ++){
            for(int j = 0; j < 2; j ++){
                this.matrice[i][j].setText(null);
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
                    attivaDet = true;
                    repaint();
                }
                if(btn.equals(reset)){
                    resetCampi();
                    attivaDet = false;
                    repaint();
                }
                if(btn.equals(indietro)){
                    mainFrame.switchPanel(mainFrame.matrRango2x2, mainFrame.managementPanelRango);
                    attivaDet = false;
                    resetCampi();
                }
                
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, /*"CI SONO DEI CAMPI VUOTI!"*/ "INSERIRE DEI VALORI VALIDI!");
            }
        }
    }
    
}
