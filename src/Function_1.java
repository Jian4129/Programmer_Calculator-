import java.awt.*;

import javax.swing.*;

public class Function_1 extends JPanel
{
	JButton buttonOne, buttonTwo, buttonUnit, buttonFour, buttonFive;
	GridBagConstraints gbc = new GridBagConstraints();
	
	public Function_1() {}
	public Function_1(int width, int height)
	{
		setLayout(new GridBagLayout());
		setPreferredSize(new Dimension(width, height*2/24));
		gbc.weightx = 1;
		gbc.weighty = 1.0;
		gbc.fill = GridBagConstraints.BOTH;
		
		//menuButton
		ImageIcon icon = new ImageIcon("Pic/One.jpg");
		Image i = icon.getImage();
		i = i.getScaledInstance(icon.getIconWidth(), icon.getIconHeight(), Image.SCALE_SMOOTH);
		icon = new ImageIcon(i);
		
		buttonOne = new JButton(icon);
		
		icon = new ImageIcon("Pic/two.JPG");
		i = icon.getImage();
		i = i.getScaledInstance(icon.getIconWidth(), icon.getIconHeight(), Image.SCALE_SMOOTH);
		icon = new ImageIcon(i);
		
		buttonTwo = new JButton(icon);
		
		buttonUnit = new JButton("QWORD");
		buttonFour = new JButton("MS");
		buttonFive = new JButton("M-");
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		add(buttonOne, gbc);
		
		gbc.gridx = 1;
		add(buttonTwo, gbc);
		
		gbc.gridx = 2;
		gbc.gridwidth = 2;
		add(buttonUnit, gbc);
		
		gbc.gridx = 4;
		gbc.gridwidth = 1;
		add(buttonFour, gbc);
		
		gbc.gridx = 5;
		add(buttonFive, gbc);
		
		Font font = new Font("Dialog", Font.BOLD, height/50);
		for(Component c : this.getComponents())
		{
			((JButton)c).setFont(font);
			((JButton)c).setHorizontalAlignment(JButton.CENTER);
			((JButton)c).setBackground(new Color(238, 238, 238));
			((JButton)c).setBorder(null);
		}	
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
