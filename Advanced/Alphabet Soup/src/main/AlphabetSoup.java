package main;

/**
 * A bowl of alphabet soup!
 * @author Josh Sizer
 *
 */
public class AlphabetSoup {
	private static final int NUMBER_OF_LETTERS_IN_BOWL = 60;
	private final int[] letters;
	
	/**
	 * Creates a bowl of Alphabet Soup and fills it with alphabet pasta
	 */
	public AlphabetSoup() {
		letters = new int[26];
		pourSoup();
	}
	
	/**
	 * Randomly fills the letters array with letters;
	 * Index 0 = A, index 1 = B, etc. 
	 */
	private void pourSoup() {
		for (int i = 0; i < NUMBER_OF_LETTERS_IN_BOWL; i++) {
			letters[(int)(Math.random() * 26)]++;
		}
	}
	
	/**
	 * Returns an array where index 0 represents the number of 'A's this bowl has,
	 * index 1 represents the number of 'B's this bowl has, and so on. 
	 * @return
	 */
	public int[] getLetters() {
		return letters;
	}
	
	/**
	 * Format: [A: '#ofA's', B: '#ofB's', C: ... Z: '#ofZ's']
	 */
	public String toString() {
		String formated = "[";
		for (int i = 0; i < 26; i++) {
			formated += (char)('A' + i) + ": " + letters[i];
			if (i == 25)
				break;
			formated += ", ";
		}
		return formated += "]";
	}

}
