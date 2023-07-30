
public class Node <T> {
	private Node next;
	private T newNode;
	
	public Node(T t) {
		this.newNode = t;
		next = null;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public T getNewNode() {
		return newNode;
	}

	public void setNewNode(T t) {
		this.newNode = t;
	}
	
	public String toString() {
		return getNewNode().toString();
	}
}
