package activity1;

/**
 * This is a class that tests the Card class.
 */
public class CardTester {

	/**
	 * The activity1 method in this class checks the Card operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
		Card c1 = new Card("2", "Spades", 2);
		Card c2 = new Card("Ace", "Hearts", 11);
		Card c3 = new Card("10", "Diamonds", 10);

		/*
		 * For effeciency's sake, I am only calling the card's toString method. The two String method
		 * uses the method calls to aquire their own properties, rather than accessing the private
		 * member variables directly. This is a cleaner way to prove that all functions work, mearly by
		 * one function call.
		 */
		System.out.println(c1);
    System.out.println(c2);
    System.out.println(c3);

    System.out.println("Card one matches card 2: " + c1.matches(c2));
	}
}
