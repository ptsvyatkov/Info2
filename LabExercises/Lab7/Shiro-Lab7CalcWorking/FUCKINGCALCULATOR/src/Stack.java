public interface Stack {

	void push (Object obj);
	Object pop() throws StackUnderflow;
	Object top() throws StackUnderflow;
	boolean isEmpty();
	String toString();

}
