
public class TestPostfix {
	public static void main(String[] args) {
		Postfix testPostfix = new Postfix();
		try {
			
			//3+5*2
			System.out.println("Expression: 3+5*2");
			
			System.out.println("Postfix: " + testPostfix.infixToPostfix("3+5*2"));
			if (testPostfix.evaluate(testPostfix.infixToPostfix("3+5*2")) == 13) {
				System.out.println(
						"Correct! The result is: " + testPostfix.evaluate(testPostfix.infixToPostfix("3+5*2")) + "\n");
			} else {
				System.out.println("Error! Check the postfix or evaluate()");
			}

			//3*5+2
			System.out.println("Expression: 3*5+2");

			System.out.println("Postfix: " + testPostfix.infixToPostfix("3*5+2"));
			if (testPostfix.evaluate(testPostfix.infixToPostfix("3*5+2")) == 17) {
				System.out.println(
						"Correct! The result is: " + testPostfix.evaluate(testPostfix.infixToPostfix("3*5+2")) + "\n");
			} else {
				System.out.println("Error! Check the postfix or evaluate()");
			}
			
			//(3+5)*2
			System.out.println("Expression: (3+5)*2");

			System.out.println("Postfix: " + testPostfix.infixToPostfix("(3+5)*2"));
			if (testPostfix.evaluate(testPostfix.infixToPostfix("(3+5)*2")) == 16) {
				System.out.println(
						"Correct! The result is: " + testPostfix.evaluate(testPostfix.infixToPostfix("(3+5)*2")) + "\n");
			} else {
				System.out.println("Error! Check the postfix or evaluate()");
			}
			
			//3+5*2-4
			System.out.println("Expression: 3+5*2-4");

			System.out.println("Postfix: " + testPostfix.infixToPostfix("3+5*2-4"));
			if (testPostfix.evaluate(testPostfix.infixToPostfix("3+5*2-4")) == 9) {
				System.out.println(
						"Correct! The result is: " + testPostfix.evaluate(testPostfix.infixToPostfix("3+5*2-4")) + "\n");
			} else {
				System.out.println("Error! Check the postfix or evaluate()");
			}
			
			//3+5*2-4
			System.out.println("Expression: 3+5*2-4");

			System.out.println("Postfix: " + testPostfix.infixToPostfix("3+5*2-4"));
			if (testPostfix.evaluate(testPostfix.infixToPostfix("3+5*2-4")) == 9) {
				System.out.println(
						"Correct! The result is: " + testPostfix.evaluate(testPostfix.infixToPostfix("3+5*2-4")) + "\n");
			} else {
				System.out.println("Error! Check the postfix or evaluate()");
			}
			
			//3*5+2-4
			System.out.println("Expression: 3*5+2-4");

			System.out.println("Postfix: " + testPostfix.infixToPostfix("3*5+2-4"));
			if (testPostfix.evaluate(testPostfix.infixToPostfix("3*5+2-4")) == 13) {
				System.out.println(
						"Correct! The result is: " + testPostfix.evaluate(testPostfix.infixToPostfix("3*5+2-4")) + "\n");
			} else {
				System.out.println("Error! Check the postfix or evaluate()");
			}
			
			//3-5+2*4
			System.out.println("Expression: 3-5+2*4");

			System.out.println("Postfix: " + testPostfix.infixToPostfix("3-5+2*4"));
			if (testPostfix.evaluate(testPostfix.infixToPostfix("3-5+2*4")) == 6) {
				System.out.println(
						"Correct! The result is: " + testPostfix.evaluate(testPostfix.infixToPostfix("3-5+2*4")) + "\n");
			} else {
				System.out.println("Error! Check the postfix or evaluate()");
			}
			
			//(3-5+2)*4
			System.out.println("Expression: (3-5+2)*4");

			System.out.println("Postfix: " + testPostfix.infixToPostfix("(3-5+2)*4"));
			if (testPostfix.evaluate(testPostfix.infixToPostfix("(3-5+2)*4")) == 0) {
				System.out.println(
						"Correct! The result is: " + testPostfix.evaluate(testPostfix.infixToPostfix("(3-5+2)*4")) + "\n");
			} else {
				System.out.println("Error! Check the postfix or evaluate()");
			}
			
			//3+5*2-4/2
			System.out.println("Expression: 3+5*2-4/2");

			System.out.println("Postfix: " + testPostfix.infixToPostfix("3+5*2-4/2"));
			if (testPostfix.evaluate(testPostfix.infixToPostfix("3+5*2-4/2")) == 11) {
				System.out.println(
						"Correct! The result is: " + testPostfix.evaluate(testPostfix.infixToPostfix("3+5*2-4/2")) + "\n");
			} else {
				System.out.println("Error! Check the postfix or evaluate()");
			}
			
			//3/5*2-4+2
			System.out.println("Expression: 3/5*2-4+2");

			System.out.println("Postfix: " + testPostfix.infixToPostfix("3/5*2-4+2"));
			if (testPostfix.evaluate(testPostfix.infixToPostfix("3/5*2-4+2")) == 0) {
				System.out.println(
						"Correct! The result is: " + testPostfix.evaluate(testPostfix.infixToPostfix("3/5*2-4+2")) + "\n");
			} else {
				System.out.println("Error! Check the postfix or evaluate()\n");
			}
			
			//3/5
			System.out.println("Expression: 3/5");

			System.out.println("Postfix: " + testPostfix.infixToPostfix("3/5"));
			if (testPostfix.evaluate(testPostfix.infixToPostfix("3/5")) == 0) {
				System.out.println(
						"Correct! The result is: " + testPostfix.evaluate(testPostfix.infixToPostfix("3/5")) + "\n");
			} else {
				System.out.println("Error! Check the postfix or evaluate()");
			}
			
			//8/4*2-4+2
			System.out.println("Expression: 8/4*2-4+2");

			System.out.println("Postfix: " + testPostfix.infixToPostfix("8/4*2-4+2"));
			if (testPostfix.evaluate(testPostfix.infixToPostfix("8/4*2-4+2")) == 2) {
				System.out.println(
						"Correct! The result is: " + testPostfix.evaluate(testPostfix.infixToPostfix("8/4*2-4+2")) + "\n");
			} else {
				System.out.println("Error! Check the postfix or evaluate()");
			}
			
			//8-4/2+4*2
			System.out.println("Expression: 8-4/2+4*2");

			System.out.println("Postfix: " + testPostfix.infixToPostfix("8-4/2+4*2"));
			if (testPostfix.evaluate(testPostfix.infixToPostfix("8-4/2+4*2")) == 14) {
				System.out.println(
						"Correct! The result is: " + testPostfix.evaluate(testPostfix.infixToPostfix("8-4/2+4*2")) + "\n");
			} else {
				System.out.println("Error! Check the postfix or evaluate()");
			}
			
			//4-8/2+4*2
			System.out.println("Expression: 4-8/2+4*2");

			System.out.println("Postfix: " + testPostfix.infixToPostfix("4-8/2+4*2"));
			if (testPostfix.evaluate(testPostfix.infixToPostfix("4-8/2+4*2")) == 8) {
				System.out.println(
						"Correct! The result is: " + testPostfix.evaluate(testPostfix.infixToPostfix("4-8/2+4*2")) + "\n");
			} else {
				System.out.println("Error! Check the postfix or evaluate()");
			}
			
			//(4-8)/2+4*2
			System.out.println("Expression: (4-8)/2+4*2");

			System.out.println("Postfix: " + testPostfix.infixToPostfix("(4-8)/2+4*2"));
			if (testPostfix.evaluate(testPostfix.infixToPostfix("(4-8)/2+4*2")) == 6) {
				System.out.println(
						"Correct! The result is: " + testPostfix.evaluate(testPostfix.infixToPostfix("(4-8)/2+4*2")) + "\n");
			} else {
				System.out.println("Error! Check the postfix or evaluate()");
			}
		} catch (InputException e) {
		}
	}

}
