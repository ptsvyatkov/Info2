// changed in order to get rid of the List class
// based on the implementation of Sophia Stölzle, Dennis Bröcker

public class StackAsList implements Stack {

    Node head;

    // Constructor
    public StackAsList() {
        head = null;
    }

    public void push(Object data) {
        Node tmp;

        if (head == null) {
            tmp = new Node(data,null);
        } else {
            tmp = new Node(data,head);
        }
        head = tmp;
    }

    public Object pop() throws StackUnderflow {
        Node tmp;

        if (head == null) {
            throw new StackUnderflow();
        } else {
            tmp = head;
            head = tmp.next;

            return tmp.getData();
        }
    }

    public Object top() throws StackUnderflow {

        if (head != null) {
            return head.data;
        }
        else {
            throw new StackUnderflow();
        }
    }

    public boolean isEmpty() {
        return (head == null);
        }

    public String toString() {
        String r = "";
        r += "TOP: ";

        for (Node first = head; first != null; first = first.next) {
            r += first.data;

            if (first.next != null)
                r += ", ";
        }

        r += ": BOTTOM";

        return r;
    }

}