/**
 * Hash table spell checker
 * 
 * Reads a dictionary, a personal dictionary, and an input file(to be spellchecked)
 * Reads the dictionaries into a hash table, and checks to see if each word 
 * in the input file exists in the hash table. If not, it indicates the word
 * and the line on which it appears.
 * Then, it checks to see if it is possible to create a "correct" word by 
 * removing a character, inserting a character, or exchanging adjacent characters.
 * 
 * TO RUN: javac Test.java
 * java Test bigdictionary.txt personaldictionary.txt input.txt
 */



import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;


public class Test 
{
	public static void main(String[] args) throws IOException
	{		
		QuadraticProbingHashTable<MyString> entries = new QuadraticProbingHashTable<MyString>();

		//input words from big dictionary (specified in 1st cmd line arg)

		BufferedReader br = new BufferedReader(new FileReader(new File(args[0])));
		int bigDictionaryLineCounter = 0;

		String input1Line;
		while((input1Line = br.readLine()) != null)
		{		
			//remove commas and periods at end of word
			if (input1Line.charAt(input1Line.length()-1) == ',' || 
					input1Line.charAt(input1Line.length()-1) == '.')
				input1Line = input1Line.substring(0, input1Line.length()-1);
			

			entries.insert(new MyString(input1Line.toLowerCase()));

			
			bigDictionaryLineCounter++;
		}	
		br.close();
		
//		System.out.println("Successful inserts from bigdict: " + bigDictionaryLineCounter);

		//input words from personal dictionary
		int personalDictionaryCounter = 0;
		BufferedReader br2 = new BufferedReader(new FileReader(new File(args[1])));
		String input2Line;
		while ((input2Line = br2.readLine()) != null)
		{
			//remove commas and periods from end of word
			if (input2Line.charAt(input2Line.length()-1) == ',' || 
					input2Line.charAt(input2Line.length()-1) == '.')
				input2Line = input2Line.substring(0, input2Line.length()-1);
			
			entries.insert(new MyString(input2Line.toLowerCase()));
			personalDictionaryCounter++;
		}
		br2.close();
//		System.out.println("Successful inserts from personal dictionary: " +
//		personalDictionaryCounter);
//		
//		System.out.println("Total: " + (personalDictionaryCounter + bigDictionaryLineCounter));
		
//		
//		System.out.println("Size: " + entries.size());
//		System.out.println("Capacity: " + entries.capacity());
//		System.out.println(entries.contains(new MyString("s")));
			
		//read input file, to spellcheck
		BufferedReader br3 = new BufferedReader(new FileReader(new File(args[2])));
		

		
		int lineCounter = 0;
		String input3Line;
		while ((input3Line = br3.readLine()) != null)
		{
			StringTokenizer str = new StringTokenizer(input3Line);
			while(str.hasMoreTokens())
			{
				String s = str.nextToken();
				if (s.charAt(s.length()-1) == ',' || s.charAt(s.length()-1) == '.')
					s = s.substring(0, s.length()-1);
				
				MyString string3 = new MyString(s.toLowerCase());
				if (!(entries.contains(string3)))
				{
					System.out.println("Misspelled word: " + string3.toString() + " Line: " + lineCounter);
					
					//then, output all words obtainable by adding one character
					addChar(string3, entries);
					
					//removing one character
					removeChar(string3, entries);
					
					//exchanging adjacent characters
					exchangeAdjacentChars(string3, entries);
				}
			}
			lineCounter++;
		}	
		br3.close();
	}
	
	//possible chars that can be included in words in the dictionary
	private static final char[] charsToCheck = {'a', 'b', 'c', 'd', 'e', 
		'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
		's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '\''};
	
	/**
	 * Add a character to the word (one at a time) and check if the new word is in the dictionary
	 * @param string3 the original word
	 * @param entries the hash table
	 */
	public static void addChar(MyString string3, QuadraticProbingHashTable<MyString> entries)
	{
		for (int i = 0; i < charsToCheck.length; i++)
		{
			for (int j = 0; j < string3.length() + 1; j++)
			{
				//insert characters at this location
				String s = new StringBuilder(string3.toString()).insert(j, charsToCheck[i]).toString();
		
				MyString myS2 = new MyString(s.toLowerCase()); 
				
				if (entries.contains(myS2))
				{
					System.out.println("Corrected: " + myS2);
				}	
			}
			
		} 
	}
	
	/**
	 * Remove a character (one at a time) from a string and check if the 
	 * resulting word is in the hash table
	 * @param string3 original word
	 * @param entries hash table
	 */
	public static void removeChar(MyString string3, QuadraticProbingHashTable<MyString> entries)
	{
		for (int j = 0; j < string3.length(); j++)
		{
			//delete characters at this location
			String s = new StringBuilder(string3.toString()).deleteCharAt(j).toString();
	
			MyString myS2 = new MyString(s.toLowerCase()); 


			if (entries.contains(myS2))
			{
				System.out.println("Corrected: " + myS2);
			}	
		}	
	}
	
	/**
	 * Exchange adjacent chars in a word
	 * output it if it is in the dictionary
	 * @param string3 the original word
	 * @param entries the hash table
	 */
	public static void exchangeAdjacentChars(MyString string3, QuadraticProbingHashTable<MyString> entries)
	{
		for (int i=0; i < string3.length() - 1; i++)
		{
			String s = string3.toString();
			char temp = s.charAt(i);
			StringBuilder strbuild = new StringBuilder(s);
			strbuild.setCharAt(i+1, temp);
			strbuild.setCharAt(i, s.charAt(i+1));
			s = strbuild.toString();

			MyString myS = new MyString(s.toLowerCase());
			
			if(entries.contains(myS))
			{
				System.out.println("Corrected: " + myS);
			}
		}
	}
}
