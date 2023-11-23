package RayCalculate;

import Objects.Point;
import Objects.Line;

public class calc {
    public static Point findClosestPoint(Point p, Point l1, Point l2){

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
}
