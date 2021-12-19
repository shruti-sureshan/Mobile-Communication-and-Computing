

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.StringItem;
import javax.microedition.lcdui.TextField;
import javax.microedition.midlet.MIDlet;
import javax.microedition.midlet.MIDletStateChangeException;

public class DaysConverter extends MIDlet implements CommandListener{
	
	private Display display;
	private Form form;
	private TextField input;
	private StringItem output;
	private Command com;

	public DaysConverter() {
		input = new TextField("Enter days: ", "", 10, TextField.NUMERIC);
		com = new Command("OK", Command.OK, 2);
		output = new StringItem("", "");
	}

	protected void destroyApp(boolean arg0) throws MIDletStateChangeException {
		notifyDestroyed();
	}

	protected void pauseApp() {}

	protected void startApp() throws MIDletStateChangeException {
		display = Display.getDisplay(this);
		form = new Form("Days Converter");
		form.append(input);
		form.append(output);
		form.addCommand(com);
		form.setCommandListener(this);
		display.setCurrent(form);
	}
	
	public void show() {
		display = Display.getDisplay(this);
		int days = Integer.parseInt(input.getString());
		int years = days / 365;
		int months = (days % 365) / 30;
		int pending_days = (days % 365) % 30;
		
		String res = "Years: " + years + " Months: " + months + " Days: " + pending_days;
		output.setText(res);
		display.setCurrent(form);
	}

	public void commandAction(Command c, Displayable arg1) {
		String label = c.getLabel();
		if(label.equals("OK"))
			show();
	}

}
