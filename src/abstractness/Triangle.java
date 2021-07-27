package abstractness;

// static import for using name of a static function without any class name / instance

import static java.lang.Math.*;

class Triangle extends Figure {
    private double A, B, C;

    /**
     * Constructor of a Triangle class
     * @param sides - supposed in the following order: A, B, C
     * @throws IllegalArgumentException - in case of specifying more or less than 3 sides
     */
    Triangle(double ...sides) throws IllegalArgumentException{

        // using the basic checking validity of input parameters
        super(sides);

        // checking number of input sides
        if (sides.length != 3){
            throw new IllegalArgumentException("The general triangle demands specifying of 3 sides");
        }

        this.A = sides[0]; this.B = sides[1]; this.C = sides[2]; // assigning values

        // checking validity of sides values (possibility of making out of them a triangle)
        if ((this.A + this.B < this.C) || (this.A + this.C < this.B) || (this.B + this.C < this.A)) {
            String description;
            if (this.A + this.B < this.C) {
                description = "A + B < C";
            }
            else if (this.A + this.C < this.B){
                description = "A + C < B";
            }
            else{ description = "B + C < A"; }

            throw new IllegalArgumentException(description);
        }
        System.out.println("The triangle initialized with the values: " + this.A + ", " + this.B + ", " + this.C);

    }

    @Override
    double perimeter() {
        return (this.A + this.B + this.C);
    }

    /**
     * Calculates area of a triangle using Heron's formula
     * @return area double
     */
    @Override
    double area() {
        double halfPerimeter = 0.5*this.perimeter();
        return sqrt(halfPerimeter*(halfPerimeter - this.A)*(halfPerimeter - this.B)*(halfPerimeter - this.C));
    }

    public void printProperties(){
        System.out.println("The perimeter is: " + this.perimeter());
        System.out.println("The area is: " + this.area());
        System.out.println("The rounded area is: " + round(this.area()));
    }

    /**
     * Returns array containing sides of the initialized triangle
     * @return sides - array of 3 double values
     */
    public double[] getSides(){
        double sides[] = {this.A, this.B, this.C};
        return sides;
    }

    /**
     * Comparison of two triangles by comparing their sides lengths side by side.
     * @param t:
     *         Triangle class
     * @return boolean
     */
    boolean equalTo(Triangle t){
        boolean equal = true;
        double[] sides = this.getSides();
        double[] comparedToSides = t.getSides();
        for (int i = 0; i < sides.length; i++){
            if (sides[i] != comparedToSides[i]){
                equal = false;
                break;
            }
        }
        return equal;
    }
}
