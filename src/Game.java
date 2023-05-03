import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.event.*; 

public class Game  extends JPanel implements Runnable, KeyListener, MouseListener, MouseMotionListener{

	/*
	   _       __    ___   _    __    ___   _     ____      ___   ____  __    _      __    ___    __   _____  _   ___   _     
	  \ \  /  / /\  | |_) | |  / /\  | |_) | |   | |_      | | \ | |_  / /`  | |    / /\  | |_)  / /\   | |  | | / / \ | |\ | 
 	   \_\/  /_/--\ |_| \ |_| /_/--\ |_|_) |_|__ |_|__     |_|_/ |_|__ \_\_, |_|__ /_/--\ |_| \ /_/--\  |_|  |_| \_\_/ |_| \| 
 	   
 	   TODO Variable Declaration
	 */

	//Management Variables
	private BufferedImage back; 
	private File file;
	
	//Objects
	private CharacterObject astronaut = new CharacterObject(300, 300, (int)(121/2), (int)(176/2), new ImageIcon("Astronaut Facing Right Lifting None.png"));
	private Button startButton;
	private Button invisibleButton;
	
	private Button aboutButton;
	private Button storeButton;
	private Button homeButton;
	private Button taskButton;
	private Button finishedInputtingTask;
	private Button XButton;
	private Button forwardButton, backwardButton, rightArrowButton, leftArrowButton;
	
	private TextBox taskNameInput, taskDateInput, taskRewardInput, taskPositionInput;
	private TextBox currentInputBox;

	private Task newtask;

	Scanner scan;
	
	//Integers
	private int key;
	private int mvmfactor;
	private int taskIteratePos = 0;
	private double testX = centerXPosition(40);
	private double testY = centerYPosition(40);
	private double diameter = 200;
	private double angle = 0.0;
	private double ratio;
	private int deleteStop;
	
	//Other Numbers
	private long starttime;
	
	//Boolean
	private boolean moving;
	private boolean recentright;
	private boolean called;
	private boolean astronautNeeded;
	private boolean make;
	private boolean finishEnteringTaskNotif = false;
	private boolean taskAdded = false;
	private boolean inputStat;
	
	//Strings
	//private String screenstatus = "Start Up";
	private String screenstatus = "Start Up";
	private String temporaryTaskName = new String("");
	private String temporaryTaskDate = new String("");
	private String temporaryTaskReward = new String("");
	private String temporaryTaskPositionInQueue = new String("");
	private String currentInput = new String("");
	private String iteratedDate, iteratedName, iteratedReward, iteratedPosition;

	//Array Lists
	private ArrayList <Task> tasks = new ArrayList();
	
	/*
	  _       __    _       __    __    ____  _      ____  _     _____ 
	 | |\/|  / /\  | |\ |  / /\  / /`_ | |_  | |\/| | |_  | |\ |  | |  
	 |_|  | /_/--\ |_| \| /_/--\ \_\_/ |_|__ |_|  | |_|__ |_| \|  |_|  
	 
	 TODO Management
	 */

	public Game() {
		
		//Thread Setup
		new Thread(this).start();	
		this.addKeyListener(this);
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		
		mvmfactor = 5;
		called = false;
		astronautNeeded = false;
		
		startButton = new Button(20, 0, 1400, 725, new ImageIcon("Spaceship Icon.png"));
		invisibleButton = new Button(527, 155, 262, 357, new ImageIcon("nan.png"));
		
		aboutButton = new Button (350,300,140,56, new ImageIcon ("AboutButtonn2.png"));
		aboutButton = new Button (350,300,140,56, new ImageIcon ("AboutButtonn2.png"));
		storeButton = new Button(900, 300,140,56, new ImageIcon ("StoreButton2.png"));
		homeButton = new Button (centerXPosition(140), centerYPosition(70), 140, 70, new ImageIcon("HomeButton2.png"));
		taskButton = new Button(centerXPosition(140),centerYPosition(56),140,56, new ImageIcon("Task Button.png"));
		finishedInputtingTask = new Button(1100,200,100,100, new ImageIcon("Checkmark2.png"));
		XButton = new Button(1000,180,40,40, new ImageIcon("X Button.png"));
		forwardButton = new Button(150,550,335,70, new ImageIcon("Move Forward Button.png"));
		backwardButton = new Button(forwardButton.getX()+forwardButton.getW()+30, 550, 335,70, new ImageIcon("MoveBackwardButton.png"));
		rightArrowButton = new Button(centerXPosition(100)+600, centerYPosition(50)-50, 100,100, new ImageIcon ("RightArrowButton.png"));
		leftArrowButton = new Button(centerXPosition(100)-600, centerYPosition(50)-50, 100,100, new ImageIcon ("LeftArrowButton.png"));

		taskNameInput = new TextBox(centerXPosition(600) + 30,centerYPosition(600)+100, 560, 90, 7, false, "Task: ");
		taskDateInput = new TextBox(centerXPosition(600) + 30,centerYPosition(600)+230, 560, 30, 11, false, "Due Date: ");
		taskRewardInput = new TextBox(centerXPosition(600)+ 30, centerYPosition(600)+360, 560,60,9,false, "Reward: ");
		taskPositionInput = new TextBox(centerXPosition(600)+ 30, centerYPosition(600)+490, 560,30, 10, false, "Position: ");
	}

