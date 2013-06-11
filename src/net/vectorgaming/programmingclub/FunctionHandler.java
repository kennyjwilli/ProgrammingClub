
package net.vectorgaming.programmingclub;

import de.congrace.exp4j.Calculable;
import de.congrace.exp4j.ExpressionBuilder;
import java.text.DecimalFormat;
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
    
    public double evaulateAt(double x)
    {
        String fnStr = "";
        for(String s : fn)
        {
            fnStr += s;
            fnStr += x;
        }
        try
        {
            Calculable eval = new ExpressionBuilder(fnStr)
                    .build();
            return eval.calculate();
        }catch(Exception e){}
        return 0;
    }
    
    public String deriveAt(double y)
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
            Calculable evalFirst = new ExpressionBuilder(first)
                    .build();
            Calculable evalSec = new ExpressionBuilder(second)
                    .build();
            
            //double evalFirst = (Double)se.eval(first);
            //double evalSec = (Double)se.eval(second);
            DecimalFormat dm = new DecimalFormat("#.###");
            double ans = ((evalFirst.calculate() - evalSec.calculate()) / DELTA_X);
            return dm.format(ans);
        }catch(Exception e){}
        return "Error";
    }
    
    public String integrate(double lowerLimit, double upperLimit)
    {
        double limitSub = (upperLimit - lowerLimit);
        double rect = (upperLimit - lowerLimit)*200;
        double deltaX = (upperLimit - lowerLimit) / rect;
        double fnEval = 0;
        
        for(double i = lowerLimit; i < upperLimit; i += deltaX)
        {
            if(i == lowerLimit || i == upperLimit)
            {
                fnEval += this.evaulateAt(i);
            }else
            {
                fnEval += 2*this.evaulateAt(i);
            }
        }
        DecimalFormat dm = new DecimalFormat("#.###");
        double output = (deltaX/2)*fnEval;
        return dm.format(output);
    }
    
    public void addElement(String str){fn.add(str);}
}
