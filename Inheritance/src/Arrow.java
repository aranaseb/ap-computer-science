import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

import javax.swing.JComponent;

public class Arrow extends JComponent
{
	private int x;
	private int y;
	
	private int x1;
	private int y1;
	
	public Arrow(int x, int y, int x1, int y1)
	{
		this.x = x;
		this.y = y;
		
		this.x1 = x1;
		this.y1 = y1;
	}
	
	protected void paintComponent(Graphics g)
	{
		Graphics2D g2d = (Graphics2D) g;
		
		Line2D.Double line = new Line2D.Double(x,y+12,x1,y1);
		g2d.setColor(Color.BLACK);
		g2d.draw(line);
		
		g2d.drawPolygon(new int[] {x-6,x+6,x},new int[] {y+12,y+12,y}, 3);
	}
}
