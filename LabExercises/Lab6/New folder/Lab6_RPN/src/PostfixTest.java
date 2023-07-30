import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PostfixTest {

    @Test
    void TestEvaluatePostfix() throws StackOverflow, StackUnderflow {
        Postfix pfx = new Postfix();

        // Checking all finger exercises from prelab
        assertEquals(5, pfx.evaluate("12*3+"));
        assertEquals(7, pfx.evaluate("123*+"));
        assertEquals(-78, pfx.evaluate("12+34^-"));
        assertEquals(-11, pfx.evaluate("12^34*-"));
        assertEquals(-1011, pfx.evaluate("123*+45^-6+"));
        assertEquals(9, pfx.evaluate("12+3*456-^+"));
        assertEquals(98, pfx.evaluate("12+34/+5+678+*+"));
        assertEquals(-1, pfx.evaluate("91-2-32*-1-"));

        // Checking with spaces
        assertEquals(-1, pfx.evaluate("9 1 - 2 - 3 2 * - 1 -"));

    }

    @Test
    void TestInfixToPostfix() throws StackOverflow, StackUnderflow {
        Postfix pfx = new Postfix();

        // Checking all finger exercises from prelab
        assertEquals("12*3+", pfx.infixToPostfix("1 * 2 + 3"));
        assertEquals("123*+", pfx.infixToPostfix("1 + 2 * 3 "));
        assertEquals("12+34^-", pfx.infixToPostfix("1 + 2 - 3 ^ 4"));
        assertEquals("12^34*-", pfx.infixToPostfix("1 ^ 2 - 3 * 4 "));
        assertEquals("123*+45^-6+", pfx.infixToPostfix("1 + 2 * 3 - 4 ^ 5 + 6"));
        assertEquals("12+3*456-^+", pfx.infixToPostfix("( 1 + 2 ) * 3 + ( 4 ^ ( 5 - 6 ) )"));
        assertEquals("12+34/+5+678+*+", pfx.infixToPostfix("1 + 2 + 3 / 4 + 5 + 6 * ( 7 + 8 )"));
        assertEquals("91-2-32*-1-", pfx.infixToPostfix("9 - 1 - 2 - 3 * 2 - 1"));
    }

    @Test
    void TestInvalidExpressions() throws StackOverflow, StackUnderflow {
        Postfix pfx = new Postfix();

        String exc = "Input expression is not valid!";

        // Wrong parentheses
        assertEquals(exc, pfx.infixToPostfix("((5+3)+2"));
        assertEquals(exc, pfx.infixToPostfix("5+)3"));
        assertEquals(exc, pfx.infixToPostfix("5+(3"));
        assertEquals(exc, pfx.infixToPostfix(")3+4("));
        assertEquals(exc, pfx.infixToPostfix("3+4+5))"));

        // Invalid characters
        assertEquals(exc, pfx.infixToPostfix("!"));
        assertEquals(exc, pfx.infixToPostfix("$"));
        assertEquals(exc, pfx.infixToPostfix("?"));
        assertEquals(exc, pfx.infixToPostfix("&"));
        assertEquals(exc, pfx.infixToPostfix("#"));
    }
}