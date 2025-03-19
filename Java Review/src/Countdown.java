import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JLabel;


public class Countdown extends JFrame
{
	
	//screen size variables
	static int width = 200;
	static int height = 200;
	static Dimension screenSize = new Dimension(width, height);
	
	JLabel l;
	
	public Countdown() 
	{
        super();

        setSize(screenSize);
		setResizable(false);
		setVisible(true);
		getContentPane().setBackground(Color.BLACK);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		setLayout(new FlowLayout(FlowLayout.CENTER,50,50));
		
		l = new JLabel();
		add(l);
		l.setForeground(Color.GREEN);
	}
	
	public static void main(String[] args) throws InterruptedException 
	{
		Countdown cd = new Countdown();
		cd.count(5);
	}
	
	public void count(int n) throws InterruptedException
	{
		if(n==0)
		{	
			setVisible(false);
			BreakingBadBomb.generateBad();    //an absolute atrocity
		}
		
		if(n>0)
		{
			l.setText(n + "");
			Toolkit.getDefaultToolkit().beep();
			
			repaint();
			Thread.sleep(1000);    //waits 1 second before updating
			
			count(n-1);
		}
	}
}