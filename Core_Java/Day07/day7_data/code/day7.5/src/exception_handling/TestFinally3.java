
package exception_handling;

public class TestFinally3 {

    public static void main(String[] args) {

        try {

            // Calling testMe() method with a valid numeric String
            testMe("1345");

            // Executes only if testMe() completes normally
            System.out.println("end of try in main");

        } catch (Exception e) {

            // Handles exceptions propagated from testMe()
            System.out.println("in main's catch-all");
            System.out.println(e);

        } finally {

            // Executes when control leaves the try-catch normally
            // or through an exception or return
            // System.exit(0) is an exception to this rule
            System.out.println("in main's finally");
        }

        // Executes only if JVM has not been terminated
        System.out.println("main over....");
    }


    // Declaring InterruptedException because Thread.sleep()
    // can throw a checked exception
    static void testMe(String s) throws InterruptedException {

        System.out.println("in testMe");

        try {

            // Converts String into integer
            // "1345" is valid, so no NumberFormatException occurs
            System.out.println("Parsed int value " + Integer.parseInt(s));

            // Pauses execution for 100 milliseconds
            // Can throw checked InterruptedException
            Thread.sleep(100);

            boolean flag = true;

            if (flag) {

                // return;
                // If return is executed:
                // 1. Method's finally executes
                // 2. Control returns to main()
                // 3. Main's remaining statements execute

                 System.exit(0);
                // Immediately terminates the JVM.
                // Finally blocks are NOT guaranteed to execute.
                // Statements after System.exit(0) do not execute.
            }

            // Executes only if flag is false
            System.out.println("end of meth's try");

        } finally {

            // Does not execute when System.exit(0) terminates the JVM
            System.out.println("in method's finally");
        }

        // Executes only if the method completes normally
        System.out.println("end of method");
    }

}

