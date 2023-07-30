public class Postfix {

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
                s.pop();
            }

            // If character has higher precedence than the one in the stack
            else if (s.isEmpty() || getPrecedence(c) > getPrecedence((Character) s.top())) {
                s.push(c);
            }

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

        while (!s.isEmpty()) {
            if ((Character) s.top() != '(' || (Character) s.top() != ')') {
                result += s.top();
                s.pop();
            }
            else
                s.pop();
        }

        return result;
    }

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
        String s = pfx.infixToPostfix("1 + 2 - 3 ^ 4");
        System.out.println(s);
    }

}