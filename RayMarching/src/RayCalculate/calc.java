package RayCalculate;

import Objects.Point;
import WorldSpace.World;
import Objects.Line;
import Objects.LineSegment;

public class Calc {
    public static Point findClosestPoint(Point p, LineSegment line){
        Point l1 = line.getP1();
        Point l2 = line.getP2();

        double ogM;
        if ((l1.getX()-l2.getX()) == 0) ogM = 999999999;
        else ogM = (l1.getY()-l2.getY())/(l1.getX()-l2.getX());
        double ogB = Line.calcB(l1, ogM);

        double pM;
        if (ogM != 0){
            pM = -1/ogM;
        }else {
            pM = 999999999;
        }
        
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

    public static boolean castRay(Point cam, Point nearPlanePoint, World w, int precision){
        Point currentP = new Point(nearPlanePoint);
        double smDist = -1;
        for (int i = 0; i < precision; i++){
            smDist = findClosestDist(currentP, w);
            Point dir = new Point(currentP.getX() - cam.getX(), currentP.getY() - cam.getY());
            double magnitude = Math.sqrt(
                Math.pow(dir.getX(),2) + 
                Math.pow(dir.getY(),2)
            );
            Point unitDir = new Point(dir.getX() / magnitude, dir.getY() / magnitude);
            currentP.setX(currentP.getX() + smDist*unitDir.getX());
            currentP.setY(currentP.getY() + smDist*unitDir.getY());
            // System.out.println(currentP.toString() + ", Dist: " + smDist);
        }
        return smDist < 0.01;
    }
}
