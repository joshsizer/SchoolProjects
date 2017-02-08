package activity2;
/**
 * Questions:
 * 1) A deck has any number of cards.
 * 2) 6. The number of cards is the number of suits times the number of ranks.
 * 3) Did so.
 * 4) The order doesn't really matter since the shuffle function is called in the constructor
 *    immediately after filling the deck with cards.
 */

/**
 * This is a class that tests the Deck class.
 */
public class DeckTester {

	/**
	 * The main method in this class checks the Deck operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
		String[] suits = {"Hearts", "Spades", "Diamonds", "Clubs"};
		String[] ranks = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen",
				"King"};
		int[] values = {11, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10};

		Deck deck = new Deck(ranks, suits, values);
		System.out.println("The deck's size is " + deck.size());

		for (int i = 1; !deck.isEmpty();) {
		  Card card = deck.deal();
		  System.out.println(i++ + ": " + card.toString());
    }
	}
}
