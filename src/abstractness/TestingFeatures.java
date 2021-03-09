package abstractness;

public class TestingFeatures {

    public static void main(String[] args) {

        // testing initialization of figure with negative size
        // Triangle triangle = new Triangle(1, 2, -2);
        try{
            Triangle invalidTriangle = new Triangle(1, 10, 3);
            invalidTriangle.printProperties();
        } catch (IllegalArgumentException e){
            e.printStackTrace();
        }
        Triangle triangleValid = new Triangle(3, 4, 6);
        triangleValid.printProperties();

    }
}
