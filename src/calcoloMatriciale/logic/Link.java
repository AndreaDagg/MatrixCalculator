package calcoloMatriciale.logic;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;

public class Link extends Rectangle{
    private int dim;
    
    public Link(int pDim){
        this.dim = pDim;
    }
    
    public boolean isClicked(MouseEvent e){
        return this.contains(e.getPoint());
    }
    
    public void disegna(Graphics g){
        g.fillRect(x, y, width, height);
        g.setFont(new Font("Arial", Font.BOLD, dim));
        g.setColor(Color.WHITE);
        g.drawString("storia della matematica.pdf", x, y + 16);
    }
    
}
