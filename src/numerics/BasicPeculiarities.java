package numerics;

public class BasicPeculiarities {
    public static void main(String[] args) {
        // demonstration of basic peculiarities of calculations in Java
        int a = 5;  int c = 3; double b = 2.0;
        int acDiv;
        acDiv = a/c;
        System.out.println("5/3 result is automatically set to integer part if assigned to int value: " + acDiv);
        System.out.println("5/3 result is set again to integer value if directly using 'a/c' eq: " + a/c);
        double acDoubleDiv = a/c;
        System.out.println("5/3 is not automatically converted to match to the value assigned: " + acDoubleDiv);
        // seems, only the way to get proper result of floating point division
        acDoubleDiv = (double) a / (double) c;
        System.out.println("5/3 proper result after explicit conversion of integer values: " + acDoubleDiv);
        acDoubleDiv  = a/b;
        System.out.println("5/2.0 result division is automatically convert to double: " + acDoubleDiv);

    }
}
