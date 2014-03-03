import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.util.TimerTask;


public class barrier {
	boolean on;
	int x1;
	int x2;
	int y1;
	int y2;
	
	
	public barrier(int startX, int startY){
		this.on = false;
		this.x1 = startX;
		this.x2 = startX + (13 * mainFrame.SCALE);
		this.y1 = startY;
		this.y2 = startY + (144 * mainFrame.SCALE);
	}
	public void drawBarrier(Graphics2D g2d){
		if (this.on){
			for(int i = 0; i < this.y2 / mainFrame.SCALE;i++){
				g2d.drawImage(scaledImages.SI[2], this.x1,this.y1 + (i * mainFrame.SCALE), scaledImages.SI[2].getWidth(null),scaledImages.SI[2].getHeight(null), null);
			}
		}
	}
	
}
