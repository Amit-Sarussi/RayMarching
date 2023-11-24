package RayCalculate;

import Objects.Point;
import WorldSpace.World;
import Objects.Line;
import Objects.LineSegment;

public class Calc {
    public static Point findClosestPoint(Point p, LineSegment line){
        Point l1 = line.getP1();
        Point l2 = line.getP2();

        double ogM = (l1.getY()-l2.getY())/(l1.getX()-l2.getX());
        double ogB = Line.calcB(l1, ogM);

        double pM = -1/ogM;
        double pB = Line.calcB(p, pM);

        
        Line og = new Line(ogM, ogB);
        Line pL = new Line(pM, pB);
        Point inter = og.intersect(pL);

        Point small;
        Point big;
        if (l1.getX() < l2.getX()) {small = l1; big = l2;}
        else {small = l2; big = l1;}
        
        if (inter.getX() < small.getX()){
            return small;
        }else if (inter.getX() > big.getX()){
            return big;
        }else{
            return inter;
        }
    }

    public static double findClosestDist(Point p, World w){
        LineSegment[] lines = w.getLines();
        double minLength = -1;

        for (LineSegment l : lines){
            double dist = findClosestPoint(p, l).dist(p);
            if (minLength == -1) minLength = dist;
            else if (minLength > dist) minLength = dist;
        }
        return minLength;

    }

    public static double castRay(Point cam, Point nearPlanePoint, World w, int precision){
        Point currentP = new Point(nearPlanePoint);
        double smDist = -1;
        for (int i = 0; i < precision; i++){
            smDist = findClosestDist(currentP, w);
            double t = smDist / cam.dist(nearPlanePoint);
            currentP.setX((1-t)*cam.getX()+t*nearPlanePoint.getX());
            currentP.setY((1-t)*cam.getY() + t*nearPlanePoint.getY());
            System.out.println(currentP.toString() + ", Dist: " + smDist);
        }
        return smDist;
    }
}
