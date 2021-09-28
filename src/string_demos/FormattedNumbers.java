package string_demos;

import java.util.Formatter;

public class FormattedNumbers {

    public static void main(String[] args) {
        // demo of output formatted numbers for the console just by using printf()
        double n = 1_254_90;
        System.out.printf("Long number by printf: %.2E %n", n); // !!!: doesn't work with int, look also on rounding rules!
        System.out.printf("Short pi by printf: %.3f %n", Math.PI);
        // the same demo, but explicitly calling Formatter class:
        try(Formatter formatter = new Formatter()){
            formatter.format("Short PI by Formatter: %.3f", Math.PI);
            System.out.println(formatter);
        }
    }
}
