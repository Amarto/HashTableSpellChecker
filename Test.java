import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Test 
{
	public static void main(String[] args) throws FileNotFoundException
	{
		//hash all the large dictionary entries
		//hash the personal dictionary entries
		
		HashTable<MyString> entries = new HashTable<MyString>();
//		
//		entries.insert("frog");
////		entries.insert(frog2);
		//input words from big dictionary (specified in 1st cmd line arg)
		
		Scanner in = new Scanner(new File(args[0]));
		while (in.hasNextLine())
		{
			entries.insert(new MyString(in.nextLine().toLowerCase()));
		}	
		in.close();

		//input words from personal dictionary
		Scanner in2 = new Scanner(new File(args[1]));
		while (in2.hasNextLine())
		{
			entries.insert(new MyString(in2.nextLine().toLowerCase()));
		}
		in2.close();
		
		
		// testing

		//System.out.println(entries.contains(new MyString("discotec")));
		
		
		//read input file, to spellcheck
		Scanner in3 = new Scanner(new File(args[2]));
		
		int lineCounter = 0;
		while (in3.hasNextLine())
		{
			StringTokenizer str = new StringTokenizer(in3.nextLine());
			while(str.hasMoreTokens())
			{
				MyString string3 = new MyString(str.nextToken());
//				System.out.println(string3.toString());
//				System.out.println(entries.contains(string3));
				if (!(entries.contains(string3)))
				{
					System.out.println(string3.toString() + " " + lineCounter);
//					
//					//then, output all words obtainable by adding one character
//					
//					char ch = 'a';
//					while(ch != 'z')
//					{
//						for (int i = 0; i < myS.length() + 1; i++)
//						{
//							//insert characters a-z at this location
//							String s = new StringBuilder(myS.toString()).insert(i, ch).toString();
//							MyString myS2 = new MyString(s);
//						}
//					} 	
//					
//					//removing one character
//					
//					
//					//exchanging adjacent characters
				}
			}
			lineCounter++;
		}	
		
		//for every word in the input file, call contains to see if correct
		//if so, pass over it
		//if not, 
		//TODO remove one character 
	}

}
