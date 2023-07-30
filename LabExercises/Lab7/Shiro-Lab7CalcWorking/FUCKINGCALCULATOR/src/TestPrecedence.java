import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class TestPrecedence.
 *
 * @author  Sophia Stölzle, Timo Schmidt
 * @version 2019.12.07
 */
public class TestPrecedence
{
	
    private CalcEngine calc;

    /**
     * Default constructor for test class TestPrecedence
     */
    public TestPrecedence()
    {
        
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        calc = new CalcEngine();
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    @Test
    /**
     * 1*2+3
     */
    public void testCase1() throws StackUnderflow
    {
        calc.buttonPressed("1");
        calc.buttonPressed("*");
        calc.buttonPressed("2");
        calc.buttonPressed("+");
        calc.buttonPressed("3");
        assertEquals("1*2+3", calc.getDisplayString());
        calc.equals();
        assertEquals("5", calc.getDisplayString());
    }

    @Test
    /**
     * 1+2*3 = 
     */
    public void testCase2() throws StackUnderflow
    {
        calc.buttonPressed("1");
        calc.buttonPressed("+");
        calc.buttonPressed("2");
        calc.buttonPressed("*");
        calc.buttonPressed("3");
        assertEquals("1+2*3", calc.getDisplayString());
        calc.equals();
        assertEquals("7", calc.getDisplayString());
    }
    
    @Test
    /**
     * 4+2*2*2
     */
    public void testCase3() throws StackUnderflow
    {
        calc.buttonPressed("4");
        calc.buttonPressed("+");
        calc.buttonPressed("2");
        calc.buttonPressed("*");
        calc.buttonPressed("2");
        calc.buttonPressed("*");
        calc.buttonPressed("2");
        assertEquals("4+2*2*2", calc.getDisplayString());
        calc.equals();
        assertEquals("12", calc.getDisplayString());
    }
    
    @Test
    /**
     * 5-2*3
     */
    public void testCase4() throws StackUnderflow
    {
        calc.buttonPressed("5");
        calc.buttonPressed("-");
        calc.buttonPressed("2");
        calc.buttonPressed("*");
        calc.buttonPressed("3");
        assertEquals("5-2*3", calc.getDisplayString());
        calc.equals();
        assertEquals("-1", calc.getDisplayString());
    }
    
    @Test
    /**
     * 8/4-2
     */
    public void testCase5() throws StackUnderflow
    {
        calc.buttonPressed("8");
        calc.buttonPressed("/");
        calc.buttonPressed("4");
        calc.buttonPressed("-");
        calc.buttonPressed("2");
        assertEquals("8/4-2", calc.getDisplayString());
        calc.equals();
        assertEquals("0", calc.getDisplayString());
    }
    
    @Test
    /**
     * 8/(4-2)
     */
    public void testCase6() throws StackUnderflow
    {
        calc.buttonPressed("8");
        calc.buttonPressed("/");
        calc.buttonPressed("(");
        calc.buttonPressed("4");
        calc.buttonPressed("-");
        calc.buttonPressed("2");
        calc.buttonPressed(")");
        assertEquals("8/(4-2)", calc.getDisplayString());
        calc.equals();
        assertEquals("4", calc.getDisplayString());
    }
    
    @Test
    /**
     * 9/3+6/2 
     */
    public void testCase7() throws StackUnderflow
    {
        calc.buttonPressed("9");
        calc.buttonPressed("/");
        calc.buttonPressed("3");
        calc.buttonPressed("+");
        calc.buttonPressed("6");
        calc.buttonPressed("/");
        calc.buttonPressed("2");
        assertEquals("9/3+6/2", calc.getDisplayString());
        calc.equals();
        assertEquals("6", calc.getDisplayString());
    }
    
    @Test
    /**
     * (9/3+6)/3 
     */
    public void testCase8() throws StackUnderflow
    {
        calc.buttonPressed("(");
        calc.buttonPressed("9");
        calc.buttonPressed("/");
        calc.buttonPressed("3");
        calc.buttonPressed("+");
        calc.buttonPressed("6");
        calc.buttonPressed(")");
        calc.buttonPressed("/");
        calc.buttonPressed("3");
        assertEquals("(9/3+6)/3", calc.getDisplayString());
        calc.equals();
        assertEquals("3", calc.getDisplayString());
    }
    
    @Test
    /**
     * 2^5*2-6 = 58 
     */
    public void testCase9() throws StackUnderflow
    {
        calc.buttonPressed("2");
        calc.buttonPressed("^");
        calc.buttonPressed("5");
        calc.buttonPressed("*");
        calc.buttonPressed("2");
        calc.buttonPressed("-");
        calc.buttonPressed("6");
        assertEquals("2^5*2-6", calc.getDisplayString());
        calc.equals();
        assertEquals("58", calc.getDisplayString());
    }
    
    @Test
    /**
     * 2^(5*2-6) = 16
     */
    public void testCase10() throws StackUnderflow
    {
        calc.buttonPressed("2");
        calc.buttonPressed("^");
        calc.buttonPressed("(");
        calc.buttonPressed("5");
        calc.buttonPressed("*");
        calc.buttonPressed("2");
        calc.buttonPressed("-");
        calc.buttonPressed("6");
        calc.buttonPressed(")");
        assertEquals("2^(5*2-6)", calc.getDisplayString());
        calc.equals();
        assertEquals("16", calc.getDisplayString());
    }
    
    @Test
    /**
     * 7*(3+5*(14-2)/2)/3-1 = 76
     */
    public void testCase11() throws StackUnderflow
    {
    	calc.displayString = "7*(3+5*(14-2)/2)/3-1";
    	calc.equals();
    	assertEquals("76", calc.getDisplayString());
    	
    }
    
    @Test
    /**
     * 7+(2+5)*(18+3*2)/(11-8) = 63
     */
    public void testCase12() throws StackUnderflow
    {
    	calc.displayString = "7+(2+5)*(18+3*2)/(11-8)";
    	calc.equals();
    	assertEquals("63", calc.getDisplayString());
    }
    
    @Test
    /**
     * (6+(20-3*5)+9)/4 = 5
     * @throws StackUnderflow
     */
    public void testCase13() throws StackUnderflow
    {
    	calc.displayString = "(6+(20-3*5)+9)/4";
    	calc.equals();
    	assertEquals("5", calc.getDisplayString());
    }
    
    @Test
    /**
     *((15/5)+(10/2-14/7))*10/5 = 12
     * @throws StackUnderflow
     */
    public void testCase14() throws StackUnderflow
    {
        calc.displayString = "((15/5)+(10/2-14/7))*10/5";
        calc.equals();
        assertEquals("12", calc.getDisplayString());
    }
    
    @Test
    /**
     * (2-3)^2/(3-2)^2+2 = 3
     * @throws StackUnderflow
     */
    public void testCase15() throws StackUnderflow
    {
    	 calc.displayString = "(2-3)^2/(3-2)^2+2";
         calc.equals();
         assertEquals("3", calc.getDisplayString());
    }
}


