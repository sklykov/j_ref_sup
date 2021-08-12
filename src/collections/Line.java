package collections;

public class Line {
    private double[] origin;
    private double[] end;
    private double length;
    Line(double x1, double y1, double x2, double y2){
        this.origin = new double[2]; this.origin[0] = x1; this.origin[1] = y1;
        this.end = new double[2]; this.end[0] = x2; this.end[1] = y2;
        this.length = Math.sqrt(Math.pow((this.end[0]-this.origin[0]), 2) + Math.pow((this.end[1]-this.origin[1]), 2));
    }

    public double getLength() {
        return length;
    }

    @Override
    public String toString(){
        return Double.toString(this.length);
    }
}
