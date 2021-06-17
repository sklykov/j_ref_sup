package std_input_demos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SimpleConsoleReader {

    public static void main(String[] args) {
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        String input;
        System.out.println("Basic input demo. Provide zero input for finishing the program");
        // trying to read non-zero inputs and trying to convert them to String
        boolean flag = true;
        while (flag){
            try {
                input = stdin.readLine().toString(); // conversion of input to String
                if (input.length() > 0){
                    // System.out.println("Read: " + input);
                    try{
                        int read = Integer.parseInt(input);
                        System.out.println("Input read as the int value: " + read);
                        continue;
                    } catch (NumberFormatException exception) { }
                    try {
                        double read = Double.parseDouble(input);
                        System.out.println("Input read as the double value: " + read);
                        continue;
                    } catch (NumberFormatException exception) { }
                    System.out.println("Read should be a string: " + input);

                } else {
                    System.out.println("Reading of inputs ends because of the zero input");
                    flag = false;
                }
            } catch (IOException e){
                System.out.println("Reading of inputs ends because of an input error");
                flag = false;
            }
        }


    }
}
