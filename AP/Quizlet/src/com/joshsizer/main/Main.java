package com.joshsizer.main;

import java.util.Scanner;

public class Main {
	public static Scanner userInput = new Scanner(System.in);

	public static void main(String[] args) {
		Question q1, q2;

		q1 = new Question("What is the capital of Jamaica?", "Kingston");
		q1.setComplexity(4);

		q2 = new Question("Which is worse, ignorance or apathy?", "I don't know and I don't care");
		q2.setComplexity(10);
		
		Question[] questionArray = {q1, q2};
		Quiz[] quiz = {new Quiz("Test Quiz", questionArray)};
		
		QuizTime quizTime= new QuizTime(quiz);
		
		quizTime.giveQuiz("Test Quiz");
	}
}
