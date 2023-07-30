import java.util.Scanner;

public class Postfix {
	
	StackAsList<Character> myStack = new StackAsList();
	private Scanner stringReader;
	
	public static void main(String[] args) {
		Postfix myPostfix = new Postfix();
		myPostfix.input();
		
		//		try {
//			myPostfix.infixToPostfix("(1+2+(3/4-3)+5+(6*(7+8)))");
//		} catch (Exception e) {
//		}
		
	}
	
	public void input() {
		String ifx = "";
		stringReader = new Scanner(System.in);
		System.out.println("Enter the term you will calculate! BUG: YOU HAVE TO START WITH '(' AND FINISH WITH ')'");
		ifx = stringReader.nextLine();
		try {
			infixToPostfix(ifx);
		} catch (InputException e) {
		}
	}
	
	//precedence of operator
	public static int precedence(char c){
        switch (c){
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
	
	//infix to postfix BUG: just works if first char is ( and last ). everthing between is fine
	//example: (1+2*(3$4-5)) will work. 1+2*(3$4-5) wont
	public String infixToPostfix (String ifx) throws InputException{
		String result = "";
		for(int i = 0; i < ifx.length(); i++) {
		   char token = ifx.charAt(i);
		   
		   
		   if (i < ifx.length()-1) {
			   if ((Character.toString(ifx.charAt(i)).matches("[+-/*$]")) 
					   && (Character.toString(ifx.charAt(i+1)).matches("[+-/*$]"))) {
				   throw new InputException();
			}
		   }
		   
		   //Operand as ASCII int for now. Better way? RegEx again? condition without regEx: token >= 48 && token <= 57 
		   if (Character.toString(token).matches("[0-9]")) {
			//token = token-48; for condition without regEx
			result = result + token;
			}
		   
		   //dealing with open parenthesis
		   if (token == '(') {
			   try {
				   myStack.push(token);
			   } catch (OverflowException e) {
			}
		   }
		   
			//dealing with closing parenthesis
		   if (token==')') {
				try {
					while ((char)myStack.top() != '(') {
						result = result + (char)myStack.top();
						myStack.pop();
					}
					myStack.pop();
				} catch (UnderflowException e) {
				}
			}
			
			//dealing with operator
		   if (token == '+' || token == '-' || token == '*' || token == '/' || token =='$') {
				
				try {
					while (!(precedence((char)myStack.top()) < precedence(token)) || token == '$' 
							&& precedence((char)myStack.top()) == precedence(token))  {
						result = result + (char)myStack.top();
						myStack.pop();
					}
					myStack.push(token);
				} catch (UnderflowException e) {
				} catch (OverflowException e) {
				}
				
			}
		   }
		
		try {
			while (!myStack.isEmpty()) {
				result = result + (char)myStack.top();
				myStack.pop(); 
			}
		} catch (UnderflowException e) {
		}
		System.out.println(result);
		return result;
	}
	
	
	
	
	

}
