import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.*;

import javax.swing.ImageIcon;


public class PF_TEMPESTA_SEVEN {
	public static Font PF_Tempesta_Seven;
	
	public static void LOAD(){
		try {
			InputStream in = PF_TEMPESTA_SEVEN.class.getResourceAsStream("pf_tempesta_seven_bold.TTF");
			PF_Tempesta_Seven = Font.createFont( Font.TRUETYPE_FONT, in );
			//PF_Tempesta_Seven = PF_Tempesta_Seven.deriveFont(Font.PLAIN,(float)fontSize);
			GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(PF_Tempesta_Seven);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FontFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
