package calcoloMatriciale.GUI.Panels.Rango;

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

public class MatrRango3x3 extends JPanel {

    private MainFrame mainFrame;

    private JButton calcola;
    private JButton reset;
    private JButton indietro;

    private JTextField[][] matrice = new JTextField[3][3];

    private double n1, n2, n3, n4, n5, n6, n7, n8, n9, det;
    int ris2x2;
    private boolean attivaDet = false;

    public MatrRango3x3(MainFrame pMainFrame) {
        this.setSize(MainFrame.LARGHEZZA, MainFrame.ALTEZZA);
        this.setLayout(null);
        this.mainFrame = pMainFrame;


        mouseListner listner = new mouseListner();

        this.calcola = new JButton("RANGO");
        this.calcola.setBounds(420, 490, 180, 60);
        this.calcola.addMouseListener(listner);
        this.calcola.setForeground(Color.WHITE);
        this.calcola.setBackground(Color.BLACK);
        this.add(this.calcola);

        this.reset = new JButton("Cancella");
        this.reset.setBounds(420 + 180, 490, 180, 60);
        this.reset.addMouseListener(listner);
        this.reset.setForeground(Color.WHITE);
        this.reset.setBackground(Color.BLACK);
        this.add(this.reset);

        this.indietro = new JButton("INDIETRO");
        this.indietro.setBounds(20, 580, 180, 60);
        this.indietro.addMouseListener(listner);
        this.indietro.setForeground(Color.BLACK);
        this.indietro.setBackground(new Color(239, 83, 80));
        this.add(this.indietro);

        int spazioX = 140, spazioY = 80;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                this.matrice[i][j] = new JTextField();
                this.matrice[i][j].setBounds(410 + (spazioX * i), 100 + (spazioY * j), 102, 42);
                this.matrice[i][j].setBackground(Color.WHITE);
                this.matrice[i][j].setFont(new Font(Font.DIALOG, Font.ITALIC, 16));
                this.matrice[i][j].setForeground(Color.BLACK);
                this.add(matrice[i][j]);
            }
        }

    }

    @Override
    protected void paintComponent(Graphics g) {
        Color c = new Color(239, 83, 80);
        g.setColor(c);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());

        g.setColor(Color.BLACK);
        g.setFont(new Font(Font.DIALOG, Font.PLAIN, 50));
        g.drawString("Calcolo rango di una matrice 3x3", 50, 60);


        //parentesi sx
        g.setColor(Color.BLACK);
        g.fillRect(380, 90, 5, 240);
        //parentesi dx
        g.fillRect(815, 90, 5, 240);

        Color c1 = new Color(239, 83, 80);
        g.setColor(c1);
        g.fillRect(0, 380, this.getWidth(), 230);

        g.setColor(Color.BLACK);
        g.setFont(new Font(Font.SERIF, Font.BOLD, 30));
        g.drawString("Rango: ", 420, 400);


        g.setColor(Color.BLACK);
        g.setFont(new Font(Font.SERIF, Font.ITALIC, 30));
        if (attivaDet) {
           // g.drawString("Il rango e': ", 20, 420);
            if (det != 0) {
                g.setColor(Color.white);
                g.drawString("3", 550, 400);
            } else {
                this.ris2x2 = det2x2();
                if (ris2x2 == 2) {
                    g.setColor(Color.white);
                    g.drawString("2", 550, 400);
                } else if (this.ris2x2 == 1) {
                    g.setColor(Color.white);
                    g.drawString("1", 550, 400);
                } else if (this.ris2x2 == 0) {
                    g.setColor(Color.white);
                    g.drawString("0", 550, 400);
                }
            }

        }

    }

    public double getDeterminante() {
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

        det = n1 * (n5 * n9 - n6 * n8) - n2 * (n4 * n9 - n6 * n7) + n3 * (n4 * n8 - n5 * n7);

        det = det * 100;
        determinante = Math.floor(det);
        determinante = determinante / 100;
        return determinante;
    }

    private int det2x2() {
        double det2x2;

        det2x2 = (n5 * n9) - (n8 * n6);

        if (det2x2 == 0)
            det2x2 = (n2 * n9) - (n8 * n3);

        if (det2x2 == 0)
            det2x2 = (n2 * n6) - (n5 * n3);

        if (det2x2 == 0)
            det2x2 = (n4 * n9) - (n7 * n6);

        if (det2x2 == 0)
            det2x2 = (n1 * n9) - (n7 * n3);

        if (det2x2 == 0)
            det2x2 = (n1 * n6) - (n4 * n3);

        if (det2x2 == 0)
            det2x2 = (n4 * n8) - (n7 * n5);

        if (det2x2 == 0)
            det2x2 = (n1 * n8) - (n7 * n2);

        if (det2x2 == 0)
            det2x2 = (n1 * n5) - (n4 * n2);


        if (det2x2 != 0)
            return 2;
        else if (n1 == 0 && n2 == 0 && n3 == 0 && n4 == 0 && n5 == 0 && n6 == 0 && n7 == 0 && n8 == 0 && n9 == 0)
            return 0;
        else
            return 1;
    }

    private void resetCampi() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                this.matrice[i][j].setText(null);
            }
        }
    }


    private class mouseListner extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            try {
                JButton btn = (JButton) e.getSource();

                if (btn.equals(calcola)) {
                    det = getDeterminante();
                    attivaDet = true;
                    repaint();
                }
                if (btn.equals(reset)) {
                    resetCampi();
                    attivaDet = false;
                    repaint();
                }
                if (btn.equals(indietro)) {
                    mainFrame.switchPanel(mainFrame.matrRango3x3, mainFrame.managementPanelRango);
                    resetCampi();
                    attivaDet = false;
                }

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "INSERIRE DEI VALORI VALIDI!");
            }
        }
    }

}
