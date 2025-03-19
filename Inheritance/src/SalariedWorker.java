
public class SalariedWorker extends Worker
{
	public SalariedWorker(String n, double p)
	{
		name = n;
		payRate = p;
		System.out.println("The salaried worker " + n + " works at a $" + payRate + " dollar rate");
	}
	
	@Override
	public double computePay(int hours)
	{
		return payRate*40;
	}
	
}
