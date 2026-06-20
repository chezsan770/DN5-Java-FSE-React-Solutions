public class SingletonTest {
    public static void main(String[] args) {
        Logger firstLogger = Logger.getInstance();
        Logger secondLogger = Logger.getInstance();

        firstLogger.log("Message written using the first reference.");
        secondLogger.log("Message written using the second reference.");

        if (firstLogger == secondLogger) {
            System.out.println("Test passed: both references use the same Logger instance.");
        } else {
            throw new AssertionError("Test failed: multiple Logger instances were created.");
        }
    }
}
