import java.util.Scanner;

public class Postfix {

    private Scanner scanner = new Scanner(System.in);

    public int evaluate (String pfx) throws StackOverflow, StackUnderflow {

        // Create a new stack
        StackAsList s = new StackAsList();

        // Iterate through the postfix String
        for (int i = 0; i < pfx.length(); i++) {

            // Scan characters
            char c = pfx.charAt(i);

            // Skip spaces
            if (c == ' ')
                continue;

            // Push operands to stack
            if (Character.isLetterOrDigit(c))
                s.push(c - '0');

            else {
                int op1 = (int) s.top();
                s.pop();
                int op2 = (int) s.top();
                s.pop();

                switch(c) {
                    case '+':
                        s.push(op2 + op1);
                        break;
                    case '-':
                        s.push(op2 - op1);
                        break;
                    case '*':
                        s.push(op2 * op1);
                        break;
                    case '/':
                        s.push(op2 / op1);
                        break;
                    case '^':
                        s.push((int) Math.pow(op2, op1));
                }
            }
        }
        return (int) s.top();
    }

    public String infixToPostfix(String ifx) throws StackOverflow, StackUnderflow {

        // Create a new stack
        StackAsList s = new StackAsList();

        // Create a new String which represents the result
        String result = "";

        String exc = "Input expression is not valid!";

        // Iterate through the infix String
        for (int i = 0; i < ifx.length(); i++) {

            // Scan characters
            char c = ifx.charAt(i);

            // Skip spaces
            if (c == ' ')
                continue;

            // If character is Letter/Digit, output it
            else if (Character.isLetterOrDigit(c))
                result += c;

            // If character is '(' push it to the stack
            else if (c == '(')
                s.push(c);

            // If character is ')' pop and output until '('
            else if (c == ')') {
                while (!s.isEmpty() && (Character) s.top() != '(') {
                    result += s.top();
                    s.pop();
                }
                // pop '(' from stack
                if (!s.isEmpty() && (Character) s.top() == '(')
                    s.pop();
                else
                    return exc;

            }

            // If character has higher precedence than the one in the stack
            else if (s.isEmpty() || getPrecedence(c) > getPrecedence((Character) s.top())) {
                s.push(c);
            }

            // If character is an operator
            // Pop all operators from stack with equal/greater precedence
            else {
                while (!s.isEmpty() && getPrecedence((Character) s.top()) >= getPrecedence(c) &&
                        ((Character) s.top() != '(' || (Character) s.top() != ')')) {
                    result += s.top();
                    s.pop();
                }
                s.push(c);
            }
        }

        // Check the stack for any characters left
        while (!s.isEmpty()) {
            if (getPrecedence((Character) s.top()) != -1) {
                result += s.top();
                s.pop();
            }
            else
                return exc;
        }

        return result;
    }

    /** Method to get the precedence (as a value from 1 to 3) of the corresponding operator
     * any other character returns a -1
     **/
    private int getPrecedence(char c) {
        if (c == '+' || c == '-')
            return 1;
        else if (c == '*' || c == '/')
            return 2;
        else if (c == '^')
            return 3;
        else
            return -1;
    }

    public static void main(String[] args) throws StackOverflow, StackUnderflow {
        Postfix pfx = new Postfix();
        pfx.readAndEvaluateInfix();
    }

    /**
     * Method to read an infix String from the console, evaluate it and print it to the console.
     * @throws StackOverflow
     * @throws StackUnderflow
     */
    public void readAndEvaluateInfix() throws StackOverflow, StackUnderflow {

        System.out.print("Type in your infix expression to evaluate: ");
        String ifx = scanner.nextLine();

        System.out.println("Result: " + evaluate(infixToPostfix(ifx)));

    }
}