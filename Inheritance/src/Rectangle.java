import javax.swing.BorderFactory;
import javax.swing.JComponent;
import java.awt.*;
import java.awt.geom.*;

@SuppressWarnings("serial")
public class Rectangle extends JComponent
{
	private int x;
	private int y;
	
	private int width;
	private int height;
	
	private Color c;
	
	public Rectangle(Point p, Point d, Color c)
	{
		this.x = p.x;
		this.y = p.y;
		
		this.width = d.x;
		this.height = d.y;
		
		this.c = c;
	}
	
	protected void paintComponent(Graphics g)
	{
		Graphics2D g2d = (Graphics2D) g;
		
		Rectangle2D.Double r = new Rectangle2D.Double(x,y,width,height);
		g2d.setColor(c);
		g2d.fill(r);
		
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
	}
}
