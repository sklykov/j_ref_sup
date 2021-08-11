package basic_lang_features;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Model implementation of complex numbers to demonstrate some features of writing code.
 */
public class ComplexNumber {
    private double real;
    private double imaginary;

    ComplexNumber(double real, double imaginary){
        this.imaginary = imaginary; this.real = real;
    }

    /**
     * The constrictor trying to parse input string supposing that it specifies complex number
     * @param str:
     *           Input string in the form "1 + 2.5j"
     */
    ComplexNumber(String str){
        str = str.toLowerCase();
        System.out.println("Input string: " + str);
        boolean initialized = false;
        char startChar = str.charAt(0); char endChar = str.charAt(str.length()-1); char whiteSpace = ' ';
        // adding whitespace to the start and end of the string for simplifying its parsing
        if (startChar != whiteSpace) str = " " + str;
        if (endChar != whiteSpace) str = str + " ";
        // searching for complex part
        Pattern pattern = Pattern.compile("([^\\.]\\dj)|(\\d+\\.\\d+j)|(-\\d+\\.\\d+j)");
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()){
            String imaginePart = matcher.group();
            str = str.replaceAll(imaginePart,""); // remove found imaginary part from input string
            // System.out.println("W/t imaginary part: " + str);
            // removing all redundant characters from found string
            imaginePart = imaginePart.replace("+", ""); // remove plus sign
            imaginePart = imaginePart.replace(" ", ""); // remove white spaces
            imaginePart = imaginePart.replace("j","");  // remove j sign
            // System.out.println("Parsed imagine part: " + imaginePart);
            try{
                this.imaginary = Double.parseDouble(imaginePart);
                initialized = true;
            } catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
        // if any other double value found without "j" then the IllegalArgumentException will be thrown
        if (matcher.find()){
            throw new IllegalArgumentException("More than 1 number supposed to be imaginary part found in the input string");
        }

        // searching for real part
        pattern = Pattern.compile("(-?\\d+\\.\\d+)|(-?\\d+[^\\.])");
        matcher = pattern.matcher(str);
        if (matcher.find()){
            String realPart = matcher.group();
            // removing all redundant characters from found string
            realPart = realPart.replace("+", ""); // remove plus sign
            realPart = realPart.replace(" ", ""); // remove white spaces
            realPart = realPart.replace("j","");  // remove j sign
            // System.out.println("Parsed real part: " + realPart);
            try{
                this.real = Double.parseDouble(realPart);
                initialized = true;
            } catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
        // if any other double value found without "j" then the IllegalArgumentException will be thrown
        if (matcher.find()){
            throw new IllegalArgumentException("More than 1 number supposed to be real part found in the input string");
        }

        // reporting that all numbers parsed and complex number parsed into real and imaginary part
        char sign = this.imaginary < 0.0? '-': '+';
        if (initialized) {
            System.out.println("The Complex number initialized: " + this.real + sign + Math.abs(this.imaginary) + "j");
        } else throw new IllegalArgumentException("Provided string either contains no complex number, or it can't be parsed");
    }

    @Override
    public String toString(){
        char sign = this.imaginary < 0.0? '-': '+';
        String realN = Double.toString(this.real);
        String imaginaryN = Double.toString(Math.abs(this.imaginary));
        String result = realN + sign + imaginaryN + "j";
        return result;
    }

    public double getReal() {
        return real;
    }

    public double getImaginary() {
        return imaginary;
    }

    public ComplexNumber add(ComplexNumber cn){
        double real = this.real + cn.getReal();
        double imaginary = this.imaginary + cn.getImaginary();
        ComplexNumber result = new ComplexNumber(real, imaginary);
        return result;
    }

    public void add(double realPart, double imaginaryPart){
        this.real += realPart;
        this.imaginary += imaginaryPart;
    }
}
