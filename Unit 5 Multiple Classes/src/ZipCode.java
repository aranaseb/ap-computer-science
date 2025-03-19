
public class ZipCode 
{
	private String code;
	
	public ZipCode(String s)
	{
		this.code = s;
	}
	
	private String zip = "";
	
	public String getZip() //returns zip string
	{
		String digit = "",zip = "";
		String bar = this.code.substring(0,25); //removes correction digit
		for(int i=0;i<25;i+=5)
		{
			digit = bar.substring(i,i+5);
			zip += Digit.getBarcodeDigit(digit,i/5);
		}
		this.zip = zip;
		return zip;
	}
	
	public int getCorrection()
	{
		int digit,sum = 0,correction = 0;
		for(int i=0;i<5;i++)
		{
			digit = Integer.parseInt(this.zip.substring(i,i+1));
			sum += digit;
		}
		
		correction = 10-(sum%10); //calculates correction digit
		if(correction==10)
			correction = 0;
		
		return correction;
	}
	
	public void displayZipcode()
	{
		for(int i=0;i<5;i++)
			Digit.displayDigit(Character.getNumericValue(this.zip.charAt(i)));
		Digit.displayDigit(getCorrection());
		PostalCodeTest.barcodeDisplay.addText(this.zip);
	}
	
}
