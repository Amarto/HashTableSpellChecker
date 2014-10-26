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
		System.out.println("MyString hashCode called");
	    int hashVal = 0;
	    for (int i = 0; i < word.length(); i++)
	    {
	    	hashVal += 13 * hashVal + word.charAt(i);	
	    }
	    //System.out.println(hashVal);
	    	
	    return Math.abs(hashVal);
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
