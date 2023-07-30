public class StackAsList implements Stack {

    private List myStack;

    // Constructor
    public StackAsList() {
        this.makeEmpty();
    }

    public void push(Object obj) throws StackOverflow {
        myStack.addFirst(obj);
    }

    public void pop() throws StackUnderflow {
        if (myStack.isEmpty())
            throw new StackUnderflow();
        else {
            myStack.reset();
            myStack.remove();
        }
    }

    public Object top() throws StackUnderflow {
        if (myStack.isEmpty())
            throw new StackUnderflow();
        else {
            myStack.reset();
            return myStack.current();
        }
    }

    public boolean isEmpty() {
        return myStack.isEmpty();
    }

    public void makeEmpty() {
        myStack = new List();
    }

    public String toString(){
        return myStack.print();
    }

}
