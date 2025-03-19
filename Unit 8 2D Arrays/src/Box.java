import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;

/*
 * 
 * @author Sebastian Arana
 *
 */
public class Box 
{
	public JButton box;
	
	public Box(int x, int y, int size)
	{	
		Border blackLine = BorderFactory.createLineBorder(Color.black);
		box = new JButton();
		box.setText("");
		box.setFont(new Font("Arial", Font.PLAIN, 160));
		box.setBounds(x,y,size,size);
		box.setBackground(Color.WHITE);
		box.setBorder(blackLine);
	}
	
	public char player = '-';
	
	public void setChar(char turn)
	{
		player = turn;
	}
	
	public char getChar()
	{
		return player;
	}
	
}
