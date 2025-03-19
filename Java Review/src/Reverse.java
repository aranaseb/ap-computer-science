import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JLabel;


public class Reverse extends JFrame
{
	public static void main(String[] args) throws InterruptedException 
	{
		Reverse r = new Reverse("tacocat racecar 2002");
	}
	
	//---------------------------------------------------------
	
	//screen size variables
	static int width = 500;
	static int height = 250;
	static Dimension screenSize = new Dimension(width, height);
	
	JLabel l,l2;
	
	public Reverse(String r) throws InterruptedException 
	{
        super();

        setSize(screenSize);
		setResizable(false);
		setVisible(true);
		getContentPane().setBackground(Color.BLACK);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		setLayout(new FlowLayout(FlowLayout.CENTER,200,20));
		
		l = new JLabel("-->  " + r);
		add(l);
		l.setForeground(Color.GREEN);
		
		l2 = new JLabel("<--  ");
		add(l2);
		l2.setForeground(Color.GREEN);
		l2.setText("<--  " + reverse(r));
	}
	
	public String reverse(String s) throws InterruptedException
	{
		l2.setText(l2.getText() + s.charAt(s.length()-1));
		Thread.sleep(100);
		if(s.length()==1)
			return s;
		return s.charAt(s.length()-1) + reverse(s.substring(0, s.length()-1));
	}
}