import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Ellipse2D;

import javax.swing.JComponent;

public class PolarPoint extends JComponent
{
	private int x;
	private int y;
	
	public PolarPoint(int r, int angle)
	{
		x = (int) (r*Math.cos(Math.toRadians(angle)));
		y = (int) (r*Math.sin(Math.toRadians(angle)));
	}
	
	protected void paintComponent(Graphics g)
	{
		Point c = new Point(300,300);
	    
		Graphics2D g2d = (Graphics2D) g;

		Ellipse2D.Double e = new Ellipse2D.Double(x + c.x-2,y + c.y-2,5,5);
		g2d.setColor(Color.BLACK);
		g2d.fill(e);
	}
}
