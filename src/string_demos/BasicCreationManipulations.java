package string_demos;

public class BasicCreationManipulations {

    /**
     * Print out to the standard output all created strings below.
     * @param strings : strings to print out
     */
    public static void printAll(String[] strings){
        int index = 1;
        for(String str: strings){
            if(str.length() > 0) {
                System.out.println("string #" + index + ": " + str);
                index++;
            }
            else{
                break;  // stop attempts to print out the content of input strings
            }
        }
    }


    public static void main(String[] args) {
        // Various way of String initialization / creation
        String[] initializedStrings = new String[20]; // holding of constructed below strings
        for(int i = 0; i < initializedStrings.length; i++){
            initializedStrings[i] = new String();
        }
        int count = 0;

        // 1 - the simplest
        String str1 = new String("simplest constructor");
        initializedStrings[count] = str1; count++;

        // 2 - from char arrays
        char[] chars = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i'};
        String str2 = new String(chars);
        initializedStrings[count] = str2; count++;
        // 2.1 - with specification of starting index length
        int startingIndex = 3; int length = 3;
        String str3 = new String(chars, startingIndex, length);
        initializedStrings[count] = str3; count++;

        // 3 - from ASCII and Unicode characters sets (standards)
        byte[] chars_ASC = {65, 66, 67, 68, 69, 70, 71, 72, 73};
        String str4 = new String(chars_ASC);
        initializedStrings[count] = str4; count++;
        // Unicode values in decimal form should be specified as char array below, no int or short!
        char[] chars_Unicode = {1072, 1073, 1074, 1075, 1076, 1077, 1078, 1079};
        String str5 =   new String(chars_Unicode);
        initializedStrings[count] = str5; count++;
        // Another Unicode example
        char[] chars_Unicode2 = {'\u03B1', '\u03B2', '\u03B3', '\u03B4', '\u03B5'};
        String str6 =   new String(chars_Unicode2);
        initializedStrings[count] = str6; count++;

        // observing the results of initialization / manipulations
        printAll(initializedStrings);

        // toString() of some class using
        MeaningfulClass sample = new MeaningfulClass("Automatic conversion to String");
        System.out.println(sample);

        // simple comparison of strings
        System.out.println("str2 equals to str4?: " + str2.equals(str4));
        System.out.println("str2 equals (ignore case) to str4?: " + str2.equalsIgnoreCase(str4));
        // important note: avoid wrong using of equals() and ==
        String str7 = "abcdefghi";
        initializedStrings[count] = str7; count++;
        System.out.println("Comparing characters only of str2 and str7: " + str2.equals(str7));
        System.out.println("Wrong usage of equal operator '==' : " + (str2 == str7));

        // a few useful operators
        String str8 = "  Here is  too many      white       spaces in    original    string     ";
        str8 = str8.trim();  // removing trailing white-spaces
        count = 0; CharSequence spacebars = "  ";
        // removing wrong distributions of spaces
        while (count <= 5){
            str8 = str8.replace(spacebars, " ");
            count++;
            //spacebars += " ";
        }
        System.out.println(str8);

        // StringBuffer and StringBuilder - synchronized and non-synchronized mutable strings
        StringBuffer sbfer = new StringBuffer("This is test for StringBuffer and StringBuilder");
        StringBuilder sbder = new StringBuilder(sbfer);
        System.out.println("buffer length and capacity: " + sbfer.length() + ", " + sbfer.capacity());
        System.out.println("builder length and capacity: " + sbder.length() + ", " + sbder.capacity());
        // cut out redundant words - working on the StringBuffer and StringBuilder strings
        int startCut = sbder.indexOf("a");  // position of 'a' character
        startCut -= 1;
        sbfer.delete(startCut, sbfer.length());
        sbfer.append(" + StrBuff appender");
        System.out.println(sbfer);
        int endCut = startCut + 4;
        startCut = sbder.indexOf("r");  // position of 'f' character
        sbder.delete(startCut + 1, endCut);
        sbder.append(" + ending appender");
        System.out.println(sbder);

    }
}
