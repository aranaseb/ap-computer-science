public class JavaSandbox 
{
	public static void main(String[] args)
	{
		String word = "tree";
//					   0123456789ABC
		String letter = "e";
		int index = 0;
		while(index != -1) 
		{
			index = word.indexOf(letter,index+1);
			if(index!=-1)
			{
			System.out.println(index);
			}
		}
	}
}
