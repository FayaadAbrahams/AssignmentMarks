public class Runner {
    public static void main(String[] args) throws Exception {
        // Comment out either one, but only run one at a time.

        // Swing Interface
        new GUI();

        // Console Interface
        ConsoleInterface dc = new ConsoleInterface();
        dc.fetchUserInput();
    }
}
