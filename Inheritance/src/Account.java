import java.text.DecimalFormat;

public class Account 
{
	private String name;
	private double balance;
	private int years = 0;
	
	public Account(String name)
	{
		this.name = name;
	}
	
	public Account(String name, double balance)
	{
		this.name = name;
		this.balance = balance;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public double getBalance()
	{
		return this.balance;
	}
	
	public String toString()
	{
		DecimalFormat df = new DecimalFormat("'$'###,###,###,##0.00");
		return this.name + " has " + df.format(this.balance);
	}
	
	public void deposit(double amt)
	{
		this.balance += amt;
	}
	
	
	public void withdraw(double amt)
	{
		this.balance -= amt;
	}
	
	public void addYears(int yrs)
	{
		years += yrs;
	}
}
