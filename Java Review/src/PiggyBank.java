import javax.swing.JOptionPane;

//Sebastian Arana - program that tracks the number of coins in a piggy bank and the total in the bank
public class PiggyBank 
{

	public static void main(String[] args) 
	{
		final double PENNY_VALUE = .01;
		final double NICKEL_VALUE = .05;
		final double DIME_VALUE = .10;
		final double QUARTER_VALUE = .25;
		
		String input = "";
		int pennyCount = 0;
		int nickelCount = 0;
		int dimeCount = 0;
		int quarterCount = 0;
		double total = 0;
		
		JOptionPane.showMessageDialog(null, "Welcome to the Piggy Bank Calculator!");
		
		input = JOptionPane.showInputDialog("How many pennies are in the bank?");
		pennyCount = Integer.parseInt(input);
		
		input = JOptionPane.showInputDialog("How many nickels are in the bank?");
		nickelCount = Integer.parseInt(input);
		
		input = JOptionPane.showInputDialog("How many dimes are in the bank?");
		dimeCount = Integer.parseInt(input);
		
		input = JOptionPane.showInputDialog("How many quarters are in the bank?");
		quarterCount = Integer.parseInt(input);
		
		total = pennyCount*PENNY_VALUE + nickelCount*NICKEL_VALUE + dimeCount*DIME_VALUE + quarterCount*QUARTER_VALUE;
		
		
				
		JOptionPane.showMessageDialog(null, "The total value of the coins in the bank is $" + total);
	}

}
