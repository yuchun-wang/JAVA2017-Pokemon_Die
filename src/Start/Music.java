package Start;

import java.io.*;
import javax.sound.sampled.*;

public class Music {
		
	public Music(String filename) {  
		try {
			Clip clip = AudioSystem.getClip();
		    clip.open(AudioSystem.getAudioInputStream(new File(filename)));
		    clip.start();
		}
		catch (Exception exc) {
			exc.printStackTrace(System.out);
		}
	}
}