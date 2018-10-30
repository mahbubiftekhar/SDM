package hr.josip.questions;

import java.util.ArrayList;

import hr.josip.main.Main;

import javax.swing.JFrame;

public class QuestionChange {
	static String q = null;
	static String op1 = null;
	static String op2 = null;
	static String op3 = null;
	static String op4 = null;
	static int solution = 0;

	static Main quiz;
	static Questions questions;
	static String currQuestion;

	public QuestionChange() {
		quiz = new Main();
		newQuestion();
	}

	public static void newQuestion() {
		questions = new Questions();
		currQuestion = questions.question;
		
		parser();
		sendText();
	}

	public static void sendText() {
		quiz.changeLabelText(q);
		quiz.solution = solution;
		quiz.changeButtonText(1, op1);
		quiz.changeButtonText(2, op2);
		quiz.changeButtonText(3, op3);
		quiz.changeButtonText(4, op4);
	}

	public static void parser() {
		String question[] = currQuestion.split("\\$");
		for (int i = 0; i < question.length; i++) {
			switch (i) {
			case 0:
				q = question[i];
				break;
			case 1:
				op1 = question[i];
				break;
			case 2:
				op2 = question[i];
				break;
			case 3:
				op3 = question[i];
				break;
			case 4:
				op4 = question[i];
				break;
			case 5:
				solution = Integer.parseInt(question[i]);
				break;

			}
		}
	}

}
