import java.awt.GraphicsEnvironment;
import java.awt.MediaTracker;
import javax.swing.JFrame;

public class loadManager {
	public static boolean LOADING_COMPLETE = false;
	public static void LOAD_ALL(JFrame frame)  
	{  
	LOADING_COMPLETE = false;
	
	images.initializeImages();
	scaledImages.initializeScaledImages();
	MediaTracker tracker = new MediaTracker(frame);  
	for (int i = 0; i < images.I.length; i++) {
			tracker.addImage( images.I[i], 0 );  

				try  
				{  
					tracker.waitForAll();  
				}  
				catch( InterruptedException x )  
				{  
						System.err.println( "MediaTracker interrupted! Image "+i+"!");  
				}  
	}  
	for (int i = 0; i < scaledImages.SI.length; i++) {
		tracker.addImage( scaledImages.SI[i], 0 );  

			try  
			{  
				tracker.waitForAll();  
			}  
			catch( InterruptedException x )  
			{  
				System.err.println( "MediaTracker interrupted! Scaled image "+i+"!");  
			}  
}  
	LOADING_COMPLETE = true;
	}
	}
