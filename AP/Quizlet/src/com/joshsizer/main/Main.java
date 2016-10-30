package com.joshsizer.main;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	public static Scanner userInput = new Scanner(System.in);
	public static String path = "save.txt";

	public static void main(String[] args) {
		if (args.length != 0) {
			path = args[0];
		}
		QuizTime quizTime;
		try {
			quizTime = new QuizTime(path);
			quizTime.giveQuiz("Test Quiz");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
