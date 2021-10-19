package io_demos;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

public class NIOpFIleAttributes {

    // demonstration of file attributes checking
    public static void main(String[] args) {
        NIOpFIleAttributes thisInstance = new NIOpFIleAttributes();
        String rootPath = AbsolutePathBuilder.buildAbsPath(thisInstance);
        Path testFile = Paths.get(rootPath, "test.txt");
        // !!!: the creation of attributes below is according to the documentation and Java Ref.
        try {
            BasicFileAttributes attributes = Files.readAttributes(testFile, BasicFileAttributes.class);
            System.out.println("Size of test.txt in bytes: " + attributes.size());
            System.out.println("Last modification at: " + attributes.lastModifiedTime());
        } catch (IOException e) {e.printStackTrace();}

    }
}
