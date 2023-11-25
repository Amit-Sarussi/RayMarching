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
            new Point(1,6), new Point(5,6)
        );

        LineSegment[] ls = {l1, l2};
        World w = new World(ls);
        Camera cam = new Camera(new Point(1,1), 0.2, 2);

        for (int j = 0; j< 360; j++){
            cam.setAngle(j);
            System.out.println(j);

            boolean[] view = new boolean[800];

            Point mid = cam.getCameraPoint().moveAlongAngle(j, cam.getNearPlaneDist());
    
            for (int i = 0; i<800; i++){
                view[i] = Calc.castRay(
                    cam.getCameraPoint(), 
                    mid.moveAlongAngle(j+90, (double)  (i-400)*cam.getNearPlaneWidth()/ (double) 400), w, 10);
                // System.out.println(mid.moveAlongSlope(-1/slope, (double)  (i-400)/ (double) 400).toString());
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
