import java.awt.Color;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class CircleTest 
{

	public static void main(String[] args) 
	{
		JFrame window = new JFrame();
		int s = 150;
		window.setSize(s,s);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setUndecorated(true);
		window.setBackground(new Color(1.0f,1.0f,1.0f,0.0f));
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		
		Color c = new Color(128,0,0);
		Color c2 = c.brighter();
		Color c3 = c2.brighter();
		
		Circle circle = new Circle(0,0,s/2,c);
		window.add(circle);
		SwingUtilities.updateComponentTreeUI(window);
		
		Circle newCircle = new Circle(0,0,s/2,c2);
		Circle newCircle2 = new Circle(0,0,s/2,c3);
		window.addMouseListener(new MouseListener()
		{
			public void mouseClicked(MouseEvent e)
			{
				System.exit(0);
			}

			public void mousePressed(MouseEvent e)
			{
				window.remove(newCircle);
				window.add(newCircle2);
				SwingUtilities.updateComponentTreeUI(window);
			}
			
			public void mouseReleased(MouseEvent e) 
			{
				window.remove(newCircle2);
				window.add(newCircle);
				SwingUtilities.updateComponentTreeUI(window);
			}

			public void mouseEntered(MouseEvent e)
			{
				window.remove(circle);
				window.add(newCircle);
				SwingUtilities.updateComponentTreeUI(window);
			}

			public void mouseExited(MouseEvent e) 
			{
				window.remove(newCircle);
				window.add(circle);
				SwingUtilities.updateComponentTreeUI(window);
			}
		});
		
		window.addMouseMotionListener(new MouseMotionListener()
		{
			public void mouseDragged(java.awt.event.MouseEvent e)
			{
				Point p = MouseInfo.getPointerInfo().getLocation();
				p.x-=s/2;
				p.y-=s/2;
				window.setLocation(p);
				SwingUtilities.updateComponentTreeUI(window);
			}
			
			public void mouseMoved(java.awt.event.MouseEvent e)
			{
				
			}
		});
	}

}
