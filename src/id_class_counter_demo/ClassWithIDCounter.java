package id_class_counter_demo;


// demo for using modifiers to account # of instances created
public class ClassWithIDCounter {
    private String description;
    private static int classCounter = 0;
    private final int instanceCounter; // not initialized, but final counter, used along with static value
    ClassWithIDCounter(String description){
        this.description = description;
        classCounter++; // !!!: static variable can be increased
        instanceCounter = classCounter; // some necessary trick to store counter for the class in final parameter
        System.out.println("Class " + description + " created accounted as # " + instanceCounter);
    }

    public int getInstanceCounter() {
        return instanceCounter;
    }
}
