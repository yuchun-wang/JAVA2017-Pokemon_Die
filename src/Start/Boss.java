package Start;

import java.awt.Image;
import java.util.Random;

import javax.swing.*;

public class Boss{
	
	private JLabel boss = null;
	private int x = 0, y = -20;
	public boolean alive = true;
	
	public Boss(Start frame, ImageIcon iconboss, int posX) {
		x = posX;
		try {
			iconboss.setImage(iconboss.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT));
			boss = new JLabel(iconboss);
			boss.setBounds(x, y, 150, 150);
			frame.add(boss, 5);
			boss.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void move() {
		for (y = y; y < 800; y = y + 3) {
			if(Game.freeze == true) break;
			boss.setLocation(x, y);
			try {
				Thread.sleep(15);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		if(Player.alive == true){
			if(Game.freeze == true)
				boss.setVisible(true);
			else
				boss.setVisible(false);
		}		
	}
	
	public void disappear() { boss.setVisible(false); }
	public int getX() { return x; }
	public int getY() { return y; }
	
}