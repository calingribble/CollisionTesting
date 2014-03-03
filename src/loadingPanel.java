import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JPanel;


public class loadingPanel extends JPanel {
	static Timer timer = new Timer();
	static int x = 0;
	static float opacity = 1.0f;
	public static void startLoadAnimation(){
		TimerTask loadAnimation = new TimerTask(){
			public void run() {
				if (x != 3){
					x++;
				}else{
					x = 0;
				}
				
			}
		};
		timer.schedule(loadAnimation, 0, 200);
	}
	
	public loadingPanel(){
		PF_TEMPESTA_SEVEN.LOAD();
		setLayout(null);
		setBounds(0, 0, mainFrame.WIDTH, mainFrame.HEIGHT);
		startLoadAnimation();
		setFocusable(true);
		setVisible(true);
		render.render(this);
	}
	public void paint(Graphics g){
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.BLACK);
		g2d.fillRect(0, 0, mainFrame.WIDTH, mainFrame.HEIGHT);
		g2d.setColor(Color.WHITE);
		g2d.setFont(new Font("PF Tempesta Seven", Font.PLAIN, mainFrame.SCALE*18));
		if (x == 0){
			g2d.drawString("LOADING", (mainFrame.WIDTH / 2)-(mainFrame.SCALE * 53), mainFrame.HEIGHT / 2);
		}else if (x == 1){
			g2d.drawString("LOADING.", (mainFrame.WIDTH / 2)-(mainFrame.SCALE * 53), mainFrame.HEIGHT / 2);
		}else if (x == 2){
			g2d.drawString("LOADING..", (mainFrame.WIDTH / 2)-(mainFrame.SCALE * 53), mainFrame.HEIGHT / 2);
		}else {
			g2d.drawString("LOADING...", (mainFrame.WIDTH / 2)-(mainFrame.SCALE * 53), mainFrame.HEIGHT / 2);
		}
		
		
		
	}
}
