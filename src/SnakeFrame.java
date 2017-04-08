import java.awt.Dimension;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.UIManager;

public class SnakeFrame extends JFrame implements WindowListener {

	private SnakePanel panel;

	// 12 wide, 17 high, multiples of 60/85
	final static double MIN_WIDTH = 60.000;
	final static double MIN_HEIGHT = 85.000;
	final static double ASPECT_RATIO = MIN_WIDTH / MIN_HEIGHT;
	
	// Because java sucks
	final static int HORIZONTAL_OFFSET = 18; 
	final static int VERTICAL_OFFSET = 48;
	
	// Default scaling of 10
	final static int INITIAL_WIDTH = 660;
	final static int INITIAL_HEIGHT = 935;
	
	// Frame management
	final static int MAX_FPS = 30;
	final static int OPTIMAL_DELAY = 1000 / MAX_FPS;

	public static void main(String[] args) throws Exception {
		try {UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());} catch(Exception e) {}
		SnakeFrame frame = new SnakeFrame("Snek");
		frame.setVisible(true);
	}

	// CONSTRUCTOR
	public SnakeFrame(String title) {

		// Frame initialization
		super(title);
		setResizable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(30,30);
		setSize(INITIAL_WIDTH, INITIAL_HEIGHT);

		// Create panel with default initializations
		panel = new SnakePanel(MIN_WIDTH, MIN_HEIGHT);
		panel.setBounds(0, 0, INITIAL_WIDTH, INITIAL_HEIGHT);
		add(panel);

		// Main game loop
		Thread runGame = new Thread(new Runnable() {
			@Override
			public void run() {
				
				long frameCount = 0;
				while (true) {
					try {
						
						// Initial time
						long startTime = System.nanoTime();
						
						// Get screen dimensions
						Dimension screenSize = getSize();
						int width = ((int) screenSize.getWidth()) - HORIZONTAL_OFFSET;
						int height = ((int) screenSize.getHeight()) - VERTICAL_OFFSET;
						
						// Do game updates
						panel.setBounds(0, 0, width, height);
						panel.updateGame(width, height, frameCount);
						panel.render();
						
						// Increment frame counter
						if (frameCount == Long.MAX_VALUE) frameCount = 0;
						else frameCount++;
						
						// Finished time
						long endTime = System.nanoTime();
						long timeDifferenceMillis = (endTime - startTime) / 1000000;
						try {Thread.sleep(OPTIMAL_DELAY - timeDifferenceMillis);} catch (Exception e) {}
						
					} catch (Exception e) {}
				}
			}
		});
		runGame.start();
	}

	@Override
	public void windowActivated(WindowEvent e) {
	}
	@Override
	public void windowClosed(WindowEvent e) {
		System.exit(0);
	}
	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}
	@Override
	public void windowDeactivated(WindowEvent e) {
	}
	@Override
	public void windowDeiconified(WindowEvent e) {
	}
	@Override
	public void windowIconified(WindowEvent e) {
	}
	@Override
	public void windowOpened(WindowEvent e) {
	}

}
