package mobileapplication5;
import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;
public class Midlet extends MIDlet implements CommandListener {
    Display display;
    Form form;
    TextField name,pswd;
    Command cancel,submit;

    public void startApp() {
           
        display = Display.getDisplay(this);
        form = new Form("MyForm");
       
        name = new TextField("Name","",10,TextField.ANY);
        pswd = new TextField("Password","",8,TextField.PASSWORD);
               
        cancel = new Command("Cancel",Command.CANCEL,1);
        submit = new Command("Submit",Command.OK,1);
       
        form.addCommand(cancel);
        form.addCommand(submit);
        form.append(name);
        form.append(pswd);
        form.setCommandListener(this);
        display.setCurrent(form);  
    }
   
    public void validateUser(String name, String password) {
    if (name.equals("abcd") && password.equals("abcd")) {
       Alert error = new Alert("Login Successful"," ", null, AlertType.ERROR);
       display.setCurrent(error, form);
    } else {
       Alert error = new Alert("Login Incorrect", "Please try again", null, AlertType.ERROR);
       display.setCurrent(error, form);
    }
  }
   
    public void pauseApp() {
    }
   
    public void destroyApp(boolean unconditional) {
        notifyDestroyed();
    }

    public void commandAction(Command c, Displayable d) {
         String label = c.getLabel();
         if (label.equals("Cancel")) {
             destroyApp(true);
        }
         else if (label.equals("Submit")) {
             validateUser(name.getString(), pswd.getString());
         }
    }
}
