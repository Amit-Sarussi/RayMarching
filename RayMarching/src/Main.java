import Graphics.Frame;

import Objects.LineSegment;
import Objects.Point;
import RayCalculate.Calc;
import RayCalculate.Camera;
import WorldSpace.World;

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

        int j = 0;
        while (true){
            j++;
            j %= 360;
            cam.setAngle(j);
            System.out.println(j);

            double[] view = new double[800];

            Point mid = cam.getCameraPoint().moveAlongAngle(j, cam.getNearPlaneDist());
    
            for (int i = 0; i<800; i++){
                view[i] = Calc.castRay(
                    cam.getCameraPoint().moveAlongAngle(j+90, (double)  (i-400)*cam.getNearPlaneWidth()/ (double) 400), 
                    mid.moveAlongAngle(j+90, (double)  (i-400)*cam.getNearPlaneWidth()/ (double) 400), 
                    w, 20
                );
            }
    
            f.getCanvas().setBList(view);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        
    }
}