	//Run Method
	public void run()
	   {
	   	try
	   	{
	   		while(true)
	   		{
	   		   //Thread.currentThread().sleep(5);
			   Thread.currentThread().sleep(5);
	            repaint();
	         }
	      }
	   		catch(Exception e) {
	   			
	      }
	  	}
	
	/*
 	 _       __    _   _          ____  ___   _  _____  ___   ___  
	| |\/|  / /\  | | | |\ |     | |_  | | \ | |  | |  / / \ | |_) 
	|_|  | /_/--\ |_| |_| \|     |_|__ |_|_/ |_|  |_|  \_\_/ |_| \ 
	
	TODO Main Editor
	 */
	public void paint(Graphics g){
		
		Graphics2D twoDgraph = (Graphics2D) g; 
		if( back ==null)
			back=(BufferedImage)( (createImage(getWidth(), getHeight()))); 
				
		//Back Graphics and Setup
		Graphics g2d = back.createGraphics();
		g2d.clearRect(0,0,getSize().width, getSize().height);
		g2d.setFont( new Font("Courier New", Font.BOLD, 20));
		g2d.setColor(Color.WHITE);
		((Graphics2D) g2d).setStroke(new BasicStroke(10));
		
		//Start Screen
		if(screenstatus.equals("Start Up")) {
			StartUpScreen(g2d);
		} else if(screenstatus.equals("Start")) {
			StartScreen(g2d);
		} else if(screenstatus.equals("Play")) {
			PlayScreen(g2d);
		} else if(screenstatus.equals("About")) {
			AboutScreen(g2d);
		} else if(screenstatus.equals("Store")) {
			StoreScreen(g2d);
		} else if(screenstatus.equals("Input")){
			InputScreen(g2d);
		} else if(screenstatus.equals("Reorder Tasks")){
			ReorderTasksScreen(g2d);
		}
		
		textTimer();

		//Pop-Up Notifications
		if(finishEnteringTaskNotif && screenstatus.equals("Input")){
			drawScreen(g2d,new ImageIcon("White Filter.png"));
			g2d.drawImage(new ImageIcon("Finish Filling Out Box.png").getImage(),centerXPosition(800),centerYPosition(800),800,800, this);
			drawButton(g2d, XButton);
		}

		if(taskAdded && screenstatus.equals("Input")){
			drawScreen(g2d,new ImageIcon("White Filter.png"));
			g2d.drawImage(new ImageIcon("Task Added Notification.png").getImage(),centerXPosition(800),centerYPosition(800)-15,800,800, this);
			drawButton(g2d, XButton);
		}

		//Astronaut
		if(astronautNeeded) {
			g2d.drawImage(astronaut.getImg().getImage(), (int)astronaut.getX(), (int)astronaut.getY(), (int)astronaut.getW(), (int)astronaut.getH(), this);
		
			if(recentright) {
				if(moving) {
					if(((int)(System.currentTimeMillis()/200))%2==0) {
						astronaut.setImg(new ImageIcon("Astronaut Facing Right Lifting Right.png"));
					} else {
						astronaut.setImg(new ImageIcon("Astronaut Facing Right Lifting Left.png"));
					}
				} else {
					astronaut.setImg(new ImageIcon("Astronaut Facing Right Lifting None.png"));
				}
			} else {
				if(moving) {
					if(((int)(System.currentTimeMillis()/200))%2==0) {
						astronaut.setImg(new ImageIcon("Astronaut Facing Left Lifting Right.png"));
					} else {
						astronaut.setImg(new ImageIcon("Astronaut Facing Left Lifting Left.png"));
					}
				} else {
					astronaut.setImg(new ImageIcon("Astronaut Facing Left Lifting None.png"));
				}
			}
		}





		if(screenstatus.equals("Testing Room")){
			
			drawScreen(g2d, new ImageIcon("void.png"));
			circularMotion(g2d,astronaut,100,true);
			
		}










		twoDgraph.drawImage(back, null, 0, 0);
}
	
