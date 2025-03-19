import java.awt.Dimension;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BarcodeGUI 
{
	private JFrame bd = new JFrame("Barcode");
	
	public BarcodeGUI()
	{
		bd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		bd.setSize(new Dimension(300,200));
		bd.setLocationRelativeTo(null);
		bd.setLayout(null);
		bd.getContentPane().setBackground(Color.LIGHT_GRAY);
	}
	
	private int x = 95;
	
	public void addWideBar()
	{
		int w = 3; //width of wide bar on display
		bd.setVisible(true);
		JPanel b1 = new JPanel();
		bd.add(b1,null);
		b1.setBounds(x,40,w,60);
		b1.setBackground(Color.BLACK);	
		this.x += 4;
	}
	
	public void addThinBar()
	{
		int w = 1; //width of thin bar in display
		JPanel b0 = new JPanel();
		bd.add(b0,null);
		b0.setBounds(x,40,w,60);
		b0.setBackground(Color.BLACK);	
		this.x += 2;
	}
	
	public void addText(String zip)
	{
		JLabel l = new JLabel("ZIP  " + zip);
		bd.add(l,null);
		Dimension size = l.getPreferredSize();
		l.setBounds(110,100,size.width,size.height);
	}
	
	public void addDigit(String code)
	{
		for(int i=0;i<5;i++)
		{
			if(code.charAt(i) == ':')
				addThinBar();
			if(code.charAt(i) == '|')
				addWideBar();
		}
		this.x += 1;
	}
}
