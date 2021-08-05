package id_class_counter_demo;

public class ExtenderOfClassWithCounter extends ClassWithIDCounter{
    private static int extenderClassesCounter = 0;
    private final int extenderCounters;
    ExtenderOfClassWithCounter(String description) {
        super(description);
        extenderClassesCounter++;
        extenderCounters = extenderClassesCounter;
        System.out.println("This is extender class accounted as # " + extenderCounters + " between extender classes");
    }

    public int getExtenderCounters() {
        return extenderCounters;
    }
}
