import javax.swing.JComponent;
import java.awt.*;
import java.awt.geom.*;

public class Ellipse extends JComponent
{
	int x,y,w,h;
	
	private Color c;
	
	public Ellipse(int x, int y, int w, int h, Color c)
	{
		this.x = x;
		this.y = y;
		
		this.w = w;
		this.h = h;
		
		this.c = c;
	}
	
	protected void paintComponent(Graphics g)
	{
		Graphics2D g2d = (Graphics2D) g;
		
		Ellipse2D.Double e = new Ellipse2D.Double(x,y,w,h);
		g2d.setColor(c);
		g2d.fill(e);
	}
}
