import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JPanel;

public class render{
	public static Timer timer = new Timer();
	public static final int TARGET_FPS = 70;
	
	public static void render(final JPanel panel){
		
		TimerTask repaint = new TimerTask(){
			@Override
			public void run() {
				panel.repaint();	
			}	
		};
		timer.schedule(repaint, 0, 1000/TARGET_FPS);
	}
}
