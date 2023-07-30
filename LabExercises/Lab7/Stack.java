public interface Stack<T> {
    void push(T t); // pushing values
    T pop () throws UnderflowException; // fetching values
    T top () throws UnderflowException; // looking up most recent value
    boolean isEmpty(); // checking whether stack is empty
    void empty();
}
// in her examples she uses Object as parameter types for pop and top