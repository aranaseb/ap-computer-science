import java.text.DecimalFormat;

public class Salary
{
	private double salary;
	private String rate;
	
	private DecimalFormat sf = new DecimalFormat("$###,###,###.00");
	
	public Salary(double salary)
	{
		this.salary = salary;

		if(salary>50)
			this.rate = "/year";
		else
			this.rate = "/hour";
			
	}
	
	public String getRate()
	{
		return this.rate;
	}
	
	public String salaryString()
	{
		return sf.format(this.salary) + this.rate;
	}
	
	public void raiseSalary(int percent)
	{
		Double numSalary = this.salary;
		numSalary += numSalary/100*percent;
		this.salary = numSalary;
	}

}
