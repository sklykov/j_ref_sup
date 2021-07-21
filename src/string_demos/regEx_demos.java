package string_demos;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class regEx_demos {
    public static void main(String[] args) {
        String example = " This is the example string for testing a few (1-10) regular expressions: " +
                "0, 1, 3.14, 2.721828, 98, 100,  8.67, 102, 5.6, -99, -1, -1.01, 2.60";
        // the task - to test regular expression for selection of values 0-99 with no more than 2 digits
        // tested partially on the website: regex101.com
        Pattern pattern = Pattern.compile("(\\d?\\.+\\d?\\d\\b)|(\\b[1-9]\\d\\b)|(\\b^-\\d\\b)"); // still to fix: find -99 and 2.60
        // Brief explanation: \\d - matches any digit, \\d? - limits to zero or one occurrence of digit, \\. - matches dot,
        // the \\b - limits the searching (consecutive number) or means that there is the border
        Matcher matcher = pattern.matcher(example);
        while (matcher.find()){
            System.out.println("Match: " + matcher.group());
        }
    }
}
