/**
 * The main class of a simple calculator. Create one of these and you'll
 * get the calculator on screen.
 * 
 * @author David J. Barnes and Michael Kolling
 * @version 2008.03.30
 */
public class Calculator
{
    //private CalcEngine engine;
    private HexCalcEngine hexengine;
    //private UserInterface gui;
    private HexCalculator hex;

    /**
     * Create a new calculator and show it.
     */
    public Calculator()
    {
        hexengine = new HexCalcEngine();
        //gui = new UserInterface(engine);
        hex = new HexCalculator(hexengine);
    }

    /**
     * In case the window was closed, show it again.
     */
    public void show()
    {
        hex.setVisible(true);
    }
}
