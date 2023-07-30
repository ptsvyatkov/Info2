
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *
 */
public class CalculatorTest
{
    private CalculatorTest calcTest;
    private CalcEngine engine;
    private HexUI gui;
    public CalculatorTest()
    {
        engine = new CalcEngine();
        gui = new HexUI(engine);
    }

    @Before
    public void setUp()
    {
    }

    @After
    public void tearDown()
    {
    }   

    @Test
    public void DecimalTest()
    {
        engine.numberPressed(5);
        engine.plus();
        engine.numberPressed(5);
        engine.equals();
        assertEquals(10, engine.getDisplayValue());
        engine.multiply();
        engine.numberPressed(5);
        engine.equals();
        assertEquals(50, engine.getDisplayValue());
        engine.minus();
        engine.numberPressed(55);
        engine.equals();
        assertEquals(-5, engine.getDisplayValue());
        engine.clear();
    }

    @Test
    public void HexadecimalTest()
    {
        engine.numberPressed(1);
        engine.numberPressed(0);
        engine.plus();
        engine.numberPressed(1);
        engine.numberPressed(0);
        engine.equals();
        gui.redisplay();
        assertEquals("14", gui.returnHexNumber());
        engine.multiply();
        engine.numberPressed(1);
        engine.numberPressed(0);
        engine.equals();
        gui.redisplay();
        assertEquals("C8", gui.returnHexNumber());
        engine.minus();
        engine.numberPressed(1);
        engine.numberPressed(0);
        engine.equals();
        gui.redisplay();
        assertEquals("BE", gui.returnHexNumber());
        engine.clear();
    }

    @Test
    public void ClearTest()
    {
        assertEquals(0, engine.getDisplayValue());
        engine.numberPressed(9);
        engine.numberPressed(6);
        engine.numberPressed(3);
        engine.clear();
        engine.equals();
        assertEquals(0, engine.getDisplayValue());
        gui.redisplay();
        assertEquals("0", gui.returnHexNumber());
    }

    @Test
    public void DeepTest()
    {
        engine.numberPressed(234);
        engine.multiply();
        engine.numberPressed(136);
        engine.equals();
        assertEquals(31824, engine.getDisplayValue());
        gui.redisplay();
        assertEquals("7C50", gui.returnHexNumber());
        engine.minus();
        engine.numberPressed(40000);
        engine.equals();
        assertEquals(-8176, engine.getDisplayValue());
        gui.redisplay();
        assertEquals("-E7DC", gui.returnHexNumber());
        engine.clear();
        assertEquals(0, engine.getDisplayValue());
    }
    
    @Test
    public void OverflowTest()
    {
        engine.numberPressed(999);
        engine.multiply();
        engine.numberPressed(999);
        engine.equals();
        assertEquals(31824, engine.getDisplayValue());
        gui.redisplay();
        assertEquals("7C50", gui.returnHexNumber());
        engine.minus();
        engine.numberPressed(40000);
        engine.equals();
        assertEquals(-8176, engine.getDisplayValue());
        gui.redisplay();
        assertEquals("-E7DC", gui.returnHexNumber());
        engine.clear();
        assertEquals(0, engine.getDisplayValue());
    }
}
