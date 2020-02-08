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
        
        this.calcola = new JButton("RANGO");
        this.calcola.setBounds(420, 420, 180, 60);
        this.calcola.addMouseListener(listner);
        this.calcola.setForeground(Color.WHITE);
        this.calcola.setBackground(Color.BLACK);
        this.add(this.calcola);
        
        this.reset = new JButton("Cancella");
        this.reset.setBounds(420 + 181, 420, 180, 60);
        this.reset.addMouseListener(listner);
        this.reset.setForeground(Color.WHITE);
        this.reset.setBackground(Color.BLACK);
        this.add(this.reset);
        
        this.indietro = new JButton("INDIETRO");
        this.indietro.setBounds(20, 570, 180, 60);
        this.indietro.addMouseListener(listner);
        this.indietro.setForeground(Color.BLACK);
        this.indietro.setBackground(new Color(239, 83, 80));
        this.add(this.indietro);
        
        int spazioX = 180, spazioY = 80; 
        for(int i = 0; i < 2; i ++){
            for(int j = 0; j < 2; j ++){
                this.matrice[i][j] = new JTextField();
                this.matrice[i][j].setBounds(470 + (spazioX * i), 130 + (spazioY * j), 102, 42);
                this.matrice[i][j].setBackground(Color.WHITE);
                this.matrice[i][j].setFont(new Font(Font.DIALOG, Font.ITALIC, 16));
                this.matrice[i][j].setForeground(Color.BLACK);
                this.add(matrice[i][j]);
            }
        }
        
    }
    
    @Override
    protected void paintComponent(Graphics g){
        Color c = new Color(239, 83, 80);
        g.setColor(c);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());


        g.setColor(Color.BLACK);
        g.setFont(new Font(Font.SERIF, Font.PLAIN, 50));
        g.drawString("Calcolo rango di una matrice 2x2", 50, 60);


        //parentesi sx
        g.setColor(Color.BLACK);
        g.fillRect(400, 110, 5, 160);  //verticale

        
        //parentesi dx
        g.fillRect(815, 110, 5, 160);  //verticale

        Color c1 = new Color(239, 83, 80);
        g.setColor(c1);
        g.fillRect( 0, 380, this.getWidth(), 230);

        g.setColor(Color.BLACK);
        g.setFont(new Font(Font.SERIF, Font.BOLD, 30));
        g.drawString("Rango: ", 430, 320);
        
        g.setColor(Color.BLACK);
        g.setFont(new Font(Font.SERIF, Font.ITALIC, 30));
        if(attivaDet){
           // g.drawString("Il rango e': ", 20, 420);
            if(det != 0){
                g.setColor(Color.white);
                g.drawString("2", 600, 320);
            }
            else if(num1 == 0 && num2 == 0 && num3 == 0 && num4 == 0){
                g.setColor(Color.white);
                g.drawString("0", 600, 320);
            }
            else{
                g.setColor(Color.white);
                g.drawString("1", 600, 320);
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
                JOptionPane.showMessageDialog(null, /*"CI SONO DEI CAMPI VUOTI!"*/ "Errore!");
            }
        }
    }
    
}
