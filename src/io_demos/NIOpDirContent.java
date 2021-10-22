package io_demos;

import java.io.IOException;
import java.nio.file.*;

public class NIOpDirContent {
    // demo of reading and returning of directory content
    public static void main(String[] args) {
        NIOpDirContent thisClassInstance = new NIOpDirContent();
        String packagePath = AbsolutePathBuilder.buildAbsPath(thisClassInstance);
        Path packageDirectory = Paths.get(packagePath);

        // list content of I/O package directory ended with txt using 'glob' - "*.txt"
        if (Files.isDirectory(packageDirectory)){
            try(DirectoryStream<Path> content = Files.newDirectoryStream(packageDirectory, "*.txt")){
                System.out.print("All *txt files: ");
                for(Path file: content){ System.out.print(file.getFileName() + "; ");}
                System.out.println();
            } catch (IOException | DirectoryIteratorException e) {e.printStackTrace();} // last exception recommended to catch
        }

        // list content of I/O package directory after applying filter
        // 'filter' is interface with only single method 'accept' that should be implemented => nice and elegant
        // to implement it by using lambda function
        DirectoryStream.Filter<Path> isDirectory = f -> Files.isDirectory(f);
        // another way - to explicitly implement this interface
        DirectoryStream.Filter<Path> isReadable = new DirectoryStream.Filter<Path>() {
            @Override
            public boolean accept(Path entry) throws IOException {return Files.isReadable(entry);}
        };
        // printing out all subdirectories of package folder
        try(DirectoryStream<Path> content = Files.newDirectoryStream(packageDirectory, isDirectory)){
            for(Path file: content){
                System.out.println(file.getFileName() + " is a subdirectory");
            }
        } catch (IOException e) {e.printStackTrace();}
        // printing out all readable files
        try(DirectoryStream<Path> content = Files.newDirectoryStream(packageDirectory, isReadable)){
            System.out.print("Readable files: ");
            int i = 0;
            for(Path file: content){
                System.out.print(file.getFileName() + "; ");
                i++;
                if (i == 7) System.out.println();
            }
        } catch (IOException e) {e.printStackTrace();}
    }
}
