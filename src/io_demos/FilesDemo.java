package io_demos;

import java.io.File;

public class FilesDemo {

    public static void main(String[] args) {
        // Testing some features of java.io.File class
        String projectPath = System.getProperty("user.dir");
        System.out.println(projectPath);
        File projectDirectory = new File(projectPath); // retains path to the project directory
        if (projectDirectory.isDirectory()){
            String[] allEntities = projectDirectory.list();
            // list of subdirectories in the project (packages)
            System.out.print("The list of subdirectories: ");
            for (String entity:allEntities) {
                File subFile = new File(projectPath + "/" + entity);
                if (subFile.isDirectory()){
                    System.out.print(entity + ", ");
                }
            }
            System.out.println();
            System.out.print("The list of files: ");
            for (String entity:allEntities) {
                File subFile = new File(projectPath + "/" + entity);
                if (subFile.isFile()){
                    System.out.print(entity + ", ");
                }
            }
        }

    }
}
