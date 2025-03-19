import java.awt.FlowLayout;
import java.awt.Dimension;
import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JLabel;


public class FindWord extends JFrame
{
	public static void main(String[] args) throws InterruptedException 
	{
		FindWord r = new FindWord("This is an experiment");
		r.find("expr");
	}
	
	//---------------------------------------------------------
	
	//screen size variables
	static int width = 500;
	static int height = 250;
	static Dimension screenSize = new Dimension(width, height);
	
	String sentence;
	JLabel l,l2;
	
	public FindWord(String r)
	{
        super();
        
        sentence = r;
        
		setSize(screenSize);
		setResizable(false);
		setVisible(true);
		getContentPane().setBackground(Color.BLACK);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		setLayout(new FlowLayout(FlowLayout.CENTER,200,20));
		
		l = new JLabel("Sentence: [" + r + "]");
		add(l);
		l.setForeground(Color.GREEN);
		
		l2 = new JLabel("");
		add(l2);
		l2.setForeground(Color.GREEN);
	}
	
	public boolean find(String s) throws InterruptedException
	{
		if(sentence.length() < s.length())
		{
			type("The sentence does not contain [" + s + "].");
			return false;
		}
		if((sentence.substring(0,s.length())).equals(s))
		{
			type("The sentence contains [" + s + "].");
			return true;
		}
		sentence = sentence.substring(1);
		find(s);
		return false;
	}
	
	public void type(String s) throws InterruptedException
	{
		if(s.length()>0)
		{
			l2.setText(l2.getText() + s.charAt(0));
			s = s.substring(1);
			Thread.sleep(100);
			type(s);
		}
	}
}