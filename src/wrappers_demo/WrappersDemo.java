package wrappers_demo;

public class WrappersDemo {

    public static void main(String[] args) {
        // definition of constants
        // experimentally defining allowance for digits after point
        double d = 1.000_000_000_000_000_1;  // will be interpreted as 1.0
        double a = 1.000_000_000_000_000_2; // 2 will be saved, see print statements
        String number = "1.0000000000000002";
        String anotherNumber = "1,000000000000001"; // cause the error in constructor of class Double
        String warning = "Incorrect precision comparison";
        // various constructors
        Double d2 = new Double(d);
        Double numberD = new Double(number);
        double d3 = Double.parseDouble(number);
        Double anotherNumberD;
        try{
            anotherNumberD = new Double(anotherNumber);

        } catch(NumberFormatException e){
            System.out.println("Comma as separator in float number has not been parsed!");
            System.out.println("float number as #,# will exchanged to format like #.# ");
            anotherNumber = anotherNumber.replace(",", ".");
            anotherNumberD = new Double(anotherNumber);
        }

        // checking comparison abilities
        System.out.println("no more than 12 digits allowed, see definition and that is printed: " + d);
        System.out.println("12 digits but 2 in the end: " + a);
        if (d2 == d3){
            System.out.println(warning);
        }
        System.out.println("Comparison values are:");
        System.out.println(numberD + " and " + anotherNumberD);
        switch(numberD.compareTo(anotherNumberD)){
            case 0:
                System.out.println(warning); break;
            case 1:
                System.out.println("First value is larger"); break;
            case 2:
                System.out.println("Second value is larger"); break;
        }

        // interestingly, no exception in Double class for division by zero, returning special value - infinity
        Double inf = new Double(1.0/0.0);
        System.out.println(inf.isInfinite() + " " + inf);

        // conversions of numbers to different radixes
        Integer convert = new Integer(20);
        System.out.println("20 as binary #: " + convert.toBinaryString(convert.intValue()));
        System.out.println("20 as hexadecimal #: " + Integer.toHexString(convert.intValue()));
        System.out.println("20 as octal #: " + Integer.toOctalString((convert.intValue())));

    }
}
