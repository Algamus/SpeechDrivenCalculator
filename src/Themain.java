/*
  Name: SpeechDrivenCalculator 
  Copyright: Gobus   
  Author: Gökhan Göbüs ,Sercan Sarý ,Merve Kayacý
  Description:Basicly, this is a calculator that driven by speech commands
*/
public class Themain {
	@SuppressWarnings("unused")
	public static void main( String args[] )
	{
		Engine engine= new Engine(); //Create Engine class
		MainFrame g = new MainFrame(engine);//Create Gui ,all gui,keyboard and mouse listeners
	}
}