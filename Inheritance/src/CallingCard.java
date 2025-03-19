
public class CallingCard extends Card
{
	private int cardNumber;
	private int pin;
	
	public CallingCard(String n,int c,int p)
	{
		super(n);
		cardNumber = c;
		pin = p;
	}
	
	public String format()
	{
		return super.format() + ", CardNumber: " + cardNumber + ", PIN: " + pin;
	}
	
	public boolean equals(Card c)
	{
		try {
			CallingCard cc = (CallingCard) c;
			if(super.equals(c)||cardNumber==cc.cardNumber||pin==cc.pin)
				return true;
		}
		catch(ClassCastException e) {
			
		}
		
		return false;
	}
}
