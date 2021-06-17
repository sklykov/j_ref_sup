package exception_demos;

public class ThrowingExceptionDemo {

    /**
     * Calculates the sum of input double parameters (accept any number of them)
     * @param args
     * @return sum of input arguments
     * @throws Exception "ZeroInputParametersToMethod"
     */
    public static double calculateSum(double ...args) throws Exception {
        double sum = 0.0;
        if (args.length == 0) {
            throw new Exception("ZeroInputParametersToMethod");
        }
        else{

            for (double argument:args){
                sum += argument;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        double a = 1.0; double b = 1.0; double sum;
        try {
            sum = calculateSum(a, b);
        } catch (Exception e) { }

        try {
            sum = calculateSum();
        } catch (Exception e) {
            System.out.println("Exception " + e.getMessage()+ " occurred");
        }

    }
}
