package RayCalculate;

import Objects.Point;

public class Camera {

    Point cameraPoint;
    double nearPlaneDist;
    double nearPlaneWidth;

    public Camera(double nearPlaneDist, double nearPlaneWidth){
        this.cameraPoint = new Point(0, 0);
        this.nearPlaneDist = nearPlaneDist;
        this.nearPlaneWidth = nearPlaneWidth;
    }

    public Camera(Point cameraPoint, double nearPlaneDist, double nearPlaneWidth){
        this.cameraPoint = new Point(cameraPoint);
        this.nearPlaneDist = nearPlaneDist;
        this.nearPlaneWidth = nearPlaneWidth;
    }
    
}
