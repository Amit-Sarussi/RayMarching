package Graphics;

import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

public class Canvas extends JComponent{
    
    int width;
    int height;
    boolean[] view;
    public Canvas(int w, int h){
        this.width = w;
        this.height = h;
        this.setBackground(Color.black);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        for (int i = 0; i < 800; i++){
            Rectangle2D.Double r = new Rectangle2D.Double(i, 0, i+1, this.view[i] ? 800 : 0);
            g2d.setColor(Color.black);
            g2d.fill(r);
        }
    }

    public void setBList(boolean[] viewList){
        this.view = viewList;
        repaint();
    }
}
