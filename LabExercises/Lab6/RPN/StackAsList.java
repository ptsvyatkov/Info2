public class StackAsList implements LinkedList, Stack {

    private Node head;
    private Node current;
    private Node first;

    public StackAsList() {
        this.makeEmpty();
    }

    public Object get(int index) {
        return null;
    }

    public void add(Object o) {
        head = new Node(o);
    }

    public void add(int index, Object o) {
        Node temp = head;
        while (temp.next != null)
            temp = temp.next;
        temp.next = new Node(o);
    }

    public void remove(int index) {
        Node temp = head;
        // ...
    }

    public void push(Object o) {

    }

    public void pop() throws Underflow {

    }

    public Object top() {
        return null;
    }

    public boolean isEmpty() {
        return false;
    }

    public void makeEmpty() {

    }

    public void clear() {

    }
}
}
