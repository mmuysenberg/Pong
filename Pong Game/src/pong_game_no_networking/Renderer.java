package pong_game_no_networking;

import java.awt.Graphics;

import javax.swing.JPanel;

public class Renderer extends JPanel {

	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Pong.pong.render(g);
	}
}
