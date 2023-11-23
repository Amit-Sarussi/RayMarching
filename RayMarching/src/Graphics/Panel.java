package Graphics;

import java.awt.*;
import javax.swing.*;

public class Panel extends JPanel{
    
    Panel(){
        this.setPreferredSize(new Dimension(800,800));
    }

    public void paint(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;

        g2D.setBackground(Color.red);
        g2D.setColor(Color.red);
        g2D.setStroke(new BasicStroke(10));
        g2D.drawLine(0,0,0,800);
        
    }
}
