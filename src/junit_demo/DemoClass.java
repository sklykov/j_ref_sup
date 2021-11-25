package junit_demo;

// some abstract class for performing tests on that
public class DemoClass {
    private int positiveID;
    private int negativeID;
    private String descriptor;

    DemoClass(int positiveID, int negativeID, String descriptor){
        if (positiveID <= 0){
            throw new IllegalArgumentException("Initial positive ID is not positive number");
        }
        this.positiveID = positiveID;
        if (negativeID >= 0){
            throw new IllegalArgumentException("Initial positive ID is not positive number");
        }
        this.negativeID = negativeID;
        if (descriptor.length() == 0){
            throw new IllegalArgumentException("Provided descriptor is empty");
        }
        this.descriptor = descriptor;
    }

    public void increasePositiveID(int additionalAmount){
        this.positiveID += additionalAmount;
    }

    public void decreaseNegativeID(int additionalAmount) {
        this.negativeID += additionalAmount;
    }

    public int getNegativeID() {
        return negativeID;
    }

    public int getPositiveID() {
        return positiveID;
    }

    public String getDescriptor() {
        return descriptor;
    }

}
