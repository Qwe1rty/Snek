package main;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import game.*;

public class SnakePanel extends JPanel {
	
	// Panel that displays the game
	private GamePanel gamePanel;
	
	private final double minWidth;
	private final double minHeight;
	private final double aspectRatio;
	
	private int scalingSize = 1;
	private int panelWidth = 0;
	private int panelHeight = 0;
	private int gameWidth = 0;
	private int gameHeight = 0;
	
	// T = top, B = bottom, L = left, R = right 
	private int TLx;
	private int TLy;
	private int TRx;
	private int TRy;
	private int BLx;
	private int BLy;
	private int BRx;
	private int BRy;
	
	// CONSTRUCTOR
	public SnakePanel(double minWidth, double minHeight) {
		setBackground(Color.WHITE);
		this.minWidth = minWidth;
		this.minHeight = minHeight;
		this.aspectRatio = this.minWidth / this.minHeight;
		
//		gamePanel = new GamePanel(minWidth, minHeight);
		// TODO IMPLEMENT MAINMENUPANEL
		add(gamePanel);
	}
	
	public void updateGame(int panelWidth, int panelHeight, long frameCount) {
		
		// For rendering
		this.panelWidth = panelWidth;
		this.panelHeight = panelHeight;
		
		// Calculates the scaling size
		if (aspectRatio * panelHeight < panelWidth) // Wider than is necessary, limited by height
			scalingSize = (int) (Math.floor(panelHeight / minHeight));
		else scalingSize = (int) (Math.floor(panelWidth / minWidth)); // Taller than necessary, limited by width
		
		// Determine boundaries of actual game
		gameWidth = (int) (minWidth * scalingSize);
		gameHeight = (int) (minHeight * scalingSize);
		TLx = ((panelWidth - gameWidth) / 2);
		TLy = ((panelHeight - gameHeight) / 2);
		TRx = TLx + gameWidth;
		TRy = TLy;
		BLx = TLx;
		BLy = TLy + gameHeight;
		BRx = TRx;
		BRy = BLy;
		
		// Set boundaries of the game panel
		gamePanel.setBounds(TLx, TLy, gameWidth, gameHeight);
		
		// Update game panel
		gamePanel.updateGame(scalingSize, frameCount);
		gamePanel.render();
		
	}
	
	public void render() {
		// Forcibly updates the game panel
		repaint();
		revalidate();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		// Draws game background (grey is placeholder)
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(0, 0, panelWidth, panelHeight);
		
		// Draw borders of the game
		g.setColor(Color.BLACK);
		g.fillRect(TLx - 2, TLy - 2, gameWidth + 2, 2);
		g.fillRect(TLx - 2, TLy - 2, 2, gameHeight + 2);
		g.fillRect(BLx - 2, BLy, gameWidth + 2, 2);
		g.fillRect(TRx, TRy - 2, 2, gameHeight + 4);
		
//		g.setColor(Color.RED);
//		g.drawLine(TLx, TLy, TRx, TRy);
//		g.drawLine(TLx, TLy, BLx, BLy);
//		g.drawLine(BLx, BLy, BRx, BRy);
//		g.drawLine(TRx, TRy, BRx, BRy);
		
		// DEBUG INFO
		g.setColor(Color.BLACK);
		g.drawString("Panel width: " + String.valueOf(panelWidth), 10, 18);
		g.drawString("Panel height: " + String.valueOf(panelHeight), 10, 38);
		g.drawString("Game width: " + String.valueOf(gameWidth), 10, 58);
		g.drawString("Game height: " + String.valueOf(gameHeight), 10, 78);
		g.drawString("Scaling size: " + String.valueOf(scalingSize), 10, 98);
		g.drawString("TL: (" + String.valueOf(TLx) + ", " + String.valueOf(TLy) + ")", 10, 118);
		g.drawString("BL: (" + String.valueOf(BLx) + ", " + String.valueOf(BLy) + ")", 10, 138);
	}
	
}
