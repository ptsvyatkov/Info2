import java.util.Scanner;

public class Postfix {

	StackAsList<Character> operatorStack = new StackAsList();
	StackAsList<Integer> operandStack = new StackAsList();
	private Scanner stringReader;

	public static void main(String[] args) {
		Postfix myPostfix = new Postfix();
		//myPostfix.input();

	}
	
	//input and output handling
	public void input() {
		String ifx = "";
		String result = "";
		stringReader = new Scanner(System.in);
		System.out.println("Enter the term you will calculate! ");
		ifx = stringReader.nextLine();
		try {
			String pfx = infixToPostfix(ifx);
			result += evaluate(pfx);
		} catch (InputException e) {
		}
		System.out.println("The result is:" + result);
	}
	
	
	//evaluates the result from poststring and returns int as result
	public int evaluate(String pfx) {
		int result = 0;
		Integer operand = 0;
		//reading through String
		for (int i = 0; i < pfx.length(); i++) {
			char token = pfx.charAt(i);
			//if the char is a number
			if (Character.toString(token).matches("[0-9]")) {
				operand = Integer.valueOf(token - 48); //map ascii value to real value
				try {
					operandStack.push(operand);
				} catch (OverflowException e) {
				}
			} else {
				try {
					//assigning values to left and righthand operator
					int rhs = operandStack.top();
					operandStack.pop();
					int lhs = operandStack.top();
					operandStack.pop();
					//calculation by calculate method call
					int interimResult = calculate(token, lhs, rhs);
					operandStack.push(interimResult);
				} catch (UnderflowException e) {
				} catch (OverflowException e) {
				}
			}
		}
		try {
			result = operandStack.top();
		} catch (UnderflowException e) {
		}
		return result;
	}

	
	//dealing with the operators for evaluate()
	public static int calculate(char c, int lhs, int rhs) {
		switch (c) {
		case '+':
			return lhs + rhs;
		case '-':
			return lhs - rhs;

		case '*':
			return lhs * rhs;
		case '/':
			return lhs / rhs;

		case '$':
			return (int) Math.pow(lhs, rhs);

		}
		return -1;
	}

	// precedence of operator
	public static int precedence(char c) {
		switch (c) {
		case '+':
		case '-':
			return 1;
		case '*':
		case '/':
			return 2;
		case '$':
			return 3;
		}
		return -1;
	}

	// infix to postfix BUG: just works if first char is ( and last ). everything
	// between is fine
	// example: (1+2*(3$4-5)) will work. 1+2*(3$4-5) wont
	public String infixToPostfix(String ifx) throws InputException {
		String result = "";
		for (int i = 0; i < ifx.length(); i++) {
			char token = ifx.charAt(i);
			
			//checking for operator followed by operator
			//for a real valid input additional checks are necessary 
//			if (i < ifx.length() - 1) {
//				if ((Character.toString(ifx.charAt(i)).matches("[+-/*$]"))
//						&& (Character.toString(ifx.charAt(i + 1)).matches("[+-/*$]"))) {
//					throw new InputException();
//				}
//			}
		
			
			if (Character.toString(token).matches("[0-9]")) {
				result += token;
			}

			// dealing with open parenthesis
			else if (token == '(') {
				try {
					operatorStack.push(token);
				} catch (OverflowException e) {
				}
			}

			// dealing with closing parenthesis
			else if (token == ')') {
				try {
					while ((char) operatorStack.top() != '(') {
						result += operatorStack.top();
						operatorStack.pop();
					}
					operatorStack.pop();
					
				} catch (UnderflowException e) {
				}
			} else //version from pavel adjusted to my code
				try {
					if (operatorStack.isEmpty() || precedence(token) > precedence((Character) operatorStack.top())) {
					    operatorStack.push(token);
					}

					// If character is an operator
					// Pop all operators from stack with equal/greater precedence
					else {
					    while (!operatorStack.isEmpty() && precedence((Character) operatorStack.top()) >= precedence(token) &&
					            ((Character) operatorStack.top() != '(' || (Character) operatorStack.top() != ')')) {
					        result += operatorStack.top();
					        operatorStack.pop();
					    }
					    operatorStack.push(token);
					}
				} catch (UnderflowException | OverflowException e) {
				}
			// dealing with operator
			/*else if (token == '+' || token == '-' || token == '*' || token == '/' || token == '$') {

				try {
					while (!(precedence((char) operatorStack.top()) < precedence(token))
							|| token == '$' && precedence((char) operatorStack.top()) == precedence(token)) {
						result +=  operatorStack.top();
						operatorStack.pop();
					}
					operatorStack.push(token);
				} catch (UnderflowException e) {
				} catch (OverflowException e) {
				}
			}*/
		}

		try {
			while (!operatorStack.isEmpty()) {
				result += operatorStack.top();
				operatorStack.pop();
			}
		} catch (UnderflowException e) {
		}
		return result;
	}
}
