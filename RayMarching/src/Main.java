import Graphics.Frame;

import Objects.LineSegment;
import Objects.Point;
import RayCalculate.Calc;
import RayCalculate.Camera;
import WorldSpace.World;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class Main {
    public static void main(String[] args) {
        Frame f = new Frame(800, 800);
        

        LineSegment l1 = new LineSegment(
            new Point(4,1), new Point(8,2)
        );

        LineSegment l2 = new LineSegment(
            new Point(1,6), new Point(2,6)
        );

        LineSegment l3 = new LineSegment(
            new Point(3,6), new Point(4,6)
        );

        LineSegment l4 = new LineSegment(
            new Point(5,6), new Point(6,6)
        );

        LineSegment l5 = new LineSegment(
            new Point(1,6), new Point(0,6)
        );

        LineSegment l6 = new LineSegment(
            new Point(-1,6), new Point(-2,6)
        );

        LineSegment l7 = new LineSegment(
            new Point(-3,6), new Point(-4,6)
        );

        LineSegment[] ls = {l1, l2, l3, l4, l5, l6, l7};
        World w = new World(ls);
        Camera cam = new Camera(new Point(0,0), 0.1, 4);

        
        while (true){
            double angle = cam.getAngle();
            double[] view = new double[800];

            Point mid = cam.getCameraPoint().moveAlongAngle(angle, cam.getNearPlaneDist());
    
            for (int i = 0; i<800; i++){
                view[i] = Calc.castRay(
                    cam.getCameraPoint().moveAlongAngle(angle+90, (double)  (i-400)*cam.getNearPlaneWidth()/ (double) 400), 
                    mid.moveAlongAngle(angle+90, (double)  (i-400)*cam.getNearPlaneWidth()/ (double) 400), 
                    w, 20
                );
            }
    
            f.getCanvas().setBList(view);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            f.addKeyListener(new KeyListener() {
                @Override
                public void keyTyped(KeyEvent e) {
                }
        
                @Override
                public void keyPressed(KeyEvent e) {
                    if (e.getKeyChar() == 'd'){
                        cam.getCameraPoint().setY(cam.getCameraPoint().getY()+0.01);
                        cam.setCameraPoint(cam.getCameraPoint());
                    }
                    else if (e.getKeyChar() == 'w'){
                        cam.getCameraPoint().setX(cam.getCameraPoint().getX()+0.01);
                        cam.setCameraPoint(cam.getCameraPoint());
                    }
                    else if (e.getKeyChar() == 'a'){
                        cam.getCameraPoint().setY(cam.getCameraPoint().getY()-0.01);
                        cam.setCameraPoint(cam.getCameraPoint());
                    }
                    else if (e.getKeyChar() == 's'){
                        cam.getCameraPoint().setX(cam.getCameraPoint().getX()-0.01);
                        cam.setCameraPoint(cam.getCameraPoint());
                    }
                    if (e.getKeyCode() == 39){
                        cam.setAngle(cam.getAngle()+0.01);
                    }
                    else if (e.getKeyCode() == 37){
                        cam.setAngle(cam.getAngle()-0.01);
                    }
                }
        
                @Override
                public void keyReleased(KeyEvent e) {
                }
            });
        }
        
    }
}
