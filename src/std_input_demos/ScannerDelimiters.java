package std_input_demos;

import java.util.ArrayList;
import java.util.Scanner;

public class ScannerDelimiters {

    public static void main(String[] args) {
        // demo of usage of delimiters by Scanner
        String target = "Here is numbers: 1, 1.2, 1.4, 1.56,   0.987, -1.08";
        Scanner src = new Scanner(target);
        src.useDelimiter("(, *)|(,-*)|(: *)"); // could be made as the regular expression shown here
        ArrayList readNumbers = new ArrayList();
        // be careful, below if there is no next double number parsed, the while loop exist prematurely
        // and also next step should be specified
        while (src.hasNext()){
            if (src.hasNextDouble()){
                readNumbers.add(src.nextDouble());
            }
            else {
                // System.out.println(src.next());
                src.next(); // w/t this command not doing the next step after constantly reading the same string "Here is numbers"!
            }
        }
        System.out.println("Initial string: " + target);
        System.out.println("Found decimal numbers: " + readNumbers);
    }
}
