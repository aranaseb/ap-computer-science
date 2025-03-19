
public class HourlyWorker extends Worker
{
	public HourlyWorker(String n,double p)
	{
		name = n;
		payRate = p;
		System.out.println("The hourly worker " + n + " works at a $" + payRate + " dollar rate");
	}

	@Override
	public double computePay(int hours) 
	{
		if(hours<=40)
			return hours*payRate;
		else
			return hours*payRate + 1.5*(hours-40)*payRate;
	}
}
