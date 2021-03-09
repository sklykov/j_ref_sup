package abstractness;


/**
 * Classical demonstration of the abstractness concept using abstract class "Figure" below
 */

// class access - package-protected
abstract class Figure {
    private double[] characteristicSizes;

    /**
     * General constructor
     * @param characteristicSizes double[...] variable arguments, should be implemented in each figure
     * @throws IllegalArgumentException if characteristic sizes are less or equal to 0
     */
    Figure(double ...characteristicSizes) throws IllegalArgumentException{

        // checking input parameters validity - characteristic sizes should be positive!
        int i = 1;
        for(double size: characteristicSizes){
            if (size <= 0.0){
                throw new IllegalArgumentException("Side #" + i + " is less or equal to 0");
            }
            i++;
        }

        this.characteristicSizes = characteristicSizes;
    }

    // Abstract methods to be implemented by concrete Figures
    abstract double perimeter();
    abstract double area();
}
