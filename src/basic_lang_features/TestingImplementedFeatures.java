package basic_lang_features;

/**
 * This class for some observing of implemented classes, methods, features in this package
 */

public class TestingImplementedFeatures {

    public static void main(String[] args) {
        System.out.println("8! = " + FactorialRecursive.calculate(8));  // testing recursion for factorial calculation
        // Below - testing creation and manipulation of simple Complex number class
        ComplexNumber cn1 = new ComplexNumber("-101-1.5j");
        ComplexNumber cn2 = new ComplexNumber(" -2.99j + 12.77  ");
        // ComplexNumber cn3 = new ComplexNumber("6.2 + 1.2"); // will cause the exception
        ComplexNumber cn4 = new ComplexNumber("-101.11j+2007.13 ");
        // ComplexNumber cn5 = new ComplexNumber("-1j + 2j"); // will cause the exception
        ComplexNumber sum = cn2.add(cn4);
        System.out.println(cn2 + " + " + cn4 + " = " + sum );
        cn1.add(102, 0.5);
        System.out.println(cn1);
    }
}
