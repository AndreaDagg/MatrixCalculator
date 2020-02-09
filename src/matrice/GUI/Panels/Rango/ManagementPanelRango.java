package matrice.GUI.Panels.Rango;

import matrice.GUI.Frame.MainFrame;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ManagementPanelRango extends JPanel{
    
    private MainFrame mainFrame;
    
    private JButton matrici2x2;
    private JButton matrici3x3;
    private JButton matrici4x4;
    private JButton indietro;
    
    private static final int WIDTH_PULSANTE = 180, HEIGHT_PULSANTE = 60;                            
    
    
    public ManagementPanelRango(MainFrame pMainFrame){
        this.setSize(mainFrame.LARGHEZZA, mainFrame.ALTEZZA);
        this.setLayout(null);
        this.mainFrame = pMainFrame;
        
        mouseListner listner = new mouseListner();
        
        this.matrici2x2 = new JButton("2x2");
        this.matrici2x2.setBounds(580, 120, WIDTH_PULSANTE, HEIGHT_PULSANTE);
        this.matrici2x2.addMouseListener(listner);
        this.matrici2x2.setForeground(Color.BLACK);
        this.matrici2x2.setBackground(Color.WHITE);
        this.add(this.matrici2x2);
        
        this.matrici3x3 = new JButton("3x3");
        this.matrici3x3.setBounds(580, 330, WIDTH_PULSANTE, HEIGHT_PULSANTE);
        this.matrici3x3.addMouseListener(listner);
        this.matrici3x3.setForeground(Color.BLACK);
        this.matrici3x3.setBackground(Color.WHITE);
        this.add(this.matrici3x3);
        
        this.indietro = new JButton("HOME");
        this.indietro.setBounds(20, 550, WIDTH_PULSANTE, HEIGHT_PULSANTE);
        this.indietro.addMouseListener(listner);
        this.indietro.setForeground(Color.BLACK);
        this.indietro.setBackground(new Color(239, 83, 80));
        this.add(indietro);
        
        
    }
    
    @Override
    protected void paintComponent(Graphics g){
        Color c = new Color(239, 83, 80);
        g.setColor(c);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        
        g.setColor(Color.BLACK);
        g.setFont(new Font("Castellar", Font.BOLD, 30));
        g.drawString("Calcolo rango matrice di ordine:", 20, 150);
        g.drawString("Calcolo rango matrice di ordine:", 20, 370);

    }
    
    private class mouseListner extends MouseAdapter{
        @Override
        public void mouseClicked(MouseEvent e){
            JButton btn = (JButton) e.getSource();
            
            if(btn.equals(matrici2x2)){
                mainFrame.switchPanel(mainFrame.managementPanelRango, mainFrame.matrRango2x2);
            }
            if(btn.equals(matrici3x3)){
                mainFrame.switchPanel(mainFrame.managementPanelRango, mainFrame.matrRango3x3);
            }
            if(btn.equals(indietro))
                mainFrame.switchPanel(mainFrame.managementPanelRango, mainFrame.mainPanel);
        }
    }
    
}
