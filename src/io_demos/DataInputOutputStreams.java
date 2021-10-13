package io_demos;

import java.io.*;

public class DataInputOutputStreams {
    // demo of usage of DataInputStream and DataOutputStream classes
    public static void main(String[] args) {
        File root = new File(""); // another variant to get path to the whole project
        System.out.println("The root path of the project: " + root.getAbsolutePath()); // another way of getting it
        String packageName = DataInputOutputStreams.class.getPackage().getName(); // getting name of current package
        // System.out.println("Current package name: " + packageName);
        String delimiter = System.getProperty("file.separator");
        // Below - building the entire path to the package folder containing this class file
        String pathToActualPackage = root.getAbsolutePath()+ delimiter + "src" + delimiter + packageName;
        System.out.println("The working directory (package folder): " + pathToActualPackage);
        File packageFolder = new File(pathToActualPackage);
        // Creation of temporal file for I/O operations
        if (packageFolder.isDirectory()){
            File binaryFile = new File(packageFolder, "binaryDataFile.dat");
            if (!binaryFile.exists()){
                try {
                    binaryFile.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            int a = 1; double d = 1.1; boolean flag = true;
            // writing above stated values to the temporal file
            try(DataOutputStream dataOutput = new DataOutputStream(new FileOutputStream(binaryFile))){
                  dataOutput.writeDouble(d);
                  dataOutput.writeChar(' ');
                  dataOutput.writeInt(a);
                  dataOutput.writeChar(' ');
                  dataOutput.writeBoolean(flag);
            } catch (FileNotFoundException e) {System.out.println("File not found!");;
            } catch (IOException e) { e.printStackTrace();}

            // reading stored values in a file
            try(DataInputStream dataInput = new DataInputStream(new FileInputStream(binaryFile))){
                // below two commented out lines - possible way to read all bytes, if the coding scheme is unknown
                /* byte wholeLine[] = new byte[10];
                dataInput.readFully(wholeLine);*/
                // Assume that a developer knows which types of values recorded in the temporal binary file
                double readD; int readInt; boolean readFlag; char readDelimiter;
                readD = dataInput.readDouble();
                readDelimiter = dataInput.readChar();
                readInt = dataInput.readInt();
                readDelimiter = dataInput.readChar(); // for moving reading pointer further (could be skipped by the method)
                readFlag = dataInput.readBoolean();
                System.out.println("Read values: " + readD + readDelimiter + readInt + readDelimiter + readFlag);
            } catch (FileNotFoundException e) { System.out.println("File not found!");
            } catch (IOException e) {e.printStackTrace();}

            // delay for fast inspection of made file
            try {
                Thread.sleep(0_000);
            } catch (InterruptedException e) { e.printStackTrace();}

            // cleaning up created binary temporal file
            if (binaryFile.exists()){
                if (binaryFile.delete()) System.out.println("Temporal file is cleaned up (removed)");
            }
        }
    }
}
