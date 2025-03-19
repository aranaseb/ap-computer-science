import java.text.DecimalFormat;

public class Bank 
{
	public static void main(String[] args)
	{
		SavingsAccount walter = new SavingsAccount("Walter White");
		DecimalFormat df = new DecimalFormat("'$'###,###,###,##0.00");
		
		int drugMoney = 88000000;
		walter.deposit(drugMoney);    //not suspicious at all
		System.out.println(walter.toString());
		
		System.out.println("-------------------------------------");
		
		int yearsSaved = 10;
		System.out.println("Walter White saved for "+ yearsSaved + " years");
		walter.save(yearsSaved);
		System.out.println(walter.toString());
		
		System.out.println("-------------------------------------");
		
		int withdraw = 88000000;
		System.out.println("Walter White withdrew " + df.format(withdraw));
		walter.withdraw(withdraw);
		
		System.out.println("-------------------------------------");
		
		withdraw = 10000000;
		System.out.println("Walter White withdrew " + df.format(withdraw));
		walter.withdraw(withdraw);
		System.out.println(walter.toString());
	}
}
