

import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;


public class CompoundInterest extends MIDlet{
	private Display display;
	private TextField tprin, trate, tyear, tres;
	private Form form;
	private Command cmd;
	
	public CompoundInterest() {
		// TODO Auto-generated constructor stub
		display = Display.getDisplay(this);
		form = new Form("Compound Interest");
		
		tprin = new TextField("Enter principal", "", 20, TextField.DECIMAL);
		trate = new TextField("Enter rate", "", 20, TextField.DECIMAL);
		tyear = new TextField("Enter no of years", "", 20, TextField.DECIMAL);
		tres  = new TextField("Result:", "", 20, TextField.DECIMAL);
		
		form.append(tprin);
		form.append(trate);
		form.append(tyear);
		
		cmd = new Command("Calculate", Command.OK, 2);
		form.addCommand(cmd);
		form.setCommandListener(new CommandListener() {
			
			public void commandAction(Command c, Displayable d) {
				if(c.equals(cmd)) {
					float p = Float.parseFloat(tprin.getString());
					float r = Float.parseFloat(trate.getString());
					int n = Integer.parseInt(tyear.getString());
					
					float res = 1.0f;
					for(int i = 0; i < n; i++) {
						res *= (1.0 + r/100.0);
					}
					res *= p;
					
					try {
						form.delete(3); // Delete result TextField
					} catch(Exception e) {
						;
					}
					tres.setString(res+"");
					form.append(tres);
					
				}
				
			}
		});

		
		display.setCurrent(form);
	}
	
	
	protected void startApp() throws MIDletStateChangeException {
		// TODO Auto-generated method stub

	}

	protected void destroyApp(boolean arg0) throws MIDletStateChangeException {
		// TODO Auto-generated method stub

	}

	protected void pauseApp() {
		// TODO Auto-generated method stub

	}


}
