

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.StringItem;
import javax.microedition.lcdui.TextField;
import javax.microedition.midlet.MIDlet;
import javax.microedition.midlet.MIDletStateChangeException;

public class Rectangle extends MIDlet implements CommandListener{
	
	private Form form;
	private Display display;
	private TextField inp_len;
	private TextField inp_br;
	private StringItem op1;
	private StringItem op2;
	private Command com;

	public Rectangle() {
		inp_len = new TextField("Enter length:", "", 40, TextField.DECIMAL);
		inp_br = new TextField("Enter breadth:", "", 40, TextField.DECIMAL);
		op1 = new StringItem("Area: ", "");
		op2 = new StringItem("Perimeter: ", "");
		com = new Command("OK", Command.OK, 2);
	}

	protected void destroyApp(boolean arg0) throws MIDletStateChangeException {
		notifyDestroyed();
	}

	protected void pauseApp() {}

	protected void startApp() throws MIDletStateChangeException {
		display = Display.getDisplay(this);
		form = new Form("Circle");
		form.append(inp_len);
		form.append(inp_br);
		form.append(op1);
		form.append(op2);
		form.addCommand(com);
		form.setCommandListener(this);
		display.setCurrent(form);

	}
	
	public void show() {
		display = Display.getDisplay(this);
		double len = Double.parseDouble(inp_len.getString());
		double breadth = Double.parseDouble(inp_br.getString());
		double area = len * breadth;
		double peri = 2 * (len + breadth);
		op1.setText(String.valueOf(area));
		op2.setText(String.valueOf(peri));		
		display.setCurrent(form);
	}

	public void commandAction(Command c, Displayable arg1) {
		String label = 	c.getLabel();
		if(label.equals("OK"))
			show();
	}

}
