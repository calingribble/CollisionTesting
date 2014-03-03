import java.awt.Image;
import java.io.File;
import javax.swing.ImageIcon;



public class scaledImages {
	public static Image[] SI = new Image[new File("scaledImages").listFiles().length];
	private static Image temp_image;
	
	public static void initializeScaledImages(){
		for (int i = 0; i < SI.length;i++){
			temp_image = new ImageIcon(scaledImages.class.getResource("s"+i+".png")).getImage();
			SI[i] = temp_image.getScaledInstance(temp_image.getWidth(null) * mainFrame.SCALE, temp_image.getHeight(null)* mainFrame.SCALE, Image.SCALE_FAST);
		}
	}
	

}
