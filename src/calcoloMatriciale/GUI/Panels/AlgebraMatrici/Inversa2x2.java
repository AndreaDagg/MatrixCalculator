package calcoloMatriciale.GUI.Panels.AlgebraMatrici;

import calcoloMatriciale.GUI.Frame.MainFrame;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Inversa2x2 extends JPanel{
    
    private MainFrame mainFrame;
    
    private JButton calcola;
    private JButton reset;
    private JButton indietro;
    
    private JTextField[][] matrice = new JTextField[2][2];
    private double matrTrasposta[][] = new double[2][2];
    private double matrAggiunta[][] = new double[2][2];
    private double matrInversa[][] = new double[2][2];
    private double matrInversaDec[][] = new double[2][2];
    
    private double n1, n2, n3, n4, det;
    private double t00, t01, t10, t11;
    
    private boolean attivaInv = false;
    private boolean errore = false;
    
    public Inversa2x2(MainFrame pMainFrame){
        this.setSize(MainFrame.LARGHEZZA, MainFrame.ALTEZZA);
        this.setLayout(null);
        this.mainFrame = pMainFrame;
        
        mouseListner listner = new mouseListner();
        
        this.calcola = new JButton("CALCOLA");
        this.calcola.setBounds(500, 140, 180, 60);
        this.calcola.addMouseListener(listner);
        this.calcola.setForeground(Color.WHITE);
        this.calcola.setBackground(Color.BLACK);
        this.add(this.calcola);
        
        this.reset = new JButton("Cancella");
        this.reset.setBounds(130, 270, 180, 60);
        this.reset.addMouseListener(listner);
        this.reset.setForeground(Color.WHITE);
        this.reset.setBackground(Color.BLACK);
        this.add(this.reset);
        
        this.indietro = new JButton("INDIETRO");
        this.indietro.setBounds(40, 570, 180, 60);
        this.indietro.addMouseListener(listner);
        this.indietro.setForeground(Color.BLACK);
        this.indietro.setBackground( new Color(129, 200, 132));
        this.add(this.indietro);
        
        int spazioX = 180, spazioY = 80; 
        for(int i = 0; i < 2; i ++){
            for(int j = 0; j < 2; j ++){
                this.matrice[i][j] = new JTextField();
                this.matrice[i][j].setBounds(100 + (spazioX * i), 110 + (spazioY * j), 102, 42);
                this.matrice[i][j].setBackground(Color.WHITE);
                this.matrice[i][j].setFont(new Font(Font.DIALOG, Font.ITALIC, 16));
                this.matrice[i][j].setForeground(Color.BLACK);
                this.add(matrice[i][j]);
            }
        }
        
    }
    
    @Override
    protected void paintComponent(Graphics g){
        Color c = new Color(129, 200, 132);
        g.setColor(c);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());

        g.setColor(Color.BLACK);
        g.setFont(new Font(Font.DIALOG, Font.PLAIN, 50));
        g.drawString("Calcolo inversa di una matrice 2x2", 50, 60);

        //parentesi sx
        g.setColor(Color.BLACK);
        g.fillRect(40, 100, 5, 160);  //verticale


        //parentesi dx
        g.fillRect(435, 100, 5, 160);  //verticale


        Color c1 =  new Color(129, 200, 132);
        g.setColor(c1);
        g.fillRect( 0, 380, this.getWidth(), 230);
        
        g.setColor(Color.BLACK);
        
        int spX = 90, spY = 60;
        if(attivaInv == true){

            for(int i = 0; i < 2; i ++){
                for(int j = 0; j < 2; j ++){
                    g.setFont(new Font(Font.DIALOG, Font.PLAIN, 18));
                    g.drawString("" + matrInversaDec[i][j], 770 + (spX * i), 140 + (spY * j) );
                }
            }
            g.setColor(Color.BLACK);
            g.fillRect(730, 100, 5, 160);  //verticale
            g.fillRect(950, 100, 5, 160);  //verticale
        }
        g.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
        if(errore == true){
            g.drawString("La matrice non e' invertibile!", 20, 400);
        }
    }
    
    public double getDeterminante(){
        double det, determinante;
        
        n1 = Double.parseDouble(matrice[0][0].getText());
        n2 = Double.parseDouble(matrice[1][0].getText());
        n3 = Double.parseDouble(matrice[0][1].getText());
        n4 = Double.parseDouble(matrice[1][1].getText());
        
        det =  (n1*n4 - n3*n2);
        
        det = det * 100;
        determinante = Math.floor(det);
        determinante = determinante / 100;
        return determinante;
    }
    
    private void resetCampi(){
        errore = false;
        attivaInv = false;
        for(int i = 0; i < 2; i ++){
            for(int j = 0; j < 2; j ++){
                this.matrice[i][j].setText(null);
            }
        }
    }
    
    private void getTrasposta(){
        matrTrasposta[0][0] = n1;
        matrTrasposta[1][0] = n2;
        matrTrasposta[0][1] = n3;
        matrTrasposta[1][1] = n4;
        
        t00 = matrTrasposta[0][0];
        t01 = matrTrasposta[1][0];
        t10 = matrTrasposta[0][1];
        t11 = matrTrasposta[1][1];
    }
    
    private void aggiunta(){
        getTrasposta();
        
        matrAggiunta[0][0] = t11;
        matrAggiunta[1][0] = t10;
        matrAggiunta[0][1] = t01;
        matrAggiunta[1][1] = t00;
    }
    
    private void inversa(){
        aggiunta();
        
        matrInversa[0][0] = matrAggiunta[0][0] / det;
        matrInversa[1][0] = matrAggiunta[0][1] / det;
        matrInversa[0][1] = matrAggiunta[1][0] / det;
        matrInversa[1][1] = matrAggiunta[1][1] / det;
        
        for(int i = 0; i < 2; i++){
            for(int j = 0; j < 2; j ++){
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
                    mainFrame.switchPanel(mainFrame.inversa2x2, mainFrame.managementPanelOper);
                    resetCampi();
                    attivaInv = false;
                }
                
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "INSERIRE DEI VALORI VALIDI!");
            }
        }
    }
    
}

