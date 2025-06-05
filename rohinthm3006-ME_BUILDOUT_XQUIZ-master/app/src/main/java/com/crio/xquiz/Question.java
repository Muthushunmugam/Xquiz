package com.crio.xquiz;
import java.util.*;

public class Question {
    private String questionText;
    private String answer;
    private List<String> choices;
    private boolean isPresent = false;

    public Question(String questionText, List<String> choices, String answer) {
        // Validate question text
        if (questionText == null || questionText.length() == 0) {
            System.out.println("Question text cannot be null or empty!");
            return;
        }

        // Validate answer
        if (answer == null || answer.length() == 0) {
            System.out.println("Answer cannot be null or empty!");
            return;
        }

        // Validate choices
        if (choices == null || choices.isEmpty()) {
            System.out.println("Choices cannot be null or empty!");
            return;
        }

        // Check if answer is among choices
        for (String choice : choices) {
            if (answer.equals(choice)) {
                isPresent = true;
                break;
            }
        }
        
        if (!isPresent) {
            System.out.println("Answer is not present among the choices!");
        }

        this.questionText = questionText;
        this.answer = answer;
        this.choices = choices;
    }

    public String getQuestionText() {
        return questionText;
    }

    public String getAnswer() {
        return answer;
    }

    public List<String> getChoices() {
        return choices;
    }

    public boolean checkAnswer(String userAnswer) {
        // Validate if the provided answer matches the correct answer
        return userAnswer != null && userAnswer.equals(this.answer);
    }

    public void display() {
        System.out.println(getQuestionText());
        for (int i = 0; i < choices.size(); i++) {
            int choiceNumber = i + 1;
            System.out.println(choiceNumber + ": " + choices.get(i));
        }
    }
}
