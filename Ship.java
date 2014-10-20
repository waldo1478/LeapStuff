import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;


/*
 * A simple thing to keep onscreen in a Leap demo...it can move, change size, and change color.
 */
public class Ship
{
	private int x, y, palmX, palmY, width, height, rotate;
	
	private int radius = 30;
	
	private Color clr;
	
	public Ship(int x, int y, int palmX, int palmY, int rotate)
	{
		this.x = x;
		this.y = y;
		this.palmX = palmX;
		this.palmY = palmY;
		this.rotate = rotate;
		clr = Color.RED;
	}
	
	public int getX() { return x; }
	public int getY() { return y; }
	public int getRadius() { return radius; }
	
	
	/*
	 * Change the x-coord of the ship but keep the center onscreen.
	 */
	public void changeX( int delta ) 
	{ 
//		x += delta;
//		
//		if(x < 0) x = 0;
//		if(x > LeapDemoFramePollingDrawingArea.WIDTH) x = LeapDemoFramePollingDrawingArea.WIDTH;
		x = 250;
	}
	
	/*
	 * Change the y-coord of the ship but keep the center onscreen.
	 */
	public void changeY( int delta ) 
	{ 
		y = 250;
//		y += delta; 
//	
//		if(y < 0) y = 0;
//		if(y > LeapDemoFramePollingDrawingArea.HEIGHT) y = LeapDemoFramePollingDrawingArea.HEIGHT;
	}
	
	/*
	 * Changes the radius by some amount (pos. or neg.) and maintains certain size limits.
	 */
	public void changeRadius( int delta )
	{
		radius = delta;
		width = delta;
		height = delta;
		
		if(radius < 3) radius = 3;		// a minimum size
//		if(radius > 120) radius = 120;	// a maximum size
	}
	
	public void changeRotate( int delta )
	{
		rotate = delta;
		
//		if(radius < 3) radius = 3;		// a minimum size
//		if(radius > 120) radius = 120;	// a maximum size
	}
	
	public void changeAspects( int width, int height )
	{
		this.width = width;
		this.height = height;
		
//		if(radius < 3) radius = 3;		// a minimum size
//		if(radius > 120) radius = 120;	// a maximum size
	}
	
	public void changePalmCoord( int x, int y )
	{
		palmX = x;
		palmY = y;
		
//		if(radius < 3) radius = 3;		// a minimum size
//		if(radius > 120) radius = 120;	// a maximum size
	}
	
	/*
	 * Changes the color to some random color
	 */
	public void changeColor()
	{
		clr = new Color( 	(int)(Math.random()*255), 
							(int)(Math.random()*255), 
							(int)(Math.random()*255) 
						);
	}
	
	public void draw(Graphics g)
	{
		Graphics2D g2d = (Graphics2D)g;
		g2d.setColor(clr);
//		g.fillOval(x - radius, y - radius, 2*radius, 2*radius);
//		g2d.translate(palmX ,palmY);
//		g2d.rotate(Math.toRadians(rotate));
//		g2d.fillRect(palmX - radius, palmY - radius, 2*radius, 2*radius);
		
		g2d.translate(x,y); // Translate the center of our coordinates.
		g2d.rotate( Math.toRadians(rotate), width, height);  // Rotate the image by 1 radian.
		g2d.fillRect( 0, 0, width*2, height*2);
	}
}
