import java.awt.Color;
import java.awt.Graphics2D;

import javax.swing.JFrame;

public class Window extends JFrame implements Runnable {

	Graphics2D g2d;

	public Window() {
		this.setSize(Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);
		this.setTitle(Constants.SCREEN_TITILE);
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		g2d = (Graphics2D) this.getGraphics();
	}

	public void update(double dt) {
		g2d.setColor(Color.BLACK);
		g2d.fillRect(0, 0, Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);
	}

	public void run() {
		double lastFrameTime = 0.0;
		while (true) {
			// Game Loop
			double time = Time.getTime();
			double deltaTime = time - lastFrameTime;
			lastFrameTime = time;
			update(deltaTime);
			try {
				Thread.sleep(30);
			} catch (Exception e) {

			}
		}
	}
}
