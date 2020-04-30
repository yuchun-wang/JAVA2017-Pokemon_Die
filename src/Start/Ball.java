package Start;

import javax.swing.*;
import java.awt.Image;

public class Ball {
	
	private ImageIcon iconBall;
	private JLabel lbBall;
	private int x = 0, y = 630;
	
	public Ball(Start frame, int playerX) {
		iconBall = new ImageIcon("src/image/babyball.png");
		// getScaledInstance(int width, int height, int hints) Creates a scaled version of this image.
		iconBall.setImage(iconBall.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));			
		
		lbBall = new JLabel(iconBall);
		x = playerX + 50;
		lbBall.setBounds(x, y, 50, 50);
		
		frame.add(lbBall, 5);			
	}
	
	Music BackgroundMusic = new Music("src/Music/laser1.wav");
	
	public void move() {		
		while(y>=-50){
			if(Game.freeze==true) break;
			lbBall.setLocation(x, y-=25);
			try{
				Thread.sleep(15);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
	public void disappear() { lbBall.setVisible(false); }
	public int getX() { return x; } 
	public int getY() { return y; }
	
}
