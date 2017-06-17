


import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Color;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;





@SuppressWarnings("serial")
public class MainFrame extends JFrame implements ActionListener,KeyListener{
	
	
	//Engine class holder
	private Engine engine;
	
	//Gui's Calculator Elements
	private JTextArea textExpression;
	private JButton buttonListening;
	private JButton buttonDeleting;
	private JButton buttonRefresh;
	private JButton buttonOne;
	private JButton buttonTwo;
	private JButton buttonThree;
	private JButton buttonFour;
	private JButton buttonFive;
	private JButton buttonSix;
	private JButton buttonSeven;
	private JButton buttonEight;
	private JButton buttonNine;
	private JButton buttonZero;
	private JButton buttonPlus;
	private JButton buttonMinus;
	private JButton buttonX;
	private JButton buttonDiv;
	private JButton buttonEqual;
	private JButton buttonE;
	private JButton buttonSq;
	private JButton buttonPoint;
	
	
	
	private boolean buttonListenActive;

	public MainFrame(Engine e){//MainFrame constructer
		super("SpeechDrivenCalculator");//Gui Name
		
		elementsforgui();//Creation of Elements Function Call
		addlisteners();	//Declaration Listeners For Buttons Functions Call
		
		buttonListenActive=false;
		engine=e; //connection between MainFrame Class to Engine Class 
		engine.bridge(textExpression);//Sharing the textbox to Engine Class
		
		
		CreateGui(); //Create Gui Functions Call
		
	}
	private void CreateGui(){//Create ,Setting and Show The SpeechDriven Gui Function
		

		setBackground(Color.WHITE);
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		setBounds(100, 100, 318, 318);
		setLayout( null);
		setResizable(false);
        setVisible( true );
	}
	private void addlisteners(){//ADD All Buttons Listeners to Gui
		
		
		addKeyListener(this);//Keyboard Listeners
		
		//Buttons
		buttonListening.addActionListener(this);		
		buttonDeleting.addActionListener(this);
		buttonRefresh.addActionListener(this);
		buttonOne.addActionListener(this);
		buttonTwo.addActionListener(this);
		buttonThree.addActionListener(this);
		buttonFour.addActionListener(this);
		buttonFive.addActionListener(this);
		buttonSix.addActionListener(this);
		buttonSeven.addActionListener(this);
		buttonEight.addActionListener(this);
		buttonNine.addActionListener(this);
		buttonZero.addActionListener(this);
		buttonPlus.addActionListener(this);
		buttonMinus.addActionListener(this);
		buttonX.addActionListener(this);
		buttonDiv.addActionListener(this);
		buttonEqual.addActionListener(this);
		buttonE.addActionListener(this);
		buttonSq.addActionListener(this);
		buttonPoint.addActionListener(this);
		
		//Set Keyboard and Action Listeners
		setFocusable(true);
	}
	
	
	private void elementsforgui(){ //Creations and Settings for elements of gui
		
		
		//text box expreesion
		textExpression= new JTextArea();
		textExpression.setForeground(Color.WHITE);
		textExpression.setBackground(Color.BLACK);
		textExpression.setBounds(12, 12, 288, 30);
		textExpression.setEditable(false);
		
		add(textExpression);
		
		
		//button Listening
		
		buttonListening = new JButton("Listening");
		buttonListening.setBounds(12, 54, 288, 30);
		buttonListening.setBackground(Color.WHITE);
		
		
		add(buttonListening);
		
		//button deletion last expression
		
		buttonDeleting = new JButton("<---");
		buttonDeleting.setBounds(12, 96, 138, 25);
		buttonDeleting.setBackground(Color.WHITE);
		
		add(buttonDeleting);
		
		//button refreshing the expression
		
		buttonRefresh = new JButton("Refresh");
		buttonRefresh.setBounds(162, 96, 138, 25);
		buttonRefresh.setBackground(Color.WHITE);
		
		add(buttonRefresh);
		
		//button one
		buttonOne = new JButton("1");
		buttonOne.setBounds(12, 133, 48, 25);
		buttonOne.setBackground(Color.WHITE);
		
		add(buttonOne);
		//button two
		buttonTwo = new JButton("2");
		buttonTwo.setBounds(72, 133, 48, 25);
		buttonTwo.setBackground(Color.WHITE);
		
		add(buttonTwo);
		
		//button three
		buttonThree = new JButton("3");
		buttonThree.setBounds(132, 133, 48, 25);
		buttonThree.setBackground(Color.WHITE);
		
		add(buttonThree);
		
		//button four
		buttonFour = new JButton("4");
		buttonFour.setBounds(12, 170, 48, 25);
		buttonFour.setBackground(Color.WHITE);
		
		add(buttonFour);
		
		//button Five
		buttonFive = new JButton("5");
		buttonFive.setBounds(72, 170, 48, 25);
		buttonFive.setBackground(Color.WHITE);
		
		add(buttonFive);
		
		//button Six
		buttonSix = new JButton("6");
		buttonSix.setBounds(132, 170, 48, 25);
		buttonSix.setBackground(Color.WHITE);
		
		add(buttonSix);
		
		//button seven
		buttonSeven = new JButton("7");
		buttonSeven.setBounds(12, 207, 48, 25);
		buttonSeven.setBackground(Color.WHITE);
		
		add(buttonSeven);
		
		//button eight
		buttonEight = new JButton("8");
		buttonEight.setBounds(72, 207, 48, 25);
		buttonEight.setBackground(Color.WHITE);
		
		add(buttonEight);
		
		//button nine
		buttonNine= new JButton("9");
		buttonNine.setBounds(132, 207, 48, 25);
		buttonNine.setBackground(Color.WHITE);
		
		add(buttonNine);
		
		//button zero
		buttonZero = new JButton("0");
		buttonZero.setBounds(12, 244, 108, 25);
		buttonZero.setBackground(Color.WHITE);
		
		add(buttonZero);
		
		//button plus
		buttonPlus = new JButton("+");
		buttonPlus.setBounds(192, 133, 48, 25);
		buttonPlus.setBackground(Color.WHITE);
		
		add(buttonPlus);
		
		//button minus
		buttonMinus = new JButton("-");
		buttonMinus.setBounds(192, 170, 48, 25);
		buttonMinus.setBackground(Color.WHITE);
		
		add(buttonMinus);
		
		//button times
		buttonX = new JButton("X");
		buttonX.setBounds(252, 133, 48, 25);
		buttonX.setBackground(Color.WHITE);
		
		add(buttonX);
		
		//button divider(over)
		buttonDiv = new JButton("/");
		buttonDiv.setBounds(252, 170, 48, 25);
		buttonDiv.setBackground(Color.WHITE);
		
		add(buttonDiv);
		
		//button exponent
		buttonE = new JButton("e");
		buttonE.setBounds(192, 207, 48, 25);
		buttonE.setBackground(Color.WHITE);
		
		add(buttonE);
		
		//button .(point)
		buttonPoint = new JButton(".");
		buttonPoint.setBounds(132, 244, 48, 25);
		buttonPoint.setBackground(Color.WHITE);
		
		add(buttonPoint);
		
		//button Power
		buttonSq = new JButton("^");
		buttonSq.setBounds(192, 244, 48, 25);
		buttonSq.setBackground(Color.WHITE);
		
		add(buttonSq);
		
		//button equal
		buttonEqual = new JButton("=");
		buttonEqual.setBounds(252, 207, 48, 62);
		buttonEqual.setBackground(Color.WHITE);
		
		add(buttonEqual);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String whichkey=e.getActionCommand();
		if(whichkey.compareTo("Listening")==0){ //listening button
			//
			System.out.println("buton listening a gridim");
			// TODO Auto-generated method stub
			if(!buttonListenActive){
				
			
				System.out.println("thread begin");
				Thread t = new Thread(new Runnable() {
				     public void run() {
				    	System.out.println("thread start");
				    	buttonListenActive=true;
				    	buttonListening.setBackground(Color.RED);
				    	buttonListening.disable();
				    		
				    	//do startlisten
				    	engine.startRecording();
				    		
				    	buttonListenActive=false;
			    		buttonListening.setBackground(Color.WHITE);
			    		buttonListening.enable();
			    		
			    		//do stoplisten
			    		engine.stopRecording();
			    		
			    		System.out.println("thread stop");
			    		buttonListenActive=false;
				     }
				});
				t.start();
			}
		
		}else if(whichkey.compareTo("<---")==0){//button deletion last expression
			//
			System.out.println("buton <-- a gridim");
			engine.dlllastchrTextExpression();
		
		}else if(whichkey.compareTo("Refresh")==0){//button refresh
			//
			System.out.println("buton refresh a gridim");
			textExpression.setText("");
		}else if(whichkey.compareTo("1")==0){//button one
			//
			System.out.println("buton 1 a gridim");
			engine.addTextExpression("1");
			
		}else if(whichkey.compareTo("2")==0){//button two
			//
			System.out.println("buton 2 a gridim");
			engine.addTextExpression("2");
			
		}else if(whichkey.compareTo("3")==0){//button three
			//
			System.out.println("buton 3 a gridim");
			engine.addTextExpression("3");
			
		}else if(whichkey.compareTo("4")==0){//button four
			//
			System.out.println("buton 4 a gridim");
			engine.addTextExpression("4");
			
		}else if(whichkey.compareTo("5")==0){//button five
			//
			System.out.println("buton 5 a gridim");
			engine.addTextExpression("5");
			
		}else if(whichkey.compareTo("6")==0){//button six
			//
			System.out.println("buton 6 a gridim");
			engine.addTextExpression("6");
			
		}else if(whichkey.compareTo("7")==0){//button seven
			//
			System.out.println("buton 7 a gridim");
			engine.addTextExpression("7");
			
		}else if(whichkey.compareTo("8")==0){//button eight
			//
			System.out.println("buton 8 a gridim");
			engine.addTextExpression("8");
			
		}else if(whichkey.compareTo("9")==0){//button nine
			//
			System.out.println("buton 9 a gridim");
			engine.addTextExpression("9");
			
		}else if(whichkey.compareTo("0")==0){// button zero
			//
			System.out.println("buton 0 a gridim");
			engine.addTextExpression("0");
			
		}else if(whichkey.compareTo("+")==0){//button plus
			//
			System.out.println("buton + a gridim");
			engine.addTextExpression("+");
			
		}else if(whichkey.compareTo("-")==0){//button minus
			//
			System.out.println("buton - a gridim");
			engine.addTextExpression("-");
			
		}else if(whichkey.compareTo("X")==0){//button times(carpma)
			//
			System.out.println("buton X a gridim");
			engine.addTextExpression("*");
			
		}else if(whichkey.compareTo("/")==0){//button diveder(over)
			//
			System.out.println("buton / a gridim");
			engine.addTextExpression("/");
			
		}else if(whichkey.compareTo("e")==0){// button exponent
			//
			System.out.println("buton e a gridim");
			engine.addTextExpression("exp");
			
		}else if(whichkey.compareTo(".")==0){//button point
			//
			System.out.println("buton . a gridim");
			engine.addTextExpression(".");
			
		}else if(whichkey.compareTo("^")==0){//button power
			//
			System.out.println("buton ^ a gridim");
			engine.addTextExpression("^");
			
		}else if(whichkey.compareTo("=")==0){//button equal
			//
			System.out.println("buton = a gridim");
			engine.evaluateText(textExpression.getText());
		}
		
	}


	
	 
	 
	 
