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

public class SumDiff4x4Panel extends JPanel {

    private MainFrame mainFrame;

    private JButton buttonSomma;
    private JButton buttonDiff;
    private JButton reset1;
    private JButton reset2;
    private JButton home;

    private boolean attivaSomma = false;
    private boolean attivaDiff = false;

    private JTextField[][] matrice = new JTextField[4][4];
    private JTextField[][] matrice1 = new JTextField[4][4];

    private double[][] matrRisult = new double[4][4];

    public SumDiff4x4Panel(MainFrame pMainFrame) {
        this.setSize(MainFrame.LARGHEZZA, MainFrame.ALTEZZA);
        this.setLayout(null);
        this.mainFrame = pMainFrame;

        mouseListner listner = new mouseListner();

        this.buttonSomma = new JButton(" + ");
        this.buttonSomma.setBounds(260, 406, 145, 60);
        this.buttonSomma.addMouseListener(listner);
        this.buttonSomma.setForeground(Color.WHITE);
        this.buttonSomma.setBackground(Color.BLACK);
        this.add(this.buttonSomma);

        this.buttonDiff = new JButton(" - ");
        this.buttonDiff.setBounds(260 + 145, 406, 145, 60);
        this.buttonDiff.addMouseListener(listner);
        this.buttonDiff.setForeground(Color.WHITE);
        this.buttonDiff.setBackground(Color.BLACK);
        this.add(this.buttonDiff);

        this.reset1 = new JButton("Cancella 1");
        this.reset1.setBounds(150, 310, 145, 60);
        this.reset1.addMouseListener(listner);
        this.reset1.setForeground(Color.WHITE);
        this.reset1.setBackground(Color.BLACK);
        this.add(this.reset1);

        this.reset2 = new JButton("Cancella 2");
        this.reset2.setBounds(510, 310, 145, 60);
        this.reset2.addMouseListener(listner);
        this.reset2.setForeground(Color.WHITE);
        this.reset2.setBackground(Color.BLACK);
        this.add(this.reset2);

        this.home = new JButton("INDIETRO");
        this.home.setBounds(333, 490, 145, 60);
        this.home.addMouseListener(listner);
        this.home.setForeground(Color.BLACK);
        this.home.setBackground(new Color(129, 200, 132));
        this.add(this.home);


        int spazioX = 86, spazioY = 60;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                this.matrice[i][j] = new JTextField();
                this.matrice[i][j].setBounds(40 + (spazioX * i), 80 + (spazioY * j), 84, 42);
                this.matrice[i][j].setBackground(Color.WHITE);
                this.matrice[i][j].setFont(new Font(Font.DIALOG, Font.ITALIC, 13));
                this.matrice[i][j].setForeground(Color.BLACK);
                this.add(matrice[i][j]);
            }
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                this.matrice1[i][j] = new JTextField();
                this.matrice1[i][j].setBounds(420 + (spazioX * i), 80 + (spazioY * j), 84, 42);
                this.matrice1[i][j].setBackground(Color.WHITE);
                this.matrice1[i][j].setFont(new Font(Font.DIALOG, Font.ITALIC, 13));
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
        g.fillRect(20, 70, 5, 240);  //verticale

        //parentesi dx
        g.fillRect(394, 70, 5, 240);

        //seconde parentesi
        //parentesi sx
        g.setColor(Color.BLACK);
        g.fillRect(401, 70, 5, 240);
        //parentesi dx
        g.fillRect(776, 70, 5, 240);

        Color c1 = new Color(129, 200, 132);
        g.setColor(c1);
        g.fillRect(0, 380, this.getWidth(), 230);

        g.setColor(Color.BLACK);
        g.setFont(new Font(Font.DIALOG, Font.ITALIC, 16));

        int spX = 80, spY = 40;
        if (attivaSomma == true) {
            g.setFont(new Font(Font.DIALOG, Font.BOLD, 18));
            g.drawString("Somma", 940, 360);
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    g.setFont(new Font(Font.DIALOG, Font.PLAIN, 18));
                    g.drawString("" + matrRisult[i][j], 885 + (spX * i), 150 + (spY * j));
                }
            }
        }
        if (attivaDiff == true) {
            g.setFont(new Font(Font.DIALOG, Font.BOLD, 18));
            g.drawString("Differenza", 940, 360);
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    g.setFont(new Font(Font.DIALOG, Font.PLAIN, 18));
                    g.drawString("" + matrRisult[i][j], 885 + (spX * i), 150 + (spY * j));
                }
            }
        }
        if (attivaDiff == true || attivaSomma == true){
            g.setColor(Color.BLACK);
            g.setFont(new Font(Font.DIALOG, Font.PLAIN, 30));
            g.drawString("=", 800, 220);
            g.fillRect(855, 70, 5, 240);  //verticale
            g.fillRect(1180, 70, 5, 240);  //verticale

        }

    }

    private void somma() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                matrRisult[i][j] = Double.parseDouble(matrice[i][j].getText()) + Double.parseDouble(matrice1[i][j].getText());
            }
        }
        attivaSomma = true;
    }

    private void differenza() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                matrRisult[i][j] = Double.parseDouble(matrice[i][j].getText()) - Double.parseDouble(matrice1[i][j].getText());
            }
        }
        attivaDiff = true;
    }

    private void reset1() {
        attivaSomma = false;
        attivaDiff = false;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                this.matrice[i][j].setText(null);
            }
        }
    }

    private void reset2() {
        attivaDiff = false;
        attivaSomma = false;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                this.matrice1[i][j].setText(null);
            }
        }
    }

    private class mouseListner extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            try {
                JButton btn = (JButton) e.getSource();

                if (btn.equals(buttonSomma)) {
                    //if(attivaDiff == false){
                    attivaDiff = false;
                    somma();
                    repaint();
                    //}
                }
                if (btn.equals(buttonDiff)) {
                    //if(attivaSomma == false){
                    attivaSomma = false;
                    differenza();
                    repaint();
                    //}
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
                    reset1();
                    reset2();
                    mainFrame.switchPanel(mainFrame.sumDiff4x4Panel, mainFrame.managementPanelOper);
                }

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "INSERIRE DEI VALORI VALIDI!");
            }
        }
    }

}
