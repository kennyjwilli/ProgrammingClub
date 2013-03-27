package net.vectorgaming.programmingclub;

/**
 *
 * @author Kenny
 */
public class ProgrammingClub 
{
    
    
    public static void main(String[] args) 
    {
        ClubAPI.union(2, 3);
        if(ClubAPI.connected(2, 3))
        {
            System.out.println("Points 2 and 3 ARE connected.");
        }else
        {
            System.out.println("Points 2 and 3 are NOT connected.");
        }
    }
}
