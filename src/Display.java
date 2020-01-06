import java.awt.*;
import java.math.BigInteger;

import javax.swing.*;


public class Display extends JPanel
{
	JTextField display;
	private String displayedNumber = new String();
	
	public Display(int width, int height)
	{
		setLayout(new FlowLayout(FlowLayout.RIGHT));
		setPreferredSize(new Dimension(width, height*3/24));
		//default design for this panel
		display = new JTextField("0");
		display.setPreferredSize(new Dimension(width, height*3/24));
		Font font = new Font("Serif", Font.PLAIN, height/20);
		display.setFont(font);
		display.setHorizontalAlignment(JTextField.RIGHT);
		display.setBackground(new Color(238,238,238));
		display.setBorder(null);
		display.setEditable(false);
		
		add(display);
	}
	//exist for consistency seek
	public void addListener(Programmer_Calculator e)
	{
		
	}
	//append the number, treating displayedNumber as an array of char
	public void pushDisplayedNumber(int i) 
	{
		displayedNumber = displayedNumber + Integer.toString(i);
		display.setText(displayedNumber);
	}
	//pop the number on the display
	private String temp;
	public String popDisplayedNumber() 
	{
		temp = displayedNumber;
		displayedNumber = null;
		displayedNumber = new String();
		display.setText("0");
		return temp;
	}
	
	public String getDisplayedNumber()
	{
		return displayedNumber;
	}
	
	public void setDisplayedNumber(String s)
	{
		displayedNumber = s;
	}
	
	public void clear() //clean the display
	{
		displayedNumber = null;
		displayedNumber = new String();
		display.setText("0");
	}
	
	public void Resize(int width, int height)
	{
		
	}
}
