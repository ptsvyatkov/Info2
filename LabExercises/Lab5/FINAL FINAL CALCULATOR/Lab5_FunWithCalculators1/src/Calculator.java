/**
 * The main class of a simple calculator. Create one of these and you'll
 * get the calculator on screen.
 * 
 * @author David J. Barnes and Michael Kolling
 *         extended by Timo Schmidt, Pavel Tsvyatkov
 * @version 2019.11.24
 */
public class Calculator
{
    private HexCalcEngine engine;
    private HexUserInterface gui;

    /**
     * Create a new calculator and show it.
     */
    public Calculator()
    {
        engine = new HexCalcEngine();
        gui = new HexUserInterface(engine);
    }

    /**
     * In case the window was closed, show it again.
     */
    public void show()
    {
        gui.setVisible(true);
    }
}
