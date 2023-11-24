package Objects;

public class Point {

    double x;
    double y;
    
    public Point(double x, double y){
        this.x = x;
        this.y = y;
    }

    public Point(Point other){
        this.x = other.getX();
        this.y = other.getY();
    }
    
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
    
    public void setX(double x) {
        this.x = x;
    }
    
    public void setY(double y) {
        this.y = y;
    }

    @Override
    public String toString(){
        return x + ", " + y;
    }

    public double dist(Point other){
        return Math.sqrt(
            Math.pow((other.getX() - x),2) + 
            Math.pow((other.getY() - y),2)
        );
    }
}
