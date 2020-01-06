import java.awt.Dimension;

import javax.swing.JFrame;

public class Main 
{
	public static void main(String[] args) throws Exception
	{
		
		int width = 500;
		int height = 850;
		Programmer_Calculator c1 = new Programmer_Calculator(width, height);
		c1.setTitle("Calculator");
		c1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		c1.pack();
		c1.setVisible(true);
	}

}
