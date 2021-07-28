package com.aueb.triviaquiz.categories;

import com.aueb.triviaquiz.model.Question;

import java.util.ArrayList;
import java.util.List;

public class QuestionContainerScience {

    private List<Question> questions;

    public QuestionContainerScience() {
        questions = new ArrayList<>();
        questionsGenerator();
    }

    private void questionsGenerator() {
        generateEasyQuestions();
        generateMediumQuestions();
        generateHardQuestions();
    }

    //TODO FILL THE QUESTIONS FOR EACH CATEGORY
    private void generateEasyQuestions() {
        Question q1 = new Question();
        questions.add(q1);
        Question q2 = new Question();
        questions.add(q2);
        Question q3 = new Question();
        questions.add(q3);
        Question q4 = new Question();
        questions.add(q4);
        Question q5 = new Question();
        questions.add(q5);
        Question q6 = new Question();
        questions.add(q6);
        Question q7 = new Question();
        questions.add(q7);
        Question q8 = new Question();
        questions.add(q8);
        Question q9 = new Question();
        questions.add(q9);
        Question q10 = new Question();
        questions.add(q10);
    }

    private void generateMediumQuestions() {
        Question q1 = new Question();
        questions.add(q1);
        Question q2 = new Question();
        questions.add(q2);
        Question q3 = new Question();
        questions.add(q3);
        Question q4 = new Question();
        questions.add(q4);
        Question q5 = new Question();
        questions.add(q5);
        Question q6 = new Question();
        questions.add(q6);
        Question q7 = new Question();
        questions.add(q7);
        Question q8 = new Question();
        questions.add(q8);
        Question q9 = new Question();
        questions.add(q9);
        Question q10 = new Question();
        questions.add(q10);
    }

    private void generateHardQuestions() {
        Question q1 = new Question();
        questions.add(q1);
        Question q2 = new Question();
        questions.add(q2);
        Question q3 = new Question();
        questions.add(q3);
        Question q4 = new Question();
        questions.add(q4);
        Question q5 = new Question();
        questions.add(q5);
        Question q6 = new Question();
        questions.add(q6);
        Question q7 = new Question();
        questions.add(q7);
        Question q8 = new Question();
        questions.add(q8);
        Question q9 = new Question();
        questions.add(q9);
        Question q10 = new Question();
        questions.add(q10);
    }

    public List<Question> getQuestions() {
        return questions;
    }

}

