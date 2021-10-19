package io_demos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.*;

public class NIOpReadWrite {
    // Demonstration of Files class capabilities in providing BufferedWriter and BufferedReader
    // Note that there also available classes Input/OutputStream for bytes handling
    public static void main(String[] args) {
        NIOpReadWrite thisInstance = new NIOpReadWrite();
        String packagePath = AbsolutePathBuilder.buildAbsPath(thisInstance);
        Path path = Paths.get(packagePath,"test_copy.txt");
        System.out.println("Path to the target file: " + path.toAbsolutePath());

        // !!!: take a look, that the "append" open option should be specified explicitly for providing such behaviour
        try (BufferedWriter writer = Files.newBufferedWriter(path, StandardOpenOption.APPEND);
             BufferedReader checker = Files.newBufferedReader(path))
        {
            // for preventing of appending the same text lin on each testing run of this class
            if (checker.lines().toArray().length == 2){
                String toWrite =  "Actual work on copy of the test.txt file";
                writer.append("\n");
                writer.append(toWrite);
            }
        }
        catch (IOException e) {e.printStackTrace();}

        // !!!: check below elegant way to read file with characters line-by-line in a loop
        try(BufferedReader reader = Files.newBufferedReader(path)){
            // another elegant way to read file w/t knowledge of how many lines in it
            while (reader.ready()){
                System.out.println(reader.readLine());
            }

        } catch (IOException e) {e.printStackTrace();}
    }
}
