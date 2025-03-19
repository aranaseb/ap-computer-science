import java.util.Calendar;

public class DriverLicense extends Card
{
	private int expYear;
	
	public DriverLicense(String n, int yr) 
	{
		super(n);
		expYear = yr;
	}

	public boolean isExpired()
	{
		if(Calendar.getInstance().get(Calendar.YEAR)>expYear)
			return true;
		return false;
	}
	
	public String format()
	{
		return super.format() + ", Exp Year: " + expYear;
	}
	
	public boolean equals(Card c)
	{
		try {
			DriverLicense d = (DriverLicense) c;
			if(super.equals(c)&&expYear==d.expYear)
				return true;
		}
		catch(ClassCastException e) {
			
		}
		
		return false;
	}
}
