package Start;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Start extends JFrame implements ActionListener {

	private JButton Gotcha;
	private JButton Bye;
	private JButton Pause;
	private JButton Conti;
	private JLabel background;
	private JLabel scorePicture;
	private JLabel playBgd;
	private JLabel pauseKabi;private JLabel winBgd;
	private JLabel Score;
	private int score = 0;
	public static Start frame;
	public static Game game;

	public static void main(String[] args) {
		frame = new Start();
		game = new Game();
		frame.setVisible(true);
		frame.getContentPane().setBackground(Color.WHITE);
		
		//play muisic
		//Music koMusic = new Music();
		//koMusic.playMusic("src/BackgroundMusic.wav");

	}
	
	Music BackgroundMusic = new Music("src/Music/BackgroundMusic.wav");

	public Start() {
		// set frame
		setSize(600, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		
		JLayeredPane layered = new JLayeredPane();
		this.setContentPane(layered); //layered.add(lbConan, 0);

		try {
			// Gotcha button
			Gotcha = new JButton("Gotcha!");
			MyButtonListener gotListener = new MyButtonListener();
			Gotcha.addActionListener(this); 
			Gotcha.setLocation(50, 570);
			Gotcha.setSize(200, 50);
			Gotcha.setContentAreaFilled(false); // make button Transparent
			Gotcha.setFont(new Font("Dialog", Font.BOLD, 32)); // type of the word
			Gotcha.setForeground(Color.white);
			add(Gotcha);

			// Bye button
			Bye = new JButton("Bye...");
			MyButtonListener byeListener = new MyButtonListener();
			Bye.addActionListener(this);
			Bye.setLocation(350, 570);
			Bye.setSize(200, 50);
			Bye.setContentAreaFilled(false); // make button Transparent
			Bye.setFont(new Font("Dialog", Font.BOLD, 32)); // type of the word
			Bye.setForeground(Color.white);
			add(Bye);

			// Score picture
			ImageIcon iconScore = new ImageIcon("src/image/1200px-Kaito_Kid_signature.svg.png");
			iconScore.setImage(iconScore.getImage().getScaledInstance(50, 80, Image.SCALE_DEFAULT)); // getScaledInstance(int width, int height, int hints)Creates a scaled version of this image.

			scorePicture = new JLabel(iconScore);
			scorePicture.setBounds(0, 0, 50, 80);
			layered.add(scorePicture, 2);
			scorePicture.setVisible(false);

			// pause button
			ImageIcon buttonPause = new ImageIcon("src/image/Pause.png");
			buttonPause.setImage(buttonPause.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
			Pause = new JButton(buttonPause);
			MyButtonListener pauseListener = new MyButtonListener();
			Pause.addActionListener(this);
			Pause.setActionCommand("pause"); // let pause button can receive clip message
			Pause.setBounds(530, 0, 50, 50);
			Pause.setContentAreaFilled(false); // make button Transparent
			Pause.setBorderPainted(false); // make button have no frame
			layered.add(Pause, 2);
			Pause.setVisible(false);

			// continue button
			ImageIcon buttonConti = new ImageIcon("src/image/512x512bb.png");
			buttonConti.setImage(buttonConti.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
			Conti = new JButton(buttonConti);
			MyButtonListener contiListener = new MyButtonListener();
			Conti.addActionListener(this);
			Conti.setActionCommand("continue"); 
			Conti.setBounds(270, 430, 50, 50);
			Conti.setContentAreaFilled(false); // make button Transparent
			Conti.setBorderPainted(false); // make button have no frame
			layered.add(Conti, 1);
			Conti.setVisible(false);

			// pauseKabi picture
			ImageIcon iconpKabi = new ImageIcon("src/image/StopBackgroundImage-01.png");
			iconpKabi.setImage(iconpKabi.getImage().getScaledInstance(600, 800, Image.SCALE_DEFAULT));
			pauseKabi = new JLabel(iconpKabi);
			pauseKabi.setBounds(0, 0, 600, 800);
			layered.add(pauseKabi, 2);
			pauseKabi.setVisible(false);

			// start background picture
			ImageIcon iconbackground = new ImageIcon("src/image/19075429_2079310108963526_966663627_n.jpg");
			iconbackground.setImage(iconbackground.getImage().getScaledInstance(600, 800, Image.SCALE_DEFAULT));
			background = new JLabel(iconbackground);
			background.setBounds(0, 0, 600, 800);
			add(background);
			background.setVisible(true);
			
			// play background picture
			ImageIcon iconplaybgd = new ImageIcon("src/image/BackgroundImage.png");
			iconplaybgd.setImage(iconplaybgd.getImage().getScaledInstance(600, 800, Image.SCALE_DEFAULT));
			playBgd = new JLabel(iconplaybgd);
			playBgd.setBounds(0, 0, 600, 800);
			layered.add(playBgd, 100);
			playBgd.setVisible(false);
			
			//win background picture
			ImageIcon iconWinbgd = new ImageIcon("src/image/2-01.png");
			iconWinbgd.setImage(iconWinbgd.getImage().getScaledInstance(600, 800, Image.SCALE_DEFAULT));
			winBgd = new JLabel(iconWinbgd);
			winBgd.setBounds(0, 0, 600, 800);
			add(winBgd);
			winBgd.setVisible(false);		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void actionPerformed(ActionEvent e) {
		new Thread(() -> {
			String actionCommand = e.getActionCommand();

			// press start game button
			if (actionCommand.equals("Gotcha!")) {
				Gotcha.setVisible(false);
				Bye.setVisible(false);
				scorePicture.setVisible(true);
				Pause.setVisible(true);
				background.setVisible(false);
				pauseKabi.setVisible(false);
				playBgd.setVisible(true);
				game.startGame(frame);
			}
			// press end game button
			else if (actionCommand.equals("Bye...")) {
				dispose();
			}
			// press pause game button
			else if (actionCommand.equals("pause")) {
				game.pause(frame);
				Gotcha.setVisible(false);
				Bye.setVisible(false);
				scorePicture.setVisible(false);
				Pause.setVisible(false);
				Conti.setVisible(true);
				background.setVisible(false);
				pauseKabi.setVisible(true);	
				playBgd.setVisible(false);
			}
			// press game continue button
			else if (actionCommand.equals("continue")) {
				Gotcha.setVisible(false);
				Bye.setVisible(false);
				scorePicture.setVisible(true);
				Pause.setVisible(true);
				Conti.setVisible(false);
				background.setVisible(false);
				pauseKabi.setVisible(false);
				playBgd.setVisible(true);
				game.conti(frame);
			}
		}).start();
	}
}
