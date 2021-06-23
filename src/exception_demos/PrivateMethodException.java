package exception_demos;

public class PrivateMethodException {

    /**
     * Note(!): the private method (and with package access modifier) not necessary specifies explicitly that they
     * may throw some exception.
     * @param param: int parameter, that cannot be zero
      */
    private static void checkApplicability(int param){
        if (param == 0) {
            throw new IllegalArgumentException("Parameter " + param + " is illegal");
        }
    }

    public static void main(String[] args) {
        // Demo of working with private method
        int a[] = {1, 3, 4, 6, 0, 10, 11, 2};
        System.out.println("The initial array: ");
        for (int arrayEl: a){
            System.out.print(arrayEl + " ");
        }
        System.out.println();
        System.out.println("The processed by the method checkApplicability array: ");
        for (int arrayEl: a){
            try{
                checkApplicability(arrayEl);
                System.out.print(arrayEl + " ");
            } catch (IllegalArgumentException e){
                System.out.print(". ");
            }
        }
    }
}
