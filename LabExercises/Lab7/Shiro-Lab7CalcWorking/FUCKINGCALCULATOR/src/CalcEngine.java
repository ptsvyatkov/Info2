/**
 * The main part of the calculator doing the calculations.
 *
 * @author David J. Barnes and Michael Kolling
 *         extended by Timo Schmidt, Pavel Tsvyatkov
 *         extended by Timo Schmidt, Sophia Stölzle
 * @version 2019.12.06
 */
public class CalcEngine {
	
    // The current value (to be) shown in the display.
    protected String displayString;

    public CalcEngine() {
        clear();
    }
    
    /**
     * @return The value that should currently be displayed
     * on the calculator display.
     */
    public String getDisplayString() { 
    	return displayString; 
    }
    
    /**
     * A number or operator button was pressed.
     * Either start a new operand, or incorporate this number as
     * the least significant digit of an existing one.
     * @param c The number or operator pressed on the calculator.
     */
    public void buttonPressed(String c) { //number and operator
        displayString += c;
    }

    /**
     * The '=' button was pressed.
     */
    public void equals() throws StackUnderflow {
		displayString = Integer.toString(evaluate(infixToPostfix(displayString)));
    }

    /**
     * New evaluation method, can also deal with multiple digits
     * Source: https://algorithms.tutorialhorizon.com/evaluation-of-postfix-expressions-polish-postfix-notation-set-2/
     * changed to take our StackAsList as Stack
     */
    public int evaluate(String pfx) throws StackUnderflow {

        // Create new Stack
        StackAsList s = new StackAsList();

        // Iterate through all characters of the pfx String
        for (int i = 0; i < pfx.length(); i++) {
            char c = pfx.charAt(i);
            //check if it is a space (separator)
            if(c == ' ')
                continue;
            if (c == '*' || c == '/' || c == '^' || c == '+' || c == '-') {
                int a = (int) s.pop();
                int b = (int) s.pop();
                switch(c) {
                    case '+':
                        s.push(b + a);
                        break;
                    case '-':
                        s.push(b - a);
                        break;
                    case '*':
                        s.push(b * a);
                        break;
                    case '/':
                        if (a == 0)
                            throw new UnsupportedOperationException("Cannot divide by zero");
                        s.push(b / a);
                        break;
                    case '^':
                        s.push((int) Math.pow(b, a));
                        break;
                }

            } else {
                //if here means, its a digit
                int num = 0;
                //extract the characters and store it in num
                while(Character.isDigit(c)) {
                    num = num*10 + (c-'0');
                    i++;
                    c = pfx.charAt(i);
                }
                i--;
                //push the number in stack
                s.push(num);
            }
        }
        return (int) s.pop();
    }

    /**
     * Method for transforming an infix expression into postfix
     * @param ifx - Infix expression
     * @return pfx - Postfix expression
     * @throws StackUnderflow
     */
    public String infixToPostfix(String ifx) throws StackUnderflow {

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
            else if (Character.isLetterOrDigit(c)) {
                result += c;

                // Added to separate numbers
                if (i + 1 >= ifx.length() || !Character.isLetterOrDigit(ifx.charAt(i + 1)))
                    result += ' ';
            }

            // If character is '(' push it to the stack
            else if (c == '(')
                s.push(c);

            // If character is ')' pop and output until '('
            else if (c == ')') {
                while (!s.isEmpty() && (Character) s.top() != '(') {
                    result += s.pop();
                    result += ' ';
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
                    result += s.pop();
                    result += ' ';
                }
                s.push(c);
            }
        }

        // Check the stack for any characters left
        while (!s.isEmpty()) {
            if (getPrecedence((Character) s.top()) != -1) {
                result += s.pop();
                result += ' ';
            }
            else
                return exc;
        }

        return result;
    }

    /**
     * Get precedence of an operator
     * @param c - Character to check
     */
    private int getPrecedence(char c) {
        switch (c) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
            default:
                return -1;
        }
    }

    /**
     * The 'AC' (clear) button was pressed.
     * Reset everything to a starting state.
     */
    public void clear(){
        displayString = "";
    }

    /**
     * @return The title of this calculation engine.
     */
    public String getTitle()
    {
        return "Java Calculator";
    }

    /**
     * @return The author of this engine.
     */
    public String getAuthor()
    {
        return "David J. Barnes and Michael Kolling // changed by Timo Schmidt & Sophia Stölzle";
    }

    /**
     * @return The version number of this engine.
     */
    public String getVersion()
    {
       return "Version 3.0";
    }

}
