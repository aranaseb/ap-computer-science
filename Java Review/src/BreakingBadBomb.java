import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BreakingBadBomb extends JFrame
{
	private static ImageIcon[] bb = new ImageIcon[6];
	
	public static void main(String[] args)
	{
		BreakingBadBomb spam = new BreakingBadBomb();
		spam.setVisible(true);
		
		JButton execute = new JButton("Call Saul");
		execute.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		execute.setBounds(20,20,160,160);
		execute.setBackground(Color.RED);
		execute.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e) 
			{
				generateBad();
			}  
		});
		
		spam.add(execute,null);
	}
	
	public BreakingBadBomb()
	{	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);
		setSize(200,200);
		setLocationRelativeTo(null);
		setLayout(null);
		getContentPane().setBackground(Color.GRAY);
	}
	
	public static void generateBad()
	{
		addPics();
		for(int i=0;i<100;i++)
		{
			JFrame sus = new JFrame("amogus");
			addBadComponents(sus);
			sus.setVisible(true);
		}
	}
	
	public static void addBadComponents(JFrame sus)
	{
		((JFrame) sus).setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		((JFrame) sus).setUndecorated(true);
		((JFrame) sus).setExtendedState(JFrame.MAXIMIZED_VERT);
		sus.setBackground(new Color(1.0f,1.0f,1.0f,0.0f));
		
		JLabel label = new JLabel(); 
		label.setIcon(randImage()); 
		sus.setSize(256,256);
		sus.add(label);
		((JFrame) sus).getContentPane().add(label); 
		sus.setLocation((int)(Math.random()*(Toolkit.getDefaultToolkit().getScreenSize().width))-70,(int)(Math.random()*(Toolkit.getDefaultToolkit().getScreenSize().height))-30);
		sus.setVisible(true);
	}
	
	public static ImageIcon randImage()
	{
		Random rand  = new Random();
		return bb[rand.nextInt(6)];
		
	}
	
	public static void addPics()
	{
		ImageIcon icon1 = new ImageIcon("C:\\Users\\Thano\\OneDrive\\Desktop\\School 22-23\\APCSI\\eclipse-workspace\\Test\\bb\\1.jpg"); 
		Image image1 = icon1.getImage();
		Image newimg1 = image1.getScaledInstance(icon1.getIconWidth()+100,icon1.getIconHeight()-40,Image.SCALE_SMOOTH);  
		icon1 = new ImageIcon(newimg1);
		bb[0] = icon1;
		
		ImageIcon icon2 = new ImageIcon("C:\\Users\\Thano\\OneDrive\\Desktop\\School 22-23\\APCSI\\eclipse-workspace\\Test\\bb\\2.png"); 
		Image image2 = icon2.getImage();
		Image newimg2 = image2.getScaledInstance(icon2.getIconWidth()-100,icon2.getIconHeight()-300,Image.SCALE_SMOOTH); 
		icon2 = new ImageIcon(newimg2);
		bb[1] = icon2;
		
		ImageIcon icon3 = new ImageIcon("C:\\Users\\Thano\\OneDrive\\Desktop\\School 22-23\\APCSI\\eclipse-workspace\\Test\\bb\\3.jpg"); 
		Image image3 = icon3.getImage();
		Image newimg3 = image3.getScaledInstance(icon3.getIconWidth()+100,icon3.getIconHeight()-90,Image.SCALE_SMOOTH);  
		icon3 = new ImageIcon(newimg3);
		bb[2] = icon3;
		
		ImageIcon icon4 = new ImageIcon("C:\\Users\\Thano\\OneDrive\\Desktop\\School 22-23\\APCSI\\eclipse-workspace\\Test\\bb\\4.png"); 
		Image image4 = icon4.getImage();
		Image newimg4 = image4.getScaledInstance(icon4.getIconWidth(),icon4.getIconHeight()-400,Image.SCALE_SMOOTH);  
		icon4 = new ImageIcon(newimg4);
		bb[3] = icon4;
		
		ImageIcon icon5 = new ImageIcon("C:\\Users\\Thano\\OneDrive\\Desktop\\School 22-23\\APCSI\\eclipse-workspace\\Test\\bb\\5.jpg"); 
		Image image5 = icon5.getImage();
		Image newimg5 = image5.getScaledInstance(icon5.getIconWidth(),icon5.getIconHeight(),Image.SCALE_SMOOTH);  
		icon5 = new ImageIcon(newimg5);
		bb[4] = icon5;
		
		ImageIcon icon6 = new ImageIcon("C:\\Users\\Thano\\OneDrive\\Desktop\\School 22-23\\APCSI\\eclipse-workspace\\Test\\bb\\6.jpg"); 
		Image image6 = icon6.getImage();
		Image newimg6 = image6.getScaledInstance(icon6.getIconWidth()+100,icon6.getIconHeight()-90,Image.SCALE_SMOOTH);  
		icon6 = new ImageIcon(newimg6);
		bb[5] = icon6;
	}
}
