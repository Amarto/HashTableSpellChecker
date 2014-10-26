/**
 * String wrapper class to house methods specific to HashTable implementation.
 * 
 * @author Amarto Rajaram aar2160
 *
 */


public class MyString
{
	private String word; 
	
	public MyString(String word)
	{
		this.word = word;
	}

	public int hashCode()
	{
	    int hashVal = 0;
	    for (int i = 0; i < word.length(); i++)
	    {
	    	hashVal += 13 * hashVal + word.charAt(i);	
	    }
	    	
	    return Math.abs(hashVal);
	}
	
	public boolean equals(Object other)
	{
		return this.hashCode() == other.hashCode();
	}
	
	public String toString()
	{
		return word;
	}
	
	public int length()
	{
		return word.length();
	}
	
	

}
