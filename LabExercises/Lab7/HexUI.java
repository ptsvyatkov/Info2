import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.Container;
//import java.awt.GridBagLayout;
import java.awt.GridLayout;
//import java.awt.Panel;
import java.awt.event.ActionEvent;
//import java.awt.event.ItemListener;

import javax.swing.AbstractButton;
//import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
//import javax.swing.JLabel;
import javax.swing.JPanel;
//import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class HexUI extends UserInterface {
	Checkbox checkbox;
	JPanel hexButtons;
	JFrame hexFrame;
	boolean stateCheckbox = true;
	String hexNumber;

	public HexUI(CalcEngine engine) {
		super(engine);
		hexFrame.setVisible(true);
		frame.setVisible(false);
	}

	protected void makeFrame() {
		hexFrame = new JFrame(calc.getTitle());
		JPanel content = (JPanel) hexFrame.getContentPane();
		content.setLayout(new BorderLayout(8, 8));
		content.setBorder(new EmptyBorder(10, 10, 10, 10));

		hexButtons = new JPanel(new GridLayout(6, 1));
		addButton(hexButtons, "A");
		addButton(hexButtons, "B");
		addButton(hexButtons, "C");
		addButton(hexButtons, "D");
		addButton(hexButtons, "E");
		addButton(hexButtons, "F");

		content.add(hexButtons, BorderLayout.EAST);

		super.makeFrame();
		content.add(super.frame.getContentPane(), BorderLayout.CENTER);

		JPanel checkPanel = new JPanel(new GridLayout(1, 1));
		addCheckbox(checkPanel, "Hexadecimal", true);
		// checkbox.addActionListener();
		content.add(checkPanel, BorderLayout.SOUTH);

		hexButtons.setVisible(true);

		/*status = new JLabel(calc.getAuthor());
		content.add(status, BorderLayout.SOUTH);*/

		hexFrame.pack();

	}

	public void setVisible(boolean visible) {
		hexFrame.setVisible(visible);
	}

	public void actionPerformed(ActionEvent event) {
		String command = event.getActionCommand();
		AbstractButton hexDeCheckBox = (AbstractButton) event.getSource();
		boolean selected = hexDeCheckBox.getModel().isSelected();
		
		//System.out.println(command);
		if (command.equals("A")) {
			calc.numberPressed(1);
			calc.numberPressed(0);
		} else if (command.equals("B")) {
			calc.numberPressed(1);
			calc.numberPressed(1);
		} else if (command.equals("C")) {
			calc.numberPressed(1);
			calc.numberPressed(2);
		} else if (command.equals("D")) {
			calc.numberPressed(1);
			calc.numberPressed(3);
		} else if (command.equals("E")) {
			calc.numberPressed(1);
			calc.numberPressed(4);
		} else if (command.equals("F")) {
			calc.numberPressed(1);
			calc.numberPressed(5);
		} else {
			super.actionPerformed(event);
		}
		if (command.equals("Hexadecimal")) {
			hexButtons.setVisible(selected);
			stateCheckbox = selected;
		}
		if (stateCheckbox) {
			redisplay();
		}
		else {
			super.redisplay();
		}
		
	}

	protected void redisplay() {
		char[] hexArray = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
		int decimalDisplay = calc.getDisplayValue();
		String hexDisplayString = "";
		int hexDisplay;
		if (decimalDisplay == 0) {
			hexDisplayString = "0";
		}
		while (decimalDisplay > 0) {
			hexDisplay = decimalDisplay / 16;
			hexDisplayString += hexArray[decimalDisplay % 16];
			decimalDisplay = hexDisplay;
		}
		String hexReverse = mirror(hexDisplayString);
		display.setText("" + hexReverse);
	}

	private String mirror(String str) {
		String mirrorString = "";
		for (int i = str.length() - 1; i >= 0; i--) {
			mirrorString += str.charAt(i);
		}
		hexNumber = mirrorString;
		return mirrorString;
	}

	private void addCheckbox(Container panel, String checkboxString, boolean state) {
		JCheckBox checkbox = new JCheckBox(checkboxString, state);
		checkbox.addActionListener(this);
		panel.add(checkbox);
	}
	
	protected String returnHexNumber() {
		return hexNumber;
	}
	
	
}