	/*
 	 ___   ___    __    _           _      ____ _____  _     ___   ___   __  
	| | \ | |_)  / /\  \ \    /    | |\/| | |_   | |  | |_| / / \ | | \ ( (` 
	|_|_/ |_| \ /_/--\  \_\/\/     |_|  | |_|__  |_|  |_| | \_\_/ |_|_/ _)_) 
	
	TODO Draw Methods
	 */

	private void drawScreen(Graphics g2d, ImageIcon drawnImage) {
		g2d.drawImage(drawnImage.getImage(), 0, 0, getWidth(), getHeight(), this);
	}
	
	private void drawButton(Graphics g2d, Button button) {
		g2d.drawImage(button.getImg().getImage(), button.getX(), button.getY(), button.getW(), button.getH(), this);
	}

	public int centerXPosition(int objectWidth){
		int temp;
		temp = (1400/2)-(objectWidth/2);
		return temp;
	}

	public int centerYPosition(int objectHeight){
		int temp;
		temp = (725/2)-(objectHeight/2);
		return temp;
	}
	
	/*
 	 __   __    ___   ____  ____  _          _      ____ _____  _     ___   ___   __  
	( (` / /`  | |_) | |_  | |_  | |\ |     | |\/| | |_   | |  | |_| / / \ | | \ ( (` 
	_)_) \_\_, |_| \ |_|__ |_|__ |_| \|     |_|  | |_|__  |_|  |_| | \_\_/ |_|_/ _)_) 
	
	TODO Screen Methods
	 */
	
	private void StartUpScreen(Graphics g2d) {
		g2d.drawImage(new ImageIcon("Loading Frame.png").getImage(), 0,0,getWidth(),getHeight(),this);
		generateAll();
		if(!called) {
			starttime = System.currentTimeMillis();
			called = true;
		}
		g2d.drawImage(new ImageIcon("Start Screen GIF.gif").getImage(), 0,0,getWidth(),getHeight(),this);
		if(System.currentTimeMillis()-starttime >= 7500) {
			g2d.drawImage(new ImageIcon("End Frame.png").getImage(), 0,0,getWidth(),getHeight(),this);
			screenstatus = "Start";
		}
	}
	
	private void StartScreen(Graphics g2d) {
		g2d.drawImage(new ImageIcon("End Frame.png").getImage(), 0,0,getWidth(),getHeight(),this);
		g2d.drawImage(new ImageIcon("Cosmiccomplish Title.png").getImage(), getWidth()/2 - (674/2), getHeight()/2 - (114/2)-150, 674, 114,this);
		drawButton(g2d, startButton);
		drawButton(g2d, aboutButton);
		drawButton(g2d, storeButton);
	}

	private void PlayScreen(Graphics g2d) {
		drawScreen(g2d, new ImageIcon("End Frame.png"));
		drawButton(g2d, taskButton);
	}
	
	private void AboutScreen(Graphics g2d) {
		drawScreen(g2d, new ImageIcon("End Frame.png"));
		g2d.setColor(Color.white);
		g2d.drawString("About",500,500);
		drawButton(g2d, homeButton);
	}
	
	private void StoreScreen(Graphics g2d) {
		drawScreen(g2d, new ImageIcon("End Frame.png"));
		g2d.setColor(Color.white);
		g2d.drawString("Store", 500, 500);
		drawButton(g2d, homeButton);
	}

