package io_demos;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class CharacterReaderWriter {

    public static void main(String[] args) {
        // demo of using FileReader and FileWriter
        // building path to a file
        String rootPath = System.getProperty("user.dir");
        String pathDelimiter = System.getProperty("file.separator");
        String packageName = CharacterReaderWriter.class.getPackage().getName();
        String textFilePath = rootPath + pathDelimiter + "src" + pathDelimiter + packageName + pathDelimiter + "test.txt";
        String textFilePath2 = rootPath + pathDelimiter + "src" + pathDelimiter + packageName + pathDelimiter + "test2.txt";
        // generation of some data (floating-point values)
        double[] values = new double[10];
        for (int i = 0; i < values.length; i++){
            values[i] = (i+1)*0.05;
        }
        char delimiter = ' ';  // for placing between values

        // writing to a temporal file - !!! - use try-with-resources for proper writing to a file
        // writing each single character to a file
        try(FileWriter textWriter = new FileWriter(textFilePath)){
            for(int i = 0; i < values.length; i++){
                String number = Double.toString(values[i]);
                if (number.length() > 3){
                    number = number.substring(0, 4);
                }
                textWriter.write(number);
                // 3 whitespaces for a number like 0.1 and 2 whitespaces for a number like 0.05
                if (number.length() == 3){
                    textWriter.write(delimiter); textWriter.write(delimiter); textWriter.write(delimiter);
                } else {
                    textWriter.write(delimiter); textWriter.write(delimiter);
                }
                if (i == ((values.length / 2) - 1)){
                    textWriter.write('\n');
                }
            }
        } catch (IOException e) { e.printStackTrace();}

        // generation of additional values
        for (int i = 0; i < values.length; i++){
            values[i] = (i+1)*0.25;
        }

        // writing some string line by line by using BufferedWriter
        try(BufferedWriter bufferedFileWriter = new BufferedWriter(new FileWriter(textFilePath2))){
            // lines writing
            int j = 1;
            while (j <= values.length / (values.length / 2)){
                StringBuilder stringBuilder = new StringBuilder();
                for (int i = ((values.length / 2)*(j-1)); i < (values.length / 2)*j; i++){
                    String number = Double.toString(values[i]);
                    if (number.length() > 3){
                        number = number.substring(0, 4);
                    }
                    stringBuilder.append(number);
                    if (number.length() == 3){
                        stringBuilder.append(delimiter); stringBuilder.append(delimiter); stringBuilder.append(delimiter);
                    } else {
                        stringBuilder.append(delimiter); stringBuilder.append(delimiter);
                    }
                }
                String toWrite = new String(stringBuilder);
                bufferedFileWriter.write(toWrite);
                bufferedFileWriter.newLine();
                j++;
            }
        } catch (IOException e) {e.printStackTrace();}

        // reading chars or String from a file - it's too low because it reads only single chars or some char buffer with some size
        try(FileReader textReader = new FileReader(textFilePath)){
            int readChar;
            ArrayList<Character> readChars = new ArrayList<>();
            while((readChar = textReader.read()) != -1){
                // System.out.println((char) readChar);
                // again, some initial knowledge should be about how the numbers stored for low level char reading
                // this read feature is really low level - reading only stable character
                readChars.add(((char) readChar));
            }
            // System.out.println(readChars); // Represents all read characters as ArrayList<Character>
        } catch (FileNotFoundException e) {System.out.println("File not found on the specified path!");
        } catch (IOException e) { e.printStackTrace();}

        // reading the information from txt file line by line by using BufferedReader
        try(BufferedReader textReader = new BufferedReader(new FileReader(textFilePath))){
            String readLine;
            while ((readLine = textReader.readLine()) != null){
                System.out.println(readLine);
            }
        } catch (FileNotFoundException e) {System.out.println("File not found on the specified path!");
        } catch (IOException e) {e.printStackTrace();}

        // reading text information from a temporal file line by line using Scanner
        System.out.println("Reading another text file: ");
        try (Scanner scanner = new Scanner(new FileReader(textFilePath2))){
            String readLine;
            while(scanner.hasNextLine()){
                readLine = scanner.nextLine();
                System.out.println(readLine);
            }
        } catch (FileNotFoundException e) { e.printStackTrace();}
    }
}
