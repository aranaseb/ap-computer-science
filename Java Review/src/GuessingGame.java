/*In this guessing game, I did implement the storage of guesses in an array and the file reader.
 * To start, the filereader reads my 1000-word  list file using BufferedReader to separate lines.
 * If the word is 4 letters or less, finds a longer word for theWord. This is to improve the quality of the game.
 * 
 * There are two static methods; correctLetters returns a string with the incomplete word (example: |-x--pl-| if x, p, l guessed)
 * addGuess adds each new guess to an array by temporarily converting it to an arrayList and uses the .add method
 * A short for loop before the main game measures the length of the word and gives a hint in the format of correctLetters
 * 
 * In the main loop, there are two conditions that prevent the guess from being added
 * The user input must be one character and it must not already exist in the "guessBank" array.
 * If there are no dashes in "wordProgress" after attempt and all correct letters were guessed, game is won before attempts run out.
 * 
 * The game is lost when all the attempts are used and correctLetters still has dashes
*/ 
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

class GuessingGame
{
	public static void main(String[] args) throws IOException 
	{	
		int numGuesses = 6;
		//determines number of guesses allowed
	 
		BufferedReader br = new BufferedReader(new FileReader("gameWordList.txt"));
		//reads my text file by line
		
		String[] wordArray = new String[0];
		String line = br.readLine();
		while(line != null)
		{
			line = br.readLine();
			wordArray = addWord(wordArray,line);
		}
		br.close();
		//adds words to array using my addWord method
				
		String theWord = "";	
		while(theWord.length() < 5)
		{
			Random rand = new Random();
			int index = rand.nextInt(wordArray.length);
			theWord = (wordArray[index]);
		}
		//randomizes word from array, gets new word until word is 5+ letters
		
		String[] guessBank = new String[0];
		//array to store guesses
		
		int len = theWord.length();
		String wordLength = "";	
		for(int i=0;i<len;i++)
		{
			wordLength += "-";
		}
		//used to create word blanks (as a hint)
		
		String wordProgress = "";
		//will be used to store correctLetters method
		
		String userGuess;
		
		//start of console output
		System.out.println("---| Welcome to the Word Guessing Game!|---\n");
		System.out.println("Guess a letter in the secret word: |" + wordLength + "|\n(6 attempts remaining)");
		
		Scanner sc = new Scanner(System.in);
		for(int t = numGuesses;t>0;t--)
		{
			userGuess = sc.next();

			//checks if guess is mroe than 1 character
			if(userGuess.length()>1)
			{
			System.out.println("Try guessing a letter");
			t++;
			}
			
			else if(userGuess.length() == 1)
			{
				//makes array into list to use "contains" method
				List<String> guessList = new ArrayList<>(Arrays.asList(guessBank));
				
				//checks if letters have been guessed already
				if(guessList.contains(userGuess))
				{
				System.out.println("Letter already guessed\n ");
				t++;
				}

				else
				{
					guessBank = addWord(guessBank,userGuess);
					//uses static method to add new guess to array
				
					if(theWord.contains(userGuess))
					{	
						wordProgress = correctLetters(guessBank,theWord);
						//builds new hint using new guess
						
						//makes sure all correct letters haven't been guessed yet
						if(wordProgress.contains("-"))
						{
							System.out.println("\nLetter is in the word!");
							System.out.println("The word so far: |" + wordProgress + "|");
							t++;
							//because it's correct, doesn't subtract attempt
						}
					}
					else
					{
						if(!wordProgress.contains("-"))
						{
							System.out.println("Letter is not in the word");
							System.out.println("The word so far: |" + wordLength + "|");
							//if first guesses are wrong, prints wordLength instead of wordProgress
						}
						else
						{
							System.out.println("Letter is not in the word");
							System.out.println("The word so far: |" + wordProgress + "|");
							//wordProgress will not be updated if guess is incorrect but old guesses correct
						}
					}
					
					//checks if all correct letters have been guessed which will end game
					if(!wordProgress.contains("-") &&  wordProgress.length() > 3)
					{
						//next if statements print custom messages depending on number of guesses used
						if(t == 6)
						{
						System.out.println("Perfect! The word was |" + theWord + "|.");
						}
						if(t == 5)
						{
							System.out.println("Excellent! The word was |" + theWord + "|.");
						}
						if(t == 4 || t == 3 || t == 2)
						{
							System.out.println("Nice! The word was |" + theWord + "|.");
						}
						if(t == 1)
						{
							System.out.println("Nice save! The word was |" + theWord + "|.");
						}
						System.out.println("\nGame complete");
						break;
					}
					System.out.println("___________________________________________\n \n(" + (t-1) + "/" + numGuesses + " attempts remaining)");
					//prints formatting + remaining attempts
				}
			}
		}
		//if word not completed, informs user what it was
		if(wordProgress.contains("-") || wordProgress == "")
		{
			System.out.println("\nSorry! The word was |" + theWord + "|.");
			System.out.println("\nGame Over");
		}
		sc.close();
	}	
	
	
	//method that returns progress of correct letters ( |--x---x-| format)
	public static String correctLetters(String guessBank[],String theWord)
	{
		//will compare values and build new string to return
		String result = "";
		int len = theWord.length();
		
		//compares each letter in theWord to each string in the guessBank array
		for(int i=0;i<len;i++)
		{
			List<String> guessList = new ArrayList<>(Arrays.asList(guessBank));
			if(guessList.contains(Character.toString(theWord.charAt(i))))
			{
			for(String guess : guessBank)
				if(guess.charAt(0) == theWord.charAt(i))
				{
					result += guess;
				}
			}
			else
			{
				result += "-";
			}
		}
		return result;
	}
	
	
	//adds guess to array by temporarily converting to arrayList
	public static String[] addWord(String guessBank[],String userGuess)
	{
       List<String> guessList = new ArrayList<String>(Arrays.asList(guessBank));
       
       guessList.add(userGuess);
       
       guessBank = guessList.toArray(guessBank);
       
       return guessBank;
	}
}