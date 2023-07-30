import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * CalculatorTest class.
 *
 * @author  Timo Schmidt, Pavel Tsvyatkov
 * @version 2019.11.24
 */
public class CalculatorTest
{
    public CalculatorTest()
    {
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
    public void T01_01_TestDecTyping()
    {
        HexCalcEngine hexcalc = new HexCalcEngine();

        // 255
        hexcalc.numberPressed(2);
        hexcalc.numberPressed(5);
        hexcalc.numberPressed(5);
        assertEquals(255, hexcalc.getDisplayValue());
    }

    @Test
    public void T01_02_TestHexTyping()
    {
        HexCalcEngine hexcalc = new HexCalcEngine();
        HexUserInterface gui = new HexUserInterface(hexcalc);
        hexcalc.setHexMode(true);

        // DAD
        hexcalc.numberPressed(13);
        hexcalc.numberPressed(10);
        hexcalc.numberPressed(13);
        gui.redisplay();
        assertEquals("DAD", gui.getHexadecimal()); // F - A = 5
    }

    @Test
    public void T02_01_TestDecAddition()
    {
        HexCalcEngine hexcalc = new HexCalcEngine();

        // 2 + 5
        hexcalc.numberPressed(2);
        hexcalc.plus();
        hexcalc.numberPressed(5);
        hexcalc.equals();
        assertEquals(7, hexcalc.getDisplayValue());

        // 20 + 60
        hexcalc.numberPressed(2);
        hexcalc.numberPressed(0);
        hexcalc.plus();
        hexcalc.numberPressed(6);
        hexcalc.numberPressed(0);
        hexcalc.equals();
        assertEquals(80, hexcalc.getDisplayValue());


        // 122 + 188
        hexcalc.numberPressed(1);
        hexcalc.numberPressed(2);
        hexcalc.numberPressed(2);
        hexcalc.plus();
        hexcalc.numberPressed(1);
        hexcalc.numberPressed(8);
        hexcalc.numberPressed(8);
        hexcalc.equals();
        assertEquals(310, hexcalc.getDisplayValue());
    }

    @Test
    public void T02_02_TestDecSubtraction()
    {
        HexCalcEngine hexcalc = new HexCalcEngine();

        // 9 - 5
        hexcalc.numberPressed(9);
        hexcalc.minus();
        hexcalc.numberPressed(5);
        hexcalc.equals();
        assertEquals(4, hexcalc.getDisplayValue());

        // 20 - 13
        hexcalc.numberPressed(2);
        hexcalc.numberPressed(0);
        hexcalc.minus();
        hexcalc.numberPressed(1);
        hexcalc.numberPressed(3);
        hexcalc.equals();
        assertEquals(7, hexcalc.getDisplayValue());
    }

    @Test
    public void T02_03_TestDecMultiplication()
    {
        HexCalcEngine hexcalc = new HexCalcEngine();

        // 3 * 3
        hexcalc.numberPressed(3);
        hexcalc.multiply();
        hexcalc.numberPressed(3);
        hexcalc.equals();
        assertEquals(9, hexcalc.getDisplayValue());

        // 10 * 12
        hexcalc.numberPressed(10);
        hexcalc.multiply();
        hexcalc.numberPressed(12);
        hexcalc.equals();
        assertEquals(120, hexcalc.getDisplayValue());
    }

    @Test
    public void T02_04_TestDecDivision()
    {
        HexCalcEngine hexcalc = new HexCalcEngine();

        // 9 : 3
        hexcalc.numberPressed(9);
        hexcalc.divide();
        hexcalc.numberPressed(3);
        hexcalc.equals();
        assertEquals(3, hexcalc.getDisplayValue());

        // 40 : 10
        hexcalc.numberPressed(40);
        hexcalc.divide();
        hexcalc.numberPressed(10);
        hexcalc.equals();
        assertEquals(4, hexcalc.getDisplayValue());
    }


    @Test
    public void T03_01_TestHexAddition() {
        HexCalcEngine hexcalc = new HexCalcEngine();
        HexUserInterface gui = new HexUserInterface(hexcalc);
        hexcalc.setHexMode(true);

        // A + A
        hexcalc.numberPressed(10);
        hexcalc.plus();
        hexcalc.numberPressed(10);
        hexcalc.equals();
        gui.redisplay();
        assertEquals("14", gui.getHexadecimal());

        // FF + AA
        hexcalc.numberPressed(15);
        hexcalc.numberPressed(15);
        hexcalc.plus();
        hexcalc.numberPressed(10);
        hexcalc.numberPressed(10);
        hexcalc.equals();
        gui.redisplay();
        assertEquals("1A9", gui.getHexadecimal());

        // A5 + C9
        hexcalc.numberPressed(10);
        hexcalc.numberPressed(5);
        hexcalc.plus();
        hexcalc.numberPressed(12);
        hexcalc.numberPressed(9);
        hexcalc.equals();
        gui.redisplay();
        assertEquals("16E", gui.getHexadecimal());

        // ACD + F96
        hexcalc.numberPressed(10);
        hexcalc.numberPressed(12);
        hexcalc.numberPressed(13);
        hexcalc.plus();
        hexcalc.numberPressed(15);
        hexcalc.numberPressed(9);
        hexcalc.numberPressed(6);
        hexcalc.equals();
        gui.redisplay();
        assertEquals("1A63", gui.getHexadecimal());
    }

    @Test
    public void T03_02_TestHexSubtraction() {
        HexCalcEngine hexcalc = new HexCalcEngine();
        HexUserInterface gui = new HexUserInterface(hexcalc);
        hexcalc.setHexMode(true);

        // F - A
        hexcalc.numberPressed(15);
        hexcalc.minus();
        hexcalc.numberPressed(10);
        hexcalc.equals();
        gui.redisplay();
        assertEquals("5", gui.getHexadecimal());

        // CC - AA
        hexcalc.numberPressed(12);
        hexcalc.numberPressed(12);
        hexcalc.minus();
        hexcalc.numberPressed(10);
        hexcalc.numberPressed(10);
        hexcalc.equals();
        gui.redisplay();
        assertEquals("22", gui.getHexadecimal());

        // F9 - D5
        hexcalc.numberPressed(15);
        hexcalc.numberPressed(9);
        hexcalc.minus();
        hexcalc.numberPressed(13);
        hexcalc.numberPressed(5);
        hexcalc.equals();
        gui.redisplay();
        assertEquals("24", gui.getHexadecimal());

        // C1D – A5
        hexcalc.numberPressed(12);
        hexcalc.numberPressed(1);
        hexcalc.numberPressed(13);
        hexcalc.minus();
        hexcalc.numberPressed(10);
        hexcalc.numberPressed(5);
        hexcalc.equals();
        gui.redisplay();
        assertEquals("B78", gui.getHexadecimal());
    }

    @Test
    public void T03_03_TestHexMultiplication() {

        HexCalcEngine hexcalc = new HexCalcEngine();
        HexUserInterface gui = new HexUserInterface(hexcalc);
        hexcalc.setHexMode(true);

        // A*B
        hexcalc.numberPressed(10);
        hexcalc.multiply();
        hexcalc.numberPressed(11);
        hexcalc.equals();
        gui.redisplay();
        assertEquals("6E", gui.getHexadecimal());

        // AC*BD
        hexcalc.numberPressed(10);
        hexcalc.numberPressed(12);
        hexcalc.multiply();
        hexcalc.numberPressed(11);
        hexcalc.numberPressed(13);
        hexcalc.equals();
        gui.redisplay();
        assertEquals("7EFC", gui.getHexadecimal());

        // AAA*BBB
        hexcalc.numberPressed(10);
        hexcalc.numberPressed(10);
        hexcalc.numberPressed(10);
        hexcalc.multiply();
        hexcalc.numberPressed(11);
        hexcalc.numberPressed(11);
        hexcalc.numberPressed(11);
        hexcalc.equals();
        gui.redisplay();
        assertEquals("7D182E", gui.getHexadecimal());
    }

    @Test
    public void T03_04_TestHexDivision() {

        HexCalcEngine hexcalc = new HexCalcEngine();
        HexUserInterface gui = new HexUserInterface(hexcalc);
        hexcalc.setHexMode(true);

        // C/4
        hexcalc.numberPressed(12);
        hexcalc.divide();
        hexcalc.numberPressed(4);
        hexcalc.equals();
        gui.redisplay();
        assertEquals("3", gui.getHexadecimal());

        // FF/5
        hexcalc.numberPressed(15);
        hexcalc.numberPressed(15);
        hexcalc.divide();
        hexcalc.numberPressed(5);
        hexcalc.equals();
        gui.redisplay();
        assertEquals("33", gui.getHexadecimal());
    }

    @Test
    public void T04_01_TestNegativeResults() {
        HexCalcEngine hexcalc = new HexCalcEngine();
        HexUserInterface gui = new HexUserInterface(hexcalc);

        // Decimal mode 10 - 15
        hexcalc.setHexMode(false);
        hexcalc.numberPressed(1);
        hexcalc.numberPressed(0);
        hexcalc.minus();
        hexcalc.numberPressed(1);
        hexcalc.numberPressed(5);
        hexcalc.equals();
        assertEquals(-5, hexcalc.getDisplayValue());

        // Hexidecimal mode A1 - A2
        hexcalc.setHexMode(true);
        hexcalc.numberPressed(10);
        hexcalc.numberPressed(1);
        hexcalc.minus();
        hexcalc.numberPressed(10);
        hexcalc.numberPressed(2);
        hexcalc.equals();
        gui.redisplay();
        assertEquals("FFFFFFFF", gui.getHexadecimal());
    }

    @Test
    public void T04_02_StartingNumberNegative() {
        HexCalcEngine hexcalc = new HexCalcEngine();

        // -5 + 10
        hexcalc.minus();
        hexcalc.numberPressed(5);
        hexcalc.plus();
        hexcalc.numberPressed(1);
        hexcalc.numberPressed(0);
        hexcalc.equals();
        assertEquals(5, hexcalc.getDisplayValue());
    }

}









