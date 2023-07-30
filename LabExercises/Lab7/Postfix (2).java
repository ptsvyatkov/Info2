import java.util.Scanner;
public class Postfix{
	String pfxString;
public static void main(String[] args) throws UnderflowException {
	//main method tests the evaluation of an example expression
	String example = "1 2 * 3 +"; //String for testing postfix evaluation
	String example2 = "1 + 2 * 3";
	Postfix postfix = new Postfix(); //object to test evaluation method on
	postfix.evaluate(example); //call evaluate method with example String
	System.out.println("The result of the postfix expression '"+example+"' is: "+ postfix.evaluate(example)+"."); //print the result to the console
	System.out.println("The conversion of the infix '"+example2+"' to a postfix is: "+ postfix.infixToPostfix(example2)+"."); //print the result to the console
    postfix.CustomString();
}
	public int evaluate (String pfx) throws UnderflowException
	{
		StackAsList<Integer> pfxList = new StackAsList<>(); //initializes a list to store integers
		pfx = pfx.replaceAll(" ",""); //remove possible empty spaces from the String
		int result; //stores the value being pushed to the list
		for (int i = 0; i < pfx.length(); i++) //iterates through the characters of pfx
		{
			char c = pfx.charAt(i); //stores the characters of pfx
			if(Character.isDigit(c)) //if t is an operand
				pfxList.push( (c - '0')); //push the value of the char to the list
			else //if t is an operator
			{
				int rhs = pfxList.pop(); //put the top into rhs, pop it
				int lhs = pfxList.pop(); //put the top into lhs, pop it
		     switch(c) //calculate lhs t rhs and push the result
		     { 
             case '+': 
            	 result = lhs + rhs;
                 pfxList.push(result); 
                 break;
             case '-': 
            	 result = lhs - rhs;
                 pfxList.push(result); 
                 break; 
             case '/': 
            	 result = lhs / rhs;
                 pfxList.push(result); 
                 break; 
             case '*':
            	 result = lhs * rhs;
                 pfxList.push(result); 
                 break; 
             case '^':
            	 result = (int) Math.pow(lhs, rhs);
            	 pfxList.push(result); 
            	 } 
		     }
			}
		return pfxList.top();
		} 
	public String infixToPostfix(String ifx) throws UnderflowException {
		StackAsList<Character> stack = new StackAsList<>();
		ifx = ifx.replaceAll(" ",""); // remove possible empty spaces from the String
		String result = "";

		try {
			for (int i = 0; i < ifx.length(); i++) { // until input string is empty
				char t = ifx.charAt(i); // grab token

				if (Character.isDigit(t)) {
					result += t;
				}

				if (isOperator(t)) {
						while (!stack.isEmpty()// noch was da auf dem stack?
								&& isOperator(stack.top()) // ist top ein operator?
								&& !rightAss(t) // ist der operator linksassoziativ?
								&& ((prec(t, stack.top()) == -1) // ist token kleiner?
								|| (prec(t, stack.top()) == 0))) { // oder ist token gleich?
							result += stack.pop();
						}
						stack.push(t);
				}


				if (t == '(')
					stack.push(t);
				if (t == ')') {
					while (stack.top() != '('){
						if (stack.isEmpty()){
							System.out.println("PARSE ERROR: \' ( \' missing!"); // error
							break;
						} else {
							result += stack.pop();
						}
					}
					stack.pop();
				}
			}

			while(!stack.isEmpty()){
				if (stack.top() == '('){
					System.out.println("PARSE ERROR: to many parentheses!"); // error
					break;
				} else {
					result += stack.pop();
				}
			}

		} catch (UnderflowException uex){
			uex.printStackTrace(); // stack's empty, dude
		}

		return result;
	}




	// precedence evaluation
	public int prec (char opr1, char opr2){

		// returns : -1 lower, 0 equal, 1 higher than opr2

		if (opr1 == '+'){
			if (opr2 == '+'){
				return 0;
			} else
				return -1;
		}

		if (opr1 == '-'){
			if (opr2 == '+'){
				return 1;
			}
			if (opr2 == '-'){
				return 0;
			} else return -1;
		}

		if (opr1 == '*'){
			if (opr2 == '+'){
				return 1;
			}
			if (opr2 == '-'){
				return 1;
			}
			if (opr2 == '*'){
				return 0;
			}
			else return -1;
		}
		if (opr1 == '/'){
			if (opr2 == '+'){
				return 1;
			}
			if (opr2 == '-'){
				return 1;
			}
			if (opr2 == '*'){
				return 1;
			}
			if (opr2 == '/'){
				return 0;
			} else return -1;
		}

		if (opr1 == '^'){
			return 1; // highest precedence
		}
		return 0;
	}

		// right associative?
	boolean rightAss(char opr){
		switch (opr){
			case '+':
				return false;
			case '-':
				return false;
			case '*':
				return false;
			case '/':
				return false;
			case '^':
				return true;
			default: return false;
		}
	}

	boolean isOperator(char token){
		if(token =='+'||token =='-'||token =='*'||token =='/'|| token=='^'){
			return true;
		} else return false;
	}
	public void CustomString() throws UnderflowException
	{Postfix postfix = new Postfix();
		System.out.println("Please type in the infix expression, you want to have converted & evaluated.");
		System.out.println("Beware of using the correct operators:");
		System.out.println("Addition: '+', Subtraction: '-', Multiplication: '*', Division: '/' & Square: '^'");
		Scanner reader = new Scanner(System.in);
        String input = reader.nextLine();
		System.out.println();
		System.out.println("You entered: "+input+".");
		System.out.println();
		System.out.println("Evaluating the results...");
		System.out.println();
		System.out.println("The conversion of the infix '"+input+"' to a postfix is: "+ postfix.infixToPostfix(input)+".");
		System.out.println("The result of the postfix expression '"+"' is: "+ postfix.evaluate(postfix.infixToPostfix(input))+".");
		reader.close();
	}
	}
		
	
//outdated code fragments

/*	class Token
{
	char data;
	Token (char data)
	{
		setData(data);
		}
	void setData(char data)
	{
		this.data = data;
		}
	}
*/

//if (tchar == '+'||tchar == '-'||tchar == '*'||tchar == '/'||tchar == '^') 