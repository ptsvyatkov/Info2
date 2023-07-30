public class StackOverflow extends Exception {
    private static final long serialVersionUID = 1L;
    StackOverflow() {
        System.err.println("StackOverflow Exception. Stack is Full.");
    }
}
