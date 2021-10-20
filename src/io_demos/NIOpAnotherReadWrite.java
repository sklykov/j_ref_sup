package io_demos;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.List;

public class NIOpAnotherReadWrite {
    // another way to read lines from some text file using nio classes (Files, Path, Paths)
    public static void main(String[] args) {
        Path root = FileSystems.getDefault().getPath(""); // this again is similar to System.getProperty("user.dir")
        System.out.println("Root project path: " + root.toAbsolutePath());
        // Get the actual path to package folder by using AbsolutePathBuilder
        NIOpAnotherReadWrite thisInstance = new NIOpAnotherReadWrite();
        String projectPath = AbsolutePathBuilder.buildAbsPath(thisInstance);
        // getting actual path to the test2.txt
        Path filePath = Paths.get(projectPath, "test3.txt");

        // create and write or append to a file using Files methods
        if (!filePath.toFile().exists()){
            // txt file doesn't exist on the time of call
            try {
                Files.createFile(filePath);
                Files.write(filePath, "first run - first line \n".getBytes(StandardCharsets.UTF_8));
            } catch (IOException e) {e.printStackTrace();}
        } else {
            try {
                List<String> alreadyExistLines = Files.readAllLines(filePath);
                if (alreadyExistLines.size() < 3){
                    // the lines will be appended to the existing lines in the file
                    Files.write(filePath, "another test run - another line \n".getBytes(StandardCharsets.UTF_8), StandardOpenOption.APPEND);
                }
            } catch (IOException e) {e.printStackTrace();}
        }

        // another way to read all lines from a text file (!!!: encoded using UTF-8 Charset)
        try {
            List<String> readLines = Files.readAllLines(filePath);
            for(String singleLine: readLines){
                System.out.println(singleLine);
            }
        } catch (IOException e) {e.printStackTrace();}
    }
}
