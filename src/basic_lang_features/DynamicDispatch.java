package basic_lang_features;

public class DynamicDispatch {

    public static void main(String[] args) {
        // Demonstration of concepts of dynamic dispatch on few classes
        Parent pr = new Child();  // reference of parent could accept child class instance
        System.out.println("Parent class reference holding Child class attributes: " + pr.getDescription());

        Child child = new Child();
        System.out.println("Child class could "+ child.getSpecificValue());
        pr.exchangeSpecificValue(); // Child class could perform methods of its parent
        System.out.println("Parent exchanged specific value: " + child.getSpecificValue());
        // same applicable for instance pr

        // another experiment - exchanging references between Parent and Child
        Parent parent = new Parent();
        parent.finalExchanger(); // possible for Parent instance
        System.out.println("Still description belongs to Parent: " + parent.getDescription());
        // child = parent; // illegal operation,
        parent = child; // legal operation - exchanging references
        // after exchanging of reference, only the Child class methods are available:
        parent.finalExchanger();
        System.out.println("After exchanging: " + parent.getDescription());



    }
}
