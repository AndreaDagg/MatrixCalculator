package calcoloMatriciale.GUI.Panels.AlgebraMatrici;

import calcoloMatriciale.GUI.Frame.MainFrame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ManagementPanelOper extends JPanel {

    private MainFrame mainFrame;

    private JButton sommaDiff2x2;
    private JButton sommaDiff3x3;
    private JButton sommaDiff4x4;
    private JButton prodotto3x3;
    private JButton prodotto4x4;
    private JButton inversa2x2;
    private JButton inversa3x3;
    private JButton indietro;

    private static final int WIDTH_PULSANTE = 180, HEIGHT_PULSANTE = 60;


    public ManagementPanelOper(MainFrame pMainFrame) {
        this.setSize(mainFrame.LARGHEZZA, mainFrame.ALTEZZA);
        this.setLayout(null);
        this.mainFrame = pMainFrame;

        mouseListner listner = new mouseListner();

        this.sommaDiff2x2 = new JButton("MATRICE 2x2");
        this.sommaDiff2x2.setBounds(580, 60, WIDTH_PULSANTE, HEIGHT_PULSANTE);
        this.sommaDiff2x2.addMouseListener(listner);
        this.sommaDiff2x2.setForeground(Color.BLACK);
        this.sommaDiff2x2.setBackground(Color.WHITE);
        this.add(this.sommaDiff2x2);


        this.sommaDiff3x3 = new JButton("MATRICE 3x3");

        this.sommaDiff3x3.setBounds(600 + WIDTH_PULSANTE, 60, WIDTH_PULSANTE, HEIGHT_PULSANTE);
        this.sommaDiff3x3.addMouseListener(listner);
        this.sommaDiff3x3.setForeground(Color.BLACK);
        this.sommaDiff3x3.setBackground(Color.WHITE);
        this.add(this.sommaDiff3x3);

        this.sommaDiff4x4 = new JButton("MATRICE 4x4");
        this.sommaDiff4x4.setBounds(620 + WIDTH_PULSANTE + WIDTH_PULSANTE, 60, WIDTH_PULSANTE, HEIGHT_PULSANTE);
        this.sommaDiff4x4.addMouseListener(listner);
        this.sommaDiff4x4.setForeground(Color.BLACK);
        this.sommaDiff4x4.setBackground(Color.WHITE);
        this.add(this.sommaDiff4x4);

        this.prodotto3x3 = new JButton("MATRICI 3x3");
        this.prodotto3x3.setBounds(580, 220, WIDTH_PULSANTE, HEIGHT_PULSANTE);
        this.prodotto3x3.addMouseListener(listner);
        this.prodotto3x3.setForeground(Color.BLACK);
        this.prodotto3x3.setBackground(Color.WHITE);
        this.add(this.prodotto3x3);

        this.prodotto4x4 = new JButton("MATRICI 4X4");
        this.prodotto4x4.setBounds(600 + WIDTH_PULSANTE, 220, WIDTH_PULSANTE, HEIGHT_PULSANTE);
        this.prodotto4x4.addMouseListener(listner);
        this.prodotto4x4.setForeground(Color.BLACK);
        this.prodotto4x4.setBackground(Color.WHITE);
        this.add(this.prodotto4x4);

        this.inversa2x2 = new JButton("MATRICE 2x2");
        this.inversa2x2.setBounds(580, 380, WIDTH_PULSANTE, HEIGHT_PULSANTE);
        this.inversa2x2.addMouseListener(listner);
        this.inversa2x2.setForeground(Color.black);
        this.inversa2x2.setBackground(Color.WHITE);
        this.add(this.inversa2x2);

        this.inversa3x3 = new JButton("MATRICE 3x3");
        this.inversa3x3.setBounds(600 + WIDTH_PULSANTE, 380, WIDTH_PULSANTE, HEIGHT_PULSANTE);
        this.inversa3x3.addMouseListener(listner);
        this.inversa3x3.setForeground(Color.black);
        this.inversa3x3.setBackground(Color.WHITE);
        this.add(this.inversa3x3);

        this.indietro = new JButton("HOME");
        this.indietro.setBounds(20, 550, WIDTH_PULSANTE, HEIGHT_PULSANTE);
        this.indietro.addMouseListener(listner);
        this.indietro.setForeground(Color.BLACK);
        this.indietro.setBackground(new Color(129, 200, 132));
        this.add(indietro);

    }

    @Override
    protected void paintComponent(Graphics g) {
        Color c = new Color(129, 200, 132);
        g.setColor(c);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());

        String scelta = "SCEGLI L'OPERAZIONE:";
        int lunghezza = scelta.length();

        String sommaDiff = "Somma o Differenza di una matrice: ";
        String prodotto = "Prodotto di una matrice:";
        String inversaString = "Inversa di una matrice:";
        g.setColor(Color.BLACK);
        g.setFont(new Font(Font.DIALOG, Font.BOLD, 30));
        g.drawString(sommaDiff, 20, 100);
        g.drawString(prodotto, 20, 250);
        g.drawString(inversaString, 20, 400);


    }

    private class mouseListner extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            JButton btn = (JButton) e.getSource();
            if(btn.equals(sommaDiff2x2))
                mainFrame.switchPanel(mainFrame.managementPanelOper, mainFrame.sumDiff2x2Panel);
            if (btn.equals(sommaDiff3x3))
                mainFrame.switchPanel(mainFrame.managementPanelOper, mainFrame.sumDiff3x3Panel);
            if (btn.equals(sommaDiff4x4))
                mainFrame.switchPanel(mainFrame.managementPanelOper, mainFrame.sumDiff4x4Panel);
            if (btn.equals(prodotto3x3))
                mainFrame.switchPanel(mainFrame.managementPanelOper, mainFrame.prodotto3x3);
            if (btn.equals(prodotto4x4))
                mainFrame.switchPanel(mainFrame.managementPanelOper, mainFrame.prodotto4x4Panel);
            if (btn.equals(inversa2x2))
                mainFrame.switchPanel(mainFrame.managementPanelOper, mainFrame.inversa2x2);
            if (btn.equals(inversa3x3))
                mainFrame.switchPanel(mainFrame.managementPanelOper, mainFrame.inversa3x3);
            if (btn.equals(indietro))
                mainFrame.switchPanel(mainFrame.managementPanelOper, mainFrame.mainPanel);
        }
    }

}
