import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.StringItem;
import javax.microedition.midlet.MIDlet;
import javax.microedition.midlet.MIDletStateChangeException;

public class ArmstrongPrint extends MIDlet{
	
	private Display display;
	private Form form;
	private StringItem op;
	
	public ArmstrongPrint() {
	}

	protected void destroyApp(boolean arg0) throws MIDletStateChangeException {
		notifyDestroyed();
	}

	protected void pauseApp() {}

	protected void startApp() throws MIDletStateChangeException {
		display = Display.getDisplay(this);
		form = new Form("Armstrong Print");
		String result = "";
		for(int i=1; i<=1000; i++) {
			if(checkArmstrong((long) i))
				result += i + " ";
		}
		op = new StringItem("Armstrong Numbers", result);
		form.append(op);
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
	
	public void show() {
		display = Display.getDisplay(this);
		String result = "";
		for(int i=1; i<=1000; i++) {
			if(checkArmstrong((long) i))
				result += i + " ";
		}
		op = new StringItem("Armstrong Numbers", result);
		form.append(op);
		display.setCurrent(form);
	}
}
