
public class StackAsList <T> implements Stack{
	
	private LinkedList myStack;
	
	public StackAsList() {
		myStack = new LinkedList<>();
	}
	
	public void push(T t) throws OverflowException{
		myStack.add(t);
	} 
	
	public void pop() throws UnderflowException{ 
		if (myStack.getFirst() == null) {
			throw new UnderflowException();
		}else {
			myStack.deleteLast();
		}
	}
	
	public T top() throws UnderflowException{
		if (myStack.getFirst()==null) {
			throw new UnderflowException();
		}else {
			return   (T) myStack.getLast().getNewNode();
		}
		
	}
	
	public boolean isEmpty() {
		return myStack.isEmpty();
	}
	
	public String print() {
		return myStack.toString();
	}
	
	
	
}


