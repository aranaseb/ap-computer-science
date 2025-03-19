
public class PrimeNumber {

	public static void main(String[] args) 
	{
		int tester = 1973;
		
		System.out.println(isPrime(tester, 2));
	}
	
	public static boolean isPrime(int n, int k)
	{
		if(n%k == 0)
		{
			return false;
		}
		
		if(n-1 == k)
		{
			return true;
		}
		
		return isPrime(n,k+1);
		
	}

}
