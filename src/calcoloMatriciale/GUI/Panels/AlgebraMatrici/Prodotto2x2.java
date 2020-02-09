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

public class Prodotto2x2 extends JPanel {

    private MainFrame mainFrame;

    private JButton buttonProdotto;
    private JButton reset1;
    private JButton reset2;
    private JButton home;

    private boolean attivaProdotto = false;

    private JTextField[][] matrice = new JTextField[3][3];
    private JTextField[][] matrice1 = new JTextField[3][3];

    private double n1, n2, n3, n4, n5, n6, n7, n8, n9;
    private double n10, n11, n12, n13, n14, n15, n16, n17, n18;

    private double[][] matrRisult = new double[3][3];

    public Prodotto2x2(MainFrame pMainFrame) {
        this.setSize(MainFrame.LARGHEZZA, MainFrame.ALTEZZA);
        this.setLayout(null);
        this.mainFrame = pMainFrame;

        Prodotto2x2.mouseListner listner = new Prodotto2x2.mouseListner();

        this.buttonProdotto = new JButton("MOLTIPLICA");
        this.buttonProdotto.setBounds(333, 410, 145, 60);
        this.buttonProdotto.addMouseListener(listner);
        this.buttonProdotto.setForeground(Color.WHITE);
        this.buttonProdotto.setBackground(Color.BLACK);
        this.add(this.buttonProdotto);

        this.reset1 = new JButton("RESET 1");
        this.reset1.setBounds(150, 306, 145, 60);
        this.reset1.addMouseListener(listner);
        this.reset1.setForeground(Color.WHITE);
        this.reset1.setBackground(Color.BLACK);
        this.add(this.reset1);

        this.reset2 = new JButton("RESET 2");
        this.reset2.setBounds(510, 306, 145, 60);
        this.reset2.addMouseListener(listner);
        this.reset2.setForeground(Color.WHITE);
        this.reset2.setBackground(Color.BLACK);
        this.add(this.reset2);

        this.home = new JButton("INDIETRO");
        this.home.setBounds(333, 490, 145, 60);
        this.home.addMouseListener(listner);
        this.home.setForeground(Color.BLACK);
        this.home.setBackground(Color.WHITE);
        this.add(this.home);


        int spazioX = 180, spazioY = 80;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                this.matrice[i][j] = new JTextField();
                this.matrice[i][j].setBounds(80 + (spazioX * i), 110 + (spazioY * j), 102, 42);
                this.matrice[i][j].setBackground(Color.WHITE);
                this.matrice[i][j].setFont(new Font(Font.DIALOG, Font.ITALIC, 16));
                this.matrice[i][j].setForeground(Color.BLACK);
                this.add(matrice[i][j]);
            }
        }

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                this.matrice1[i][j] = new JTextField();
                this.matrice1[i][j].setBounds(440 + (spazioX * i), 110 + (spazioY * j), 102, 42);
                this.matrice1[i][j].setBackground(Color.WHITE);
                this.matrice1[i][j].setFont(new Font(Font.DIALOG, Font.ITALIC, 16));
                this.matrice1[i][j].setForeground(Color.BLACK);
                this.add(matrice1[i][j]);
            }
        }

    }


    @Override
    protected void paintComponent(Graphics g) {
        Color c = new Color(129, 200, 132);
        g.setColor(c);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());

        //parentesi sx
        g.setColor(Color.BLACK);
        g.fillRect(40, 80, 5, 200);  //verticale

        //parentesi dx
        g.fillRect(392, 80, 5, 200);  //verticale

        //seconde parentesi
        //parentesi sx
        g.setColor(Color.BLACK);
        g.fillRect(404, 80, 5, 200);  //verticale

        //parentesi dx
        g.fillRect(756, 80, 5, 200);  //verticale

        Color c1 = new Color(129, 200, 132);
        g.setColor(c1);
        g.fillRect(0, 380, this.getWidth(), 230);

        g.setColor(Color.BLACK);

        int spX = 80, spY = 60;
        if (attivaProdotto == true) {
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    g.setFont(new Font(Font.DIALOG, Font.PLAIN, 18));
                    g.drawString("" + matrRisult[i][j], 900 + (spX * i), 150 + (spY * j));
                }
            }
            g.setColor(Color.BLACK);
            g.setFont(new Font(Font.DIALOG, Font.PLAIN, 30));
            g.drawString("=", 800, 220);
            g.fillRect(855, 80, 5, 200);
            g.fillRect(1140, 80, 5, 200);
        }

    }

    private void prodotto() {
        //Righe per colonne
        n1 = Double.parseDouble(matrice[0][0].getText());
        n2 = Double.parseDouble(matrice[1][0].getText());

        n4 = Double.parseDouble(matrice[0][1].getText());
        n5 = Double.parseDouble(matrice[1][1].getText());

        n10 = Double.parseDouble(matrice1[0][0].getText());
        n11 = Double.parseDouble(matrice1[1][0].getText());
        n13 = Double.parseDouble(matrice1[0][1].getText());
        n14 = Double.parseDouble(matrice1[1][1].getText());

        matrRisult[0][0] = (n1 * n10) + (n2 * n13);
        matrRisult[1][0] = (n1 * n11) + (n2 * n14);
        matrRisult[0][1] = (n4 * n10) + (n5 * n13) ;
        matrRisult[1][1] = (n4 * n11) + (n5 * n14) ;

        attivaProdotto = true;
    }

    private void reset1() {
        attivaProdotto = false;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                this.matrice[i][j].setText(null);
            }
        }
    }

    private void reset2() {
        attivaProdotto = false;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                this.matrice1[i][j].setText(null);
            }
        }
    }

    private class mouseListner extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            try {
                JButton btn = (JButton) e.getSource();

                if (btn.equals(buttonProdotto)) {
                    prodotto();
                    repaint();
                }
                if (btn.equals(reset1)) {
                    reset1();
                    repaint();
                }
                if (btn.equals(reset2)) {
                    reset2();
                    repaint();
                }
                if (btn.equals(home)) {
                    mainFrame.switchPanel(mainFrame.prodotto2x2, mainFrame.managementPanelOper);
                    reset1();
                    reset2();
                    repaint();
                }

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Errore!");
            }
        }
    }

}
