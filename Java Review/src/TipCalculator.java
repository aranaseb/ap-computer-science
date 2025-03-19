import javax.swing.JOptionPane;

public class TipCalculator {

	public static void main(String[] args) 
	{
		String input = "";
		double totalBillAmount = 0.0;
		int tipAmount = 0;
		double totalAmount = 0.0;
		double tipPercentage = 0.0;
		
		JOptionPane.showMessageDialog(null, "Welcome to the Tip Calculator!!!");
		
		input = JOptionPane.showInputDialog("Enter the total bill amount");
		totalBillAmount = Double.parseDouble(input);
		
		input = JOptionPane.showInputDialog("Enter the tip amount\nMust be a whole number");
		tipAmount = Integer.parseInt(input);
		
		totalAmount = totalBillAmount + tipAmount;
		tipPercentage = tipAmount/totalAmount*100;
		
		JOptionPane.showMessageDialog(null, String.format("Your total is $%1$.2f%nTip percentage: %2$.1f percent%nTip amount: %3$d dollars and 0 cents",totalAmount,tipPercentage,tipAmount));
	}

}
