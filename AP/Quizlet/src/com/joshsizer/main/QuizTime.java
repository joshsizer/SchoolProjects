package com.joshsizer.main;

public class QuizTime {
	private Quiz[] myQuizes;
	
	public QuizTime(Quiz[] quizes) {
		this.myQuizes = quizes;
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
	
	public void giveQuiz() {
		giveQuiz(0);
	}
}
