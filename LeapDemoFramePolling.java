import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/*
 * This class creates a Ship, a place to display the Ship, and an AnimationManager that runs
 * in its own Thread of execution. The AnimationManager is where the fun is at; it is responsible
 * for getting data from the Leap, updating the Ship based on the data, requesting redraws from
 * the onscreen windows, and then controlling the timing of the animation so that you can 
 * achieve consistent performance on different devices.
 */
public class LeapDemoFramePolling extends JFrame
{
	private JPanel drawingArea;
	
	private Ship ship;
	
	private Thread animationThread;
	private AnimationManagerLeapDemoPolling aniManager;

	
	public LeapDemoFramePolling()
	{
		super("I made this...and so can you!");				
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);	
		setSize(620, 640);
		
		
		//create the ship object and then pass it off to the drawing area and the animation manager
		ship = new Ship(300, 300, 0, 0, 0);
		
		//note the this�the GameArea will store a reference to this object, the main JFrame
		drawingArea = new LeapDemoFramePollingDrawingArea(600, 600, ship);		

		
		/*
		* Construct the AnimationManager and then pass it off to the Thread constructor...
		* calling start() on the Thread will call the run() method of the AnimationManager
		* which is where the real party is. In an infinite loop, the run() method:
		* 1) Asks the Leap directly for data
		* 2) Uses the data to modify the onscreen Ship
		* 3) Forces a repaint of the program, thus displaying the updated values/positions of Shippy
		* 4) Calculates an appropriate amount of time to pause before running the loop again. This
		* 	 last step gives you control over the speed of your animation (or other process for
		* 	 other applications).
		*/
		aniManager = new AnimationManagerLeapDemoPolling(ship, this);
		animationThread = new Thread(aniManager);
		animationThread.start();

		
		
		
		//put the JPanel onscreen and then display this window
		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());
		contentPane.add( drawingArea, BorderLayout.CENTER );
		
		setVisible(true);
	}
	
	
	
	//You need a main method...just build one of these windows and then kick back and enjoy
	//the fun :)
	public static void main(String[] args)
	{
		new LeapDemoFramePolling();
	}
	
}
