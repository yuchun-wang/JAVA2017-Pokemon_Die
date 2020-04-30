package Start;

import javax.swing.*;
import java.awt.Image;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class Player implements KeyListener {
	
	private ImageIcon iconConan;
	private JLabel lbConan;
	private int x = 230, y = 630;
	public static boolean alive = true; 
	
	public Player(Start frame) {
		iconConan = new ImageIcon("src/image/conan.png");
		// getScaledInstance(int width, int height, int hints) Creates a scaled version of this image.
		iconConan.setImage(iconConan.getImage().getScaledInstance(130, 130, Image.SCALE_DEFAULT));			
		
		lbConan = new JLabel(iconConan);
		lbConan.setBounds(x, y, 130, 130);
		
		frame.setFocusable(true);
		frame.requestFocus();
		frame.addKeyListener(this);
		frame.add(lbConan, 4);
	}
		
	public int getX() { return x; }
	public int getY() { return y; }
	
    public void keyPressed(KeyEvent e) {
    	if(e.getKeyCode()==KeyEvent.VK_LEFT && x>-20)  x-=10;
    	if(e.getKeyCode()==KeyEvent.VK_RIGHT && x<450)  x+=10;
    	lbConan.setLocation(x, y);
    }
    
    public void keyReleased(KeyEvent e){}
    public void keyTyped(KeyEvent e){}
    
    public void freeze(Start frame) { frame.setFocusable(false); }
    public void unfreeze(Start frame) { 
    	frame.setFocusable(true); 
    	frame.requestFocus();
    }	
}
