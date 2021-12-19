

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.StringItem;
import javax.microedition.lcdui.TextField;
import javax.microedition.midlet.MIDlet;
import javax.microedition.midlet.MIDletStateChangeException;

public class Largest extends MIDlet implements CommandListener{
	
	private Display display;
	private Form form;
	private TextField ip1, ip2, ip3;
	private StringItem output;
	private Command com;

	public Largest() {
		ip1 = new TextField("Enter first number: ", "", 30, TextField.NUMERIC);
		ip2 = new TextField("Enter second number: ", "", 30, TextField.NUMERIC);
		ip3 = new TextField("Enter third number: ", "", 30, TextField.NUMERIC);
		output = new StringItem("Largest: ", "");
		com = new Command("OK", Command.OK, 2);
	}

	protected void destroyApp(boolean arg0) throws MIDletStateChangeException {
		notifyDestroyed();
	}

	protected void pauseApp() {}

	protected void startApp() throws MIDletStateChangeException {
		display = Display.getDisplay(this);
		form = new Form("Largest");
		form.append(ip1);
		form.append(ip2);
		form.append(ip3);
		form.append(output);
		form.addCommand(com);
		form.setCommandListener(this);
		display.setCurrent(form);
	}
	
	public void show() {
		int num1 = Integer.parseInt(ip1.getString());
		int num2 = Integer.parseInt(ip2.getString());
		int num3 = Integer.parseInt(ip3.getString());
		
		int res = num3 > (num1 > num2 ? num1: num2) ? num3 : (num1 > num2 ? num1: num2);
		
		display = Display.getDisplay(this);
		output.setText(String.valueOf(res));
		display.setCurrent(form);
	}

	public void commandAction(Command c, Displayable arg1) {
		String label = c.getLabel();
		if(label.equals("OK")) 
			show();
	}

}
