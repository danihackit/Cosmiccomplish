//2 CHANGES REQUIRED

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;

public class Main extends JFrame{
	private static final int WIDTH =1400;
	//width = 1400
	private static final int HEIGHT=725;
	//Scanner scan;
	
	public Main () {
		super("Cosmiccomplish");
		setSize(WIDTH, HEIGHT);
		Game play = new Game();
		((Component) play).setFocusable(true);
		
		setBackground(Color.BLACK);
		
		getContentPane().add(play);
		
		setVisible(true);
		
		addWindowListener( new WindowListener() {

			@Override
			public void windowActivated(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowClosed(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowClosing(WindowEvent arg0) {
				// TODO Auto-generated method stub
				//play.saveFile();
			}

			@Override
			public void windowDeactivated(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowDeiconified(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowIconified(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowOpened(WindowEvent arg0) {
				// TODO Auto-generated method stub
				//play.createFile();
				//play.readFromFile();
			}  });
		
	}
	

	public static void main(String[] args) {
		Main run = new Main();
		
		Scanner input = new Scanner(System.in);
		String userinput = input.nextLine();
		System.out.println("user entered: "+userinput);
		
		

	}


}
