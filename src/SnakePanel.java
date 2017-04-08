import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;

public class SnakePanel extends JPanel implements ActionListener {
	
	private static final int PLAYER_ONE_UP = KeyEvent.VK_W;
	private static final int PLAYER_ONE_DOWN = KeyEvent.VK_S;
	private static final int PLAYER_ONE_LEFT = KeyEvent.VK_A;
	private static final int PLAYER_ONE_RIGHT = KeyEvent.VK_D;
	
	public SnakePanel(int panelWidth, int panelHeight, double aspectRatio, int maxFPS) {
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(panelWidth, panelHeight));
		
	}
	
	public void updateGame() {
		
	}

	public void render() {
		
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		
	}

}
