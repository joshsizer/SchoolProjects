package main;

/**
 * A class that can encrypt and decrypt text based on a rail fence cypher. 
 * All plain text entered into the class will be converted to upper-case and spaces
 * will be removed. If decrypting, it will not remove spaces as this will screw up the
 * originally encrypted plaintext obtained by the decrypt function.
 * <p> For example: "This is an example"
 * will be encrypted as: "TIIAEAPEHSSNXML". 
 * </p>
 * This accomplished by removing spaces and converting to uppercase, and creating two substrings
 * which are concatonated. The first substring will have all even index characters, and the second
 * substring will have all odd index characters. 
 * 
 * @author Josh Sizer
 */
public class RFcipher {
	String mPlainText = null;
	String mEncryptedText = null;
	String mDecryptedText = null;
	
	public RFcipher() {
	
	}
	
	/**
	 * An alternate constructor, so that the text to be encrypted is 
	 * passed in as the argument to the object instead of the object's methods.
	 * @param plainText The text to be encrypted.
	 */
	public RFcipher (String plainText) {
		mPlainText = plainText;
		mEncryptedText = encrypt(mPlainText);
		mDecryptedText = decrypt(mEncryptedText);
	}
	
	/**
	 * Encrypts the string specified by the constructor's arguments.
	 * @return The encrypted text converted to upper-case and with all spaces removed.
	 * @throws NullPointerException if this function is called without the
	 *  <code> RFcipher(String plainText) </code> constructor. 
	 */
	public String encrypt() throws NullPointerException {
		if (mEncryptedText == null) {
			throw new NullPointerException();
		}
		return mEncryptedText;
	}
	
	/**
	 * Encrypts a specified string
	 * @param plainText The plain text to be encrypted.
	 * @return The encrypted text converted to upper-case and with all spaces removed.
	 */
	public String encrypt(String plainText) {
		String beg = "";
		String end = "";
		plainText = plainText.toUpperCase();
		plainText = removeSpaces(plainText);
		for (int i = 0; i < plainText.length(); i++) {
			if (i % 2 == 0) 
				beg += plainText.charAt(i);
			else 
				end += plainText.charAt(i);
		}
		mPlainText = plainText;
		mEncryptedText = beg.concat(end);
		mDecryptedText = decrypt(mEncryptedText);
		return mEncryptedText;
	}
	
	/**
	 * Decrypts the string specified by the constructor. Essentially returns the same
	 * as the plain text entered into the constructor but converted to upper-case and with spaces removed because
	 * the plain text is first encrypted and its output is decrypted. Note the encryption always converts to uppercase
	 * and removes spaces. 
	 * @return The decrypted string.
	 * @throws NullPointerException if this function is called without the
	 *  <code> RFcipher(String plainText) </code> constructor
	 */
	public String decrypt() throws NullPointerException {
		if (mEncryptedText == null) {
			throw new NullPointerException();
		}
		return mDecryptedText;
	}
	
	/**
	 * Decrypts the specified string. It will not convert the string to upper-case or 
	 * remove spaces in the case that the argument has spaces and different cases. (If we removed
	 * the spaces and converted to upper-case an already encrypted string with these properties, the decrypted
	 * string would not accurately represent the plain text).
	 * @param encryptedText The string to be decrypted. 
	 * @return The decrypted text
	 */
	public String decrypt (String encryptedText) {
		String beg = "";
		String end = "";
		String decrypted = "";
		int middle = encryptedText.length() % 2 == 0 ? encryptedText.length()/2: encryptedText.length()/2 + 1;
		beg = encryptedText.substring(0, middle);
		end = encryptedText.substring(middle);
		for (int i = 0; i < beg.length() + end.length(); i++) {
			if (i % 2 == 0)
				decrypted += beg.charAt(i/2);
			else
				decrypted += end.charAt(i/2);
		}
		mEncryptedText = encryptedText;
		mDecryptedText = decrypted;
		mPlainText = decrypted;
		return mDecryptedText;
	}
	
	//used by the encrypt function to remove spaces
	private String removeSpaces (String str) {
		String ret = "";
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) != 0x0020) {
				ret += str.charAt(i);
			}
		}
		return ret;
	}
	
	@Override
	public String toString() throws NullPointerException {
		if (mPlainText == null || mEncryptedText == null 
				|| mDecryptedText == null) {
			throw new NullPointerException();
		}
		return "++++++++++++++++" + 
				"\nInitial String:\t" + mPlainText + 
				"\nEncrypted:\t" + mEncryptedText + 
				"\nDecrypted:\t" + mDecryptedText;
	}
}
