import java.awt.Color;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class UMLDiagram
{

	private ArrayList<UMLBox> boxes = new ArrayList<UMLBox>();
	JFrame window = new JFrame("UML Diagram");
	
	public UMLDiagram()
	{	
		int w = 150;
		int h = 100;
		
		int s = 40;
		Point dimensions = new Point(600,600);
		window.setSize(dimensions.x,dimensions.y);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLocationRelativeTo(null);
		
		window.setVisible(true);
		
		JButton save = new JButton("Save");
		window.add(save);
		save.setBounds(dimensions.x/2-50,dimensions.y-20-80,100,40);
		save.setBackground(Color.GREEN);
		save.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				saveToFile();
			}
		});
		
		UMLBox container = new UMLBox(new Point(dimensions.x/2-w/2,s),new Point(w,h));
		window.add(container);
		boxes.add(container);
		SwingUtilities.updateComponentTreeUI(window);
		
		window.add(new Line(dimensions.x/2,s+h,dimensions.x/2,s+h+s));
		SwingUtilities.updateComponentTreeUI(window);
		
		UMLBox superclass = new UMLBox(new Point(dimensions.x/2-w/2,s+h+s),new Point(w,h));
		window.add(superclass);
		boxes.add(superclass);
		SwingUtilities.updateComponentTreeUI(window);
		
		window.add(new Line(dimensions.x/2-w/2-s-w/2,s+h+s+h+s/2,dimensions.x/2+w/2+s+w/2,s+h+s+h+s/2));
		SwingUtilities.updateComponentTreeUI(window);
		
		window.add(new Arrow(dimensions.x/2,s+h+s+h,dimensions.x/2,s+h+s+h+s));
		SwingUtilities.updateComponentTreeUI(window);
		
		window.add(new Line(dimensions.x/2-w/2-s-w/2,s+h+s+h+s/2,dimensions.x/2-w/2-s-w/2,s+h+s+h+s));
		SwingUtilities.updateComponentTreeUI(window);
		
		window.add(new Line(dimensions.x/2+w/2+s+w/2,s+h+s+h+s/2,dimensions.x/2+w/2+s+w/2,s+h+s+h+s));
		SwingUtilities.updateComponentTreeUI(window);
		
		UMLBox subclass1 = new UMLBox(new Point(dimensions.x/2-w/2-s-w,s+h+s+h+s),new Point(w,h));
		window.add(subclass1);
		boxes.add(subclass1);
		SwingUtilities.updateComponentTreeUI(window);
		
		UMLBox subclass2 = new UMLBox(new Point(dimensions.x/2-w/2,s+h+s+h+s),new Point(w,h));
		window.add(subclass2);
		boxes.add(subclass2);
		SwingUtilities.updateComponentTreeUI(window);
		
		UMLBox subclass3 = new UMLBox(new Point(dimensions.x/2-w/2+s+w,s+h+s+h+s),new Point(w,h));
		window.add(subclass3);
		boxes.add(subclass3);
		SwingUtilities.updateComponentTreeUI(window);
		
		Rectangle background = new Rectangle(new Point(0,0),dimensions,new Color(222,247,255));
		window.add(background);
		SwingUtilities.updateComponentTreeUI(window);
		
		loadFile();
	}
	
	public void saveToFile()
	{
		BufferedWriter fw;
		try 
		{
			fw = new BufferedWriter(new FileWriter("src\\UMLtext.txt"));
			for(UMLBox box : boxes)
			{
				String[] text = box.getText();
				for(String line : text)
				{
					fw.write(line + "\n");
				}
			}
			fw.close();
			System.out.println("Saved");
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void loadFile()
	{
		BufferedReader br;
		try
		{
			br = new BufferedReader(new FileReader("src\\UMLtext.txt"));
			for(UMLBox box : boxes)
			{
				box.setText(new String[] {br.readLine(),br.readLine(),br.readLine(),br.readLine(),br.readLine(),br.readLine()});
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

}
