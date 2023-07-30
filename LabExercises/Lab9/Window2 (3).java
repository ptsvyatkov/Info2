import java.awt.Color;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JWindow;

public class Window2 extends JPanel {
	static Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
	int sidelength;
	Color[] colorArray = { new Color(205,50,50), new Color(205,38,38), new Color(50,205,50), new Color(139,0,0), 
			new Color(0,255,100), new Color(32,178,170), new Color(205,255,112), new Color(34,139,34) };
	JFrame frame;
	JWindow window;

	public static void main(String[] args) {
		Window2 window = new Window2();
		window.makeWindow();
	}

	public Window2() {
		frame = new JFrame();
		window = new JWindow(frame);
		frame.addComponentListener(new ComponentAdapter() {
			public void componentResized(ComponentEvent e) {
				d = frame.getSize();
//				System.out.println("new height: " + d.height + ", new width: " + d.width);
				repaint();
			}
		});
	}

	public void makeWindow() {
		frame.getContentPane().add(new Window2());
		frame.setPreferredSize(d);
		frame.setVisible(true);
		frame.pack();
	}

	public void paintComponent(Graphics g) {
		sidelength = (int) (d.height / (Math.sqrt(3) / 2));
		int side = (int) (sidelength / 2 * Math.sqrt(3));
		int[] point1 = { d.width / 2, 0 };
		int[] point2 = { d.width / 2 - sidelength / 2, side };
		int[] point3 = { d.width / 2 + sidelength / 2, side };
		g.setColor(colorArray[0]);
		
//		int side = (int) (sidelength/2 * Math.sqrt(3)); // 692 , didn't know how to
//		name this variable lol

//		Left side, but starts from top to bottom
		g.drawLine(point1[0], point1[1], point2[0], point2[1]);

//		Bottom side, starts from left to right
		g.drawLine(point2[0], point2[1], point3[0], point3[1]);

//		Right side, starts from top to bottom right
		g.drawLine(point1[0], point1[1], point3[0], point3[1]);
		
//		g.fillPolygon(new int [] {point1 [0], point2 [0], point3 [0]}, new int [] {point1 [1], point2 [1], point3 [1]}, 3);
		
		makeTriangle(g, point1, point2, point3, 0);

	}

	public void makeTriangle(Graphics g, int[] pointA, int[] pointB, int[] pointC, int counter) {
//		can sidelength be more than 800?

		if (counter < colorArray.length - 1) {
			counter++;
		} else {
			counter = 0;
		}
		g.setColor(colorArray[counter]);
		sidelength = (int) Math.sqrt(Math.pow((pointA[0] - pointB[0]), 2) + Math.pow((pointA[1] - pointB[1]), 2));

		int[] newPointA = findMidpoint(pointA[0], pointA[1], pointB[0], pointB[1]);
		int[] newPointB = findMidpoint(pointB[0], pointB[1], pointC[0], pointC[1]);
		int[] newPointC = findMidpoint(pointA[0], pointA[1], pointC[0], pointC[1]);

		g.drawLine(newPointA[0], newPointA[1], newPointB[0], newPointB[1]);
		g.drawLine(newPointB[0], newPointB[1], newPointC[0], newPointC[1]);
		g.drawLine(newPointA[0], newPointA[1], newPointC[0], newPointC[1]);
		
		g.fillPolygon(new int [] {newPointA [0], newPointB [0], newPointC [0]}, 
				new int [] {newPointA [1], newPointB [1], newPointC [1]}, 3);

		if (sidelength > 10) {
			makeTriangle(g, pointA, newPointA, newPointC, counter);
			makeTriangle(g, pointB, newPointB, newPointA, counter);
			makeTriangle(g, pointC, newPointC, newPointB, counter);
		}

	}

	private int[] findMidpoint(int x1, int y1, int x2, int y2) {
		int[] midpoint = new int[2];
		midpoint[0] = (x1 + x2) / 2;
		midpoint[1] = (y1 + y2) / 2;
		return midpoint;
	}

}