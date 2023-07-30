import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class HexUserInterface extends UserInterface {

    private JCheckBox checkbox;
    private JPanel buttonPanelHex;

    public HexUserInterface(HexCalcEngine engine) {
        super(engine);
    }

    protected void makeFrame() {
        super.makeFrame();

        JPanel contentPane = (JPanel)frame.getContentPane();
        checkbox = new JCheckBox("Hexadecimal");

        buttonPanelHex = new JPanel(new GridLayout(4,2));
        buttonPanelHex.add(checkbox);
        buttonPanelHex.add(new JLabel(""));

        addButton(buttonPanelHex, "A");
        addButton(buttonPanelHex, "B");

        addButton(buttonPanelHex, "C");
        addButton(buttonPanelHex, "D");

        addButton(buttonPanelHex, "E");
        addButton(buttonPanelHex, "F");

        contentPane.add(buttonPanelHex, BorderLayout.EAST);

        // This method gets called once to grey out the buttons in the initial state
        checkBoxAction();

        checkbox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                checkBoxAction();
            }
        });

        frame.pack(); // changed to protected
    }

    /**
     * This method gets called when the checkbox state changes (checked/unchecked)
     */
    private void checkBoxAction() {
        boolean isChecked = checkbox.isSelected();
        ((HexCalcEngine) calc).inHexMode = isChecked;

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
