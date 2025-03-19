import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;

public class EmployeeTest 
{
	
	private static Employee[] employeeList = new Employee[3];

	public static void main(String[] args) 
	{
		String input1,input2,input3;
		
		for(int i=0;i<employeeList.length;i++)
		{
			input1 = JOptionPane.showInputDialog("Employee " + (i+1) + "\nEnter employee's full name");
			input2 = JOptionPane.showInputDialog(input1 + "\nEnter employee's title");
			input3 = JOptionPane.showInputDialog(input1 + "\nEnter employee's salary");
			employeeList[i] = new Employee(i+1,input1,input2,new Salary(Double.parseDouble(input3)));
		}
		
		displayList();
	}
	
	private static void displayList()
	{
		JFrame ld = new JFrame("List");
		ld.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ld.setSize(new Dimension(500,200));
		ld.setLocationRelativeTo(null);
		
		@SuppressWarnings({ "rawtypes", "unchecked" })
		JList list = new JList(employeeList);
		list.setLayoutOrientation(JList.VERTICAL);
		list.setVisibleRowCount(-1);
		list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		
		JButton raise = new JButton("Give Raise");
		ld.add(raise,BorderLayout.PAGE_END);
		raise.addActionListener(new ActionListener()
		{
		  public void actionPerformed(ActionEvent e)
		  {
			  int index = list.getSelectedIndex();
			  String name = employeeList[index].getName();
			  String rInput;
			  rInput = JOptionPane.showInputDialog("By what percent would you like to raise the salary of " + name + "?");
			  employeeList[index].getSalaryObject().raiseSalary(Integer.parseInt(rInput));
			  ld.setVisible(false);
			  displayList();
		  }
		});
		
		ld.add(list,BorderLayout.CENTER);	
		ld.setVisible(true);
		
	}

}
