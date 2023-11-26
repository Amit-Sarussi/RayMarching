package Graphics;

import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

public class Canvas extends JComponent{
    
    int width;
    int height;
    double[] view;
    public Canvas(int w, int h){
        this.width = w;
        this.height = h;
        this.setBackground(Color.black);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        Rectangle2D.Double bg = new Rectangle2D.Double(0,0,width,height);
        g2d.setColor(Color.white);
        g2d.fill(bg);

        for (int i = 0; i < 800; i++){
            Rectangle2D.Double r = new Rectangle2D.Double(
                i, 
                this.view[i] != -1 ? this.view[i]*30 : 0, 
                i+1, 
                this.view[i] != -1 ? height - this.view[i]*60 : 0
            );
            // g2d.setColor(new Color(
            //     this.view[i] != -1 ? 255*(int)this.view[i]/9: 0,
            //     this.view[i] != -1 ? 255*(int)this.view[i]/9: 0,
            //     this.view[i] != -1 ? 255*(int)this.view[i]/9: 0
            // ));
            g2d.setColor(Color.black);
            g2d.fill(r);
        }
    }

    public void setBList(double[] viewList){
        this.view = viewList;
        repaint();
    }
}
