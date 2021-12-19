

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.StringItem;
import javax.microedition.lcdui.TextField;
import javax.microedition.midlet.MIDlet;
import javax.microedition.midlet.MIDletStateChangeException;

public class Palindrome extends MIDlet implements CommandListener{
	private Display display;
	private TextField input;
	private Command com;
	private StringItem stringItem;
	private Form form;

	public Palindrome() {
		input = new TextField("Enter String or number", "", 30, TextField.ANY);
		com = new Command("OK", Command.OK, 2);
		stringItem = new StringItem("Palindrome: ", "");
	}

	protected void destroyApp(boolean arg0) throws MIDletStateChangeException {
		notifyDestroyed();
	}

	protected void pauseApp() {}

	protected void startApp() throws MIDletStateChangeException {
		display = Display.getDisplay(this);
		form = new Form("Palindrome");
		form.append(input);
		form.append(stringItem);
		form.addCommand(com);
		form.setCommandListener(this);
		display.setCurrent(form);
	}
	
	public boolean checkPalindrome(String s) {
		String rev = "";
		for(int i=s.length()-1; i>=0; i--)
			rev += s.charAt(i);
		if(s.equals(rev))
			return true;
		return false;
	}
	
	public void show() {
		display = Display.getDisplay(this);
		String s = input.getString();
		if(checkPalindrome(s))
			stringItem.setText("True");
		else
			stringItem.setText("False");
		display.setCurrent(form);
	}

	public void commandAction(Command c, Displayable d) {
		String label = c.getLabel();
		if(label.equals("OK"))
			show();
	}

}
