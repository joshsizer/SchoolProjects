package com.joshsizer.main;

import java.io.FileNotFoundException;
import java.io.IOException;

public class QuizTime {
	private Quiz[] myQuizes;
	
	public QuizTime(Quiz[] quizes) {
		this.myQuizes = quizes;
	}
	
	public QuizTime(String path) throws FileNotFoundException {
		this(Parser.getQuizes(path));
	}
	
	public void giveQuiz() {
		giveQuiz(0);
	}
	
	public void giveQuiz(String name) {
		for (int i = 0; i < myQuizes.length; i++) {
			if (myQuizes[i].getName().equals(name)) {
				giveQuiz(i);
			}
		}
	}
	
	public void giveQuiz(int whichQuiz) {
		if (whichQuiz < 0 || whichQuiz > myQuizes.length - 1) {
			System.out.println("Index out of bounds!");
			return;
		}
		myQuizes[whichQuiz].giveQuiz();
	}
	
	public void addQuiz(Quiz quiz) {
		Quiz[] newArr = new Quiz[myQuizes.length + 1];
		for (int i = 0; i < newArr.length - 1; i++)
				newArr[i] = myQuizes[i];
		newArr[newArr.length - 1] = quiz;	
		
		myQuizes = newArr;
	}
	
	public void userAddQuiz() {
		Quiz newQuiz = null;
		
		addQuiz(newQuiz);
	}
	
	public void writeToFile(String path) throws IOException {
		StringBuilder output = new StringBuilder();
		
		Parser.toFile(path, output.toString());
	}
}