	private void InputScreen(Graphics g2d){
		g2d.setColor(Color.white);
		inputStat=true;
		if(!tasks.isEmpty()){
			g2d.drawString("Task:"+tasks.get(0).getTaskName(), 100,100);
		}
		drawScreen(g2d, new ImageIcon("Cork Board Background.png"));
		g2d.drawImage(new ImageIcon("Sticky Note.png").getImage(),centerXPosition(600), centerYPosition(600),600,600,this);		
		//Task Name Text Box
		typeTextBoxToFont(g2d,taskNameInput,30);
		typeTextBoxToFont(g2d,taskDateInput,30);
		typeTextBoxToFont(g2d, taskRewardInput, 30);
		typeTextBoxToFont(g2d, taskPositionInput, 30);

		drawButton(g2d, finishedInputtingTask);
	}

	private void ReorderTasksScreen(Graphics g2d){
		g2d.setColor(Color.white);
		drawScreen(g2d, new ImageIcon("ReorderingTasksBackground.png"));
		drawButton(g2d, forwardButton);
		drawButton(g2d, backwardButton);
		drawButton(g2d, rightArrowButton);
		drawButton(g2d, leftArrowButton);

		if(!tasks.isEmpty()){			
			displayTaskElement(g2d, tasks.get(taskIteratePos).getTaskName(),175);
			displayTaskElement(g2d, "Due Date: " + tasks.get(taskIteratePos).getDueDate(),275);
			displayTaskElement(g2d, "Reward: " + tasks.get(taskIteratePos).getRewardValue(),375);
			displayTaskElement(g2d, "" + (taskIteratePos + 1),465);

		} else {
			typeToFontNOBOX(g2d,"No Tasks to show!",centerXPosition(getWidthForText("No Tasks to show!",20)),centerYPosition(20)-40,500,50,0,20);
		}
	}
	
	
	/*
 	 ___   _   __   ___   _      __    _    
	| | \ | | ( (` | |_) | |    / /\  \ \_/ 
	|_|_/ |_| _)_) |_|   |_|__ /_/--\  |_|  s
	
	TODO Display
	 */

	 private void displayTaskElement(Graphics g2d, String inputString, int yValue){
		int tempFontSize = 30;

		while(getWidthForText(inputString,tempFontSize)>750){
			tempFontSize--;
		}

		typeToFontNOBOX(g2d,inputString,centerXPosition(getWidthForText(inputString,tempFontSize)),yValue,750,100,0,tempFontSize);

	 }
	 private void typeToFontNOBOX(Graphics g2d, String inputString, int xValue, int yValue, int width, int height, int deleteStopI, int fontSize) {
		int xAddedValue = 0;
		int yAddedValue = 0;
		int yMaxI = yValue + height;
		int margin = xValue + width;
		deleteStop = deleteStopI;
		
		for(int i=0; i<inputString.length();i++) {
			Letter newLetter = new Letter(inputString.charAt(i));
			g2d.drawImage(newLetter.getAffiliatedImage().getImage(),xValue+xAddedValue,yValue+yAddedValue,fontSize,fontSize,this);

			if(newLetter.getDimension() == 'M') {
				xAddedValue += fontSize;
			} else if(newLetter.getDimension() == 'S') {
				xAddedValue += (fontSize * 4/5);
			} else {
				xAddedValue += fontSize + (fontSize * 3 / 10);
			}

			if(xValue + xAddedValue + (fontSize * 13/10) > margin) {
				xAddedValue = 0;
				yAddedValue += (fontSize +10);
			}

			if(newLetter.getAffiliatedCharacter() == '\n'){
				xAddedValue = 0;
				yAddedValue += (fontSize +10);
			}
		}
	}

	private int getWidthForText(String inputString, int fontSize){
		int xAddedValue = 0;		
		
		for(int i=0; i<inputString.length();i++) {
			Letter newLetter = new Letter(inputString.charAt(i));
			if(newLetter.getDimension() == 'M') {
				xAddedValue += fontSize;
			} else if(newLetter.getDimension() == 'S') {
				xAddedValue += (fontSize * 4/5);
			} else {
				xAddedValue += fontSize + (fontSize * 3 / 10);
			}
		}
		return xAddedValue;
	}
	
