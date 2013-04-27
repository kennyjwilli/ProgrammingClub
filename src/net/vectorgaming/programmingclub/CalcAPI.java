package net.vectorgaming.programmingclub;

/**
 *
 * @author Kenny
 */

interface Function { public double evaluate(double x);}

public class CalcAPI 
{
    private static final double DELTA_X = 1E-8;
    
    /**
     * Takes the derivative of a function at a point
     * @param f The function to be derived
     * @param x The x-coordinate to be evaluated at
     * @return The slope of the function at point x
     */
    public static double derivativeAt(final Function f, double x){return (f.evaluate(x + DELTA_X) - f.evaluate(x))/DELTA_X;}
    
    /**
     * Derives a function
     * @param f The function that will be derived
     * @return The first derivative of the function
     */
    public static Function derivativeOf(final Function f)
    {
        return new Function()
        {
            public double evaluate(double x)
            {
                return (f.evaluate(x + DELTA_X) - f.evaluate(x)) / DELTA_X;
            }
        };
    }
    
    /**
     * Takes the derivative of the function a set amount of times
     * @param f The function that will be derived
     * @param n The nth derivative of the function
     * @return The derived function
     */
    public static Function derivativeOf(final Function f, int n)
    {
        if(n == 0) return f;
        
        Function fn = CalcAPI.derivativeOf(f);
        
        for(int i = 0; i < n-1; i++)
        {
            fn = CalcAPI.derivativeOf(fn);
        }
        return fn;
    }
}
