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

    private final int LARGHEZZA_IMMAGINE = 550, ALTEZZA_IMMAGINE = 300;
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

        Color mycolor = new Color(245, 244 ,245);
        this.mainFrame.setBackground(mycolor);

        this.logo = Resources.getImage("/matrice/GUI/images/homimg.png");


        this.buttonDeterminante = new JButton("DETERMINANTE");
        this.buttonDeterminante.setBounds(660, 435, WIDTH_PULSANTE + 25, HEIGHT_PULSANTE);
        this.buttonDeterminante.addMouseListener(listner);
        this.buttonDeterminante.setForeground(Color.BLACK);
        this.buttonDeterminante.setBackground(new Color(144, 202, 249));
        this.buttonDeterminante.setFont(new Font("Lucida Fax", Font.ITALIC, 13));
        this.add(this.buttonDeterminante); //Aggiungo il bottone al frame main se ci clicchi vai in mouse listner giu

        this.buttonOpAlg = new JButton("OPERAZIONI ALGEBRICHE");
        this.buttonOpAlg.setBounds(660, 330, WIDTH_PULSANTE + 25, HEIGHT_PULSANTE);
        this.buttonOpAlg.addMouseListener(listner);
        this.buttonOpAlg.setBackground(new Color(129, 200, 132));
        this.buttonOpAlg.setFont(new Font("Lucida Fax", Font.ITALIC, 13));
        this.add(this.buttonOpAlg);


        this.rango = new JButton("RANGO");
        this.rango.setBounds(660, 540, WIDTH_PULSANTE + 25, HEIGHT_PULSANTE);
        this.rango.addMouseListener(listner);
        this.rango.setForeground(Color.black);
        this.rango.setBackground(new Color(239, 83, 80));
        this.rango.setFont(new Font("Lucida Fax", Font.ITALIC, 13));
        this.add(rango);


        this.uscita = new JButton("USCITA");
        this.uscita.setBounds(xPulsante / 2, yPulsante + 80, WIDTH_PULSANTE, HEIGHT_PULSANTE);
        this.uscita.addMouseListener(listner);
        this.uscita.setForeground(Color.red);
        this.uscita.setBackground(Color.lightGray);
        this.uscita.setFont(new Font("Lucida Fax", Font.ITALIC, 13));
        //this.add(uscita);

    }

    @Override
    protected void paintComponent(Graphics g){
        Color c = new Color(255, 255, 255);
        g.setColor(c);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());

        g.setColor(Color.BLACK);
       g.setFont(new Font("Castellar", Font.BOLD, 30));
       // String scelta = "EFFETTUA LA TUA SCELTA:";
        //int lunghezza = scelta.length();
       // g.drawString(scelta, (MainFrame.LARGHEZZA  - lunghezza) / 5, 45);
        g.drawImage(logo, this.X_IMMAGINE, 10, this.LARGHEZZA_IMMAGINE, this.ALTEZZA_IMMAGINE, null);
        g.drawString("Somma, Differenza, Prodotto o Inversa:", 20, 370);
        g.drawString("Calcolo del determinante: ", 20, 470);
        g.drawString("Calcolo del rango: ", 20, 580);

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