	 private void typeToFont(Graphics g2d, String inputString, int xValue, int yValue, int width, int height, int deleteStopI, int fontSize, TextBox a) {
		int xAddedValue = 0;
		int yAddedValue = 0;
		int yMaxI = yValue + height;
		int margin = xValue + width;
		deleteStop = deleteStopI;
			
		for(int i=0; i<inputString.length();i++) {
			Letter newLetter = new Letter(inputString.charAt(i));
			g2d.drawImage(newLetter.getAffiliatedImage().getImage(),xValue+xAddedValue,yValue+yAddedValue,fontSize,fontSize,this);

			if(newLetter.getDimension() == 'M') {
				xAddedValue += fontSize;
			} else if(newLetter.getDimension() == 'S') {
				xAddedValue += (fontSize * 4/5);
			} else {
				xAddedValue += fontSize + (fontSize * 3 / 10);
			}

			if(xValue + xAddedValue + (fontSize * 13/10) > margin) {
				xAddedValue = 0;
				yAddedValue += (fontSize +10);
			}

			if(newLetter.getAffiliatedCharacter() == '\n'){
				xAddedValue = 0;
				yAddedValue += (fontSize +10);
			}

			if(yValue + yAddedValue > yMaxI){
				a.setInputStatus(false);
				
			} else {
				a.setInputStatus(true);
			}

			if(inputString.length()<=deleteStopI){
				a.setDeleteAllowed(false);
			} else {
				a.setDeleteAllowed(true);
			}
		}
	}
	 
	 private void typeTextBoxToFont(Graphics g2d, TextBox a, int fontSize) {
			typeToFont(g2d, a.getAffiliatedText(),a.getX(), a.getY(), a.getW(), a.getH(), a.getDeletionRestriction(),fontSize, a);
	 }


	private void circularMotion(Graphics g2d, CharacterObject object, int radius, boolean spiral){
		
		g2d.drawImage(object.getImg().getImage(), (int)testX, (int)testY, (int)object.getW(), (int)object.getH(), this);
		if(angle<360){
			angle +=0.0174532925;
		} else {
			angle = 0.0;
		}

		testX = Math.cos(angle)*diameter + centerXPosition(40);
		testY = Math.sin(angle)*diameter + centerYPosition(40);

		if(!spiral){
		diameter = radius*2;

		} else {
			if(diameter>0){
				diameter-=0.1;
			}
			object.setW((object.getW()/1.002));
			object.setH((object.getH()/1.002));
		}
		
	}
		
	
	/*
	 __    ____  _      ____  ___    __   _____  _   ___   _     
	/ /`_ | |_  | |\ | | |_  | |_)  / /\   | |  | | / / \ | |\ | 
	\_\_/ |_|__ |_| \| |_|__ |_| \ /_/--\  |_|  |_| \_\_/ |_| \| 
	
	TODO Generation
	 */
		
	public void generateAll() {
		
	}
	
	/*
 	 __     __    _      ____  ___   _      __    _         _      ____  __    _      __    _      _   __    __  
	/ /`_  / /\  | |\/| | |_  | |_) | |    / /\  \ \_/     | |\/| | |_  / /`  | |_|  / /\  | |\ | | | / /`  ( (` 
	\_\_/ /_/--\ |_|  | |_|__ |_|   |_|__ /_/--\  |_|      |_|  | |_|__ \_\_, |_| | /_/--\ |_| \| |_| \_\_, _)_) 
	
	TODO Gameplay Mechanics
	 */
	
	public void textTimer(){
		if(currentInputBox != null) {
			currentInput = currentInputBox.getAffiliatedText();
			if((System.currentTimeMillis()/500)%2==0 && !make) {
				make = true;
				currentInput = currentInput + "|";
				currentInputBox.setAffiliatedText(currentInput);
			} else if((System.currentTimeMillis()/500)%2 != 0 && make && currentInput.length()>0) {
				for(int i=currentInput.length(); i>0;i--) {
					if(currentInput.substring(i-1,i).equals("|")) {
						currentInput = currentInput.substring(0,i-1) + currentInput.substring(i,currentInput.length());
						currentInputBox.setAffiliatedText(currentInput);
						break;
					}
				}
				make = false;
			}
		}
	}
	
	/*
 	 _     ____  _         _     _   __  _____  ____  _      ____  ___       _      ____ _____  _     ___   ___   __  
	| |_/ | |_  \ \_/     | |   | | ( (`  | |  | |_  | |\ | | |_  | |_)     | |\/| | |_   | |  | |_| / / \ | | \ ( (` 
	|_| \ |_|__  |_|      |_|__ |_| _)_)  |_|  |_|__ |_| \| |_|__ |_| \     |_|  | |_|__  |_|  |_| | \_\_/ |_|_/ _)_) 
	
	TODO Key Listener Methods
	 */
	
