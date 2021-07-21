package exception_demos;

public class ChainedExceptions {

    /**
     * Prints input array as single string
     * @param a - int[] array
     * @throws Exception - generic exception that encapsulates of reasons it's thrown (use getClause())
     */
    public static void printArray(int[] a) throws Exception {
        Exception classSpecificException = new Exception("Specific exception of printArray method");
        if (a.length == 0){
            classSpecificException.initCause(new ArrayIndexOutOfBoundsException("Zero length array specified"));
            throw classSpecificException;
        }
        else if (a.length > 100){
            classSpecificException.initCause(new UnsupportedOperationException(
                    "Too many elements requested to be printed"));
            throw classSpecificException;
        }
        for (int element: a) {
            System.out.print(element + " ");
        }
    }

    public static void main(String[] args) {
        int a1[] = new int[102]; // too large array
        int a2[] = {};  // empty array
        int a3[] = {1, 5, 8, 9, 20, 12};
        try{
            printArray(a1);
        } catch (Exception e){
            // chained exception checking
            System.out.println("The exception is caught, the real reason: " + e.getCause());
        }
        try{
            printArray(a2);
        } catch (Exception e){
            // chained exception checking
            System.out.println("The exception is caught, the real reason: " + e.getCause());
        }
        try { printArray(a3); } catch (Exception e) {}


    }
}
