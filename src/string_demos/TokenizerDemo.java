package string_demos;

import java.util.StringTokenizer;

public class TokenizerDemo {

    public static void main(String[] args) {
        // small demo of useful tokenizer capabilities:
        String numbers = "1, 2, 3, 4, 5, 6, 7";
        // extract all numbers by applying tokenizer
        StringTokenizer stringTokenizer = new StringTokenizer(numbers, ",");
        System.out.print(numbers + " => tokenized as individual numbers: ");
        while (stringTokenizer.hasMoreTokens()){
            System.out.print(stringTokenizer.nextToken() + " ");
        }
    }
}