	@Override
	public void keyTyped(KeyEvent e) {
		
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		key= e.getKeyCode();
		//System.out.println(key+ " - " + e.getKeyChar());
	
		if(currentInputBox == null){
		if(key == 65 || key == 37) { // A or <-
			astronaut.move(-mvmfactor, 0);
			moving = true;
			recentright = false;
		}
		if(key == 87 || key == 38) { // W or ^
			astronaut.move(0, -mvmfactor);
			moving = true;
		}
		if(key == 68 || key == 39) { // D or ->
			astronaut.move(mvmfactor, 0);
			moving = true;
			recentright = true;
		}
		if(key == 83 || key == 40) { // S or down
			astronaut.move(0, mvmfactor);
			moving = true;
		}
		if(key == 32) { // Space
			astronautNeeded = !astronautNeeded;
		}
		
		if(key==72) { // H
			screenstatus = ("Start");
		}
		
		if(key==73){ // I
			screenstatus = ("Input");
			inputStat = true;
		}

		if(key==82){ // R
			screenstatus = ("Reorder Tasks");
		}

		if(key==39){ // ->
			if(taskIteratePos<tasks.size()-1){
				taskIteratePos++;
			}
		}

		if(key==37){
			if(taskIteratePos>0){
				taskIteratePos--;
			}
		}

		if(key==70){
			screenstatus = "Testing Room";
			testX = centerXPosition(40);
			testY = centerYPosition(40);
			diameter = 200;
			angle = 0.0;

			astronaut.setW((int)(121/2));
			astronaut.setH((int)(176/2));

		}
		}
		
		if(!(currentInputBox==null)) {
			char character = e.getKeyChar();
			
			currentInput = currentInputBox.getAffiliatedText();
									
			if(key!=16 && key!=8 && currentInputBox.getInputStatus()){
				for(int i=currentInput.length(); i>0;i--) {
					if(currentInput.substring(i-1,i).equals("|")) {
						currentInput = currentInput.substring(0,i-1) + currentInput.substring(i,currentInput.length());
						break;
					}
				}
				currentInput = currentInput + character;
			}  else if(key == 8 && currentInputBox.getDeleteAllowed()){
				if(currentInput.length()==1) {
					currentInput = "";
				} else {
					currentInput = currentInput.substring(0,currentInput.length()-2);
				}
			}
			
			currentInputBox.setAffiliatedText(currentInput);

			if(key==10) {
			}
		}
	}

	//Key Release
	@Override
	public void keyReleased(KeyEvent e) {
		
		key = e.getKeyCode();
		
		if(key == 65 || key == 37) { // A or <-
			moving = false;
		}
		if(key == 87 || key == 38) { // W or ^
			moving = false;
		}
		if(key == 68 || key == 39) { // D or ->
			moving = false;
		}
		if(key == 83 || key == 40) { // D or ->
			moving = false;
		}
		
		
	}


	/*
 	 _      ___   _     __   ____      _     _   __  _____  ____  _      ____  ___       _      ____ _____  _     ___   ___   __  
	| |\/| / / \ | | | ( (` | |_      | |   | | ( (`  | |  | |_  | |\ | | |_  | |_)     | |\/| | |_   | |  | |_| / / \ | | \ ( (` 
	|_|  | \_\_/ \_\_/ _)_) |_|__     |_|__ |_| _)_)  |_|  |_|__ |_| \| |_|__ |_| \     |_|  | |_|__  |_|  |_| | \_\_/ |_|_/ _)_) 
	
	TODO Mouse Listener Methods
	 */
	
	@Override
	public void mouseDragged(MouseEvent arg0) {
		
	}
	
