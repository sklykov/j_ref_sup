package io_demos;

public class AbsolutePathBuilder {

    /**
     * This function calculates absolute path to project path there is specified in argument calling class is located.
     * Presumption: the calling class is located in the same project folder as this class' method.
     * @param o:
     *         Instance of the class
     * @return String - absolute path to the specified class (including actual package folder)
     */
    public static String buildAbsPath(Object o){
        String objectPackage = o.getClass().getPackage().getName().toString();
        String rootProjectPath = System.getProperty("user.dir");
        String commonProjectEntry = "src";
        String pathSeparator = System.getProperty("file.separator");
        return rootProjectPath + pathSeparator + commonProjectEntry + pathSeparator + objectPackage;
    }

    public static void main(String[] args) {
        // testing implemented above function
        AbsolutePathBuilder absolutePathBuilder = new AbsolutePathBuilder();
        System.out.println(AbsolutePathBuilder.buildAbsPath(absolutePathBuilder));
    }
}
