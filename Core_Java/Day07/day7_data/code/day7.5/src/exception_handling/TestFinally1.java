
package exception_handling;

public class TestFinally1 {

    public static void main(String[] args) {

        try {  // Outer try block

            // Calling testMe() method
            // Passing an invalid numeric String
            testMe("1asdfg2345");

            // Executes only if testMe() completes successfully
            System.out.println("end of try in main");

        } catch (Exception e) {

            // Handles the exception propagated from testMe()
            System.out.println("in main's catch-all");
            System.out.println(e);

        } finally {

            // Always executes whether exception occurs or not
            System.out.println("in main's finally");
        }

        // Executes after the try-catch-finally block
        System.out.println("main over....");
    }


    // throws InterruptedException:
    // Declares that this method may throw a checked exception.
    // The calling method must handle it or declare it further.
    static void testMe(String s) throws InterruptedException {

        System.out.println("in testMe");

        try {  // Nested try block / Inner try block

            // Converts String into integer
            // Invalid String causes NumberFormatException
            // NumberFormatException is an unchecked exception.
            // It is not handled here, so it propagates to main().

            System.out.println("Parsed int value " + Integer.parseInt(s));

            // Pauses execution for 100 milliseconds.
            // sleep() throws checked InterruptedException.
            // Therefore, javac forces us to handle it
            // using try-catch or declare it using throws.
            Thread.sleep(100);

            // Executes only if parsing and sleep() are successful
            System.out.println("end of meth's try");

        } finally {

            // Executes even when an exception occurs in the try block
            System.out.println("in method's finally");
        }

        // Executes only if no exception propagates out of the try-finally
        System.out.println("end of method");
    }

}
