
public class TestStackAsList{
	public static void main(String[] args) {
	StackAsList newStackAsList = new StackAsList();
	
	try {
		if (newStackAsList.isEmpty()) {
			System.out.println("New Stack is empty");
		} else {
			System.out.println("Stack isnt empty but it should be");
		}
		
		//adding something to the Stack
		System.out.println("Adding first element:");
		newStackAsList.push("First");
		
		if (newStackAsList.top().equals("First")) {
			System.out.println("Adding first element worked\n");
		} else {
			System.out.println("Something went wrong with adding the first element\n");
		}
		
		//addin more elements
		System.out.println("Adding severel elements...\n");
		newStackAsList.print();
		newStackAsList.push("Second");
		newStackAsList.print();
		newStackAsList.push("Third");
		newStackAsList.print();
		newStackAsList.push("Fourth");
		newStackAsList.print();
		newStackAsList.push("Fifth");
		newStackAsList.print();
		newStackAsList.push("Sixth");
		newStackAsList.print();
		
		//Printing Stack
		System.out.println("\nPrinting Stack:");
		newStackAsList.print();
		
		//getting last element
		System.out.println("\nGetting Last Element:");
		if (newStackAsList.top()=="Sixth") {
			System.out.println("Everything is fine");
		} else {
			System.out.println("Something went wrong with the the last element");
		}
		
		//checking again if Stack is empty
		System.out.println("\nIs Stack empty?");
		if (newStackAsList.isEmpty()) {
			System.out.println("Stack shouldn be empty here");
		} else {
			System.out.println("There are elemts in the Stack. Nice!");
		}
		
		//pop and print for each element
		System.out.println("\nDeleting elementes:");
		newStackAsList.pop();
		newStackAsList.print();
		newStackAsList.pop();
		newStackAsList.print();
		newStackAsList.pop();
		newStackAsList.print();
		newStackAsList.pop();
		newStackAsList.print();
		newStackAsList.pop();
		newStackAsList.print();
	
		//getting last elemt again
		System.out.println("\nShow last elemt again:");
		if (newStackAsList.top().equals("First")) {
			System.out.println("Worked");
		} else {
			System.out.println("Something went wrong with deleting elemts");
		}
		
		//deleting last element remaining in the Stack
		System.out.println("\nDeleting last element remaining...");
		newStackAsList.pop();
	
		//is Stack empty now
		System.out.println("\nChecking if  Stack is empty:");
		if (newStackAsList.isEmpty()) {
			System.out.println("Stack is empty and so it should be");
		} else {
			System.out.println("There shouldn be an element left");
		}
		
		//printing emtpy stack
		System.out.println("\nTry to delete from empty stack. Should throw UnderflowException");
		newStackAsList.pop();
		
	} catch (OverflowException e) {
	} catch (UnderflowException e) {
	}
	
	
	}
}
