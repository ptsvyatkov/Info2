import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JWindow;

public class Window2 extends JPanel {

	
	public void paint(Graphics g) {
		g.drawLine(0, 0, 120, 120);

	}
	

	public static void main(String[] args) {
		//
		JFrame frame = new JFrame();
		JWindow window = new JWindow(frame);

		frame.getContentPane().add(new Window2());

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1280, 800);
		frame.setVisible(true);
	}
}