/*
 *  
 * Mouse class
 * 
 * This class stores the mouse object with an icon
 * as well as the method to relocate the mouse within a JFrame.
 * 
 * @author Sebastian Arana
 * 
 */

import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Mouse 
{	
	public JLabel mouse = new JLabel("");    //instance field for mouse icon within object
	
	public Mouse()
	{
		JLabel mIcon = new JLabel("");
		
		/*
		 * imports and scales down mouse icon from file
		 */
		ImageIcon icon = new ImageIcon("Mouse.png"); 
		Image image = icon.getImage();
		Image newimg = image.getScaledInstance(50,50,Image.SCALE_SMOOTH);  
		icon = new ImageIcon(newimg);
		
		mIcon.setBackground(new Color(1.0f,1.0f,1.0f,0.0f));
		mIcon.setIcon(icon);	
		
		mouse = mIcon;	
	}
	
	/*
	 * 
	 * @param x,y
	 * positions for mouse
	 */
	public void setMouse(int x, int y)
	{
		mouse.setBounds(x,y,50,50);
	}

}
