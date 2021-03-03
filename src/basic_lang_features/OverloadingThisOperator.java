package basic_lang_features;

/**
 * Demonstration of a simple overloading of constructor using "this" operator
 */
public class OverloadingThisOperator {
    // some intrinsic parameters
    int x, y; String description;

    // some complex default constructor
    OverloadingThisOperator(int x, int y, String description){
        this.x = x;
        this.y = y;
        this.description = description;
    }

    // overloaded construction referred to above complex constructor
    OverloadingThisOperator(int equalParameters, String description){
        this(equalParameters, equalParameters, description);
    }

    // simplified constructor with some default values when no input parameters provided
    OverloadingThisOperator(){
        this(0, 0, "No description");
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getDescription() {
        return description;
    }

    // self-test of implementation
    public static void main(String[] args) {
        OverloadingThisOperator fullConstructor = new OverloadingThisOperator(1, 1, "Full");
        OverloadingThisOperator partialConstructor = new OverloadingThisOperator(2, "Partial");
        OverloadingThisOperator shortenedConstr = new OverloadingThisOperator();
        System.out.println("Default class parameters: " + shortenedConstr.getX() +
                "," + shortenedConstr.getY() + "," + shortenedConstr.getDescription());
    }
}
