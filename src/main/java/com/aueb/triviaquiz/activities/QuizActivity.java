package com.aueb.triviaquiz.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.aueb.triviaquiz.model.Question;
import com.aueb.triviaquiz.adapters.QuizAdapter;
import com.aueb.triviaquiz.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;

public class QuizActivity extends AppCompatActivity {

    public static final String EXTRA_SCORE = "extraScore";
    private static final long COUNTDOWN_IN_MILLIS = 30000;
    private static final String KEY_SCORE = "keyScore";
    private static final String KEY_QUESTION_COUNT = "keyQuestionCount";
    private static final String KEY_ANSWERED = "keyAnswered";
    private static final String KEY_MILLIS_LEFT = "keyMillisLeft";
    private static final String KEY_QUESTION_LIST = "keyQuestionList";

    private TextView textViewQuestion;
    private TextView textViewScore;
    private TextView textViewQuestionCount;
    private TextView textViewDifficulty;
    private TextView textViewCategory;
    private TextView textViewCountDown;
    private RadioGroup radioGroup;
    private RadioButton rb1;
    private RadioButton rb2;
    private RadioButton rb3;
    private RadioButton rb4;
    private Button buttonConfirmNext;

    private ColorStateList textColorDefaultRb;
    private ColorStateList textColorDefaultCd;

    private CountDownTimer countDownTimer;
    private long timeLeftInMillis;

    private ArrayList<Question> questionList;
    private int questionCounter;
    private int questionCountTotal;
    private Question currentQuestion;

    private int score;
    private boolean answered;
    private long backPressedTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        textViewQuestion = findViewById(R.id.questionTextView);
        textViewScore = findViewById(R.id.scoreTextView);
        textViewQuestionCount = findViewById(R.id.questionCountTextView);
        textViewDifficulty = findViewById(R.id.difficultyTextView);
        textViewCategory= findViewById(R.id.categoryTextView);
        textViewCountDown = findViewById(R.id.countdownTextView);

        radioGroup = findViewById(R.id.radioGroup);
        rb1 = findViewById(R.id.radioButton1);
        rb2 = findViewById(R.id.radioButton2);
        rb3 = findViewById(R.id.radioButton3);
        rb4 = findViewById(R.id.radioButton4);
        buttonConfirmNext = findViewById(R.id.confirmNextButton);

        textColorDefaultRb = rb1.getHintTextColors();
        textColorDefaultCd = textViewCountDown.getTextColors();

        Intent intent = getIntent();
        String difficulty = intent.getStringExtra(MainActivity.EXTRA_DIFFICULTY);
        int categoryID = intent.getIntExtra(MainActivity.EXTRA_CATEGORY_ID, 0);
        String categoryName = intent.getStringExtra(MainActivity.EXTRA_CATEGORY_NAME);
        textViewDifficulty.setText("Επίπεδο Δυσκολίας: " + difficulty);
        textViewCategory.setText("Κατηγορία: " + categoryName);
        if (savedInstanceState == null) {
            QuizAdapter dbHelper = QuizAdapter.getInstance(this);
            questionList = dbHelper.getQuestions(difficulty, categoryID);
            questionCountTotal = questionList.size();
            Collections.shuffle(questionList);
            showNextQuestion();
        } else {
            questionList = savedInstanceState.getParcelableArrayList(KEY_QUESTION_LIST);
            if (questionList == null) finish();
            questionCountTotal = questionList.size();
            questionCounter = savedInstanceState.getInt(KEY_QUESTION_COUNT);
            currentQuestion = questionList.get(questionCounter - 1);
            score = savedInstanceState.getInt(KEY_SCORE);
            timeLeftInMillis = savedInstanceState.getLong(KEY_MILLIS_LEFT);
            answered = savedInstanceState.getBoolean(KEY_ANSWERED);

            if (!answered) {
                startCountDown();
            } else {
                updateCountDown();
                showSolution();
            }
        }

        buttonConfirmNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!answered) {
                    if (rb1.isChecked() || rb2.isChecked() || rb3.isChecked() || rb4.isChecked())
                        checkAnswer();
                    else
                        Toast.makeText(QuizActivity.this, "Επιλέξτε μία απάντηση", Toast.LENGTH_SHORT).show();
                } else {
                    showNextQuestion();
                }
            }
        });
    }

    private void showNextQuestion() {
        rb1.setTextColor(textColorDefaultRb);
        rb2.setTextColor(textColorDefaultRb);
        rb3.setTextColor(textColorDefaultRb);
        rb4.setTextColor(textColorDefaultRb);
        radioGroup.clearCheck();

        if (questionCounter < questionCountTotal) {
            currentQuestion = questionList.get(questionCounter);
            textViewQuestion.setText(currentQuestion.getQuestion());

            rb1.setText(currentQuestion.getOption1());
            rb2.setText(currentQuestion.getOption2());
            rb3.setText(currentQuestion.getOption3());
            rb4.setText(currentQuestion.getOption4());

            questionCounter++;
            textViewQuestionCount.setText("Ερώτηση: " + questionCounter + "/" + questionCountTotal);
            answered = false;
            buttonConfirmNext.setText("Επιβεβαίωση");
            timeLeftInMillis = COUNTDOWN_IN_MILLIS;
            startCountDown();
        } else {
            finishQuiz();
        }
    }

    private void startCountDown() {
        countDownTimer = new CountDownTimer(timeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeftInMillis = millisUntilFinished;
                updateCountDown();
            }

            @Override
            public void onFinish() {
                timeLeftInMillis = 0;
                updateCountDown();
                showSolution();
            }
        }.start();
    }

    private void updateCountDown() {
        int mins = (int) ((timeLeftInMillis / 1000) / 60);
        int secs = (int) ((timeLeftInMillis / 1000) % 60);

        String timeFormat = String.format(Locale.getDefault(), "%02d:%02d", mins, secs);
        textViewCountDown.setText(timeFormat);
        if (timeLeftInMillis < 10000)
            textViewCountDown.setTextColor(Color.RED);
        else
            textViewCountDown.setTextColor(textColorDefaultCd);
    }

    private void checkAnswer() {
        answered = true;
        countDownTimer.cancel();
        RadioButton rbSelected = findViewById(radioGroup.getCheckedRadioButtonId());
        int answerNum = radioGroup.indexOfChild(rbSelected) + 1;
        if (answerNum == currentQuestion.getAnswerNum()) {
            score++;
            textViewScore.setText("Σκορ: " + score);
        }
        showSolution();
    }

    private void showSolution() {
        rb1.setTextColor(Color.RED);
        rb2.setTextColor(Color.RED);
        rb3.setTextColor(Color.RED);
        rb4.setTextColor(Color.RED);

        switch (currentQuestion.getAnswerNum()) {
            case 1 :
                rb1.setTextColor(Color.GREEN);
                //textViewQuestion.setText("Answer 1 is correct.");
                break;
            case 2 :
                rb2.setTextColor(Color.GREEN);
               // textViewQuestion.setText("Answer 2 is correct.");
            break;
            case 3 :
                rb3.setTextColor(Color.GREEN);
               // textViewQuestion.setText("Answer 3 is correct.");
            break;
            case 4 :
                rb4.setTextColor(Color.GREEN);
              //  textViewQuestion.setText("Answer 4 is correct.");
            break;
        }
        if (questionCounter < questionCountTotal) {
            buttonConfirmNext.setText("Επόμενη Ερώτηση");
        } else {
            buttonConfirmNext.setText("Τέλος");
        }
    }

    private void finishQuiz() {
        Intent resultIntent = new Intent();
        resultIntent.putExtra(EXTRA_SCORE, score);
        setResult(RESULT_OK, resultIntent);
        finish();
    }

    @Override
    public void onBackPressed() {
        if (backPressedTime + 2000 > System.currentTimeMillis())
            finish();
        else
            Toast.makeText(this, "Πατήστε ξανά για επιστροφή.", Toast.LENGTH_SHORT).show();
        backPressedTime = System.currentTimeMillis();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (countDownTimer != null)
            countDownTimer.cancel();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_SCORE, score);
        outState.putInt(KEY_QUESTION_COUNT, questionCounter);
        outState.putLong(KEY_MILLIS_LEFT, timeLeftInMillis);
        outState.putBoolean(KEY_ANSWERED, answered);
        outState.putParcelableArrayList(KEY_QUESTION_LIST, questionList);
    }

}