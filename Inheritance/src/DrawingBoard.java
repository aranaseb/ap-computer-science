import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

import javax.swing.JComponent;

public class DrawingBoard extends JComponent
{
	private int x;
	private int y;
	
	private int width;
	private int height;
	
	public DrawingBoard(int x, int y, int w, int h)
	{
		this.x = x;
		this.y = y;
		
		width = w;
		height = h;
	}
	
	protected void paintComponent(Graphics g)
	{
		Graphics2D g2d = (Graphics2D) g;

		Ellipse2D.Double e = new Ellipse2D.Double(x+300,y+300,width,height);
		g2d.setColor(Color.BLACK);
		g2d.fill(e);
	}
}