	@Override
	public void mouseMoved(MouseEvent e) {
		
		if(screenstatus.equals("Start")) {
			if(invisibleButton.hover(e.getX(), e.getY())){
				startButton.setImg(new ImageIcon("Spaceship Animation.gif"));
			} else {
				startButton.setImg(new ImageIcon("Spaceship Icon.png"));
			}	
			
			
			if(aboutButton.hover(e.getX(), e.getY())) {
				aboutButton.setImg(new ImageIcon ("AboutHover2.png"));
			} else {
				aboutButton.setImg(new ImageIcon("AboutButtonn2.png"));
			}
			
			if(storeButton.hover(e.getX(), e.getY())) {
				storeButton.setImg(new ImageIcon ("StoreHover2.png"));
			} else {
				storeButton.setImg(new ImageIcon("StoreButton2.png"));
			}
		}
		
		
		if(homeButton.hover(e.getX(), e.getY())) {
			homeButton.setImg(new ImageIcon ("HomeHover2.png"));
		} else {
			homeButton.setImg(new ImageIcon("HomeButton2.png"));
		}
		
		if(screenstatus.equals("Play")){
			if(taskButton.hover(e.getX(), e.getY())){
				taskButton.setImg(new ImageIcon("Task Button Hover.png"));
			}else{
				taskButton.setImg(new ImageIcon("Task Button.png"));
			}
		}

		if(screenstatus.equals("Input")){
			if(finishedInputtingTask.hover(e.getX(), e.getY())){
				finishedInputtingTask.setImg(new ImageIcon ("CheckmarkHover.png"));
			}else{
				finishedInputtingTask.setImg(new ImageIcon("Checkmark2.png"));
			}
			if(finishEnteringTaskNotif || taskAdded){
				if(XButton.hover(e.getX(),e.getY())){
					XButton.setImg(new ImageIcon("X Button Highlighted.png"));
				} else {
					XButton.setImg(new ImageIcon("X Button.png"));
				}
			}
		}

		if(screenstatus.equals("Reorder Tasks")){
			if(forwardButton.hover(e.getX(), e.getY())){
				forwardButton.setImg(new ImageIcon ("MoveForwardHover.png"));
			} else{
				forwardButton.setImg(new ImageIcon("Move Forward Button.png"));
			}

			if(backwardButton.hover(e.getX(), e.getY())){
				backwardButton.setImg(new ImageIcon ("MoveBackwardHover.png"));
			} else{
				backwardButton.setImg(new ImageIcon ("MoveBackwardButton.png"));
			}

			if(rightArrowButton.hover(e.getX(), e.getY())){
				rightArrowButton.setImg(new ImageIcon ("RightArrowHover.png"));
			} else{
				rightArrowButton.setImg(new ImageIcon ("RightArrowButton.png"));
			}

			if(leftArrowButton.hover(e.getX(), e.getY())){
				leftArrowButton.setImg(new ImageIcon ("LeftArrowHover.png"));
			} else{
				leftArrowButton.setImg(new ImageIcon ("LeftArrowButton.png"));
			}
		}

		
		
	}
	
	public void operateTextBox(TextBox a) {
		a.setInputStatus(true);
		currentInputBox = a;
		currentInput = a.getAffiliatedText();
		make = true;
		currentInput = currentInput + "|";
		a.setAffiliatedText(currentInput);
	}

