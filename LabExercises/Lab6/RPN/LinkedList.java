public interface LinkedList {

    Object get(int index);             // get the element of the specified position

    void add(Object o);                // add new element at the end
    void add(int index, Object o);     // add new element at the specified position

    void remove(int index);            // remove element

    boolean isEmpty();
    void makeEmpty();

    void clear();                      // removes all elements from the list

}
