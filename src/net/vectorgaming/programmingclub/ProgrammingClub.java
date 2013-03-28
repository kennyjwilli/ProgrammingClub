package net.vectorgaming.programmingclub;

import java.util.ArrayList;

/**
 *
 * @author Kenny
 */
public class ProgrammingClub 
{
    
    
    public static void main(String[] args) 
    {
        ClubAPI.setupIds();
        
        ClubAPI.union(1, 2);
        ClubAPI.union(2, 3);
        ClubAPI.union(3, 4);
        ClubAPI.union(4, 5);
        if(ClubAPI.connected(1, 5))
        {
            System.out.println("connected");
        }else
        {
            System.out.println("not connected");
        }
    }
}
