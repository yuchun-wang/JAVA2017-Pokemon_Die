package Start;

import java.awt.Image;
import javax.swing.*;
import java.util.Random;

public class Fire {
	
	private JLabel fire = null;
	private int x = 0, y = -100;
	
	public Fire(Start frame, ImageIcon iconfire){
			
		Random ran = new Random();
		x = ran.nextInt(400)+10;
		
		try{
			iconfire.setImage(iconfire.getImage().getScaledInstance(80, 160, Image.SCALE_DEFAULT));
			fire = new JLabel(iconfire); 
			fire.setBounds(x, y, 80, 160);
			frame.add(fire, 5);
			fire.setVisible(true);
			}
		catch(Exception e){
			e.printStackTrace();
			}		
	}
	
	public void move() {
		for(y = y; y < 800; y = y+5){
			if(Game.freeze == true) break;
			fire.setLocation(x, y);
			try{ 
				Thread.sleep(15);
				}
			catch(Exception e){
				e.printStackTrace(); 
			}
		}
		if(Game.freeze == true)
			fire.setVisible(true);
		else
			fire.setVisible(false);
	}
	
	public int getX() { return x; } 
	public int getY() { return y; }
	
}