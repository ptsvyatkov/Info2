import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class HexInterface extends UserInterface
{
    protected boolean decHexSwitch = true;
    /**
     * Constructor for objects of class HexInterface
     */
    public HexInterface(CalcEngine engine)
    {
        super(engine);
    }

    protected void makeFrame(){
            super.makeFrame();
        
            buttonPanel.setLayout(new GridLayout(7, 4));
            addButton(buttonPanel, "A");
            addButton(buttonPanel, "B");
            addButton(buttonPanel, "C");
            addCheckBox(buttonPanel, "dec");
            
            addButton(buttonPanel, "D");
            addButton(buttonPanel, "E");
            addButton(buttonPanel, "F");
           
            frame.pack();
    }
    protected void addCheckBox(Container panel, String buttonText)
    {
        JCheckBox checkBox = new JCheckBox(buttonText);
        checkBox.addActionListener(this);
        buttonPanel.add(checkBox);
    }
    
    public void actionPerformed(ActionEvent event)
    {
        super.actionPerformed(event);
        String command = event.getActionCommand();

        if (command.equals("A") ||
            command.equals("B") || 
            command.equals("C") || 
            command.equals("D") ||
            command.equals("E") ||
            command.equals("F")){
                int decimal = Integer.parseInt(command, 16);
                displayValue += decimal;
                //calc.numberPressed(decimal);
        }
        else if(command.equals("dec")){
            
            decHexSwitch = !decHexSwitch;
            switchDecHex();
        }
        // else unknown command.

        redisplay();
    }
    public void switchDecHex () {
     
        Component[] button = buttonPanel.getComponents();
        
            for(int i = 0; i<button.length; i++){
                if (button[i] instanceof JButton) {
                    if(((JButton)button[i]).getText().matches("[A-Z]")){
                        ((JButton)button[i]).setEnabled(decHexSwitch);
                    }
                }
            }
         
        }
    
  
    public int calculate(String ifx) {
    	if (decHexSwitch) {
			
			String output = Integer.toHexString(super.calculate(displayValue));
	        super.displayValue = output;
		}else {
			super.calculate(ifx);
		}
    	return super.calculate(ifx);
    }
    
    
    public int convert(String bPressed){
        //bPressed
        return 10;
    }
   
    /*protected void redisplay()
    {   
    	if(decHexSwitch){
        Integer output = calc.getDisplayValue();
        String output = Integer.toHexString(calculate(displayValue));
        super.displayValue = output;
        display.setText("" + displayValue);
        } else {
        display.setText("" + displayValue);
       }
    	display.setText("" + displayValue);
    }*/
    
    
}
