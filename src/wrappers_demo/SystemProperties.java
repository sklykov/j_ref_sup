package wrappers_demo;

public class SystemProperties {
    public static void main(String[] args) {
        // demonstration of how to get some useful properties for making program aware about OS properties
        String osName = System.getProperty("os.name");
        String osVer = System.getProperty("os.version");
        System.out.println("I am running on the " + osName + " version " + osVer);
        System.out.println("Specific file separator: " + System.getProperty("file.separator"));
        System.out.println("Path to the working directory: " + System.getProperty("user.dir"));
    }
}
