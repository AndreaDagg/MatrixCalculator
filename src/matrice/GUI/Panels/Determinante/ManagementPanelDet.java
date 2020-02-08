package matrice.GUI.Panels.Determinante;

import matrice.GUI.Frame.MainFrame;

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
        this.matrici2x2.setBounds(posizioneBottone, MainFrame.ALTEZZA / 4, WIDTH_PULSANTE, HEIGHT_PULSANTE);
        this.matrici2x2.addMouseListener(listner);
        this.matrici2x2.setForeground(Color.WHITE);
        this.matrici2x2.setBackground(Color.BLACK);
        this.add(this.matrici2x2);

        this.matrici3x3 = new JButton("3x3");
        this.matrici3x3.setBounds(posizioneBottone + 300, MainFrame.ALTEZZA / 4, WIDTH_PULSANTE, HEIGHT_PULSANTE);
        this.matrici3x3.addMouseListener(listner);
        this.matrici3x3.setForeground(Color.WHITE);
        this.matrici3x3.setBackground(Color.BLACK);
        this.add(this.matrici3x3);

        this.matrici4x4 = new JButton("4x4");
        this.matrici4x4.setBounds(posizioneBottone + 600, MainFrame.ALTEZZA / 4, WIDTH_PULSANTE, HEIGHT_PULSANTE);
        this.matrici4x4.addMouseListener(listner);
        this.matrici4x4.setForeground(Color.WHITE);
        this.matrici4x4.setBackground(Color.BLACK);
        this.add(this.matrici4x4);

        this.indietro = new JButton("INDIETRO");
        this.indietro.setBounds((MainFrame.LARGHEZZA - WIDTH_PULSANTE) / 2, 450, WIDTH_PULSANTE, HEIGHT_PULSANTE);
        this.indietro.addMouseListener(listner);
        this.indietro.setForeground(Color.BLACK);
        this.indietro.setBackground(Color.WHITE);
        this.add(indietro);


    }

    @Override
    protected void paintComponent(Graphics g) {
        Color c = new Color(255, 255, 255);
        g.setColor(c);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());

        g.setColor(Color.RED);
        g.setFont(new Font("Castellar", Font.ITALIC, 50));
        g.drawString("Quale ordine? ", 62, 45);
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
                mainFrame.managementPanelDet.setVisible(false);
                mainFrame.switchPanel(mainFrame.managementPanelDet, mainFrame.mainPanel);
        }
    }
}
