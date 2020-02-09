package calcoloMatriciale.logic;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;

public class HotArea extends Rectangle{
    
    private Image symbol;
    
    public boolean isClicked(MouseEvent e){
        return this.contains(e.getPoint());
    }
    
    public void disegna(Graphics g){
        g.fillRect(x, y, width, height);
    }
    
    
    
    
}
