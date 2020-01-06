import javax.swing.*;
import java.awt.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Stack;

public class Save extends JPanel
{
	JTextField save;
	Stack<String> operand = new Stack();
	Stack<String> operator = new Stack();
	
	public Save() {}
	public Save(int width, int height)
	{
		setLayout(new FlowLayout(FlowLayout.RIGHT));
		setPreferredSize(new Dimension(width, height*1/24));
		
		save = new JTextField(new String());
		save.setPreferredSize(new Dimension(width, height*1/24));
		Font font = new Font("Dialog", Font.PLAIN, height/60);
		save.setFont(font);
		save.setHorizontalAlignment(JTextField.RIGHT);
		save.setBackground(new Color(238,238,238));
		save.setBorder(null);
		save.setEditable(false);
		
		add(save);
	}
	
	public void addOperand(String s, int currentBase)
	{
		save.setText(save.getText() + " " + s);
		s = new BigInteger(s, currentBase).toString(10);
		operand.push(s);
	}
	
	String result = new String();
	int tempResult = 0;
	public String addOperator(String operatorTwo, int currentBase) //operatorTwo is just a operator. 
	{
		save.setText(save.getText() + " " + operatorTwo);
		if(!operand.empty())
		{
			result = operand.peek();
		}
		if( (operatorTwo == "+") || (operatorTwo == "-") )
		{
			while( !operator.empty() && (operator.peek() != "(") )
			{	
				tempResult = Process(operator.pop());
				result = Integer.toString(tempResult);
				operand.push(result);
			}
			operator.push(operatorTwo);
		}
		else if( (operatorTwo == "*") || (operatorTwo == "/") || (operatorTwo == "Mod") )
		{
			while( !operator.empty() && ((operator.peek() == "*") || (operator.peek() == "/") || (operator.peek() == "Mod")) )
			{
				tempResult = Process(operator.pop());
				result = Integer.toString(tempResult);
				operand.push(result);
			}
			operator.push(operatorTwo);
		}
		else if(operatorTwo == "(")
		{	
			result = "0";
			operator.push(operatorTwo);
		}
		else if(operatorTwo == ")")
		{
			while(operator.peek() != "(")
			{
				tempResult = Process(operator.pop());
				result = Integer.toString(tempResult);
				operand.push(result);
			}
			//pop the (
			operator.pop();
		}
		else if(operatorTwo == "=")
		{
			while(!operator.empty())
			{
				tempResult = Process(operator.pop());
				result = Integer.toString(tempResult);
				operand.push(result);
			}
			result = operand.peek();
		}
		result = new BigInteger(result, 10).toString(currentBase);
		return result;
	}
	
	public int Process(String operatorTwo) 
	{
		String temp2 = operand.pop().trim();
		String temp1 = operand.pop().trim();
		return Calculate(temp1, temp2, operatorTwo);
	}
	
	public int Calculate(String one, String two, String operatorTwo) //return the calculated the value
	{
		int temp1 = Integer.parseInt(one);
		int temp2 = Integer.parseInt(two);
		switch (operatorTwo)
		{
		case "+":
			return temp1 + temp2;
		case "-":
			return temp1 - temp2;
		case "/":
			return temp1/temp2;
		case "*":
			return temp1*temp2;
		case "Mod":
			return temp1%temp2;
		default:
			return -1;
		}
	}
	
	public void clear()
	{
		save.setText(null);
		save.setText(new String ());
		
		operand = null;
		operand = new Stack();
		
		operator = null;
		operator = new Stack();
		
		result = null;
	}
	public void Resize(int width, int height)
	{
		
	}
	
	public void addListener(Programmer_Calculator e)
	{
		
	}
}
