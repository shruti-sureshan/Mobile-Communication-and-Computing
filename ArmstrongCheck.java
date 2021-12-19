import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.StringItem;
import javax.microedition.lcdui.TextField;
import javax.microedition.midlet.MIDlet;
import javax.microedition.midlet.MIDletStateChangeException;

public class ArmstrongCheck extends MIDlet implements CommandListener{
	
	private Form form;
	private Display display;
	private TextField inp;
	private StringItem op;
	private Command com;

	public ArmstrongCheck() {
		inp = new TextField("Enter string:", "", 40, TextField.ANY);
		com = new Command("OK", Command.OK, 2);
		op = new StringItem("Armstrong: ", "");
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
		if(checkArmstrong(Long.parseLong(input)))
			op.setText("true");
		else
			op.setText("false");
		display.setCurrent(form);
		
	}
	
	public static boolean checkArmstrong(long num){
		String n = String.valueOf(num);
	    int [] numArr = new int[n.length()];
	    for(int i=0; i<n.length(); i++) {
	    	numArr[i] = Integer.parseInt(String.valueOf(n.charAt(i)));
	    }
	   
	    long count = 0;
	    for(int i=0; i<numArr.length; i++)
	        count += numArr[i]*numArr[i]*numArr[i];
	    if(count == num)
	        return true;
	    return false;
	}

	public void commandAction(Command c, Displayable arg1) {
		String label = 	c.getLabel();
		if(label.equals("OK"))
			show();
	}

}
