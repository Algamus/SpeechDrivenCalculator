import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import parsii.tokenizer.ParseException;

//import translator.Translator;
import edu.cmu.sphinx.frontend.util.Microphone;
import edu.cmu.sphinx.recognizer.Recognizer;
import edu.cmu.sphinx.result.Result;
import edu.cmu.sphinx.util.props.ConfigurationManager;

public class Engine extends Thread{
	
	//Translator holder class
	private Translator translator;
	
	//For sphinx speech recognation variables
	private Recognizer recognizer;
	private Microphone microphone;
	
	private boolean recording;
	
	private JTextArea textExpression;
	
	
	public Engine(){//Engine Class Constructer
		
		
		//Do Setting Microphone and Sphinx
		recording =false;
		ConfigurationManager cm= new ConfigurationManager(Engine.class.getResource("calculator.config.xml"));
		
		recognizer =  (Recognizer) cm.lookup("recognizer");
		recognizer.allocate();
		
		microphone = (Microphone) cm.lookup("microphone");
		
		if(!microphone.startRecording()){
			System.out.println("cannot start mic");
			infoBox("Cannot Start the microphone, Program will be shutting down" ,"Error");
			recognizer.deallocate();
			System.exit(1);
		}
		
		translator = new Translator();//
		
	}
	public void bridge(JTextArea t){//Set sharing between frame's text box
		textExpression=t;
	}
	
	public static void infoBox(String infoMessage, String titleBar)//information display box
    {
        JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
    }
	
	public void setTextExpression(String s){//set string s to textbox
		textExpression.setText(s);
		
	}
	public void addTextExpression(String s){//add string s to textbox
		textExpression.setText(textExpression.getText() + s );
		
	}
	public void dlllastchrTextExpression(){// deletion last expression of text box
		int endIndex=textExpression.getText().length()-1;
		if(endIndex<0){
			endIndex=0;
		}
		textExpression.setText(textExpression.getText().substring(0, endIndex));
		
	}
	public void evaluateText(String expression){//Evaluate the input text and solve the text mathematical formula
		//after that,set text box : input text mathematical formula equal result.
		//if the text mathematical formula wrong gives syntax error
		String result = "";
		try {
			translator.calculateExpression(expression);
			result = translator.getParsedExpression() + " = " + translator.getResult();
			
			setTextExpression(result);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			//give syntax error
			e.printStackTrace();
			setTextExpression("Syntax Error");
			System.out.println("Syntax Error\n");
			infoBox("Syntex Error: invalid input", "Error");
		}

	}
	
	private void Listening() {//sphinx start listening from the user
		//if sphinx catch aproved input ,start the solve
		//if not gives user error and waiting new input
		//if sphinx can not catch any input give error :i cant hear you
				
		String resultText="";
		Result result = recognizer.recognize();

		if (result != null) {
			while(resultText==""){
				resultText = result.getBestFinalResultNoFiller();
				if(resultText==""){
				System.out.println("I can't hear what you said.\n");
				infoBox("wrong input try again","Error");
				result = recognizer.recognize();
				}
			}
			evaluateText(resultText);
		} else {
			System.out.println("I can't hear what you said.\n");
			infoBox("ý cant hear you ,try again","Error");
			
		}
		
	}
	
	public void stopRecording(){
		recording = false;
		
	}
	public void startRecording(){
		recording = true;
		Listening();
	}
	
}
