import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

public class EightBall
{
	private static JFrame window = new JFrame();
	private static JButton shake = new JButton("8"); 
	private static JButton result = new JButton();
	private static JPanel ball = new JPanel();
	private static JPanel dialog = new JPanel();
	private static JTextField question = new JTextField("",19);
	private static ArrayList<String> responses;
	
	
	public EightBall(JFrame w, ArrayList<String> r)
	{
		window = w;
		responses = r;
		
		ball.setBackground(Color.BLACK);
		ball.setBounds(0,0,500,500);
		window.add(ball,null);
		ball.setLayout(new GridBagLayout());
		
		shake.setFont(new Font("Times New Roman", Font.PLAIN, 160));
		ball.add(shake,new GridBagConstraints());
		shake.setPreferredSize(new Dimension(240,240));
		shake.setBackground(Color.WHITE);
		
		shake.addActionListener(actions);
		
		window.add(dialog,null);
		dialog.setBounds(0,500,500,50);
		JLabel label = new JLabel("");
		
		dialog.add(question);
		question.setFont(new Font("Arial", Font.PLAIN, 30));
		
		SpringLayout layout = new SpringLayout();
		layout.putConstraint(SpringLayout.WEST,label,2,SpringLayout.WEST, question);
		layout.putConstraint(SpringLayout.NORTH,label,2,SpringLayout.NORTH, question);
		
		window.setVisible(true);
	}
	
	private static ActionListener actions = new ActionListener()
	{
		public void actionPerformed(ActionEvent e)
		{
				ball.remove(shake);
				
				String response = responses.get(ThreadLocalRandom.current().nextInt(0,responses.size()));
				
				result.setText(response);
				result.setFont(new Font("Arial", Font.PLAIN, 20));
				result.setMargin(new Insets(0,0,0,0));
				Box rbox = Box.createVerticalBox();
				rbox.add(result);
				
				ball.add(result,new GridBagConstraints());
				result.setPreferredSize(new Dimension(240,240));
				result.setBackground(Color.BLUE);
				result.setForeground(Color.WHITE);
				
				result.addActionListener(actions);
				ball.revalidate();
				question.setText("");
				window.repaint();
		}
	};
	
}
