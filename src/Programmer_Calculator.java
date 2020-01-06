import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;

public class Programmer_Calculator extends JFrame implements MouseListener
{
	Container mainPanel;
	Menu menu;
	Save save;
	Display display;
	Convert convert;
	Function_1 function_1;
	Function_2 function_2;

	public Programmer_Calculator() {}
	public Programmer_Calculator(int width, int height)
	{	
		//mainPanel
		mainPanel = this.getContentPane();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		mainPanel.setPreferredSize(new Dimension(width, height));
		
		//menu
		menu = new Menu(width, height);
		
		//save
		save = new Save(width, height);
		
		//display
		display = new Display(width, height);
		
		//convert
		convert = new Convert(width, height);
		
		//function_1
		function_1 = new Function_1(width, height);
		
		//function_2
		function_2 = new Function_2(width, height);
		
		addPanel();
		
		addListener();
	}
	public void addPanel() {
		mainPanel.add(menu);
		mainPanel.add(save);
		mainPanel.add(display);
		mainPanel.add(convert);
		mainPanel.add(function_1);
		mainPanel.add(function_2);
	}
	public void addListener()
	{
		menu.addListener(this);
		save.addListener(this);
		display.addListener(this);
		convert.addListener(this);
		function_1.addListener(this);
		function_2.addListener(this);
	}
	public void Resize(int width, int height)
	{	
		mainPanel.setSize(width, height);
		menu.Resize(width, height);
		/*save.Resize(width, height);
		display.Resize(width, height);
		convert.Resize(width, height);
		function_1.Resize(width, height);
		function_2.Resize(width, height);*/
	}
	public void addOperator(String operator, int currentBase) 
	{
		String result = new String();
		result = display.popDisplayedNumber();
		if(!result.isEmpty()) {
			save.addOperand(result, currentBase); //push the operand in the display screen
			result = save.addOperator(operator, currentBase); //push the operator clicked
			display.display.setText(result); //set the text to the result
			convert.Convert(result);
		}
		if(operator == "(") {
			result = save.addOperator(operator, currentBase);
			display.display.setText(result); //set the text to the result
			convert.Convert(result);
		}
		
	}
	int temp = 0; //for shift button
	@Override
	public void mouseClicked(MouseEvent e) {
		//number key
		for(int i = 0; i < function_2.hexButtons.length; i++)
		{
			if(e.getSource() == function_2.hexButtons[i] && function_2.hexButtons[i].isEnabled())
			{
				display.pushDisplayedNumber(i);
				convert.Convert(display.getDisplayedNumber());
				return;
			}
		}
		//shift
		if (e.getSource() == function_2.shift)
		{
			if (temp == 0)
			{
				function_2.shift.setBackground(new Color(0, 255, 255));
				function_2.shiftPressed();
				temp = 1;
			}
			else
			{
				function_2.shift.setBackground(new Color(238,238,238,238));
				function_2.shiftReleased();
				temp = 0;
			}
		}
		//common math operator
		else if(e.getSource() == function_2.addition)
		{
			addOperator(function_2.addition.getText(), convert.currentBase);
		}
		else if(e.getSource() == function_2.subtract)
		{
			addOperator(function_2.subtract.getText(), convert.currentBase);
		}
		else if(e.getSource() == function_2.multiply)
		{
			addOperator(function_2.multiply.getText(), convert.currentBase);
		}
		else if(e.getSource() == function_2.divide)
		{
			addOperator(function_2.divide.getText(), convert.currentBase);
		}
		else if(e.getSource() == function_2.mod)
		{
			addOperator(function_2.mod.getText(), convert.currentBase);
		}
		else if(e.getSource() == function_2.leftPare)
		{
			addOperator(function_2.leftPare.getText(), convert.currentBase);
		}
		else if(e.getSource() == function_2.rightPare)
		{
			addOperator(function_2.rightPare.getText(), convert.currentBase);
		}
		else if (e.getSource() == function_2.equal)
		{
			addOperator(function_2.equal.getText(), convert.currentBase);
			save.clear();
		}
		//2 type of clear
		else if (e.getSource() == function_2.CE)
		{
			display.clear();
			convert.Convert("0");
		}
		else if (e.getSource() == function_2.clear)
		{
			display.clear();
			save.clear();
			convert.Convert("0");
		}
		//4 different base
		else if(e.getSource() == convert.hex)
		{
			
			convert.currentBase = 16;
			convert.backgroundChange(convert.hex);
			function_2.setActivate(function_2.hexButtons);
			String value = convert.hex.getText().substring(5, convert.hex.getText().length()).trim();
			display.setDisplayedNumber(value);
			display.display.setText(value);
		}
		else if(e.getSource() == convert.dec)
		{
			convert.currentBase = 10;
			convert.backgroundChange(convert.dec);
			function_2.setActivate(function_2.decButtons);
			String value = convert.dec.getText().substring(5, convert.dec.getText().length()).trim();
			display.setDisplayedNumber(value);
			display.display.setText(value);
		}
		else if(e.getSource() == convert.oct)
		{
			convert.currentBase = 8;
			convert.backgroundChange(convert.oct);
			function_2.setActivate(function_2.octButtons);
			String value = convert.oct.getText().substring(5, convert.oct.getText().length()).trim();
			display.setDisplayedNumber(value);
			display.display.setText(value);
		}
		else if(e.getSource() == convert.bin)
		{
			convert.currentBase = 2;
			convert.backgroundChange(convert.bin);
			function_2.setActivate(function_2.binaryButtons);
			String value = convert.bin.getText().substring(5, convert.bin.getText().length()).trim();
			display.setDisplayedNumber(value);
			display.display.setText(value);
		}
		//sign switch
		else if(e.getSource() == function_2.signSwitch)
		{
			//switch the sign
			String result = function_2.signSwitchFunc(display.display.getText(), convert.currentBase);
			//update the display
			display.setDisplayedNumber(result);
			display.display.setText(result);
			//update the 4 bases
			convert.Convert(result);
		}
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
