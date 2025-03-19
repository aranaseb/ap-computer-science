
public class Billfold 
{
	private Card card1;
	private Card card2;
	
	public Billfold() 
	{
		card1 = null;
		card2 = null;
	}
	public void addCard(Card card) 
	{
		if(card1==null)
			card1 = card;
		else if(card2==null)
			card2 = card;
	}
	
	public String formatCards()
	{
		if(card1!=null||card2==null)
			return card1.format();
		else if(card2!=null)
			return card1.format() + card2.format();
		return null;
	}
	
	public Card getCard(int num)
	{
		if(num==1)
			return card1;
		if(num==2)
			return card2;
		return null;
	}
}
