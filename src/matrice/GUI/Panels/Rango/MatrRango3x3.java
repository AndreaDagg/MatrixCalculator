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

public class MatrRango3x3 extends JPanel{
    
    private MainFrame mainFrame;
    
    private JButton calcola;
    private JButton reset;
    private JButton indietro;
    
    private JTextField[][] matrice = new JTextField[3][3];
    
    private double n1, n2, n3, n4, n5, n6, n7, n8, n9, det;
    int ris2x2;
    private boolean attivaDet = false;
    
    public MatrRango3x3(MainFrame pMainFrame){
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
               
        Color c1 = new Color(255, 150, 0);
        g.setColor(c1);
        g.fillRect( 0, 380, this.getWidth(), 230);
        
        
        //griglia
        g.setColor(Color.GRAY);
        
        int spazioX = 20;
        
        for(int i = 0; i < 15; i ++){
            g.fillRect(20, 10 + (spazioX * i), 460, 1);   //orizzontali
        }
        for(int i = 0; i < 24; i ++){
            g.fillRect(20 + (spazioX * i), 10, 1, 280);     //verticali
        }
        
        g.setColor(Color.BLACK);
        g.setFont(new Font(Font.SERIF, Font.ITALIC, 30));
        if(attivaDet){
            g.drawString("Il rango e': ", 20, 420);
            if(det != 0){
                g.setColor(Color.red);
                g.drawString("3", 230, 420);
            }
            else{
                this.ris2x2 = det2x2();
                if(ris2x2 == 2){
                    g.setColor(Color.red);
                    g.drawString("2", 230, 420);
                }
                else if(this.ris2x2 == 1){
                    g.setColor(Color.red);
                    g.drawString("1", 230, 420);
                } 
                else if(this.ris2x2 == 0){
                    g.setColor(Color.red);
                    g.drawString("0", 230, 420);
                }
            }
           
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
    
    private int det2x2(){
        double det2x2;
        
        det2x2 = (n5*n9) - (n8*n6);
        
        if(det2x2 == 0)
            det2x2 = (n2*n9) - (n8*n3);
        
        if(det2x2 == 0)
            det2x2 = (n2*n6) - (n5*n3);
            
        if(det2x2 == 0)
            det2x2 = (n4*n9) - (n7*n6);
            
        if(det2x2 == 0)
            det2x2 = (n1*n9) - (n7*n3);
           
        if(det2x2 == 0)
            det2x2 = (n1*n6) - (n4*n3);
        
        if(det2x2 == 0)
            det2x2 = (n4*n8) - (n7*n5);
        
        if(det2x2 == 0)
            det2x2 = (n1*n8) - (n7*n2);
            
        if(det2x2 == 0)
            det2x2 = (n1*n5) - (n4*n2);
            
        
        if(det2x2 != 0)
            return 2;
        else if(n1 == 0 && n2 == 0 && n3 == 0 && n4 == 0 && n5 == 0 && n6 == 0 && n7 == 0 && n8 == 0 && n9 == 0)
            return 0;
        else 
            return 1;
    }
    
    private void resetCampi(){
        for(int i = 0; i < 3; i ++){
            for(int j = 0; j < 3; j ++){
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
                    mainFrame.switchPanel(mainFrame.matrRango3x3, mainFrame.managementPanelRango);
                    resetCampi();
                    attivaDet = false;
                }
                
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "INSERIRE DEI VALORI VALIDI!");
            }
        }
    }
    
}
