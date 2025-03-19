import javax.swing.JOptionPane;

public class PostalCodeTest 
{	
	public static BarcodeGUI barcodeDisplay = new BarcodeGUI();
	
	public static void main(String[] args)
	{
		String zipCode = "";
		String barCode = "";
		
		String inputCode = JOptionPane.showInputDialog("Enter a barcode or 5 digit zip code");
		
		if(inputCode.length()==5) //zip code input
		{
			BarCode bar = new BarCode(inputCode);
			zipCode = inputCode;
			barCode = bar.getBarcode();
			System.out.println("Input Zip Code:" + zipCode);
			
			if(!barCode.contains("-"))
			{
				System.out.println("Bar Code: " + barCode);	
				bar.displayBarcode();
			}
			else
				System.out.println("Error in zip code");
		}
		
		if(inputCode.length()==30) //barcode input
		{
			ZipCode zip = new ZipCode(inputCode);
			barCode = inputCode;
			zipCode = zip.getZip();
			System.out.println("Input Barcode: " + barCode);
			
			if(!zipCode.contains("#"))
			{
				System.out.println("Zip Code: " + zipCode);
				zip.displayZipcode();
			}
			else
				System.out.println("Error in barcode");
		}
		
		else if(inputCode.length() != 30 && inputCode.length() != 5)
			System.out.println("Input code " + inputCode + " not valid");
	}

}
