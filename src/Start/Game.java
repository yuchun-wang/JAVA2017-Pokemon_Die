package Start;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Game extends Thread {

	private Player conan;
	private Ball bullet;
	private ImageIcon iconboss;
	private Boss boss1, boss2;
	private Fire fire;
	private int score = 0;
	private JLabel loseBgd;
	private JLabel finalScore;
	private JLabel Score;
	public static boolean freeze = false;

	public void startGame(Start frame) {

		conan = new Player(frame);

		shoot(frame);
		
		Score update = new Score();

		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}

		boss1(frame);
		boss2(frame);
		fire(frame);
		
		// Score
		Score = new JLabel();
		Score.setText("Score : " + score);
		Score.setFont(new Font("Dialog", Font.BOLD, 32)); // type of the word
		Score.setForeground(Color.GRAY);
		Score.setBounds(50, 20, 200, 40);
		frame.add(Score, 2);
		Score.setVisible(true);
		
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}		

		while (true) {
			if (conan.alive == true) {
				if (boss1.alive == true && conan.getX() >= boss1.getX() - 120 && conan.getX() <= boss1.getX() + 125) {
					if (conan.getY() <= boss1.getY() + 135 && conan.getY() + 130 >= boss1.getY()) {
						conan.alive = false;
						pause(frame);
					}
				} 
				if (boss2.alive == true && conan.getX() >= boss2.getX() - 120 && conan.getX() <= boss2.getX() + 125) {
					if (conan.getY() <= boss2.getY() + 135 && conan.getY() + 130 >= boss2.getY()) {
						conan.alive = false;
						pause(frame);
					}
				} 
				if (conan.getX() >= fire.getX() - 120 && conan.getX() <= fire.getX() + 55) {
					if (conan.getY() <= fire.getY() + 145 && conan.getY() + 80 >= fire.getY()) {
						conan.alive = false;
						pause(frame);		
					}
				}
			}
			if (conan.alive == true && boss1.alive == true) {
				if (bullet.getX() >= boss1.getX() - 45 && bullet.getX() <= boss1.getX() + 135) {
					if (bullet.getY() <= boss1.getY() + 135 && bullet.getY() + 50 >= boss1.getY()) {
						bullet.disappear();
						boss1.disappear();
						boss1.alive = false;
						score = update.bossScore(score);
						Score.setText("Score : " + score);
					}
				}
			}
			if (conan.alive == true && boss2.alive == true) {
				if (bullet.getX() >= boss2.getX() - 45 && bullet.getX() <= boss2.getX() + 135) {
					if (bullet.getY() <= boss2.getY() + 135 && bullet.getY() + 50 >= boss2.getY()) {
						bullet.disappear();
						boss2.disappear();
						boss2.alive = false;
						score = update.bossScore(score);
						Score.setText("Score : " + score);
					}
				}
			}
			
			if (conan.alive == false){
				try {
					Thread.sleep(1000);
				} catch (Exception e) {
					e.printStackTrace();
				}
				//lose background picture
				ImageIcon iconLosebgd = new ImageIcon("src/image/GameOverBackgroundImage-01.png");
				iconLosebgd.setImage(iconLosebgd.getImage().getScaledInstance(600, 800, Image.SCALE_DEFAULT));
				loseBgd = new JLabel(iconLosebgd);
				//loseBgd.setIcon(iconLosebgd);
				loseBgd.setBounds(0, 0, 600, 800);
				frame.add(loseBgd, 1);
				loseBgd.setVisible(true);
				Music BackgroundMusic = new Music("src/Music/converted_file_893d70dc.wav");
				
				//final Score
				finalScore = new JLabel();
				finalScore.setText("Score : " + score);
				finalScore.setFont( new Font ("Dialog", Font.BOLD, 60) ); //type of the word
				finalScore.setForeground(Color.MAGENTA);
				finalScore.setBounds(125, 300, 400, 100);
				frame.add(finalScore, 0);
				finalScore.setVisible(true);				
			}
			
			try {
				Thread.sleep(20);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private void shoot(Start frame) {
		new Thread() {
			public void run() {
				if (bullet != null) bullet.move();
				while (freeze != true && conan.alive == true) {
					bullet = new Ball(frame, conan.getX());
					bullet.move();

					try {
						Thread.sleep(300);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}.start();
	}

	private void fire(Start frame) {
		new Thread() {
			public void run() {
				if (fire != null) fire.move();
				ImageIcon iconfire;
				iconfire = new ImageIcon("src/image/fire.png");
				while (freeze != true && conan.alive == true) {
					fire = new Fire(frame, iconfire);
					fire.move();

					try {
						Thread.sleep(300);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}.start();
	}

	private void boss1(Start frame) {
		new Thread() {
			public void run() {
				if (boss1 != null) boss1.move();
				while (freeze != true && conan.alive == true) {
					int random, x1;

					Random ran = new Random();
					random = ran.nextInt(9);
					x1 = ran.nextInt(150);

					if (random == 0)
						iconboss = new ImageIcon("src/image/boss0.png");
					else if (random == 1)
						iconboss = new ImageIcon("src/image/boss1.png");
					else if (random == 2)
						iconboss = new ImageIcon("src/image/boss2.png");
					else if (random == 3)
						iconboss = new ImageIcon("src/image/boss3.png");
					else if (random == 4)
						iconboss = new ImageIcon("src/image/boss4.png");
					else if (random == 5)
						iconboss = new ImageIcon("src/image/boss5.png");
					else if (random == 6)
						iconboss = new ImageIcon("src/image/boss6.png");
					else if (random == 7)
						iconboss = new ImageIcon("src/image/boss7.png");
					else
						iconboss = new ImageIcon("src/image/boss8.png");

					boss1 = new Boss(frame, iconboss, x1);
					boss1.move();
					try {
						Thread.sleep(500);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}.start();
	}

	private void boss2(Start frame) {
		new Thread() {
			public void run() {
				if (boss2 != null) boss2.move();
				while (freeze != true && conan.alive == true) {
					int random2, x2;

					Random ran = new Random();
					random2 = ran.nextInt(9);
					x2 = ran.nextInt(150) + 260;

					if (random2 == 0)
						iconboss = new ImageIcon("src/image/boss0.png");
					else if (random2 == 1)
						iconboss = new ImageIcon("src/image/boss1.png");
					else if (random2 == 2)
						iconboss = new ImageIcon("src/image/boss2.png");
					else if (random2 == 3)
						iconboss = new ImageIcon("src/image/boss3.png");
					else if (random2 == 4)
						iconboss = new ImageIcon("src/image/boss4.png");
					else if (random2 == 5)
						iconboss = new ImageIcon("src/image/boss5.png");
					else if (random2 == 6)
						iconboss = new ImageIcon("src/image/boss6.png");
					else if (random2 == 7)
						iconboss = new ImageIcon("src/image/boss7.png");
					else
						iconboss = new ImageIcon("src/image/boss8.png");

					try {
						Thread.sleep(800);
					} catch (Exception e) {
						e.printStackTrace();
					}
					boss2 = new Boss(frame, iconboss, x2);
					boss2.move();
				}
			}
		}.start();
	}
	
	public void pause(Start frame) {
		freeze = true;
		conan.freeze(frame);
	}

	public void conti(Start frame) {
		freeze = false;
		conan.unfreeze(frame);
		shoot(frame);
		boss1(frame);
		boss2(frame);
		fire(frame);
	}
}
