public class Node {

    Object data;
    Node next;

    Node (Object o) {
        data = o;
    }

    Node (Object o, Node next) {
        data = o;
        this.next = next;
    }

    public Object getData() {
        return data;
    }

}
