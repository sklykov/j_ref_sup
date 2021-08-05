package id_class_counter_demo;

public class TestClassesCreation {
    public static void main(String[] args) {
        ClassWithIDCounter cls1 = new ClassWithIDCounter("1st basis");
        ExtenderOfClassWithCounter extCls1 = new ExtenderOfClassWithCounter("1st extender");
        ClassWithIDCounter cls2 = new ExtenderOfClassWithCounter("2nd extender");
    }
}
