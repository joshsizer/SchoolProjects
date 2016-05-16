package main;

import java.io.File;
import java.io.FileNotFoundException;

public class Main {
	
	public static void main(String[] args) {
		int[] blah = new int[100];
		for (int i = 0; i < blah.length; i++) {
			blah[i] = (int) (Math.random() * 100);
			System.out.print(blah[i] + ", ");
		}
		
		Insertion.sortIntegers(blah);
		System.out.println();
		
		for (int i = 0; i < blah.length; i++) {
			System.out.print(blah[i] + ", ");
		}
		
		System.out.println("\n" + "HELLO".compareToIgnoreCase("GON"));
		
		String[] hello;
		try {
			hello = Insertion.sortFile(new File("Gadsby.txt"));
		} catch (FileNotFoundException e) {
			hello = new String[]{"can't load file!"};
		}
		for (int i = 0; i < hello.length; i++) {
			System.out.print(hello[i] + " ");
		}
	}
}
