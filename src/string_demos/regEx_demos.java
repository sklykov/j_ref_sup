package string_demos;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class regEx_demos {
    public static void main(String[] args) {
        String example = "The example: 0, 1, 3.14, 2.721828, 98, 100,  8.67, 102, 5.6, -99, -1, -1.01, 2.60, 1.71 ";
        // the task - to test regular expression for selection of values 0-99 with no more than 2 digits
        // tested partially on the website: regex101.com
        Pattern pattern = Pattern.compile("(?:[^-\\.]\\b(([1-9]\\d)|(\\d)|(\\d?\\d\\.\\d?[1-9]))[^\\.\\d])");
        // Brief explanation: \\d - matches any digit, \\d? - limits to zero or one occurrence of digit, \\. - matches dot,
        // the \\b - limits the searching (consecutive number) or means that there is the border
        // !!!: In comparison to Python code: Python removes the end delimiter (here is comma) from found numbers
        Matcher matcher = pattern.matcher(example);
        // trying to utilize possibilities of numbers auto-conversion
        ArrayList<Double> foundNumbers = new ArrayList<>();
        Double n;
        String str;
        while (matcher.find()){
            System.out.println("Match: " + matcher.group());
            str = matcher.group();
            str = str.replace(",", "");
            System.out.println("Match: " + str);
            n = Double.parseDouble(str); // attempt to parse found double number
            foundNumbers.add(n);
        }
        System.out.println();
        // printing out found numbers using regex above
        for (Double i: foundNumbers){
            System.out.print(i + " ");
        }
    }
}
