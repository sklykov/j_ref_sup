package annotation_demo;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// only the simplest case considered - as descriptive annotation for the class
// the interface implies using only abstract methods without bodies
@Target(ElementType.TYPE) // can be applied to class, interface
@Retention(RetentionPolicy.RUNTIME)  // available at the runtime
public @interface ClassUniqueParam {
    int id() default 0;  //some unique identifier
    String description() default "None";
}