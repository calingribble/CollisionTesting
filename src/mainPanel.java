import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.*;

public class mainPanel extends JPanel{
	
	public JButton barrierOnButton1;
	public JButton barrierOffButton1;
	public JButton barrierOnButton2;
	public JButton barrierOffButton2;
	public JButton barrierOnButton3;
	public JButton barrierOffButton3;
	public barrier barrier1;
	public barrier barrier2;
	public barrier barrier3;
	
	public int collisionX;
	public int collisionY;
	public Image collideImage;
	public double temp = 3;

	
	double alphaGlow = .5;
	boolean increasing;
	public void barrierGlow(){
		TimerTask glow = new TimerTask(){
			public void run() {
				if(increasing){
					if(alphaGlow < .98){
						alphaGlow+= .01;
					}else{
						increasing = false;
					}
				}else{
					if(alphaGlow >.5){
						alphaGlow-= .01;
					}else{
						increasing = true;
					}	
				}
			}
				
		};
		
		render.timer.schedule(glow, 0,20);
	}
	rocket rocket;
	public void generateRocket(){
		
		TimerTask genRocket = new TimerTask(){
			public void run() {
				rocket = new rocket();
			}
				
		};
		
		render.timer.schedule(genRocket, 0, 6000);
	}

	public mainPanel(){
		setLayout(null);
		setBounds(0, 0, mainFrame.WIDTH, mainFrame.HEIGHT);
		render.render(this);
		barrierGlow();
		generateRocket();

		barrierOnButton1 = new JButton();
		barrierOnButton1.setSize(images.I[0].getWidth(null),images.I[0].getHeight(null));
		barrierOnButton1.setIcon(new ImageIcon(images.I[0]));
		barrierOnButton1.setDisabledIcon(barrierOnButton1.getIcon());
		barrierOnButton1.setBorder(BorderFactory.createEmptyBorder());
		barrierOnButton1.setContentAreaFilled(false);
		barrierOnButton1.addMouseListener(new java.awt.event.MouseAdapter() {
			int x = 0;
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				x = 1;
				barrierOnButton1.setIcon(new ImageIcon(images.I[1]));
				    	
			}
			public void mouseExited(java.awt.event.MouseEvent evt) {
				x = 0;
				barrierOnButton1.setIcon(new ImageIcon(images.I[0]));
				    	
			}
			public void mousePressed(java.awt.event.MouseEvent evt) {
				barrierOnButton1.setIcon(new ImageIcon(images.I[2]));
			}
			public void mouseReleased(java.awt.event.MouseEvent evt) {
				if(x == 1){
				    barrierOnButton1.setIcon(new ImageIcon(images.I[1]));
				}else{
					barrierOnButton1.setIcon(new ImageIcon(images.I[0]));
				}
			}
			});
			barrierOnButton1.addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent e)
		            {
		            	barrier1.on = true;
		            	add(barrierOffButton1);
						remove(barrierOnButton1);
		            }
		    });
			barrierOnButton1.setLocation(141*mainFrame.SCALE, 160*mainFrame.SCALE);
			add(barrierOnButton1);
			
			//barrierOffButton1
			barrierOffButton1 = new JButton();
			barrierOffButton1.setSize(images.I[3].getWidth(null),images.I[3].getHeight(null));
			barrierOffButton1.setIcon(new ImageIcon(images.I[3]));
			barrierOffButton1.setDisabledIcon(barrierOffButton1.getIcon());
			barrierOffButton1.setBorder(BorderFactory.createEmptyBorder());
			barrierOffButton1.setContentAreaFilled(false);
			barrierOffButton1.addMouseListener(new java.awt.event.MouseAdapter() {
				int x = 0;
				public void mouseEntered(java.awt.event.MouseEvent evt) {
					x = 1;
					barrierOffButton1.setIcon(new ImageIcon(images.I[4]));
					    	
				}
				public void mouseExited(java.awt.event.MouseEvent evt) {
					x = 0;
					barrierOffButton1.setIcon(new ImageIcon(images.I[3]));
					    	
				}
				public void mousePressed(java.awt.event.MouseEvent evt) {
					barrierOffButton1.setIcon(new ImageIcon(images.I[5]));
				}
				public void mouseReleased(java.awt.event.MouseEvent evt) {
					if(x == 1){
					    barrierOffButton1.setIcon(new ImageIcon(images.I[4]));
					}else{
						barrierOffButton1.setIcon(new ImageIcon(images.I[3]));
					}
				}
				});
			barrierOffButton1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e)
			    {
					barrier1.on = false;
					remove(barrierOffButton1);
					add(barrierOnButton1);
			    }
			});
			barrierOffButton1.setLocation(141*mainFrame.SCALE, 160*mainFrame.SCALE);
			//add(barrierOffButton1);
			//barrierOnButton1
			barrierOnButton2 = new JButton();
			barrierOnButton2.setSize(images.I[0].getWidth(null),images.I[0].getHeight(null));
			barrierOnButton2.setIcon(new ImageIcon(images.I[0]));
			barrierOnButton2.setDisabledIcon(barrierOnButton2.getIcon());
			barrierOnButton2.setBorder(BorderFactory.createEmptyBorder());
			barrierOnButton2.setContentAreaFilled(false);
			barrierOnButton2.addMouseListener(new java.awt.event.MouseAdapter() {
				int x = 0;
				public void mouseEntered(java.awt.event.MouseEvent evt) {
					x = 1;
					barrierOnButton2.setIcon(new ImageIcon(images.I[1]));
					    	
				}
				public void mouseExited(java.awt.event.MouseEvent evt) {
					x = 0;
					barrierOnButton2.setIcon(new ImageIcon(images.I[0]));
					    	
				}
				public void mousePressed(java.awt.event.MouseEvent evt) {
					barrierOnButton2.setIcon(new ImageIcon(images.I[2]));
				}
				public void mouseReleased(java.awt.event.MouseEvent evt) {
					if(x == 1){
					    barrierOnButton2.setIcon(new ImageIcon(images.I[1]));
					}else{
						barrierOnButton2.setIcon(new ImageIcon(images.I[0]));
					}
				}
				});
				barrierOnButton2.addActionListener(new ActionListener() {
			            public void actionPerformed(ActionEvent e)
			            {
			            	barrier2.on = true;
			            	add(barrierOffButton2);
							remove(barrierOnButton2);
			            }
			    });
				barrierOnButton2.setLocation(181*mainFrame.SCALE, 160*mainFrame.SCALE);
				add(barrierOnButton2);
				
				//barrierOffButton2
				barrierOffButton2 = new JButton();
				barrierOffButton2.setSize(images.I[3].getWidth(null),images.I[3].getHeight(null));
				barrierOffButton2.setIcon(new ImageIcon(images.I[3]));
				barrierOffButton2.setDisabledIcon(barrierOffButton2.getIcon());
				barrierOffButton2.setBorder(BorderFactory.createEmptyBorder());
				barrierOffButton2.setContentAreaFilled(false);
				barrierOffButton2.addMouseListener(new java.awt.event.MouseAdapter() {
					int x = 0;
					public void mouseEntered(java.awt.event.MouseEvent evt) {
						x = 1;
						barrierOffButton2.setIcon(new ImageIcon(images.I[4]));
						    	
					}
					public void mouseExited(java.awt.event.MouseEvent evt) {
						x = 0;
						barrierOffButton2.setIcon(new ImageIcon(images.I[3]));
						    	
					}
					public void mousePressed(java.awt.event.MouseEvent evt) {
						barrierOffButton2.setIcon(new ImageIcon(images.I[5]));
					}
					public void mouseReleased(java.awt.event.MouseEvent evt) {
						if(x == 1){
						    barrierOffButton2.setIcon(new ImageIcon(images.I[4]));
						}else{
							barrierOffButton2.setIcon(new ImageIcon(images.I[3]));
						}
					}
					});
				barrierOffButton2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e)
				    {
						barrier2.on = false;
						remove(barrierOffButton2);
						add(barrierOnButton2);
				    }
				});
				barrierOffButton2.setLocation(181*mainFrame.SCALE, 160*mainFrame.SCALE);
				//add(barrierOffButton1);
				//barrierOnButton3
				barrierOnButton3 = new JButton();
				barrierOnButton3.setSize(images.I[0].getWidth(null),images.I[0].getHeight(null));
				barrierOnButton3.setIcon(new ImageIcon(images.I[0]));
				barrierOnButton3.setDisabledIcon(barrierOnButton3.getIcon());
				barrierOnButton3.setBorder(BorderFactory.createEmptyBorder());
				barrierOnButton3.setContentAreaFilled(false);
				barrierOnButton3.addMouseListener(new java.awt.event.MouseAdapter() {
					int x = 0;
					public void mouseEntered(java.awt.event.MouseEvent evt) {
						x = 1;
						barrierOnButton3.setIcon(new ImageIcon(images.I[1]));
						    	
					}
					public void mouseExited(java.awt.event.MouseEvent evt) {
						x = 0;
						barrierOnButton3.setIcon(new ImageIcon(images.I[0]));
						    	
					}
					public void mousePressed(java.awt.event.MouseEvent evt) {
						barrierOnButton3.setIcon(new ImageIcon(images.I[2]));
					}
					public void mouseReleased(java.awt.event.MouseEvent evt) {
						if(x == 1){
						    barrierOnButton3.setIcon(new ImageIcon(images.I[1]));
						}else{
							barrierOnButton3.setIcon(new ImageIcon(images.I[0]));
						}
					}
					});
					barrierOnButton3.addActionListener(new ActionListener() {
				            public void actionPerformed(ActionEvent e)
				            {
				            	barrier3.on = true;
				            	add(barrierOffButton3);
								remove(barrierOnButton3);
				            }
				    });
					barrierOnButton3.setLocation(221*mainFrame.SCALE, 160*mainFrame.SCALE);
					add(barrierOnButton3);
					
					//barrierOffButton1
					barrierOffButton3 = new JButton();
					barrierOffButton3.setSize(images.I[3].getWidth(null),images.I[3].getHeight(null));
					barrierOffButton3.setIcon(new ImageIcon(images.I[3]));
					barrierOffButton3.setDisabledIcon(barrierOffButton3.getIcon());
					barrierOffButton3.setBorder(BorderFactory.createEmptyBorder());
					barrierOffButton3.setContentAreaFilled(false);
					barrierOffButton3.addMouseListener(new java.awt.event.MouseAdapter() {
						int x = 0;
						public void mouseEntered(java.awt.event.MouseEvent evt) {
							x = 1;
							barrierOffButton3.setIcon(new ImageIcon(images.I[4]));
							    	
						}
						public void mouseExited(java.awt.event.MouseEvent evt) {
							x = 0;
							barrierOffButton3.setIcon(new ImageIcon(images.I[3]));
							    	
						}
						public void mousePressed(java.awt.event.MouseEvent evt) {
							barrierOffButton3.setIcon(new ImageIcon(images.I[5]));
						}
						public void mouseReleased(java.awt.event.MouseEvent evt) {
							if(x == 1){
							    barrierOffButton3.setIcon(new ImageIcon(images.I[4]));
							}else{
								barrierOffButton3.setIcon(new ImageIcon(images.I[3]));
							}
						}
						});
					barrierOffButton3.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e)
					    {
							barrier3.on = false;
							remove(barrierOffButton3);
							add(barrierOnButton3);
					    }
					});
					barrierOffButton3.setLocation(221*mainFrame.SCALE, 160*mainFrame.SCALE);
					//add(barrierOffButton1);	
			
			barrier1 = new barrier(140*mainFrame.SCALE, 4* mainFrame.SCALE);
			barrier2 = new barrier(180*mainFrame.SCALE, 4* mainFrame.SCALE);
			barrier3 = new barrier(220*mainFrame.SCALE, 4* mainFrame.SCALE);
		
		
		
		setFocusable(true);
		setVisible(true);	
	}
	public void setEnabled(boolean enabled) {
	    super.setEnabled(enabled);
	    for (Component component : getComponents())
	        component.setEnabled(enabled);
	    
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(new Color(11,14,41));
		g2d.fillRect(0, 0, mainFrame.WIDTH, mainFrame.HEIGHT);
		g2d.setColor(Color.WHITE);
		starAnimation.RENDER_STARS(g2d);
		g2d.drawImage(scaledImages.SI[1],0,0,null);
		try{
			if(rocket.getAlive()){
				g2d.drawImage(scaledImages.SI[0], rocket.getX(), rocket.y, null);
			}
		}catch(Exception e){
			
		}
		
	}
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float)alphaGlow));
		barrier1.drawBarrier(g2d);
		barrier2.drawBarrier(g2d);
		barrier3.drawBarrier(g2d);
		if(!rocket.getAlive()){
			rocket.stop();
			rocket.running = false;
		}else{
			int temp2 = rocket.barrierCheck(barrier1, barrier2, barrier3);
			if(temp2 !=0){
				temp = 3;
				rocket.stop();
				if(temp2 == 1){
					collisionX = barrier1.x1;
				}else if(temp2 == 2){
					collisionX = barrier2.x1;
				}else if(temp2 == 3){
					collisionX = barrier3.x1;
				}
				collisionY = rocket.y;
					
			}
		}
		temp+=.1;
		try{
			g2d.drawImage(scaledImages.SI[(int)temp], collisionX - scaledImages.SI[3].getWidth(null), collisionY - (26*mainFrame.SCALE) , null);
		}catch(Exception e){
			
		}
	}

}
