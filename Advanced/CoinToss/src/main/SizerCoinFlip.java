package main;

public class SizerCoinFlip {
	
	public static void main (String[] args) {
		int inARow = 10;
		int coin1Streak = 0;
		int coin2Streak = 0;
		int flip = 1;
		Coin coin1 = new Coin();
		Coin coin2 = new Coin();
		String coin1Last;
		String coin2Last;
		String toPrint;
		
		while (coin1Streak < inARow || coin2Streak < inARow) {
			coin1Last = coin1.toString();
			coin2Last = coin2.toString();
			toPrint = "Flip: " + flip + "\n\tCoin 1: " + coin1Last 
					+ "\n\tCoin 2: " + coin2Last;
			System.out.println(toPrint);
			coin1.flip();
			coin2.flip();
			
			if (coin1Last.equals(coin1.toString())) 
				coin1Streak++;
			else
				coin1Streak = 0;
			
			if (coin2Last.equals(coin2.toString()))
				coin2Streak++;
			else
				coin2Streak = 0;
			flip++;
		}
		
		if (coin1Streak == inARow)
			System.out.println("Coin 1 Wins!");
		else 
			System.out.println("Coin 2 Wins!");
		
		System.out.format("It took %d coin flips to flip %d of the same side in a row.", flip, inARow);
	}

}
