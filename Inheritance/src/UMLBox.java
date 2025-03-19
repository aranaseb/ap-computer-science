import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Rectangle2D;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JTextArea;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class UMLBox extends JComponent
{
	private Point pos;
	private Point dim;
	
	private JTextField header = new JTextField("");
	private JTextArea fields = new JTextArea("");
	private JTextArea methods = new JTextArea("");
	
	public UMLBox(Point p, Point d)
	{	
		pos = p;
		dim = d;
		
		header.setBounds(pos.x,pos.y,dim.x,dim.y/6);
		header.setBorder(BorderFactory.createLineBorder(Color.black));
		add(header);
		
		fields.setBounds(pos.x,pos.y+dim.y/6,dim.x,2*dim.y/6);
		fields.setBorder(BorderFactory.createLineBorder(Color.black));
		add(fields);
		
		methods.setBounds(pos.x,pos.y+3*dim.y/6,dim.x,3*dim.y/6);
		methods.setBorder(BorderFactory.createLineBorder(Color.black));
		add(methods);
	}
	
	protected void paintComponent(Graphics g)
	{
		Graphics2D g2d = (Graphics2D) g;
		
		int x = pos.x;
		int y = pos.y;
		
		int width = dim.x;
		int height = dim.y;
		
		Rectangle2D.Double r = new Rectangle2D.Double(x,y,width,height);
		g2d.setColor(Color.BLACK);
		g2d.fill(r);
		
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
	}
	
	public String[] getText()
	{
		String fText[] = fields.getText().split("\\r?\\n");
		String mText[] = methods.getText().split("\\r?\\n");
		
		if(fText.length>0 && mText.length>0)
			return new String[] {header.getText(),fText[0],fText[1],mText[0],mText[1],mText[2]};
		else
			return new String[] {header.getText(),"-","-","+","+","+"};
	}
	
	public void setText(String[] input)
	{
		if(input[0]==null)
			header.setText("");
		else
			header.setText(input[0]);
		if(input[1]==null)
			fields.setText("-\n-");
		else
		{
			fields.setText(input[1] + "\n" + input[2]);
		}
		if(input[2]==null)
			methods.setText("+\n+\n+");
		else
		{
			methods.setText(input[3] + "\n" + input[4] + "\n" + input[5]);
		}
	}
}
