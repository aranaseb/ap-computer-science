public class Obj 
{
	/*
	 * This is a very basic Object with
	 * three basic instance fields.
	 * The toString method allows the
	 * JList in the main method to
	 * automatically list the objects
	 * neatly.
	 */
	public Obj(String one, String two, String three) 
	{
		this.one = one;
		this.two = two;
		this.three = three;
	}
	
	private String one;
	private String two;
	private String three;
	
	public String getOne() {
		return this.one;
	}
	
	public String getTwo() {
		return this.two;
	}
	
	public String getThree() {
		return this.three;
	}
	
	public String toString() {
		return String.format("   %1$4s%2$31s%3$34s",one,two,three);
	}

}
