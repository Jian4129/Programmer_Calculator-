import java.awt.*;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;

import javax.swing.*;

public class Function_2 extends JPanel
{
	JButton buttonOne, buttonTwo, buttonThree, buttonFour, buttonFive, buttonSix;
	public JButton[] binaryButtons, octButtons, decButtons;
	public JButton[] hexButtons = {
			new JButton("0"), new JButton("1"), new JButton("2"),
			new JButton("3"), new JButton("4"), new JButton("5"),
			new JButton("6"), new JButton("7"), new JButton("8"),
			new JButton("9"), new JButton("A"), new JButton("B"),
			new JButton("C"), new JButton("D"), new JButton("E"),
			new JButton("F")
	};
	public JButton 
		leftPare = new JButton("("), 
		rightPare = new JButton(")"), 
		signSwitch = new JButton("hold"), 
		dot = new JButton(".");
	
	JButton shift, mod, CE, clear, backspace;
	
	JButton divide, multiply, subtract, addition, equal;
	
	public Function_2() {}
	public Function_2(int width, int height)
	{
		setLayout(new GridLayout(6, 6));
		setPreferredSize(new Dimension(width, height/2));
		
		binaryButtons = Arrays.copyOfRange(hexButtons, 0, 2);
		octButtons = Arrays.copyOfRange(hexButtons, 0, 8);
		decButtons = Arrays.copyOfRange(hexButtons, 0, 10);
		
		buttonOne = new JButton("Lsh");
		buttonTwo = new JButton("Rsh");
		buttonThree = new JButton("Or");
		buttonFour = new JButton("Xor");
		buttonFive = new JButton("Not");
		buttonSix = new JButton("And");
		
		//CommonFunction
		shift = new JButton("shift");
		mod = new JButton ("Mod");
		CE = new JButton ("CE");
		clear = new JButton ("C");
		backspace = new JButton ("<--");
		
		//CommonOperation
		divide = new JButton("/");
		multiply = new JButton("*");
		subtract = new JButton("-");
		addition = new JButton("+");
		equal = new JButton("=");
		
		ImageIcon icon = new ImageIcon("Pic\\three.jpg");
		Image i = icon.getImage();
		i = i.getScaledInstance(icon.getIconWidth(), icon.getIconHeight(), Image.SCALE_SMOOTH);
		icon = new ImageIcon(i);
		signSwitch = new JButton(icon);
		
		add(buttonOne);
		add(buttonTwo);
		add(buttonThree);
		add(buttonFour);
		add(buttonFive);
		add(buttonSix);
		
		add(shift);
		add(mod);
		add(CE);
		add(clear);
		add(backspace);
		add(divide);
		
		add(hexButtons[10]);
		add(hexButtons[11]);
		add(hexButtons[7]);
		add(hexButtons[8]);
		add(hexButtons[9]);
		add(multiply);
		
		add(hexButtons[12]);
		add(hexButtons[13]);
		add(hexButtons[4]);
		add(hexButtons[5]);
		add(hexButtons[6]);
		add(subtract);
		
		add(hexButtons[14]);
		add(hexButtons[15]);
		add(hexButtons[1]);
		add(hexButtons[2]);
		add(hexButtons[3]);
		add(addition);
		
		add(leftPare);
		add(rightPare);
		add(signSwitch);
		add(hexButtons[0]);
		add(dot);
		add(equal);
		
		Font font = new Font("Dialog", Font.BOLD, height/50);
		for(Component c : this.getComponents())
		{
			((JButton)c).setFont(font);
			((JButton)c).setForeground(new Color(80,80,80));
			((JButton)c).setHorizontalAlignment(JButton.CENTER);
			((JButton)c).setBackground(new Color(230, 230, 230));
			((JButton)c).setBorder(BorderFactory.createLineBorder(new Color(238, 238, 238), 2));
		}
		
		for(JButton c : hexButtons)
		{
			c.setBackground(new Color(255, 255, 255));
		}
		
		setActivate(decButtons);
		
	}
	
	public void setActivate(JButton[] array)
	{
		for(JButton c : hexButtons)
		{
			c.setEnabled(false);
		}
		for(JButton c : array)
		{
			c.setEnabled(true);
		}
	}
	
	public void shiftPressed()
	{
		buttonOne.setText("Rol");
		buttonTwo.setText("RoR");
	}
	
	public void shiftReleased()
	{
		buttonOne.setText("Lsh");
		buttonTwo.setText("Rsh");
	}
	//convert a number into a opposite sign
	//@param s string that need to be converted 
	//@param currentBase the base s is in
	//@return s -(s)
	public String signSwitchFunc(String s, int currentBase) 
	{
		s = new BigInteger(s, currentBase).negate().toString(currentBase);
		return s; 
	}
	
	public void Resize(int width, int height)
	{
		
	}
	
	public void addListener(Programmer_Calculator e)
	{
		for(Component c : this.getComponents())
		{
			((JButton)c).addMouseListener(e);
		}
	}
}
