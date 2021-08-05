package annotation_demo;

// the annotation is used in its generic form for store some details about the class
@ClassUniqueParam(id=1, description = "Simple annotated class")
public class AnnotatedClass {

    // annotated field - can be used further
    @FieldKey(key = "class info")
    private String info;

    AnnotatedClass(String info){
        this.info = info;
    }

    public static void main(String[] args) {
        AnnotatedClass example = new AnnotatedClass("Created");
        // it's possible to extract the recorded values in the annotation, but I don't see any reason to store it here
        // Obtaining and processing of annotated types (classes), methods, fields is possible by using
        // Java Reflection API. Refer to in the need.
    }
}
