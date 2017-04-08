import javax.swing.JFrame;
import javax.swing.UIManager;

public class SnakeFrame extends JFrame {
	
	private SnakePanel panel;
	
	final static double ASPECT_RATIO = 60/85; // 12 wide, 17 high, multiples of 60/85
	final static int INITIAL_WIDTH = 600;
	final static int INITIAL_HEIGHT = 850;
	final static int MAX_FPS = 30;

	public static void main(String[] args) throws Exception {
		try {UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());} catch(Exception e) {}
		SnakeFrame frame = new SnakeFrame("Snek");
		frame.setVisible(true);
	}
	
	public SnakeFrame(String title) {
		
		// Frame initialization
		super(title);
		setResizable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(30,30);
		setSize(INITIAL_WIDTH, INITIAL_HEIGHT);
		
		// Create panel with default initializations
		panel = new SnakePanel(INITIAL_WIDTH, INITIAL_HEIGHT, ASPECT_RATIO, MAX_FPS);
		
		// Main game loop
		new Thread(new Runnable() {
			@Override
			public void run() {
				boolean isRunning = true;
				while (isRunning) {
					 try {
						 panel.updateGame();
						 panel.render();
						 
					 } catch (Exception e) {}
				}
			}
		}).start();
		
	}

}
