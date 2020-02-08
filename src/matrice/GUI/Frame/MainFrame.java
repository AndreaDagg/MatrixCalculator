package matrice.GUI.Frame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import matrice.GUI.Panels.MainPanel;
import matrice.GUI.Panels.Determinante.ManagementPanelDet;
import matrice.GUI.Panels.Operazioni.ManagementPanelOper;
import matrice.GUI.Panels.Determinante.Matrice2x2;
import matrice.GUI.Panels.Determinante.Matrice3x3;
import matrice.GUI.Panels.Determinante.Matrice4x4;
import matrice.GUI.Panels.Operazioni.Inversa2x2;
import matrice.GUI.Panels.Operazioni.Inversa3x3;
import matrice.GUI.Panels.Operazioni.Prodotto3x3Panel;
import matrice.GUI.Panels.Operazioni.Prodotto4x4Panel;
import matrice.GUI.Panels.Operazioni.SumDiff3x3Panel;
import matrice.GUI.Panels.Operazioni.SumDiff4x4Panel;
import matrice.GUI.Panels.Rango.ManagementPanelRango;
import matrice.GUI.Panels.Rango.MatrRango2x2;
import matrice.GUI.Panels.Rango.MatrRango3x3;

import java.awt.*;

public class MainFrame extends JFrame{
    public static final int LARGHEZZA = 1200, ALTEZZA = 680;
    
    public MainPanel mainPanel;
    public ManagementPanelDet managementPanelDet;
    public ManagementPanelOper managementPanelOper;
    public ManagementPanelRango managementPanelRango;
    
    public Matrice2x2 matrice2x2;
    public Matrice3x3 matrice3x3;
    public Matrice4x4 matrice4x4;
    
    public SumDiff3x3Panel sumDiff3x3Panel;
    public SumDiff4x4Panel sumDiff4x4Panel;
    
    public Prodotto3x3Panel prodotto3x3;
    public Prodotto4x4Panel prodotto4x4Panel;
    
    public Inversa2x2 inversa2x2;
    public Inversa3x3 inversa3x3;

    public MatrRango2x2 matrRango2x2;
    public MatrRango3x3 matrRango3x3;
    
    public MainFrame(){
        this.setSize(MainFrame.LARGHEZZA, MainFrame.ALTEZZA);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setLayout(null);
        
        this.mainPanel = new MainPanel(this);
        this.getContentPane().add(mainPanel);
        this.mainPanel.setVisible(true);
        
        this.managementPanelDet = new ManagementPanelDet(this);
        this.getContentPane().add(managementPanelDet);
        this.managementPanelDet.setVisible(false);
        
        this.matrice2x2 = new Matrice2x2(this);
        this.getContentPane().add(matrice2x2);
        this.matrice2x2.setVisible(false);
        
        this.matrice3x3 = new Matrice3x3(this);
        this.getContentPane().add(matrice3x3);
        this.matrice3x3.setVisible(false);
        
        this.matrice4x4 = new Matrice4x4(this);
        this.getContentPane().add(matrice4x4);
        this.matrice4x4.setVisible(false);
        
        this.managementPanelOper = new ManagementPanelOper(this);
        this.getContentPane().add(managementPanelOper);
        this.managementPanelOper.setVisible(false);
        
        this.sumDiff3x3Panel = new SumDiff3x3Panel(this);
        this.getContentPane().add(sumDiff3x3Panel);
        this.sumDiff3x3Panel.setVisible(false);
        
        this.sumDiff4x4Panel = new SumDiff4x4Panel(this);
        this.getContentPane().add(sumDiff4x4Panel);
        this.sumDiff4x4Panel.setVisible(false);
        
        this.prodotto3x3 = new Prodotto3x3Panel(this);
        this.getContentPane().add(prodotto3x3);
        this.prodotto3x3.setVisible(false);
        
        this.prodotto4x4Panel = new Prodotto4x4Panel(this);
        this.getContentPane().add(prodotto4x4Panel);
        this.prodotto4x4Panel.setVisible(false);
        
        this.inversa3x3 = new Inversa3x3(this);
        this.getContentPane().add(inversa3x3);
        this.inversa3x3.setVisible(false);
        
        this.inversa2x2 = new Inversa2x2(this);
        this.getContentPane().add(inversa2x2);
        this.inversa2x2.setVisible(false);
        
        this.managementPanelRango = new ManagementPanelRango(this);
        this.getContentPane().add(managementPanelRango);
        this.managementPanelRango.setVisible(false);
        
        this.matrRango2x2 = new MatrRango2x2(this);
        this.getContentPane().add(matrRango2x2);
        this.matrRango2x2.setVisible(false);
        
        this.matrRango3x3 = new MatrRango3x3(this);
        this.getContentPane().add(matrRango3x3);
        this.matrRango3x3.setVisible(false);

    }
    
    public void switchPanel(JPanel toDisable, JPanel toEnable){
        toDisable.setVisible(false);
        toEnable.setVisible(true);
    }
    
}
