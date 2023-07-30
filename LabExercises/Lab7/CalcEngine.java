
/**
 * The main part of the calculator doing the calculations.
 * 
 * @author  David J. Barnes and Michael Kolling 
 * @version 2008.03.30
 */

public class CalcEngine
{
    // The calculator's state is maintained in three fields:
    //     buildingDisplayValue, haveLeftOperand, and lastOperator.
    
    // Are we already building a value in the display, or will the
    // next digit be the first of a new one?
    private boolean buildingDisplayValue;
    // Has a left operand already been entered (or calculated)?
    private boolean haveLeftOperand;
    // The most recent operator that was entered.
    private char lastOperator;

    // The current value (to be) shown in the display.
    private int displayValue;
    // The value of an existing left operand.
    private int leftOperand;
    
    

    /**
     * Create a CalcEngine.
     */
    
    public CalcEngine()
    {
        clear();
    }

    /**
     * @return The value that should currently be displayed
     * on the calculator display.
     */
    
    public int getDisplayValue()
    {
        return displayValue;
    }

    /**
     * A number button was pressed.
     * Either start a new operand, or incorporate this number as
     * the least significant digit of an existing one.
     * @param number The number pressed on the calculator.
     */
    
    public void numberPressed(int number)
    {
        
        if(buildingDisplayValue) {
            // Incorporate this digit.
            displayValue = displayValue*10 + number;
        }
        else {
            // Start building a new number.
            displayValue = number;
            buildingDisplayValue = true;
        }
        
    }

    /**
     * The 'plus' button was pressed. 
     */
    
    public void plus()
    {
        applyOperator('+');
        
    }

    /**
     * The 'minus' button was pressed.
     */
    
    public void minus()
    {
        applyOperator('-');
        
    }
     
    /**
     * The 'multiply' button was pressed.
     */
    
    public void multiply()
    {
        applyOperator('*');
    }
    
    /**
     * The '=' button was pressed.
     */
    
    public void equals()
    {
        // This should completes the building of a second operand,
        // so ensure that we really have a left operand, an operator
        // and a right operand.
        if(haveLeftOperand &&
                lastOperator != '?' &&
                buildingDisplayValue) {
            calculateResult();
            lastOperator = '?';
            buildingDisplayValue = false;
        }
        else {
            keySequenceError();
        }
    }

    /**
     * The 'C' (clear) button was pressed.
     * Reset everything to a starting state.
     * Update: change to small 'c' to avoid problems with hex. 'C'
     */
    
    public void clear()
    {
        lastOperator = '?';
        haveLeftOperand = false;
        buildingDisplayValue = false;
        leftOperand = 0;
        displayValue = 0;
        //EXERCISE7
        
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
        return "David J. Barnes and Michael Kolling";
    }

    /**
     * @return The version number of this engine.
     */
    
    public String getVersion()
    {
       return "Version 1.0";
    }

    /**
     * Combine leftOperand, lastOperator, and the
     * current display value.
     * The result becomes both the leftOperand and
     * the new display value.
     */
    
    private void calculateResult()
    {
        switch(lastOperator) {
            case '+':
                displayValue = leftOperand + displayValue;
                haveLeftOperand = true;
                leftOperand = displayValue;
                break;
            case '-':
                displayValue = leftOperand - displayValue;
                haveLeftOperand = true;
                leftOperand = displayValue;
                break;
            case '*':
                displayValue = leftOperand * displayValue;
                haveLeftOperand = true;
                leftOperand = displayValue;
                break;
            default:
                keySequenceError();
                break;
        }
    }
    
    /**
     * Apply an operator.
     * @param operator The operator to apply.
     */
    
    private void applyOperator(char operator)
    {
        // If we are not in the process of building a new operand
        // then it is an error, unless we have just calculated a
        // result using '='.
        if(!buildingDisplayValue &&
                    !(haveLeftOperand && lastOperator == '?')) {
            keySequenceError();
            return;
        }

        if(lastOperator != '?') {
            // First apply the previous operator.
            calculateResult();
        }
        else {
            // The displayValue now becomes the left operand of this
            // new operator.
            haveLeftOperand = true;
            leftOperand = displayValue;
        }
        lastOperator = operator;
        buildingDisplayValue = false;
    }

    /**
     * Report an error in the sequence of keys that was pressed.
     */
    
    private void keySequenceError()
    {
        System.out.println("A key sequence error has occurred.");
        // Reset everything.
        clear();
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
				pfxList.push(Character.getNumericValue(c)); //push the value of the char to the list
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
						while (!stack.isEmpty()
							&& isOperator(stack.top()) 								&& !rightAss(t)								            && ((prec(t, stack.top()) == -1)							|| (prec(t, stack.top()) == 0))) {
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
}


