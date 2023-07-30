import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class HexCalculator extends UserInterface {

    private String displayValueHex = "";
    private int displayValue;
    private boolean buildingDisplayValueHex;
    private JCheckBox checkbox;
    private JPanel buttonPanelHex;

    public HexCalculator(HexCalcEngine hexengine) {
        super(hexengine);
    }

    protected void makeFrame() {
        super.makeFrame();

        JPanel contentPane = (JPanel)frame.getContentPane();
        checkbox = new JCheckBox("Hexadecimal");

        buttonPanelHex = new JPanel(new GridLayout(5,2));
            buttonPanelHex.add(checkbox);
            buttonPanelHex.add(new JLabel(""));

            addButton(buttonPanelHex, "A");           // in order to get this to work we needed to change addButton to protected
            addButton(buttonPanelHex, "B");

            addButton(buttonPanelHex, "C");
            addButton(buttonPanelHex, "D");

            addButton(buttonPanelHex, "E");
            addButton(buttonPanelHex, "F");

        contentPane.add(buttonPanelHex, BorderLayout.EAST);

        // This method gets called once to grey out the buttons in the initial state
        checkBoxAction();

        checkbox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                checkBoxAction();
            }
        });

        frame.pack(); // changed to protected
    }

    public void actionPerformed(ActionEvent event) {
        super.actionPerformed(event);
        String command = event.getActionCommand();

        switch (command) {
            case "A":
                display.setText(buildHexValue(command));
                calc.numberPressed(10);
                break;
            case "B":
                display.setText(buildHexValue(command));
                calc.numberPressed(11);
                break;
            case "C":
                display.setText(buildHexValue(command));
                calc.numberPressed(12);
                break;
            case "D":
                display.setText(buildHexValue(command));
                calc.numberPressed(13);
                break;
            case "E":
                display.setText(buildHexValue(command));
                calc.numberPressed(14);
                break;
            case "F":
                display.setText(buildHexValue(command));
                calc.numberPressed(15);
                break;
            case "+":
            case "-":
            case "*":
            case "/":
            case "=":
            case "AC":
                buildingDisplayValueHex = false;
                break;
        }

    }

    private String buildHexValue(String value) {
        if (buildingDisplayValueHex) {
            displayValueHex += value;
            }
        else {
            displayValueHex = value;
            buildingDisplayValueHex = true;
            }
        displayValue = Integer.valueOf(displayValueHex, 16);
        return displayValueHex;
    }

    protected void redisplay() {
        super.redisplay();

        // as long as the value gets built, show the String instead of number
        if (checkbox.isSelected()) {
            if (buildingDisplayValueHex)
                display.setText(displayValueHex);

        int dec = calc.getDisplayValue();
        display.setText(Integer.toHexString(dec).toUpperCase());
        }
    }

    /**
     * This method gets called when the checkbox state changes (checked/unchecked)
     */
    private void checkBoxAction() {
        boolean isChecked = checkbox.isSelected();

        Component[] button = buttonPanelHex.getComponents();
        for (Component component : button) {
            if (component instanceof JButton) {
                if (((JButton) component).getText().matches("[A-F]")) {
                    component.setEnabled(isChecked);
                }
            }
        }
    }

}
