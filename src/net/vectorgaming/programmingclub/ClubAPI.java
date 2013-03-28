package net.vectorgaming.programmingclub;

/**
 *
 * @author Kenny
 */
public class ClubAPI 
{
    private static int[] ids = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};    
    /**
     *
     * @return The list of Ids
     */
    public static int[] getIds()
    {
        return ids;
    }
    
    /**
     *
     * @param list A list of ids to be set
     */
    public static void setIds(int[] list)
    {
        ClubAPI.ids = list;
    }
    
    /**
     *
     * @param point1 The first point to be connected
     * @param point2 The second point to be connected
     */
    public static void union(int point1, int point2)
    {
        ids[point1] = point2;
    }
    
    /**
     *
     * @param point1 First point
     * @param point2 Second point
     * @return True if the two points are connected
     */
    public static boolean connected(int point1, int point2)
    {
        boolean value = true;
        int counter = 0;
        int i = point1;
        while(value)
        {
            i = ids[i];
            if(i == point2)
            {
                value = false;
                return true;
            }
            if(counter > 10)
            {
                value = false;
                return false;
            }
            counter++;
        }
        return false;
    }
}
