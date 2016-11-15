import java.util.Scanner;

/*How does it respond to:
 My mother and I talked last night.
	Tell me more about your family
 I said no!
	Why so negative?
 The weather is nice.
	"Hmmm" or "Interesting, tell me more."
 Do you know my brother? 
	Why do negative?
	
	What happens when more than one keyword appears in a string? Consider the string “My
mother has a dog but no cat.” Explain how to prioritize responses in the reply method. 
	The keyword that comes first in the if else ladder will return the corresponding response.
	The more "important" keywords should come first in the if else ladder.
	
What happens when a keyword is included in another word? Consider statements like “I know
all the state capitals” and “I like vegetables smothered in cheese.” Explain the problem with the
responses to these statements. 
	The first will return Why so negative because of the no in know and the second will return tell me
	more about your family because it has mother in smothered. All the parsing does is look for
	an occurrence of the word, not whether that occurrence is the entire word itself or in another word.
*/
/**
 * A simple class to run the Magpie class.
 * @author Laurie White
 * @version April 2012
 */
public class MagpieRunner2
{

	/**
	 * Create a Magpie, give it user input, and print its replies.
	 */
	public static void main(String[] args)
	{
		Magpie2 maggie = new Magpie2();
		
		System.out.println (maggie.getGreeting());
		Scanner in = new Scanner (System.in);
		String statement = in.nextLine();
		
		while (!statement.equals("Bye"))
		{
			System.out.println (maggie.getResponse(statement));
			statement = in.nextLine();
		}
	}

}
