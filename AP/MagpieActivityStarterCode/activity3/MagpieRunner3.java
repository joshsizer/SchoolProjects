import java.util.Scanner;
/*
 * What value is returned by indexOf if the substring does not occur in the string?
 * -1
 * 
    findKeyword("She's my sister", "sister", 0);
  		psn: 9; before: " "; after: "";
	findKeyword("Brother Tom is helpful", "brother", 0);
		psn: 0; before: ""; after: " "
	findKeyword("I can't catch wild cats.", "cat", 0);
		psn: 8; before: " "; after: "c"
		psn: 19; before" "c" after: "s"
	findKeyword("I know nothing about snow plows.", "no", 0); 
		psn: 3 before: "k" after "w"
		psn: 7 before " " after: "t"
		psn: 22 before: "s" after: "w"
 * 
 */
/**
 * A simple class to run the Magpie class.
 * @author Laurie White
 * @version April 2012
 */
public class MagpieRunner3
{

	/**
	 * Create a Magpie, give it user input, and print its replies.
	 */
	public static void main(String[] args)
	{
		Magpie3 maggie = new Magpie3();
		
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
