import java.awt.*;

import javax.swing.*;

public class Menu extends JPanel
{
	public JButton menuButton;
	public JLabel label;
	
	public Menu() {}
	public Menu(int width, int height)
	{
		//panel;
		setLayout(new FlowLayout(FlowLayout.LEFT));
		setPreferredSize(new Dimension(width, height*2/24));
		
		//menuButton
		ImageIcon icon = new ImageIcon("Pic\\menu.png");
		Image i = icon.getImage();
		i = i.getScaledInstance(icon.getIconWidth()/12, icon.getIconHeight()/12, Image.SCALE_SMOOTH);
		icon = new ImageIcon(i);
		menuButton = new JButton(icon);
		
		menuButton.setBackground(new Color(238, 238, 238));
		menuButton.setBorder(null);
		
		
		//label
		label = new JLabel("Programmer");
		Font bigFont = new Font("Dialog", Font.BOLD, height/40);
		label.setFont(bigFont);
		
		//add
		add(menuButton);
		add(label);
	}
	
	public void addListener(Programmer_Calculator e)
	{
		menuButton.addMouseListener(e);
	}
	
	public void Resize(int width, int height)
	{
		
	}
}
