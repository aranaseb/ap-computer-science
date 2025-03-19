import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JComponent;

public class CircleButton extends JComponent
{
	private int r;
	
	private Color c;
	
	public CircleButton (int r, Color c)
	{
		this.r = r;
	}
	
	protected void paintComponent(Graphics g)
	{
		Circle circle = new Circle(0,0,r,c);
		add(circle);
		Circle newCircle = new Circle(0,0,r,new Color(c.getRed(),c.getGreen(),c.getBlue()+100));
		Circle newCircle2 = new Circle(0,0,r,Color.WHITE);
		addMouseListener(new MouseListener()
		{
			public void mouseClicked(MouseEvent e)
			{
				System.exit(0);
			}

			public void mousePressed(MouseEvent e)
			{
				remove(newCircle);
				add(newCircle2);
			}
			
			public void mouseReleased(MouseEvent e) 
			{
				remove(newCircle2);
				add(newCircle);
			}

			public void mouseEntered(MouseEvent e)
			{
				remove(circle);
				add(newCircle);
			}

			public void mouseExited(MouseEvent e) 
			{
				remove(newCircle);
				add(circle);
			}
		});
	}
}
