
public enum Digit
{
	ONE(":::||"), 
	TWO("::|:|"), 
	THREE("::||:"),
	FOUR(":|::|"),
	FIVE(":|:|:"),
	SIX(":||::"),
	SEVEN("|:::|"),
	EIGHT("|::|:"),
	NINE("|:|::"),
	ZERO("||:::"),
	ERROR("-----");
		
	private final String code;
	
	private Digit(String code)
	{
		this.code = code;
	}
	public static String getZipDigit(int digit,int num)
	{
		switch(digit)
		{
			case 1: return ONE.code;
			case 2: return TWO.code;
			case 3: return THREE.code;
			case 4: return FOUR.code;
			case 5: return FIVE.code;
			case 6: return SIX.code;
			case 7: return SEVEN.code;
			case 8: return EIGHT.code;
			case 9: return NINE.code;
			case 0: return ZERO.code;
			default: return ERROR.code;
		}
	}
	
	public static String getBarcodeDigit(String digit,int num)
	{
		switch(enumOfDigit(digit))
		{
			case ONE: return "1";
			case TWO: return "2";
			case THREE: return "3";
			case FOUR: return "4";
			case FIVE: return "5";
			case SIX: return "6";
			case SEVEN: return "7";
			case EIGHT: return "8";
			case NINE: return "9";
			case ZERO: return "0";
			default: return "#";			
		}
	}
	
	public static Digit enumOfDigit(String eValue) 
	{
	    for (Digit e : Digit.values())
	    {
	        if (e.code.equals(eValue))
	        	return e;
	    }
	    return ERROR;
	}
	
	public static void displayDigit(int d)
	{
			switch(d)
			{
				case 1: 
					PostalCodeTest.barcodeDisplay.addDigit(ONE.code);
					break;
				case 2: 
					PostalCodeTest.barcodeDisplay.addDigit(TWO.code);
					break;
				case 3: 
					PostalCodeTest.barcodeDisplay.addDigit(THREE.code);
					break;
				case 4: 
					PostalCodeTest.barcodeDisplay.addDigit(FOUR.code);
					break;
				case 5: 
					PostalCodeTest.barcodeDisplay.addDigit(FIVE.code);
					break;
				case 6:
					PostalCodeTest.barcodeDisplay.addDigit(SIX.code);
					break;
				case 7: 
					PostalCodeTest.barcodeDisplay.addDigit(SEVEN.code);
					break;
				case 8: 
					PostalCodeTest.barcodeDisplay.addDigit(EIGHT.code);
					break;
				case 9: 
					PostalCodeTest.barcodeDisplay.addDigit(NINE.code);
					break;
				case 0: 
					PostalCodeTest.barcodeDisplay.addDigit(ZERO.code);
					break;
				default: 
					break;
			}
	}
}
