import java.awt.Color;

public class Circle extends Ellipse	
{
	public Circle(int x,int y, int r, Color c)
	{
		super(x,y,r*2,r*2, c);
	}
}
