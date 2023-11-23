package Objects;

public class Line {
    
    double m;
    double b;

    public Line(double m, double b){
        this.m = m;
        this.b = b;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getM() {
        return m;
    }

    public void setM(double m) {
        this.m = m;
    }

    public static double calcB(Point p, double m){
        return p.getY()-m*p.getX();
    }

    public Point intersect(Line other){
        double x = (other.getB()-b)/(m-other.getM());
        double y = m * x + b;
        return new Point(x,y);
    }

    public String toString(){
        return "y = " + m + "x + " + b ;
    }
}
