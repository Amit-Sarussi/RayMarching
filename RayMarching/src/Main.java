// import Graphics.Frame;

import Objects.LineSegment;
import Objects.Point;
import RayCalculate.Calc;
import WorldSpace.World;

public class Main {
    public static void main(String[] args) {
        LineSegment l1 = new LineSegment(
            new Point(4,1), new Point(8,2)
        );

        LineSegment l2 = new LineSegment(
            new Point(0,6), new Point(5,6)
        );

        LineSegment[] ls = {l1, l2};
        World w = new World(ls);
        Point cam = new Point(1,1);
        Point near = new Point(1.5, 2);
        System.out.println(Calc.castRay(cam, near, w, 50));
    }
}
