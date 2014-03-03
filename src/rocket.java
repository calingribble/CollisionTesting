import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class rocket {
	static int speed;
	static int x;
	int y;
	Random rand =  new Random();
	TimerTask run = new TimerTask(){
		public void run() {
			rocket.x+=rocket.speed;
		}
			
	};
	Timer timer = new Timer();
	boolean running;
	
	public rocket(){
		this.x = -(scaledImages.SI[0].getWidth(null)*mainFrame.SCALE);
		this.y = (mainFrame.SCALE * 20) + (int)(Math.random() * (((mainFrame.SCALE * 120) - (mainFrame.SCALE * 20)) + 1));
		this.speed = 5;
		this.run();
		this.running = true;
	}
	
	public int getX(){
		return this.x;
	}

	public boolean getAlive(){
		if(x < mainFrame.WIDTH + (scaledImages.SI[0].getWidth(null)*mainFrame.SCALE) && this.running){
			return true;
		}else{
			return false;
		}
	}
	/*public void run(){
		while(x < mainFrame.WIDTH + (scaledImages.SI[0].getWidth(null)*mainFrame.SCALE)){
			x+=speed;
		}
	}*/
	public void run(){
		this.stop();
		run = new TimerTask(){
			public void run() {
				rocket.x+=rocket.speed;
				
			}	
		};
		timer.schedule(run, 0, 20);
	}
	
	public void stop(){
		timer.purge();
		timer.cancel();
		timer = new Timer();
		run.cancel();
		this.running = false;
	}
	public int barrierCheck(barrier b1, barrier b2, barrier b3){
		int collision = 0;
		if(b1.on){
			for(int i = this.x; i < this.x + (scaledImages.SI[0].getWidth(null) + mainFrame.SCALE); i++){
				for(int j = b1.x1; j < b1.x2; j++){
					if(i == j) collision = 1;
				}
			}
		}
		if(b2.on){
			for(int i = this.x; i < this.x + (scaledImages.SI[0].getWidth(null) + mainFrame.SCALE); i++){
				for(int j = b2.x1; j < b2.x2; j++){
					if(i == j) collision = 2;
				}
			}
		}
		if(b3.on){
			for(int i = this.x; i < this.x + (scaledImages.SI[0].getWidth(null) + mainFrame.SCALE); i++){
				for(int j = b3.x1; j < b3.x2; j++){
					if(i == j) collision = 3;
				}
			}
		}
		return collision;
	}
	
	
}
