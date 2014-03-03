import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class mainFrame extends JFrame{
	public static final int SCALE = 3;
	public static final int WIDTH = 282*SCALE;
	public static final int HEIGHT = 188*SCALE;
	public static final String NAME = "Rockets and Barriers - Calin Gribble";
	public static final JPanel displayPanel = new JPanel();
	
	
	public mainFrame(){
		setTitle(NAME);
		setMinimumSize(new Dimension(WIDTH, HEIGHT ));
		setMaximumSize(new Dimension(WIDTH , HEIGHT));
		setPreferredSize(new Dimension(WIDTH , HEIGHT));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		add(displayPanel);
		displayPanel.setLayout(null);
		displayPanel.setBounds(0, 0, mainFrame.WIDTH, mainFrame.HEIGHT);
		displayPanel.setFocusable(true);
		displayPanel.setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
		displayPanel.add(new loadingPanel());
		setVisible(true);
		loadManager.LOAD_ALL(this);
		while(loadManager.LOADING_COMPLETE == false){
			
		}
		displayPanel.removeAll();
		starAnimation.ANIMATE_STARS();
		displayPanel.add(new mainPanel());//first panel to display
		
		pack();
		
			
	}
}
