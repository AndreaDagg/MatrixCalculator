package matrice.GUI.Panels;

import matrice.GUI.Frame.MainFrame;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JPanel;
import matrice.utils.Resources;

public class MainPanel extends JPanel{
    
    private final MainFrame mainFrame;
    private final JButton buttonDeterminante;
    private final JButton buttonOpAlg;
    private final JButton rango;
    private final JButton uscita;
    
    private final Image logo;
    
    private final int LARGHEZZA_IMMAGINE = 300, ALTEZZA_IMMAGINE = 300;
    private final int X_IMMAGINE = (MainFrame.LARGHEZZA - this.LARGHEZZA_IMMAGINE) / 2, 
                      Y_IMMAGINE = 80;
    
    private static final int WIDTH_PULSANTE = 180, HEIGHT_PULSANTE = 60;
    private static final int xPulsante = (MainFrame.LARGHEZZA - WIDTH_PULSANTE), 
                             yPulsante = 430;
    
    
    public MainPanel(MainFrame pMainFrame){
        this.setSize(MainFrame.LARGHEZZA, MainFrame.ALTEZZA);
        this.setLayout(null);
        this.mainFrame = pMainFrame;
        mouseListner listner = new mouseListner();
        
        this.logo = Resources.getImage("/matrice/GUI/images/logo.png");
        
        this.buttonDeterminante = new JButton("DETERMINANTE");
        this.buttonDeterminante.setBounds(xPulsante / 2 - 220,yPulsante, WIDTH_PULSANTE, HEIGHT_PULSANTE);
        this.buttonDeterminante.addMouseListener(listner);
        this.buttonDeterminante.setForeground(Color.WHITE);
        this.buttonDeterminante.setBackground(Color.BLACK);
        this.buttonDeterminante.setFont(new Font("Lucida Fax", Font.ITALIC, 13));
        this.add(this.buttonDeterminante);
        
        this.buttonOpAlg = new JButton("OPERAZIONI");
        this.buttonOpAlg.setBounds(xPulsante / 2,yPulsante, WIDTH_PULSANTE, HEIGHT_PULSANTE);
        this.buttonOpAlg.addMouseListener(listner);
        this.add(this.buttonOpAlg);
        this.buttonOpAlg.setBackground(Color.BLACK);
        this.buttonOpAlg.setForeground(Color.WHITE);

        this.rango = new JButton("RANGO");
        this.rango.setBounds(xPulsante / 2 + 220, yPulsante, WIDTH_PULSANTE, HEIGHT_PULSANTE);
        this.rango.addMouseListener(listner);
        this.add(rango);
        this.rango.setForeground(Color.WHITE);
        this.rango.setBackground(Color.BLACK);
        
        this.uscita = new JButton("USCITA");
        this.uscita.setBounds(xPulsante / 2, yPulsante + 80, WIDTH_PULSANTE, HEIGHT_PULSANTE);
        this.uscita.addMouseListener(listner);
        this.add(uscita);
        this.uscita.setForeground(Color.BLACK);
        this.uscita.setBackground(Color.WHITE);
        
    }
    
    @Override
    protected void paintComponent(Graphics g){
        Color c = new Color(0, 0, 0, 112);
        g.setColor(c);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        
        g.setColor(Color.BLACK);
        g.setFont(new Font("Castellar", Font.BOLD, 30));
        
        String scelta = "EFFETTUA LA TUA SCELTA:";
        int lunghezza = scelta.length();
        
        g.drawString(scelta, (MainFrame.LARGHEZZA  - lunghezza) / 5, 45);
        
        g.drawImage(logo, this.X_IMMAGINE, this.Y_IMMAGINE, this.LARGHEZZA_IMMAGINE, this.ALTEZZA_IMMAGINE, null);

    }

    
    public class mouseListner extends MouseAdapter{
        @Override
        public void mouseClicked(MouseEvent e){
            JButton btn = (JButton) e.getSource();
            
            if(btn.equals(buttonDeterminante)){
                mainFrame.switchPanel(mainFrame.mainPanel, mainFrame.managementPanelDet);
            }
            if(btn.equals(buttonOpAlg)){
                mainFrame.switchPanel(mainFrame.mainPanel, mainFrame.managementPanelOper);
            }
            if(btn.equals(rango)){
                mainFrame.switchPanel(mainFrame.mainPanel, mainFrame.managementPanelRango);
            }
            
            if(btn.equals(uscita))
                System.exit(0);
        }
    }
}
