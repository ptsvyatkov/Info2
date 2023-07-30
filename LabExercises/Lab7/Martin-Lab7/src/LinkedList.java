/*
 * List implementation to use a Stack
 * necessary changes: Fix generic. Something is reaaaaly wrong
 * 
 */
public class LinkedList<T> {
	private Node first;

	public LinkedList() {
		first = null;
	}

	// return last Element
	public Node getLast() {

		Node current = first; // Head
		while (current.getNext() != null) {
			current = current.getNext();
		}
		return current;
	}

	// add a new node
	public void add(T t) {
		if (isEmpty()) {
			first = new Node(t);
		} else {
			Node newNode = new Node(t);
			Node lastNode = getLast();
			lastNode.setNext(newNode); // next vom letzten gefunden element ist neuer eintrag
		}

	}

	// delete Last Element
	public void deleteLast() {
		Node current = first; // Head
		if (first == null) {
			System.out.println("The Stack is empty. There is nothing to delete");
		}
		if (first.getNext() != null) {
			while (current.getNext().getNext() != null) {
				current = current.getNext();
			}
			current.setNext(null);
		} else {
			first = null;
		}

	}

	// isEmpty
	public boolean isEmpty() {
		return first == null;
	}

	public Node getFirst() {
		return first;
	}

	public void setFirst(Node first) {
		this.first = first;
	}

	public String toString() {
		Node current = first;
		String s = "";
		if (first != null) {
			s = s + current.getNewNode().toString();
			while (current.getNext() != null) {
				current = current.getNext();
				s = s + " " + current.getNewNode().toString();
			}
			System.out.println(s);
		}
		return s;
	}

}
