package net.vectorgaming.programmingclub;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author Kenny
 */
public class ProgrammingClub extends JFrame
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
        
        CalcGUI gui = new CalcGUI();
        gui.setSize(400, 250);
        gui.setLocationRelativeTo(null);
        gui.setResizable(false);
        gui.setVisible(true);
        
        //Calculusalator.main(args);
        
        Function f = new Function()
        {
            @Override
            public double evaluate(double x)
            {
                return 2*x*x*x + 3*x - 2;
            }
        };
        
        //System.out.println(CalcAPI.derivativeOf(f).evaluate(2));
        //System.out.println(CalcAPI.derivativeOf(f, 2).evaluate(2));
    }
    
    private static void setupFrame(JFrame f)
    {
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(800, 800);
        Container content = f.getContentPane();
        content.setBackground(Color.WHITE);
        content.setLayout(new FlowLayout());
        content.add(new JButton("Button 1"));
        f.setVisible(true);
        //f.pack();
    }
}
