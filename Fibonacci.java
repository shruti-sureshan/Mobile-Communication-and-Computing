

// program to display nth fibonacci number(n given by user).

import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;
import java.util.*;

/**
 * @author rishabh
 */
public class Midlet extends MIDlet implements CommandListener{
    Form form;
    Command ok;
    Display display;
    
    TextField numberField;          // for taking input.
    StringItem resField;            // for displaying output
    
    public void startApp() {
        form = new Form("Factorial Application");
        ok = new Command("Calculate", Command.OK, 0);
        display = Display.getDisplay(this);
        
        numberField = new TextField("Enter N:", "", 2, TextField.NUMERIC); 
            // creates an input text field with default "" of max width 2
            // accepting only number input (including negative numbers as well).

        resField = new StringItem("Fibonacci Series % 10^9+7: ", "");
        
        form.append(numberField);
        form.append(resField);
        form.addCommand(ok);
        form.setCommandListener(this);
        
        display.setCurrent(form);
    }
    
    public void pauseApp() {}
    
    public void destroyApp(boolean unconditional) {}
    
    private String listToString(int a[]){
        String res = "[";
        int i = 0;
        for(; i < a.length -  1; i++)
            res += a[i] + ", ";
        return res + a[i] + "]";
    }
    
    public String getFiboSeries(int n){
        if(n  < 1) return "Invalid Input";
        int[] series = new int[n + 1];
        series[0] = 1;
        series[1] = 1;
        for(int i=2; i < n; i++)
            series[i] = (series[i - 1] + series[i - 2]) % 1000000007;
        return listToString(series);
    }
    
    public void commandAction(Command c, Displayable d) {
        int n = Integer.parseInt(numberField.getString());
        resField.setText(getFiboSeries(n));
    }
}
