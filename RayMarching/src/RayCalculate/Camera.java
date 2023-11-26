package RayCalculate;

import Objects.Point;

public class Camera {

    Point cameraPoint;
    double nearPlaneDist;
    double nearPlaneWidth;
    double angle = 0;

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

    public Point getCameraPoint() {
        return cameraPoint;
    }

    public double getAngle() {
        return angle;
    }

    public void setAngle(double angle){
        this.angle = angle;
    }

    public double getNearPlaneWidth() {
        return nearPlaneWidth;
    }

    public double getNearPlaneDist() {
        return nearPlaneDist;
    }

    public void setCameraPoint(Point cameraPoint) {
        this.cameraPoint = cameraPoint;
    }
    
}
