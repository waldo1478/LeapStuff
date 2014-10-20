import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

/*
 * This really just draws a Ship object onscreen...not much to see here...move along.
 */
public class LeapDemoFramePollingDrawingArea extends JPanel
{
	public static int WIDTH, HEIGHT;
	private Ship ship;
	
	public LeapDemoFramePollingDrawingArea(int w, int h, Ship s)
	{
		WIDTH = w;
		HEIGHT = h;
		ship = s;
		setBackground(Color.GREEN);
	}
	
	
	//this is the method that actually draws this region of screen...
	//do any custom drawing in here for this region
	public void paintComponent(Graphics g)
	{
		//always call super.paintComponent() in a JPanel subclass
		super.paintComponent(g);
		
		ship.draw(g);
	}
	
	
	
	
	//REQUIRED: the following help fix the size of this JPanel…you will probably have the same 
	//	methods inside any subclass of JPanel that you create.
	public Dimension getSize(){
		return new Dimension( WIDTH, HEIGHT );
	}
	public Dimension getMinimumSize(){
		return getSize();
	}
	public Dimension getMaximumSize(){
		return getSize();
	}
	public Dimension getPreferredSize(){
		return getSize();
	}
	public int getWidth(){
		return WIDTH;
	}
	public int getHeight(){
		return HEIGHT;
	}
}