	@Override
	public void keyPressed(KeyEvent event) {
		// TODO Auto-generated method stub
		String whichkey=KeyEvent.getKeyText(event.getKeyCode());
		
		if(whichkey.compareTo("T")==0 || whichkey.compareTo("t")==0 ){// do button listening start
			//t ye basýldýgýnda
			
			System.out.println("buton listening a gridim");
			// TODO Auto-generated method stub
			if(!buttonListenActive){
				
			
				System.out.println("thread begin");
				Thread t = new Thread(new Runnable() {
				     public void run() {
				    	System.out.println("thread start");
				    	buttonListenActive=true;
				    	buttonListening.setBackground(Color.RED);
				    	buttonListening.disable();
				    		
				    	//do startlisten
				    	engine.startRecording();
				    		
				    	buttonListenActive=false;
			    		buttonListening.setBackground(Color.WHITE);
			    		buttonListening.enable();
			    		
			    		//do stoplisten
			    		engine.stopRecording();
			    		
			    		System.out.println("thread stop");
			    		buttonListenActive=false;
				     }
				});
				t.start();
			}
		}	
		
		
	}
	
	@Override
	public void keyReleased(KeyEvent event) {
		
			
		
		// TODO Auto-generated method stub
		String whichkey=KeyEvent.getKeyText(event.getKeyCode());
		
		if(whichkey.compareTo("T")==0 || whichkey.compareTo("t")==0 ){//do button listening stop
			//t cekildiginde
			
			if(buttonListenActive){
				System.out.println("t ý cektim");
				buttonListenActive=false;
				
	    		engine.stopRecording();
	    	}
		}
		
	}
	@Override
	public void keyTyped(KeyEvent event) {
		String whichkey=KeyEvent.getKeyText(event.getKeyCode());
		// TODO Auto-generated method stub
		
	}
	
	
	
}

	


