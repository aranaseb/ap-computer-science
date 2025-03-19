import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SpringLayout;
import javax.swing.border.Border;

public class ObjList 
{	
	@SuppressWarnings("rawtypes")
	public static void main(String[] args)
	{
		readFile();
		
		JFrame window = new JFrame("Stocks");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(new Dimension(400,400));
		window.setLocationRelativeTo(null);
		
		JList list = newJList();
		window.add(list,BorderLayout.CENTER);
		list.setBorder(border);

		JLabel header = new JLabel(String.format(" %1$-15s%2$-13s%3$s",one,two,three));
		header.setFont(new Font("Courier", Font.BOLD, 15));
		header.setOpaque(true);
		header.setBackground(Color.DARK_GRAY);
		header.setForeground(Color.WHITE);
		window.add(header,BorderLayout.PAGE_START);
		
		JPanel buttons = new JPanel();
		buttons.setPreferredSize(new Dimension(400,40));
		buttons.setBackground(Color.DARK_GRAY);
		buttons.setBorder(border);
		window.add(buttons,BorderLayout.PAGE_END);
		
		Font font = new Font("Courier",Font.BOLD, 12);
		
		JButton add = new JButton("Add");
		buttons.add(add,null);
		add.setBackground(Color.GREEN);
		add.setFont(font);
		add.addActionListener(new ActionListener()
		{
			@SuppressWarnings("unchecked")
			public void actionPerformed(ActionEvent e)
			{
				objList.add(newObj());
				list.setListData(objList.toArray());
				saveToFile();
			}
		});
		
		JButton edit = new JButton("Edit");
		buttons.add(edit,BorderLayout.CENTER);
		edit.setBackground(Color.ORANGE);
		edit.setFont(font);
		edit.addActionListener(new ActionListener()
		{
		  @SuppressWarnings("unchecked")
		public void actionPerformed(ActionEvent e)
		  {
			  int index = list.getSelectedIndex();
			  if(index!=-1)
			  {
				  objList.set(index,newObj(objList.get(index)));
				  list.setListData(objList.toArray());
				  saveToFile();
			  }
			  else 
				  JOptionPane.showMessageDialog(window, "Please select an object");
		  }
		});
		
		JButton delete = new JButton("Delete");
		buttons.add(delete,BorderLayout.LINE_END);
		delete.setBackground(Color.RED);
		delete.setFont(font);
		delete.addActionListener(new ActionListener()
		{
		  @SuppressWarnings("unchecked")
		public void actionPerformed(ActionEvent e)
		  {
			  int index = list.getSelectedIndex();
			  if(index!=-1)
			  {
				  objList.remove(index);
				  list.setListData(objList.toArray());
				  saveToFile();
			  }
			  else 
				  JOptionPane.showMessageDialog(window, "Please select an object");
		  }
		});
		
		window.setVisible(true);
	}
	private static Border border = BorderFactory.createLineBorder(Color.DARK_GRAY);
	
	public static ArrayList<Obj> objList = new ArrayList<Obj>();
	
	private static String one = "Symbol";
	private static String two = "Shares";
	private static String three = "Unit Price";
	
	/*
	 * 
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static JList newJList()
	{
		JList list = new JList(objList.toArray());
		list.setLayoutOrientation(JList.VERTICAL);
		list.setVisibleRowCount(-1);
		list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		list.setFont(new Font("Helvetica", Font.PLAIN, 15));
		list.setBackground(Color.BLACK);
		list.setForeground(Color.WHITE);
		return list;
	}
	
	/*
	 * creates a new Obj from inputs from a popup window
	 * that will replace the old object in the arraylist
	 * @param oldObj
	 * this parameter is used to preserve the attributes
	 * of the object being replaced
	 */
	public static Obj newObj(Obj oldObj)
	{
		JPanel dialog = new JPanel();
		dialog.setSize(new Dimension(300,300));
		
		SpringLayout layout = new SpringLayout();
		
		ArrayList<JLabel> labels = new ArrayList<JLabel>();
		labels.add(new JLabel(one + ":"));
		labels.add(new JLabel(two +":"));
		labels.add(new JLabel(three + ":"));
		
		ArrayList<JTextField> textFields = new ArrayList<JTextField>();
		
		int count = 0;
		for(JLabel label : labels)
		{
			count++;
			dialog.add(label);
			JTextField textField = new JTextField();
			switch(count)
			{
				case 1:
					textField = new JTextField(oldObj.getOne(), 15);break;
				case 2:
					textField = new JTextField(oldObj.getTwo(), 15);break;
				case 3:
					textField = new JTextField(oldObj.getThree(), 15);break;
			}
			
			textFields.add(textField);
		    dialog.add(textField);
		    layout.putConstraint(SpringLayout.WEST,label,5,SpringLayout.WEST, dialog);
		    layout.putConstraint(SpringLayout.NORTH,label,5,SpringLayout.NORTH, dialog);
		}
	    
	    JOptionPane.showMessageDialog(null, dialog, "Edit Stock", JOptionPane.INFORMATION_MESSAGE);
	    
		return new Obj(textFields.get(0).getText(),textFields.get(1).getText(),textFields.get(2).getText());
	}
	
	/*
	 * creates a fully new object from inputs from a popup window
	 * that will be added to the arraylist
	 * same as other method, but there is
	 * no parameter as nothing is being replaced
	 */
	public static Obj newObj()
	{
		JPanel dialog = new JPanel();
		dialog.setSize(new Dimension(300,300));
		
		SpringLayout layout = new SpringLayout();
		
		ArrayList<JLabel> labels = new ArrayList<JLabel>();
		labels.add(new JLabel(one + ":"));
		labels.add(new JLabel(two +":"));
		labels.add(new JLabel(three + ":"));
		
		ArrayList<JTextField> textFields = new ArrayList<JTextField>();
		
		for(JLabel label : labels)
		{
			dialog.add(label);
			JTextField textField = new JTextField("", 15);
			
			textFields.add(textField);
		    dialog.add(textField);
		    layout.putConstraint(SpringLayout.WEST,label,5,SpringLayout.WEST, dialog);
		    layout.putConstraint(SpringLayout.NORTH,label,5,SpringLayout.NORTH, dialog);
		}
	    
	    JOptionPane.showMessageDialog(null, dialog, "Add Stock", JOptionPane.INFORMATION_MESSAGE);
	    
		return new Obj(textFields.get(0).getText(),textFields.get(1).getText(),textFields.get(2).getText());
	}
	
	public static void readFile()
	{
		BufferedReader br;
		String one, two, three;
		try {
			br = new BufferedReader(new FileReader("objList.txt"));
			one = br.readLine();
			while(one != null)
			{
				two = br.readLine();
				three = br.readLine();
				objList.add(new Obj(one,two,three));
				one = br.readLine();
			}
				
				
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void saveToFile()
	{
		BufferedWriter fw;
		try 
		{
			fw = new BufferedWriter(new FileWriter("objList.txt"));
			for(Obj o : objList)
			{
				fw.write(o.getOne() + "\n" + o.getTwo() + "\n" + o.getThree() + "\n");
			}
			fw.close();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}

}
