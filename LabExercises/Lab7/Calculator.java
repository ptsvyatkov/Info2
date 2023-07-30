public class Calculator
{
    private CalcEngine engine;
    private UserInterface gui;
    
    public static void main (String [] args) {
    	Calculator calculator = new Calculator();
    }

    /**
     * Create a new calculator and show it.
     */
    public Calculator()
    {
        engine = new CalcEngine();
        gui = new HexUI(engine);
    }

    /**
     * In case the window was closed, show it again.
     */
    public void show()
    {
        gui.setVisible(true);
    }
}
