import javax.swing.*;
import java.awt.*;
import java.math.BigInteger;

public class Convert extends JPanel
{
	JButton hex, dec, oct, bin;
	int currentBase = 10;
	
	public Convert() {}
	public Convert(int width, int height)
	{
		//setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		setLayout(new GridLayout(4,1));
		setPreferredSize(new Dimension(width, height*4/24));
		
		hex = new JButton ();
		dec = new JButton ();
		oct = new JButton ();
		bin = new JButton ();
		
		add(hex);
		add(dec);
		add(oct);
		add(bin);
		//set the default design for the 4 buttons
		Font font = new Font("Dialog", Font.BOLD, height/60);
		for(Component c : this.getComponents())
		{
			((JButton)c).setFont(font);
			((JButton)c).setHorizontalAlignment(JButton.LEFT);
			((JButton)c).setBackground(new Color(238, 238, 238));
			((JButton)c).setBorder(null);
		}
		//default base is dec
		backgroundChange(dec);
		//set the initial number into zero
		Convert("0");
	}
	
	public void backgroundChange(JButton current)
	{
		for(Component c : this.getComponents())
		{
			((JButton)c).setBackground(new Color(238,238,238,238));
		}
		
		current.setBackground(new Color(0, 255, 255));
	}
	//set the value in the 4 button into proper base
	public void Convert(String value)
	{
		hex.setText("  HEX " + new BigInteger(value, currentBase).toString(16).toUpperCase());
		dec.setText("  DEC " + new BigInteger(value, currentBase).toString(10));
		oct.setText("  OCT " + new BigInteger(value, currentBase).toString(8));
		bin.setText("  BIN  " + new BigInteger(value, currentBase).toString(2));
	}
	
	public void addListener(Programmer_Calculator e)
	{
		hex.addMouseListener(e);
		dec.addMouseListener(e);
		oct.addMouseListener(e);
		bin.addMouseListener(e);
	}
	
	public void Resize(int width, int height)
	{
		
	}
	
}
