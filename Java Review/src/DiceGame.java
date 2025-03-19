import javax.swing.JOptionPane;

public class DiceGame 
{

	public static void main(String[] args)
	{
		String input = " ";
		int dieRoll = 0;
		int numRolls = 0;
		int numSides = 0;
		
		input = JOptionPane.showInputDialog("How many dice would you like to roll?");
		numRolls = Integer.parseInt(input);
		
		input = JOptionPane.showInputDialog("How many sides on the dice?");
		numSides = Integer.parseInt(input);
		
		int[] rollCount = new int[numSides];
		
		for(int i=0;i<numRolls;i++)
		{
			dieRoll = (int)(Math.random()*numSides)+1;
			rollCount[dieRoll-1]++;
		}	
		JOptionPane.showMessageDialog(null,"       Rolling complete.\n     Press OK to proceed.");
		int numInput = 0;
		
		while(input != null)
		{
			try
			{
				input = JOptionPane.showInputDialog(String.format("Enter a number to see stats for.%nThe chance for each number is %.2f%%.%nPress cancel to exit.",(1.0/(double)numSides)*100));
				numInput = rollCount[Integer.parseInt(input)-1];
				JOptionPane.showMessageDialog(null, String.format("The number %s was rolled %d times. %nThis is %.25f%% of the total rolls.", input, numInput, (double)numInput/(double)numRolls*100));
			}
			catch(Exception e)
			{
				if(input != null)
					JOptionPane.showMessageDialog(null,"Please enter a number on the die");
			}
		}
	}
}
