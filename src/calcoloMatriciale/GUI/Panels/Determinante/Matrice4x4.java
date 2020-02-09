package calcoloMatriciale.GUI.Panels.Determinante;

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

public class Matrice4x4 extends JPanel {

    private MainFrame mainFrame;

    private JButton calcola;
    private JButton reset;
    private JButton indietro;

    private JTextField[][] matrice = new JTextField[4][4];

    private double a00, a01, a02, a03, a10, a11, a12, a13, a20, a21, a22, a23, a30, a31, a32, a33, det;
    private boolean attivaDet = false;

    public Matrice4x4(MainFrame pMainFrame) {
        this.setSize(MainFrame.LARGHEZZA, MainFrame.ALTEZZA);
        this.setLayout(null);
        this.mainFrame = pMainFrame;

        mouseListner listner = new mouseListner();

        this.calcola = new JButton("CALCOLA");
        this.calcola.setBounds(420, 400, 180, 60);
        this.calcola.addMouseListener(listner);
        this.calcola.setForeground(Color.WHITE);
        this.calcola.setBackground(Color.BLACK);
        this.add(this.calcola);

        this.reset = new JButton("RESET");
        this.reset.setBounds(420 + 180, 400, 180, 60);
        this.reset.addMouseListener(listner);
        this.reset.setForeground(Color.WHITE);
        this.reset.setBackground(Color.BLACK);
        this.add(this.reset);

        this.indietro = new JButton("INDIETRO");
        this.indietro.setBounds(20, 20, 180, 60);
        this.indietro.addMouseListener(listner);
        this.indietro.setForeground(Color.BLACK);
        this.indietro.setBackground(new Color(144, 202, 249));
        this.add(this.indietro);

        int spazioX = 86, spazioY = 60;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                this.matrice[i][j] = new JTextField();
                this.matrice[i][j].setBounds(430 + (spazioX * i), 40 + (spazioY * j), 84, 42);
                this.matrice[i][j].setBackground(Color.WHITE);
                this.matrice[i][j].setFont(new Font(Font.DIALOG, Font.ITALIC, 13));
                this.matrice[i][j].setForeground(Color.BLACK);
                this.add(matrice[i][j]);
            }
        }

    }

    @Override
    protected void paintComponent(Graphics g) {
        Color c = new Color(144, 202, 249);
        g.setColor(c);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());

        //parentesi sx
        g.setColor(Color.BLACK);
        g.fillRect(390, 30, 5, 240);  //verticale

        //parentesi dx
        g.fillRect(805, 30, 5, 240);  //verticale

        Color c1 = new Color(144, 202, 249);
        g.setColor(c1);
        g.fillRect(0, 380, this.getWidth(), 230);

        g.setColor(Color.BLACK);
        g.setFont(new Font(Font.SERIF, Font.BOLD, 25));
        g.drawString("Determinante: ", 420, 320);

        if (attivaDet) {
         /* g.setColor(Color.BLACK);
            g.setFont(new Font(Font.SERIF, Font.ITALIC, 20));
            g.drawString(a00 + " x " + "(" + a10 + " x " + a20 + " - " + a11 + " x " + a13 + ")", 20, 345);
            g.drawString("- " + a01 + " x " + "(" + a03 + " x " + a20 + " - " + a11 + " x " + a12 + ")", 20, 368);             
            g.drawString("+ " + a02 + " x " + "(" + a03 + " x " + a13 + " - " + a10 + " x " + a12 + ")", 20, 391);

        */

            g.setColor(Color.WHITE);
            g.drawString("" + det, 700, 320);
        }

    }

    public double getDeterminante() {
        double deter, determinante, primo, secondo, terzo, quarto;

        a00 = Double.parseDouble(matrice[0][0].getText());
        a01 = Double.parseDouble(matrice[0][1].getText());
        a02 = Double.parseDouble(matrice[0][2].getText());
        a03 = Double.parseDouble(matrice[0][3].getText());
        a10 = Double.parseDouble(matrice[1][0].getText());
        a11 = Double.parseDouble(matrice[1][1].getText());
        a12 = Double.parseDouble(matrice[1][2].getText());
        a13 = Double.parseDouble(matrice[1][3].getText());
        a20 = Double.parseDouble(matrice[2][0].getText());
        a21 = Double.parseDouble(matrice[2][1].getText());
        a22 = Double.parseDouble(matrice[2][2].getText());
        a23 = Double.parseDouble(matrice[2][3].getText());
        a30 = Double.parseDouble(matrice[3][0].getText());
        a31 = Double.parseDouble(matrice[3][1].getText());
        a32 = Double.parseDouble(matrice[3][2].getText());
        a33 = Double.parseDouble(matrice[3][3].getText());

        primo = a11 * (a22 * a33 - a32 * a23) - a12 * (a21 * a33 - a31 * a23) + a13 * (a21 * a32 - a31 * a22);
        secondo = a10 * (a22 * a33 - a32 * a23) - a12 * (a20 * a33 - a30 * a23) + a13 * (a20 * a32 - a30 * a22);
        terzo = a10 * (a21 * a33 - a31 * a23) - a11 * (a20 * a33 - a30 * a23) + a13 * (a20 * a31 - a30 * a21);
        quarto = a10 * (a21 * a32 - a31 * a22) - a11 * (a20 * a32 - a30 * a22) + a12 * (a20 * a31 - a30 * a21);

        deter = a00 * (primo) - a01 * (secondo) + a02 * (terzo) - a03 * (quarto);

        deter = deter * 100;
        determinante = Math.floor(deter);
        determinante = determinante / 100;

        return determinante;
    }


    private void resetCampi() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
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
                    mainFrame.switchPanel(mainFrame.matrice4x4, mainFrame.managementPanelDet);
                    resetCampi();
                    attivaDet = false;
                }

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Errore!");
            }
        }
    }

}
