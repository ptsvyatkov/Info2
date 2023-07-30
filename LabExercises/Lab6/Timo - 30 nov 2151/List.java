public class List {

    private Node head, curr, prev;
    private int size;

    public List() {
        head = null;
        curr = null;
        prev = null;
        size = 0;
    }

    public void add(Object obj) {
        if (head == null) {
            head = new Node(obj, null);
            curr = head;
        } else {
            if (curr == null){
                curr = new Node(obj, curr);
                prev.next = curr;
                prev = curr;
            } else {
                Node tmp = new Node (obj, curr.next);
                curr.next = tmp;
                prev      = curr;
                curr      = tmp;
            }
        }
        size += 1;
    }

    public void addFirst(Object obj) {
        Node tmp = new Node (obj, head);
        head = tmp;
        prev = null;
        curr = head;
    }

    public void remove() {
        if (this.isEmpty() || curr == null) {
            return;
        } else {
            if (prev == null) {
                head = curr.next;
                curr = head;
            } else {
                prev.next = curr.next;
                curr = curr.next;
            }
            size -= 1;
        }
    }

    public boolean isEmpty() {
        return head == null;
    }

    public Object current() {
        return curr.data;
    }

    public int getSize(){
        return this.size;
    }

    public void reset() {
        curr = head;
        prev = null;
    }

    public boolean eol() {
        return (curr == null);
    }

    public void succ() {
        curr = curr.next;
        if (prev == null)
            prev = head;
        else
            prev = prev.next;
    }

    public String print() {
        String out = "TOP: ";
        for(this.reset(); !this.eol(); this.succ())
            out += curr.data + ((curr.next != null) ? ", " : "");
        return out + " :BOTTOM";
    }

}
