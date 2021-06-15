package string_demos;

/**
 * Simple demonstration of toString() overwriting
 */
public class MeaningfulClass {
    private String description;

    MeaningfulClass(String description){
        this.description = description;
    }

    public String toString(){
        String class_description;
        class_description = "The instance of this class was initialized with following description: \n" +
                this.description;
        return  class_description;
    }
}
