
package net.vectorgaming.programmingclub;

import java.util.ArrayList;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

/**
 *
 * @author Kenny
 */
public class FunctionHandler 
{
    public FunctionHandler(String[] function)
    {
        for(String s : function)
        {
            addElement(s);
        }
    }
    private static final double DELTA_X = 1E-8;
    private ScriptEngineManager manager = new ScriptEngineManager();
    private ScriptEngine se = manager.getEngineByName("JavaScript");
    private ArrayList<String> fn = new ArrayList<>();
    
    public ArrayList<String> getFunctionComponents() {return fn;}
    
    public double deriveAt(double y)
    {
        String first = "";
        String second = "";
        for(String s : fn)
        {
            first += s;
            first += (DELTA_X + y);
        }
        
        for(String s : fn)
        {
            second += s;
            second += y;
        }
        try
        {
            double evalFirst = (Double)se.eval(first);
            double evalSec = (Double)se.eval(second);
            return ((evalFirst - evalSec) / DELTA_X);
        }catch(Exception e){}
        return 0;
    }
    
    public void addElement(String str){fn.add(str);}
}
