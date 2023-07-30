public interface Stack {

    void push (Object o);
    void pop() throws Underflow;
    Object top();
    boolean isEmpty();
    void makeEmpty();
    String toString();

}
