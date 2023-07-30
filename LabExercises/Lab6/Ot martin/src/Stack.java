

public interface Stack <T> {
	public void pop() throws UnderflowException; 
	//public void push(T t) throws OverflowException; 
	public T top() throws UnderflowException; 
	public boolean isEmpty();
	public String print();
	
}
