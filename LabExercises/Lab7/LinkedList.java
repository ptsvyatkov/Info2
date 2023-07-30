public class LinkedList<T> {

    private Node head = null;
    private Node curr = null;



    // class for our list elements / nodes
    private class Node {
        // generic types for generic data:
        private T data;
        private Node next;

        // constructor
        Node(T data, Node x) {
            this.data = data;
            this.next = x;
        }
    }


    public void add(T data) {

        Node tmp = new Node(data, head);
        head = tmp;
        curr = head;
    }

    public void remove() {
        // wenn die Liste leer ist oder der ggw. node nicht angelegt worden ist, nichts zurückgeben
        if (this.isEmpty() || curr == null) {
            return;
        } else {
            // das das ggw. element immer das erste ist und damit keinen vorgänger hat, wird sein nächstes element zum neuen head beim löschen
            head = curr.next;
            curr = head;
        }
    }

    // abchecken ob die Liste elemente besitzt
    public boolean isEmpty() {
        return head == null;
    }

    // liste resetten
    public void reset(){
        head = null;
        curr = null;
    }

    // etwas eleganter mit exception:
    public T current() throws UnderflowException {
        if (isEmpty()) throw new UnderflowException("no current element: list is empty");
        return curr.data;
    }

}