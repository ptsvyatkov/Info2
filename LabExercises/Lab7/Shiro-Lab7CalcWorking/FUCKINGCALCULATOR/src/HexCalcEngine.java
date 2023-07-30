public class HexCalcEngine extends CalcEngine {

    protected boolean inHexMode = false;

    public HexCalcEngine() {
        super();
    }

    public String evaluateHex(String pfx) throws StackUnderflow {

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
                int n = 0;
                //extract the characters and store it in num

                while(Character.isLetter(c)) {
                    switch (c) {
                        case 'A':
                            n = 10;
                            break;
                        case 'B':
                            n = 11;
                            break;
                        case 'C':
                            n = 12;
                            break;
                        case 'D':
                            n = 13;
                            break;
                        case 'E':
                            n = 14;
                            break;
                        case 'F':
                            n = 15;
                            break;
                    }

                    num = num * 16 + n;
                    i++;
                    c = pfx.charAt(i);
                }

                while(Character.isDigit(c)) {
                    num = num*16 + (c - '0');
                    i++;
                    c = pfx.charAt(i);
                }

                i--;
                //push the number in stack
                s.push(num);
            }
        }

        int result = (int) s.pop();
        return Integer.toHexString(result).toUpperCase();
    }

    public void equals() throws StackUnderflow {
        if (inHexMode)
            displayString = evaluateHex(infixToPostfix(displayString));
        else
            super.equals();
    }

}