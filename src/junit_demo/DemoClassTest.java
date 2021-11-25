package junit_demo;

import org.junit.Test;

import static org.junit.Assert.*;

// Only for simple demo of junit package capabilities
public class DemoClassTest {
    private DemoClass demoClass;

    @org.junit.BeforeClass
    public static void performOnceAtStart(){
        System.out.println("This method is performed once, before any testing method below (e.g. for reading resource)");
        System.out.println("******************************************************************************************");
    }

    @org.junit.Before
    public void initialize(){
        // initialized for each running test method
        demoClass = new DemoClass(1, -1, "Initial class");
    }

    @org.junit.Test
    public void increasePositiveID_consistencyTest() {
        demoClass.increasePositiveID(1);
        demoClass.decreaseNegativeID(-2);
        System.out.println(demoClass.getNegativeID() +  " = Negative ID is decreased for checking that Before annotation creates " +
                "for each test method the class sample. \n If it's not true, then the test for negativeID should fail ");
        // !!! SIMPLE BUT IMPORTANT (maybe, again): conversion of primitive values without casting, methods, etc.
        double positiveID = demoClass.getPositiveID();
        assertEquals(2.0, positiveID, 0.1);
    }

    @org.junit.Test
    public void decreaseNegativeID_consistencyTest() {
        demoClass.decreaseNegativeID(-1);
        assertEquals(-2, demoClass.getNegativeID(), 0.1);
    }

    // Catching expected exception
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void wrongInitPositiveID_test(){
        new DemoClass(0, -1, "some descriptor"); // will from an exception
    }

    // Another way to catch expected exception for testing
    @org.junit.Test
    public void wrongInitNegativeID_test(){
        try {
            new DemoClass(1, 1, "some descriptor");
            // if there is no exception thrown then the test should fail!
            fail("Wrong negative ID not causing IllegalArgumentException");
        } catch (IllegalArgumentException e){
            System.out.println("Test with negative ID initialization has been passed!");
        }
    }

    @org.junit.AfterClass
    public static void performedOnceAfterAllMethods(){
        System.out.println("*************************************");
        System.out.println("This method is called for cleaning up");
    }
}