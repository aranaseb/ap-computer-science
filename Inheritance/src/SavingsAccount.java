public class SavingsAccount extends Account
{
	private double interestRate;
	private double minBalance;
	
	public SavingsAccount(String name)
	{
		super(name);
		this.interestRate = 0.04;     //4%
		minBalance = getBalance();
	}
	
	public SavingsAccount(String name, double balance)
	{
		super(name,balance);
		this.interestRate = 0.04;
		minBalance = getBalance();
	}
	
	public void setInterest(double interest)
	{
		this.interestRate = interest;
	}
	
	public void withdraw(double amt)
	{
		if(getBalance() - amt < minBalance)
		{
			System.out.println("Above minimum balance, failed");
		}
		else
		{
			super.withdraw(amt);
		}
	}
	
	public void save(int yrs)
	{
		this.minBalance = getBalance();
		addYears(yrs);
		deposit(getBalance()*Math.pow(1+interestRate, yrs)-getBalance());
	}
	
	public double getMinBalance()
	{
		return this.minBalance;
	}
}
