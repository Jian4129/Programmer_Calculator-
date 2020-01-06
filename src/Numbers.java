import javax.swing.*;
import java.awt.*;

public class Numbers extends JPanel
{
	public JButton[] digitButtons = {
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
	public Numbers()
	{
		setLayout(new GridLayout(4,5));
		
		add(digitButtons[10]);
		add(digitButtons[11]);
		add(digitButtons[7]);
		add(digitButtons[8]);
		add(digitButtons[9]);
		
		add(digitButtons[12]);
		add(digitButtons[13]);
		add(digitButtons[4]);
		add(digitButtons[5]);
		add(digitButtons[6]);
		
		add(digitButtons[14]);
		add(digitButtons[15]);
		add(digitButtons[1]);
		add(digitButtons[2]);
		add(digitButtons[3]);
		
		add(leftPare);
		add(rightPare);
		add(signSwitch);
		add(digitButtons[0]);
		add(dot);
		
	}
	
	public void addListener(Programmer_Calculator e)
	{
		
	}
	
	public void Resize(int width, int height)
	{
		
	}
}
