

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.StringItem;
import javax.microedition.lcdui.TextField;
import javax.microedition.midlet.MIDlet;
import javax.microedition.midlet.MIDletStateChangeException;

public class Reverse extends MIDlet implements CommandListener{
	
	private Form form;
	private Display display;
	private TextField inp;
	private StringItem op;
	private Command com;

	public Reverse() {
		inp = new TextField("Enter string:", "", 40, TextField.ANY);
		com = new Command("OK", Command.OK, 2);
		op = new StringItem("Result: ", "");
	}

	protected void destroyApp(boolean arg0) throws MIDletStateChangeException {
		notifyDestroyed();
	}

	protected void pauseApp() {}

	protected void startApp() throws MIDletStateChangeException {
		display = Display.getDisplay(this);
		form = new Form("Reverse");
		form.append(inp);
		form.append(op);
		form.addCommand(com);
		form.setCommandListener(this);
		display.setCurrent(form);
	}
	
	public void show() {
		display = Display.getDisplay(this);
		String input = inp.getString();
		String rev = "";
		for(int i=input.length()-1; i>=0; i--)
			rev += input.charAt(i);
		op.setText(rev);
		display.setCurrent(form);
		
	}

	public void commandAction(Command c, Displayable arg1) {
		String label = 	c.getLabel();
		if(label.equals("OK"))
			show();
	}
}
