public class StackUnderflow extends Exception {
    private static final long serialVersionUID = 1L;
    StackUnderflow() {
        System.err.println("StackUnderflow Exception. Stack is Empty.");
    }
}
