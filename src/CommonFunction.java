import javax.swing.*;
import java.awt.*;

public class CommonFunction extends JPanel 
{
	JButton shift, mod, CE, clear, backspace, divide;
	public CommonFunction()
	{
		shift = new JButton("shift");
		mod = new JButton ("Mod");
		CE = new JButton ("CE");
		clear = new JButton ("C");
		backspace = new JButton ("backspace");
		divide = new JButton ("divide");
		
		add(shift);
		add(mod);
		add(CE);
		add(clear);
		add(backspace);
		add(divide);
	}
	public void addListener(Programmer_Calculator e)
	{
		shift.addMouseListener(e);
		mod.addMouseListener(e);
		CE.addMouseListener(e);
		clear.addMouseListener(e);
		backspace.addMouseListener(e);
		divide.addMouseListener(e);
	}
	
	public void resize(int width, int height)
	{
		
	}
}
