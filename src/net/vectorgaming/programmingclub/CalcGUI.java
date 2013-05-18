package net.vectorgaming.programmingclub;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author Kenny
 */
public class CalcGUI extends JFrame
{
    private JLabel desc;
    private JLabel eqDesc;
    private JLabel at;
    private JLabel from;
    private JLabel to;
    private JLabel answer;
    private JButton calc;
    private JTextField equation;
    private JTextField atField;
    private JTextField integralBot;
    private JTextField integralTop;
    private JRadioButton derivative;
    private JRadioButton integral;
    private JPanel midPanel;
    
    public CalcGUI()
    {
        super("Calculusalator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(createContentPane());
        
        /*JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(350, 250));
        setLayout(new FlowLayout());
        
        item1 = new JLabel("<html>Enter the function below. Check the derivative or integral box and hit calculate!</html>");
        item1.setHorizontalAlignment((int)JFrame.LEFT_ALIGNMENT);
        item1.setHorizontalTextPosition((int)LEFT_ALIGNMENT);
        item1.setBounds(0, 0, WIDTH, WIDTH);
        
        calc = new JButton("<html><u>Calculate!</html>");
        
        equation = new JTextField(20);
        
        add(item1);
        add(equation);
        add(calc);
        
        ButtonHandler handler = new ButtonHandler();
        calc.addActionListener(handler);*/
    }
    
    private Container createContentPane()
    {
        JPanel panel = new JPanel(new BorderLayout());
        JPanel eqPanel = new JPanel(new FlowLayout());
        JPanel buttons = new JPanel(new FlowLayout());
        JPanel integralLimits = new JPanel(new FlowLayout());
        midPanel = new JPanel(new FlowLayout());
        
        desc = new JLabel("Eaily take the derivative or integral of a function inaccurately!");
        eqDesc = new JLabel("Equation:");
        at = new JLabel("at");
        from = new JLabel("From:");
        to = new JLabel("to");
        calc = new JButton("<html><u>Calculate!</html>");
        calc.addActionListener(new ButtonHandler());
        equation = new JTextField(20);
        atField = new JTextField(3);
        integralBot = new JTextField(3);
        integralTop = new JTextField(3);
        derivative = new JRadioButton("Derivative");
        derivative.setSelected(true);
        integral = new JRadioButton("Integral");
        ButtonGroup group = new ButtonGroup();
        group.add(derivative);
        group.add(integral);
        
        derivative.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent event)
            {
                at.setVisible(true);
                atField.setVisible(true);
                from.setVisible(false);
                integralBot.setVisible(false);
                to.setVisible(false);
                integralTop.setVisible(false);
            }
        });
        
        integral.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent event)
            {
                at.setVisible(false);
                atField.setVisible(false);
                from.setVisible(true);
                integralBot.setVisible(true);
                to.setVisible(true);
                integralTop.setVisible(true);
            }
        });
        
        //Add stuff to panels
        eqPanel.add(eqDesc);
        eqPanel.add(equation);
        eqPanel.add(at);
        eqPanel.add(atField);
        buttons.add(derivative);
        buttons.add(integral);
        integralLimits.add(from);
        integralLimits.add(integralBot);
        integralLimits.add(to);
        integralLimits.add(integralTop);
        
        //Add all necessary panels to the center panel
        midPanel.add(buttons);
        midPanel.add(eqPanel);
        midPanel.add(integralLimits);
        
        //Add all to borderlayout
        panel.add(midPanel, BorderLayout.CENTER);
        panel.add(calc, BorderLayout.SOUTH);
        panel.add(desc, BorderLayout.NORTH);
        
        return panel;
    }
    
    private class ButtonHandler implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent event)
        {
            if(derivative.isSelected())
            {
                
            }else
            {
                
            }
        }
    }
}
