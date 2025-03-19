
public class BillfoldTest {

	public static void main(String[] args) 
	{
		Billfold b1 = new Billfold();
		System.out.println("First Billfold");
		
		b1.addCard(new IDCard("Bob",777));
		System.out.println("Add card: IDcard[name=Bob][idNumber=777]");
		
		b1.addCard(new DriverLicense("Bob",2021));
		System.out.println("Add card: DriverLicense[name=Bob][expYear=2021]");
		
		System.out.println("Format:" + b1.formatCards());
		
		int num = 0;
		for(int i = 1;i<=2;i++)
			if(b1.getCard(i).isExpired())
				num++;
		System.out.println("Expired Cards: " + num);
		
		System.out.println("Duplicate Cards: " + b1.getCard(1).equals(b1.getCard(2)));
		
		Billfold b2 = new Billfold();
		System.out.println("\nSecond Billfold");
		
		b2.addCard(new DriverLicense("Sally",2026));
		System.out.println("Add card: DriverLicense[name=Sally][expYear=2026]");
		
		b2.addCard(new CallingCard("Sally",555,1234));
		System.out.println("Add card: CallingCard[name=Sally][cardNumber=555,pin=1234]");
		
		System.out.println("Format:" + b2.formatCards());
		
		num = 0;
		for(int i = 1;i<=2;i++)
			if(b2.getCard(i).isExpired())
				num++;
		System.out.println("Expired Cards: " + num);
		
		System.out.println("Duplicate Cards: " + b2.getCard(1).equals(b2.getCard(2)));
	}

}
