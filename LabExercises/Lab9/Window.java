import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JWindow;

public class Window {
JWindow window;
JFrame frame;
Graphics graphic;
Dimension dimension;
int length;

	public Window() {
		frame = new JFrame();
		dimension = new Dimension (1280, 800);
		length = dimension.height;
		frame.setPreferredSize(dimension);
		window = new JWindow(frame);
		graphic = window.getGraphics();
	}
	
	public void makeTriangle () {
		graphic.drawLine(33, 99, 66, 11);
		graphic.drawLine(66, 11, 99, 99);
		graphic.drawLine(99, 99, 33, 99);
	}
	
	public static void main (String [] args) {
		Window window = new Window();
		window.makeTriangle();
		
	}

}
