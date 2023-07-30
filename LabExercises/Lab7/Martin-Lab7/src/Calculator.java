/**
 * The main class of a simple calculator. Create one of these and you'll
 * get the calculator on screen.
 * 
 * @author David J. Barnes and Michael Kolling
 * @version 2008.03.30
 */
public class Calculator
{
	public static void main(String[] args) {
		Calculator calc = new Calculator();
		calc.show();
	}
    private CalcEngine engine;
    private UserInterface gui;
    private HexInterface guiHex;
    /**
     * Create a new calculator and show it.
     */
    public Calculator()
    {
        engine = new CalcEngine();
       //gui = new UserInterface(engine);
        guiHex = new HexInterface(engine);
    }

    /**
     * In case the window was closed, show it again.
     */
    public void show()
    {
    	//gui.setVisible(true);
       guiHex.setVisible(true);
    }
}
