
public class IDCard extends Card 
{
	private int idNumber;
	
	public IDCard(String n, int id) 
	{
		super(n);
		idNumber = id;
	}
	
	public String format() 
	{
		return super.format() + ", ID Number: " + idNumber;
	}
	
	public boolean equals(Card c)
	{
		try {
			IDCard i = (IDCard) c;
			if(super.equals(c)||idNumber==i.idNumber)
				return true;
		}
		catch(ClassCastException e) {
			
		}
		return false;
	}
}
