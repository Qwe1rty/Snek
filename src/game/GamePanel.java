package game;

import javax.swing.JPanel;

public abstract class GamePanel extends JPanel {
	
	protected final double minWidth;
	protected final double minHeight;
	protected int panelWidth;
	protected int panelHeight;
	
	protected int scalingSize;
	protected int frameCount;
	
	public GamePanel(double minWidth, double minHeight) {
		this.minWidth = minWidth;
		this.minHeight = minHeight;
	}

	public void updateGame(int scalingSize, long frameCount) {
		// OVERRIDE THIS METHOD, ABSTRACTING CAUSES PROBLEMS
	}
	
	protected void updatePanelDimensions(int scalingSize) {
		panelWidth = (int) Math.round(minWidth * scalingSize);
		panelHeight = (int) Math.round(minHeight * scalingSize);
	}
	
	public final void render() {
		repaint();
		revalidate();
	}
	
	// Getters and setters
//	protected int getScalingSize() {return scalingSize;}
//	protected int getFrameCount() {return frameCount;}
//	protected void setScalingSize(int scalingSize) {this.scalingSize = scalingSize;}
//	protected void setFrameCount(int frameCount) {this.frameCount = frameCount;}
}
