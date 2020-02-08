package matrice.GUI.Panels.Determinante;

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

public class Matrice3x3 extends JPanel{
    
    private MainFrame mainFrame;
    
    private JButton calcola;
    private JButton reset;
    private JButton indietro;
    
    private JTextField[][] matrice = new JTextField[3][3];
    
    private double n1, n2, n3, n4, n5, n6, n7, n8, n9, det;
    private boolean attivaDet = false;
    
    public Matrice3x3(MainFrame pMainFrame){
        this.setSize(MainFrame.LARGHEZZA, MainFrame.ALTEZZA);
        this.setLayout(null);
        this.mainFrame = pMainFrame;
        
        
        mouseListner listner = new mouseListner();
        
        this.calcola = new JButton("CALCOLA");
        this.calcola.setBounds(420, 400, 180, 60);
        this.calcola.addMouseListener(listner);
        this.calcola.setForeground(Color.WHITE);
        this.calcola.setBackground(Color.BLACK);
        this.add(this.calcola);
        
        this.reset = new JButton("RESET");
        this.reset.setBounds(420 + 180, 400, 180, 60);
        this.reset.addMouseListener(listner);
        this.reset.setForeground(Color.WHITE);
        this.reset.setBackground(Color.BLACK);
        this.add(this.reset);
        
        this.indietro = new JButton("INDIETRO");
        this.indietro.setBounds(20, 20, 180, 60);
        this.indietro.addMouseListener(listner);
        this.indietro.setForeground(Color.BLACK);
        this.indietro.setBackground(new Color(144, 202, 249));
        this.add(this.indietro);
        
        int spazioX = 140, spazioY = 80; 
        for(int i = 0; i < 3; i ++){
            for(int j = 0; j < 3; j ++){
                this.matrice[i][j] = new JTextField();
                this.matrice[i][j].setBounds(410 + (spazioX * i), 50 + (spazioY * j), 102, 42);
                this.matrice[i][j].setBackground(Color.WHITE);
                this.matrice[i][j].setFont(new Font(Font.DIALOG, Font.ITALIC, 16));
                this.matrice[i][j].setForeground(Color.BLACK);
                this.add(matrice[i][j]);
            }
        }
        
    }
    
    @Override
    protected void paintComponent(Graphics g){
        Color c = new Color(144, 202, 249);
        g.setColor(c);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        
    /*    g.setColor(c);
        g.fillRect(220, 10, 460, 280);*/
        
        //parentesi sx
        g.setColor(Color.BLACK);
        g.fillRect(380, 30, 5, 240);  //verticale
       // g.fillRect(40, 30, 20, 5);
        //g.fillRect(40, 265, 20, 5);
        
        //parentesi dx
        g.fillRect(815, 30, 5, 240);  //verticale
        //g.fillRect(440, 30, 20, 5);
        //g.fillRect(440, 265, 20, 5);
               
        
        /*//griglia
        g.setColor(Color.GRAY);
        
        int spazioX = 20;
        
        for(int i = 0; i < 15; i ++){
            g.fillRect(20, 10 + (spazioX * i), 460, 1);   //orizzontali
        }
        for(int i = 0; i < 24; i ++){
            g.fillRect(20 + (spazioX * i), 10, 1, 280);     //verticali
        }*/

        Color c1 = new Color(144, 202, 249);
        g.setColor(c1);
        g.fillRect( 0, 380, this.getWidth(), 230);


        g.setColor(Color.BLACK);
        g.setFont(new Font(Font.SERIF, Font.BOLD, 30));
        g.drawString("Determinante: ", 420, 320);
        
        if(attivaDet){
            g.setColor(Color.BLACK);
            g.setFont(new Font(Font.SERIF, Font.ITALIC, 20));
            g.drawString(n1 + " x " + "(" + n5 + " x " + n9 + " - " + n6 + " x " + n8 + ")" + "- " + n2 + " x "
                    + "(" + n4 + " x " + n9 + " - " + n6 + " x " + n7 + ")" + "+ " + n3 + " x " + "(" + n4 + " x " + n8 + " - " + n5 + " x " + n7 + ")", 20, 600);


            
   /*         g.setFont(new Font(Font.SERIF, Font.ITALIC, 25));
            g.drawString("Il determinante e': ", 20, 420);*/
            g.setColor(Color.white);
            g.drawString("" + det,700, 320);
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
                    mainFrame.switchPanel(mainFrame.matrice3x3, mainFrame.managementPanelDet);
                    resetCampi();
                    attivaDet = false;
                }
                
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Errore!");
            }
        }
    }
    
}
