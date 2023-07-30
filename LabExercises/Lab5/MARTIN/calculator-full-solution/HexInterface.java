import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class HexInterface extends UserInterface
{
    
    /**
     * Constructor for objects of class HexInterface
     */
    public HexInterface(CalcEngine engine)
    {
        super(engine);
    }

    protected void makeFrame(){
        super.makeFrame();
        //frame = new JFrame("Hex Rechner");
        
        //JPanel contentPane = (JPanel)frame.getContentPane();
        //contentPane.setLayout(new BorderLayout(8, 8));
        //contentPane.setBorder(new EmptyBorder( 10, 10, 10, 10));

        //display = new JTextField();
        //contentPane.add(display, BorderLayout.NORTH);

            buttonPanel.setLayout(new GridLayout(10, 4));
            super.addButton(buttonPanel, "A");
            super.addButton(buttonPanel, "B");
            super.addButton(buttonPanel, "C");
            super.addButton(buttonPanel, "D");
            super.addButton(buttonPanel, "E");
            super.addButton(buttonPanel, "F");
            
            //contentPane.add(buttonPanel, BorderLayout.CENTER);

        //status = new JLabel(calc.getAuthor());
        //contentPane.add(status, BorderLayout.SOUTH);

        frame.pack();
    }
    
    /*public void actionPerformed(ActionEvent event){
        super.actionPerformed(event);
        String command = event.getActionCommand();

        if(command.equals("A") ||
           command.equals("B") ||
           command.equals("C") ||
           command.equals("D") ||
           command.equals("E") ||
           command.equals("F")) {
            //int letter = (int) (command-55);
           //int letter = Integer.parseInt(command);
           //int letter = command;
           //calc.numberPressed(convert());
        }
    }*/
    public void actionPerformed(ActionEvent event)
    {
        super.actionPerformed(event);
        String command = event.getActionCommand();

        if(command.equals("A")) {
            calc.numberPressed(10);
        }
        else if(command.equals("B")) {
            calc.numberPressed(11);
        }
        else if(command.equals("C")) {
            calc.numberPressed(12);
        }
        else if(command.equals("D")) {
            calc.numberPressed(13);
        }
        else if(command.equals("E")) {
            calc.numberPressed(14);
        }
        else if(command.equals("F")){
            calc.numberPressed(15);
        }
        // else unknown command.

        super.redisplay();
    }
    
    
    public int convert(String bPressed){
        //bPressed
        return 10;
    }
}
