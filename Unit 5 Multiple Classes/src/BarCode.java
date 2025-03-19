
public class BarCode 
{
	
	private String code;
	
	public BarCode(String s)
	{
		 this.code = s;
	}
	
	public String getBarcode() //returns barcode string
	{
		int correction = getCorrection(this.code);
		String bar = "";
		int digit;
		for(int i=0;i<5;i++)
		{
			digit = Integer.parseInt(this.code.substring(i,i+1));
			bar += Digit.getZipDigit(digit,i);
		}
		
		return bar + Digit.getZipDigit(correction,6);
	}
	
	public int getCorrection(String zip) throws NumberFormatException
	{
		zip = this.code;
		int digit,sum = 0,correction = 0;
		try {
			for(int i=0;i<5;i++)
			{
				digit = Integer.parseInt(this.code.substring(i,i+1));
				sum += digit;
			}
		}
		catch(Exception e) {
			System.out.println("Input code '" + this.code + "' not valid");
		}
		
		correction = 10-(sum%10); //calculates correction digit
		if(correction==10)
			correction = 0;
		
		return correction;
	}
	
	public void displayBarcode()
	{
		for(int i=0;i<5;i++)
			Digit.displayDigit(Character.getNumericValue(this.code.charAt(i)));
		Digit.displayDigit(getCorrection(this.code));
		PostalCodeTest.barcodeDisplay.addText(this.code);
	}
	
}
