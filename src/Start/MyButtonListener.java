package Start;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyButtonListener implements ActionListener{
	
	public void actionPerformed ( ActionEvent e ){
		System.out.println(e.getActionCommand() );
		System.out.println( e.getSource() );
	}
}
