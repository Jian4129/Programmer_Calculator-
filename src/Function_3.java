import javax.swing.*;
import java.awt.*;
public class Function_3 extends JPanel
{
	private CommonFunction cf;
	public Function_3()
	{
		cf = new CommonFunction();
		setLayout(new BorderLayout());
		
		add(cf, BorderLayout.NORTH);
	}
	
	public void addListener(Programmer_Calculator e)
	{
		cf.addListener(e);
	}
	
	public void resize(int width, int height)
	{
		
	}
}
