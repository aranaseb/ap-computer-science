public class Employee 
{
	private String name;
	private String job;
	private Salary salary;
	private int num;
	
	public Employee(int num,String n,String j,Salary s)
	{
		this.num = num;
		this.name = n;
		this.job = j;
		this.salary = s;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public String getJob()
	{
		return this.job;
	}
	
	public String getSalary()
	{
		return this.salary.salaryString();
	}
	
	public Salary getSalaryObject()
	{
		return this.salary;
	}
	public String toString()
	{
		return String.format(" %1$s.  Name: %2$-20sTitle: %3$-18sSalary: %4$-18s",this.num,this.name,this.job,getSalary());
	}
}
