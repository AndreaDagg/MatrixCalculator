package matrice.GUI.Panels.Operazioni;

import matrice.GUI.Frame.MainFrame;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;

public class ManagementPanelOper extends JPanel{
    
    private MainFrame mainFrame;
    
    private JButton sommaDiff3x3;
    private JButton sommaDiff4x4;
    private JButton prodotto3x3;
    private JButton prodotto4x4;
    private JButton inversa2x2;
    private JButton inversa3x3;
    private JButton indietro;
    
    private static final int WIDTH_PULSANTE = 180, HEIGHT_PULSANTE = 60;
    
    
    public ManagementPanelOper(MainFrame pMainFrame){
        this.setSize(mainFrame.LARGHEZZA, mainFrame.ALTEZZA);
        this.setLayout(null);
        this.mainFrame = pMainFrame;
        
        mouseListner listner = new mouseListner();
        
        this.sommaDiff3x3 = new JButton("SOMMA/DIFFERENZA 3x3");
        this.sommaDiff3x3.setBounds((MainFrame.LARGHEZZA - WIDTH_PULSANTE) / 6, MainFrame.ALTEZZA / 4, WIDTH_PULSANTE, HEIGHT_PULSANTE);
        this.sommaDiff3x3.addMouseListener(listner);
        this.sommaDiff3x3.setForeground(Color.WHITE);
        this.sommaDiff3x3.setBackground(Color.BLACK);
        this.add(this.sommaDiff3x3);
        
        this.sommaDiff4x4 = new JButton("SOMMA/DIFFERENZA 4x4");
        this.sommaDiff4x4.setBounds((MainFrame.LARGHEZZA - WIDTH_PULSANTE) / 6, MainFrame.ALTEZZA / 4 + 80, WIDTH_PULSANTE, HEIGHT_PULSANTE);
        this.sommaDiff4x4.addMouseListener(listner);
        this.sommaDiff4x4.setForeground(Color.WHITE);
        this.sommaDiff4x4.setBackground(Color.BLACK);
        this.add(this.sommaDiff4x4);
        
        this.prodotto3x3 = new JButton("PRODOTTO 3x3");
        this.prodotto3x3.setBounds((MainFrame.LARGHEZZA - WIDTH_PULSANTE) / 2, MainFrame.ALTEZZA / 4, WIDTH_PULSANTE, HEIGHT_PULSANTE);
        this.prodotto3x3.addMouseListener(listner);
        this.prodotto3x3.setForeground(Color.WHITE);
        this.prodotto3x3.setBackground(Color.BLACK);
        this.add(this.prodotto3x3);
        
        this.prodotto4x4 = new JButton("PRODOTTO 4X4");
        this.prodotto4x4.setBounds((MainFrame.LARGHEZZA - WIDTH_PULSANTE) / 2, MainFrame.ALTEZZA / 4 + 80, WIDTH_PULSANTE, HEIGHT_PULSANTE);
        this.prodotto4x4.addMouseListener(listner);
        this.prodotto4x4.setForeground(Color.WHITE);
        this.prodotto4x4.setBackground(Color.BLACK);
        this.add(this.prodotto4x4);   
        
        this.inversa2x2 = new JButton("INVERSA 2x2");
        this.inversa2x2.setBounds((MainFrame.LARGHEZZA - WIDTH_PULSANTE) / 2 + 207, MainFrame.ALTEZZA / 4, WIDTH_PULSANTE, HEIGHT_PULSANTE);
        this.inversa2x2.addMouseListener(listner);
        this.inversa2x2.setForeground(Color.WHITE);
        this.inversa2x2.setBackground(Color.BLACK);
        this.add(this.inversa2x2);
        
        this.inversa3x3 = new JButton("INVERSA 3x3");
        this.inversa3x3.setBounds((MainFrame.LARGHEZZA - WIDTH_PULSANTE) / 2 + 207, MainFrame.ALTEZZA / 4 + 80, WIDTH_PULSANTE, HEIGHT_PULSANTE);
        this.inversa3x3.addMouseListener(listner);
        this.inversa3x3.setForeground(Color.WHITE);
        this.inversa3x3.setBackground(Color.BLACK);
        this.add(this.inversa3x3); 
        
        this.indietro = new JButton("INDIETRO");
        this.indietro.setBounds((MainFrame.LARGHEZZA - WIDTH_PULSANTE) / 2, 450, WIDTH_PULSANTE, HEIGHT_PULSANTE);
        this.indietro.addMouseListener(listner);
        this.indietro.setForeground(Color.BLACK);
        this.indietro.setBackground(Color.WHITE);
        this.add(indietro);
        
    }
    
    @Override
    protected void paintComponent(Graphics g){
        Color c = new Color(255, 200, 0);
        g.setColor(c);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        
        String scelta = "SCEGLI L'OPERAZIONE:";
        int lunghezza = scelta.length();
        
        g.setColor(Color.BLACK);
        g.setFont(new Font("Castellar", Font.BOLD, 30));
        g.drawString(scelta, (MainFrame.LARGHEZZA  - lunghezza) / 4, 45);
        
        
    }
    
    private class mouseListner extends MouseAdapter{
        @Override
        public void mouseClicked(MouseEvent e){
            JButton btn = (JButton) e.getSource();
            
            if(btn.equals(sommaDiff3x3))
                mainFrame.switchPanel(mainFrame.managementPanelOper, mainFrame.sumDiff3x3Panel);
            if(btn.equals(sommaDiff4x4))
                mainFrame.switchPanel(mainFrame.managementPanelOper, mainFrame.sumDiff4x4Panel);
            if(btn.equals(prodotto3x3))
                mainFrame.switchPanel(mainFrame.managementPanelOper, mainFrame.prodotto3x3);
            if(btn.equals(prodotto4x4))
                mainFrame.switchPanel(mainFrame.managementPanelOper, mainFrame.prodotto4x4Panel);
            if(btn.equals(inversa2x2))
                mainFrame.switchPanel(mainFrame.managementPanelOper, mainFrame.inversa2x2);
            if(btn.equals(inversa3x3))
                mainFrame.switchPanel(mainFrame.managementPanelOper, mainFrame.inversa3x3);
            if(btn.equals(indietro))
                mainFrame.switchPanel(mainFrame.managementPanelOper, mainFrame.mainPanel);
        }
    }
   
}
