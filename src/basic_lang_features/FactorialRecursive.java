package basic_lang_features;

/**
 * Reference implementation of the classical recursive factorial calculation
 */
public class FactorialRecursive {

    /**
     * Static method for calculation of factorial of an input integer number n
     * @param n integer number for calculation
     * @return result integer calculated factorial
     */
    public static int calculate(int n){
        int result; // giving only name and type to result
        if (n > 0){
            if (n == 1)
                result = 1;
            else
                result = calculate(n-1)*n; // the recursive call of the function till it reaches 1
            return result;
        } else {
            System.out.println("This method can't be called for non-positive number");
            return 0;
        }
    }

    public static void main(String[] args) {
        System.out.println("Self-tests of the implemented calculation method");
        System.out.println("6! = " + calculate(6));
        System.out.println("7! = " + calculate(7));
        System.out.println("8! = " + calculate(8));
        System.out.println("-1! = " + calculate(-1));
    }

}
