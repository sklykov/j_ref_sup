package io_demos;

import java.io.File;
import java.nio.file.FileSystems;

public class GetFilesInPathSeparator {

    // 3 ways to get separators for building path
    public static void main(String[] args) {
        String separator1 = File.separator;
        String separator2 = FileSystems.getDefault().getSeparator();
        String separator3 = System.getProperty("file.separator");
        System.out.println("Collected separators: " + separator1 + " " + separator2 + " " + separator3);
    }
}
