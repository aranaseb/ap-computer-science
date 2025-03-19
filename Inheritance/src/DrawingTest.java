import java.awt.Color;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class DrawingTest 
{
	public static void main(String[] args) throws InterruptedException 
	{
		int w = 600;
		int h = 600;
		
		Point c = new Point(w/2,h/2);
		
		int pt = 4;
		
		JFrame window = new JFrame();
		window.setSize(w,h);
		window.setTitle("Drawing Board");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setUndecorated(true);
		window.setBackground(Color.WHITE);
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		
		JButton exit = new JButton();
		exit.setBackground(Color.RED);
		int s = 20;
		exit.setBounds(w-s,0,s,s);
		window.add(exit);
		exit.addActionListener(new ActionListener()
		{
			public void actionPerformed(java.awt.event.ActionEvent e)
			{
				System.exit(0);
			}
		});
		
		Line xAxis = new Line(0,h/2,w,h/2);
		window.add(xAxis);
		SwingUtilities.updateComponentTreeUI(window);
		Line yAxis = new Line(w/2,0,w/2,h);
		window.add(yAxis);
		SwingUtilities.updateComponentTreeUI(window);		
		
		int x,y;
/*		for(x=-300;x<300;x++)
			{
				y = round(100*Math.sin(Math.toRadians(x)));
				DrawingBoard db = new DrawingBoard(x,y,pt,pt);
				window.add(db);
				SwingUtilities.updateComponentTreeUI(window);
			}
*/	
		for(int t=0;t<628;t++)
		{
			x = round(250*Math.cos(3*t));
			y = round(250*Math.sin(3*t));
			
			Line line = new Line(c.x, c.y, x+c.x, y+c.x);
			window.add(line);
			SwingUtilities.updateComponentTreeUI(window);
			Thread.sleep(5);
		}
		window.addMouseMotionListener(new MouseMotionListener()
		{
			public void mouseDragged(java.awt.event.MouseEvent e)
			{
				Point p = MouseInfo.getPointerInfo().getLocation();
				Point p2 = window.getLocationOnScreen();
				
				DrawingBoard db = new DrawingBoard(p.x-p2.x-3-w/2, p.y-43-h/2, pt, pt);
				window.add(db);
				SwingUtilities.updateComponentTreeUI(window);
			}

/*			public void mouseDragged(java.awt.event.MouseEvent e)
			{
				Point p = MouseInfo.getPointerInfo().getLocation();
				Point p2 = window.getLocationOnScreen();
			
				Line line = new Line(c.x, c.y, p.x-p2.x, p.y-p2.y);
				window.add(line);
				SwingUtilities.updateComponentTreeUI(window);
			}
*/		
			public void mouseMoved(java.awt.event.MouseEvent e)
			{
				
			}
		});
		
		window.addMouseListener(new MouseListener()
		{
			public void mouseClicked(MouseEvent e)
			{
				int y;
//				for(int x=-350;x<350;x++)
//				{
//					y = round(300*(Math.pow(Math.sin(x),3)));
//					DrawingBoard db = new DrawingBoard(x,y,pt,pt);
//					window.add(db);
//					SwingUtilities.updateComponentTreeUI(window);
//				}
				
				int r;
//				for(int t = 0;t<360*2;t++)
//				{
//					r = round(100*(1/Math.sin(Math.toRadians(8*t))));
//					PolarPoint point = new PolarPoint(r,t);    //PolarPoint(radius, angle)
//					window.add(point);
//					SwingUtilities.updateComponentTreeUI(window);
//				}
				
//				for(int t = 0;t<360*2;t++)
//				{
//					r = round(200*Math.cos(Math.toRadians(8*t)));
//					PolarPoint point = new PolarPoint(r,t);    //PolarPoint(radius, angle)
//					window.add(point);
//					SwingUtilities.updateComponentTreeUI(window);
//				}
			}

			public void mousePressed(MouseEvent e)
			{
				
			}

			public void mouseReleased(MouseEvent e) 
			{
				
			}

			public void mouseEntered(MouseEvent e)
			{
				
			}

			public void mouseExited(MouseEvent e) 
			{
				
			}
		});
	
	}
	
	public static int round(double d)
	{
		return (int) (d+0.5);
	}

}
