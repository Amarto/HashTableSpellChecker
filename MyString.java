/**
 * String wrapper class to house methods specific to HashTable implementation.
 * 
 * @author Amarto Rajaram aar2160
 *
 */

public class MyString
{
	private String word; //the wrapped string
	
	/**
	 * Constructs a new MyString object
	 * @param word the passed string
	 */
	public MyString(String word)
	{
		this.word = word;
	}

	/**
	 * HashCode method for MyString objects
	 * overrides Object's hashCode method
	 */
	public int hashCode()
	{
	    int hashVal = 0;
	    for (int i = 0; i < word.length(); i++)
	    {
	    	hashVal += 23 * hashVal + 7 * word.charAt(i) + i;	
	    }
	    
	    return Math.abs(hashVal);
	}
	
	/**
	 * Equals method for MyString objects
	 * After a long time of banging my head against a wall,
	 * I realized that I needed to modify this to override Object's
	 * equals method because I overrode hashCode
	 */
	public boolean equals(Object other)
	{
		return this.hashCode() == other.hashCode();
	}
	
	public String toString()
	{
		return word;
	}
	
	/**
	 * get method for a string's length
	 * @return length of word
	 */
	public int length()
	{
		return word.length();
	}
}
