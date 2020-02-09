package calcoloMatriciale.GUI.Panels.Determinante;

import calcoloMatriciale.GUI.Frame.MainFrame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ManagementPanelDet extends JPanel {

    private MainFrame mainFrame;

    private JButton matrici2x2;
    private JButton matrici3x3;
    private JButton matrici4x4;
    private JButton indietro;

    private static final int WIDTH_PULSANTE = 180, HEIGHT_PULSANTE = 60;


    public ManagementPanelDet(MainFrame pMainFrame) {
        this.setSize(mainFrame.LARGHEZZA, mainFrame.ALTEZZA);
        this.setLayout(null);
        this.mainFrame = pMainFrame;

        mouseListner listner = new mouseListner();

        int posizioneBottone = 180;

        this.matrici2x2 = new JButton("2x2");
        this.matrici2x2.setBounds(600, 60, WIDTH_PULSANTE, HEIGHT_PULSANTE);
        this.matrici2x2.addMouseListener(listner);
        this.matrici2x2.setForeground(Color.black);
        this.matrici2x2.setBackground(Color.WHITE);
        this.add(this.matrici2x2);

        this.matrici3x3 = new JButton("3x3");
        this.matrici3x3.setBounds(600, 205, WIDTH_PULSANTE, HEIGHT_PULSANTE);
        this.matrici3x3.addMouseListener(listner);
        this.matrici3x3.setForeground(Color.black);
        this.matrici3x3.setBackground(Color.white);
        this.add(this.matrici3x3);

        this.matrici4x4 = new JButton("4x4");
        this.matrici4x4.setBounds(600, 360, WIDTH_PULSANTE, HEIGHT_PULSANTE);
        this.matrici4x4.addMouseListener(listner);
        this.matrici4x4.setForeground(Color.black);
        this.matrici4x4.setBackground(Color.white);
        this.add(this.matrici4x4);

        this.indietro = new JButton("HOME");
        this.indietro.setBounds(20, 550, WIDTH_PULSANTE, HEIGHT_PULSANTE);
        this.indietro.addMouseListener(listner);
        this.indietro.setForeground(Color.BLACK);
        this.indietro.setBackground( new Color(144, 202, 249));
        this.add(indietro);


    }

    @Override
    protected void paintComponent(Graphics g) {
        Color c = new Color(144, 202, 249);
        g.setColor(c);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());

        g.setColor(Color.BLACK);
        g.setFont(new Font(Font.DIALOG, Font.BOLD, 32));

        g.drawString("Determinante matrice di ordine: ", 20, 100);
        g.drawString("Determinante matrice di ordine: ", 20, 250);
        g.drawString("Determinante matrice di ordine: ",20, 400);
    }

    private class mouseListner extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            JButton btn = (JButton) e.getSource();

            if (btn.equals(matrici2x2)) {
                mainFrame.switchPanel(mainFrame.managementPanelDet, mainFrame.matrice2x2);
            }
            if (btn.equals(matrici3x3)) {
                mainFrame.switchPanel(mainFrame.managementPanelDet, mainFrame.matrice3x3);
            }
            if (btn.equals(matrici4x4)) {
                mainFrame.switchPanel(mainFrame.managementPanelDet, mainFrame.matrice4x4);
            }
            if (btn.equals(indietro))
                mainFrame.switchPanel(mainFrame.managementPanelDet, mainFrame.mainPanel);
        }
    }
}