	public void doNotOperateTextBox(TextBox a) {
		currentInput = a.getAffiliatedText();
		if(currentInput.substring(currentInput.length()-1,currentInput.length()).equals("|")) {
			currentInput = currentInput.substring(0,currentInput.length()-1);
			a.setAffiliatedText(currentInput);
		}
		a = null;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {		
		if(screenstatus.equals("Start")) {
			if(invisibleButton.hover(e.getX(), e.getY())){
				screenstatus = "Play";
			} else if(aboutButton.hover(e.getX(), e.getY())){
				screenstatus = "About";
			} else if(storeButton.hover(e.getX(), e.getY())) {
				screenstatus = "Store";
			}
		}
		
		if(screenstatus.equals("About")) {
			if(homeButton.hover(e.getX(), e.getY())) {
				screenstatus = "Start";
			}
		}
		
		if(screenstatus.equals("Store")) {
			if(homeButton.hover(e.getX(), e.getY())) {
				screenstatus = "Start";
			}
		}
		
		if(screenstatus.equals("Play")) {
			if(taskButton.hover(e.getX(), e.getY())){
				screenstatus = "Input";
			}
		}
		
		if(screenstatus.equals("Input")){
			boolean tempb = false;
			if(finishEnteringTaskNotif || taskAdded){
				if(XButton.hover(e.getX(),e.getY())){
					
					if(finishEnteringTaskNotif){
					finishEnteringTaskNotif = false;
					} else if(taskAdded){
						taskAdded = false;
						screenstatus = "Start";
					}
				}
			} else {
			if(taskNameInput.hover(e.getX(), e.getY())) {
				operateTextBox(taskNameInput);
				tempb = true;
			} else {
				doNotOperateTextBox(taskNameInput);
			}
			if(taskDateInput.hover(e.getX(), e.getY())) {
				operateTextBox(taskDateInput);
				tempb = true;
			} else {
				doNotOperateTextBox(taskDateInput);
			}
			if(taskRewardInput.hover(e.getX(), e.getY())) {
				operateTextBox(taskRewardInput);
				tempb = true;
			} else {
				doNotOperateTextBox(taskRewardInput);
			}
			if(taskPositionInput.hover(e.getX(), e.getY())){
				operateTextBox(taskPositionInput);
				tempb=true;
			} else{
				doNotOperateTextBox(taskPositionInput);
			}

			if(!tempb){
				currentInputBox = null;
			}
			
			if(!(currentInput == null)){
				if(finishedInputtingTask.hover(e.getX(), e.getY())){

					temporaryTaskReward = taskRewardInput.getAffiliatedText();
					temporaryTaskName = taskNameInput.getAffiliatedText();
					temporaryTaskDate = taskDateInput.getAffiliatedText();
					temporaryTaskPositionInQueue = taskPositionInput.getAffiliatedText();

					iteratedReward = temporaryTaskReward.substring(8,temporaryTaskReward.length());
					iteratedName = temporaryTaskName.substring(6,temporaryTaskName.length());
					iteratedDate = temporaryTaskDate.substring(10,temporaryTaskDate.length());
					iteratedPosition = temporaryTaskPositionInQueue.substring(9,temporaryTaskPositionInQueue.length());

					if((!iteratedReward.equals("")) && !iteratedName.equals("")&& !iteratedDate.equals("") && !iteratedPosition.equals("")){
						tasks.add(new Task(iteratedReward, iteratedName,iteratedDate,iteratedPosition));
						System.out.println(tasks.get(0).getTaskName());
						taskAdded = true;

						taskNameInput.setAffiliatedText("Task: ");
						taskDateInput.setAffiliatedText("Due Date: ");
						taskRewardInput.setAffiliatedText("Reward: ");
						taskPositionInput.setAffiliatedText("Position: ");
					} else {
						finishEnteringTaskNotif = true;
					}

					

				}
			} }}

		if(screenstatus.equals("Reorder Tasks")){
			if(forwardButton.hover(e.getX(), e.getY())){
				forwardButton.setImg(new ImageIcon ("MoveForwardHover.png"));
			}
	
			if(backwardButton.hover(e.getX(), e.getY())){
				backwardButton.setImg(new ImageIcon ("MoveBackwardHover.png"));
			}
	
			if(rightArrowButton.hover(e.getX(), e.getY())){
				if(taskIteratePos<tasks.size()-1){
					taskIteratePos++;
				}
			}
	
			if(leftArrowButton.hover(e.getX(), e.getY())){
				if(taskIteratePos>0){
					taskIteratePos--;
				}
			}	
		}	
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}



	@Override
	public void mouseExited(MouseEvent e) {
		
	}



	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}
	
	/*
 	 ____  _   _     ____      _      ____ _____  _     ___   ___   __  
	| |_  | | | |   | |_      | |\/| | |_   | |  | |_| / / \ | | \ ( (` 
	|_|   |_| |_|__ |_|__     |_|  | |_|__  |_|  |_| | \_\_/ |_|_/ _)_) 
	
	TODO File Methods
	 */
	
		//Create File
		public void createFile() {
			try {
				if(file.createNewFile()) {
					System.out.println("File Created");
				}
				else
					System.out.println("File Already Exists");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		//Read File
		public void readFromFile() {
			try {
				Scanner sc = new Scanner(file);
				//while(sc.hasNextLine()) {
					//System.out.println(sc.nextLine());
				//}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			
		}
		
		//Save File
		public void saveFile() {
			try {
				FileWriter myWriter = new FileWriter(file);

				myWriter.write("Your cool file!");
		
				myWriter.close();
				System.out.println("Successfully wrote to file");
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("Error writing to file");
			}
		}
		
		//Refresh File
		public void refreshFromFile() {
			
		}
		
}