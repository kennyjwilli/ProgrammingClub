package net.vectorgaming.programmingclub;

/**
 *
 * @author Kenny
 */
public class ProgrammingClub 
{
    
    
    public static void main(String[] args) 
    {        
//        ClubAPI.union(1, 2);
//        ClubAPI.union(2, 3);
//        ClubAPI.union(3, 4);
//        ClubAPI.union(4, 5);
//        if(ClubAPI.connected(1, 6))
//        {
//            System.out.println("connected");
//        }else
//        {
//            System.out.println("not connected");
//        }
        Function f = new Function()
        {
            @Override
            public double evaluate(double x)
            {
                return 2*x*x + 3*x - 2;
            }
        };
        
        System.out.println(CalcAPI.derivativeAt(f, 2));;
    }
}
