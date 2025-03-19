import java.util.StringTokenizer;

import javax.swing.JOptionPane;

public class EmployeeList
{
	public static void main(String[] args) 
	{
		System.out.printf("%sEmployee    First Name    Last Name     Title      Salary\n--------    ----------    ---------     -----      ------", "");
		String input = " ";
		int i = 1;
		
		while(input != "")
		{
			input = JOptionPane.showInputDialog("Employee Information\n(Last/First/Title/Salary)");
			if(input != null)
			{
				StringTokenizer employee = new StringTokenizer(input, "/");
				//tokenizes by "/" so spaces and commas are allowed
				while (employee.hasMoreTokens())
				{
					System.out.printf("\n   %1$-9d%3$-14s%2$-14s%4$-11s$%5$s/yr",i,employee.nextToken(),employee.nextToken(),employee.nextToken(),employee.nextToken());
				}
				i ++;
			}
			else
			{
			input = "";
			}
		}
		JOptionPane.showMessageDialog(null,"Employee Information Complete!");
	}

}