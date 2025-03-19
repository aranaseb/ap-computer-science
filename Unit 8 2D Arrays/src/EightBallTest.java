import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;

public class EightBallTest {

	public static void main(String[] args) throws IOException 
	{
		JFrame window = new JFrame("Magic 8 Square because graphics are a pain");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setUndecorated(true);
		window.setSize(500,550);
		window.setLocationRelativeTo(null);
		window.setLayout(null);
		
		EightBall ball = new EightBall(window,generateResults());
	}
	
	public static ArrayList<String> generateResults() throws IOException
	{
		ArrayList<String> responses = new ArrayList<String>();
		String response;
		
		BufferedReader br = new BufferedReader(new FileReader("src\\BallResponses.txt"));
		response = br.readLine();
		while(response != null)
		{
			responses.add(response);
			response = br.readLine();
		}
		br.close();
		return responses;
	}

}
