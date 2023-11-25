package Graphics;
import javax.swing.*;

public class Frame extends JFrame{
    
    int w;
    int h;
    Canvas c;
    public Frame(int width, int height){
        this.w = width;
        this.h = height;
        this.setSize(this.w, this.h);
        this.setTitle("Ray Marching");

        this.c = new Canvas(this.w,this.h);
        this.add(this.c);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public Canvas getCanvas(){
        return this.c;
    }

    
}
