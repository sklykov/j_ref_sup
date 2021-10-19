package io_demos;

import java.io.IOException;
import java.nio.file.*;

public class NIOpCopyFile {

    // demo of nio copy functionality usage
    public static void main(String[] args) {
        // Path's below don't demand using try clause, but it's recommended in Java Ref.
        try{
            // firstly, it's necessary to make root path to project
            Path root = Paths.get("").toAbsolutePath();
            String rootPath = root.toString();
            System.out.println(rootPath); // !!!: still, rootPath is resolved only up to the main project folder, not package one
            String commonProjectRoot = "src";
            String packageFolder = NIOpCopyFile.class.getPackage().getName().toString();
            // secondly, make a copy using Path
            Path source = Paths.get(rootPath, commonProjectRoot, packageFolder, "test.txt");
            Path target = Paths.get(rootPath, commonProjectRoot, packageFolder, "test_copy.txt");
            Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
        } catch (InvalidPathException e) {e.printStackTrace();}
        catch (IOException e) {e.printStackTrace();}

    }
}
