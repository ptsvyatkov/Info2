public class StackAsList implements Stack {

    private List list;

    // Constructor
    public StackAsList() {
        this.makeEmpty();
    }

    public void push(Object obj) throws StackOverflow {
        list.addFirst(obj);
    }

    public void pop() throws StackUnderflow {
        if (list.isEmpty())
            throw new StackUnderflow();
        else {
            list.reset();
            list.remove();
        }
    }

    public Object top() throws StackUnderflow {
        if (list.isEmpty())
            throw new StackUnderflow();
        else {
            list.reset();
            return list.current();
        }
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public void makeEmpty() {
        list = new List();
    }

    public String toString(){
        return list.print();
    }

}
