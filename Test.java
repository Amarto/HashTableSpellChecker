import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Test 
{
	public static void main(String[] args) throws FileNotFoundException
	{		
		HashTable<MyString> entries = new HashTable<MyString>();

		//input words from big dictionary (specified in 1st cmd line arg)
		Scanner in = new Scanner(new File(args[0]));
		while (in.hasNextLine())
		{
			String s = in.nextLine();
			
//			//remove commas and periods at end of word
//			if (s.charAt(s.length()-1) == ',' || s.charAt(s.length()-1) == '.')
//				s = s.substring(0, s.length()-1);
//				
			entries.insert(new MyString(s.toLowerCase()));
		}	
		in.close();

		//input words from personal dictionary
		Scanner in2 = new Scanner(new File(args[1]));
		while (in2.hasNextLine())
		{
			String s = in2.nextLine();
//			
//			if (s.charAt(s.length()-1) == ',' || s.charAt(s.length()-1) == '.')
//				s = s.substring(0, s.length()-1);
					
			entries.insert(new MyString(s.toLowerCase()));
		}
		in2.close();
		
		//read input file, to spellcheck
		Scanner in3 = new Scanner(new File(args[2]));
		
		int lineCounter = 0;
		while (in3.hasNextLine())
		{
			StringTokenizer str = new StringTokenizer(in3.nextLine());
			while(str.hasMoreTokens())
			{
				String s = str.nextToken();
//				System.out.println(s);
//				System.out.println(entries.contains(new MyString(s)));
//				if (s.charAt(s.length()-1) == ',' || s.charAt(s.length()-1) == '.')
//					s = s.substring(0, s.length()-1);
				
				MyString string3 = new MyString(s.toLowerCase());
				if (!(entries.contains(string3)))
				{
					System.out.println(string3.toString() + " " + lineCounter);
					
					//then, output all words obtainable by adding one character
					addChar(string3, entries);

//					
//					//removing one character
					removeChar(string3, entries);
//					
//					
//					//exchanging adjacent characters
				}
			}
			lineCounter++;
		}	
		in3.close();
	}
	
	// possible chars that can be included in words in the dictionary
	private static final char[] charsToCheck = {'a', 'b', 'c', 'd', 'e', 
		'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
		's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '\''};
	
	/**
	 * Add a character to the word (one at a time) and check if the new word is in the dictionary
	 * @param string3 the original word
	 * @param entries the hash table
	 */
	public static void addChar(MyString string3, HashTable<MyString> entries)
	{
		for (int i = 0; i < charsToCheck.length; i++)
		{
			for (int j = 0; j < string3.length() + 1; j++)
			{
				//insert characters at this location
				String s = new StringBuilder(string3.toString()).insert(j, charsToCheck[i]).toString();
		
				MyString myS2 = new MyString(s.toLowerCase()); 
//				System.out.println(myS2.toString());
				
				if (entries.contains(myS2))
				{
					System.out.println(myS2);
				}	
			}
			
		} 
	}
	
	public static void removeChar(MyString string3, HashTable<MyString> entries)
	{
		for (int j = 0; j < string3.length(); j++)
		{
			//delete characters at this location
			String s = new StringBuilder(string3.toString()).deleteCharAt(j).toString();
	
			MyString myS2 = new MyString(s.toLowerCase()); 


			if (entries.contains(myS2))
			{
				System.out.println(myS2);
			}	
		}	
	}
	
	public static void exchangeAdjacentChars(MyString string3, HashTable<MyString> entries)
	{
		
	}
}
