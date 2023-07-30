public interface Stack {

    void push (Object obj) throws StackOverflow;
    void pop() throws StackUnderflow;
    Object top() throws StackUnderflow;
    boolean isEmpty();
    void makeEmpty();
    String toString();

}
