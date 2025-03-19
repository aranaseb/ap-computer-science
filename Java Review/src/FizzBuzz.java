public class FizzBuzz {

	public static void main(String[] args)
	{
		int i;
		for(i = 1;i<=100;i++)
		{
			if(i % 15 == 0)
				System.out.print("fizzBuzz ");
			else if(i%10 == 0)
				System.out.print("buzz ");
			else if(i%5 == 0)
				System.out.print("fizz ");
			else
				System.out.printf("%d ",i);
		}
			
	}

}
