import java.awt.Image;
import java.awt.MediaTracker;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JPanel;


public class images {
	public static Image[] I = new Image[new File("images").listFiles().length];
	private static Image temp_image;
	
	public static void initializeImages(){
		for (int i = 0; i < I.length;i++){
			temp_image = new ImageIcon(images.class.getResource(i+".png")).getImage();
			I[i] = temp_image.getScaledInstance(temp_image.getWidth(null), temp_image.getHeight(null), Image.SCALE_FAST);
		}
	}
	

}
