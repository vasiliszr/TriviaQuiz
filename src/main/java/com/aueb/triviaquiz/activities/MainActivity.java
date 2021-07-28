package com.aueb.triviaquiz.activities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.aueb.triviaquiz.model.Category;
import com.aueb.triviaquiz.model.Question;
import com.aueb.triviaquiz.adapters.QuizAdapter;
import com.aueb.triviaquiz.R;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CODE_QUIZ = 1;
    public static final String EXTRA_DIFFICULTY = "extraDifficulty";
    public static final String EXTRA_CATEGORY_ID = "extraCategoryID";
    public static final String EXTRA_CATEGORY_NAME = "extraCategoryName";
    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String KEY_HIGHSCORE = "keyHighscore";

    private int highscore;
    private TextView textViewHighscore;
    private Spinner spinnerDiff;
    private Spinner spinnerCat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewHighscore = findViewById(R.id.highscoreTextView);
        spinnerDiff = findViewById(R.id.difficultySpinner);
        spinnerCat = findViewById(R.id.categorySpinner);

        loadHighscore();
        loadDifficultyLevels();
        loadCategories();

        Button buttonStartQuiz = findViewById(R.id.buttonStartQuiz);
        buttonStartQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String difficulty = spinnerDiff.getSelectedItem().toString();
                Category selectedCat = (Category) spinnerCat.getSelectedItem();
                int categoryID = selectedCat.getId();
                String categoryName = selectedCat.getName();
                Intent intent = new Intent(MainActivity.this, QuizActivity.class);
                intent.putExtra(EXTRA_DIFFICULTY, difficulty);
                intent.putExtra(EXTRA_CATEGORY_ID, categoryID);
                intent.putExtra(EXTRA_CATEGORY_NAME, categoryName);
                startActivityForResult(intent, REQUEST_CODE_QUIZ);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_QUIZ) {
            if (resultCode == RESULT_OK) {
                int score = data.getIntExtra(QuizActivity.EXTRA_SCORE, 0);
                if (score > highscore) {
                    highscore = score;
                    textViewHighscore.setText("Highscore: " + highscore);
                    SharedPreferences prefs = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
                    SharedPreferences.Editor editor = prefs.edit();
                    editor.putInt(KEY_HIGHSCORE, highscore);
                    editor.apply();
                }
            }
        }
    }

    private void loadHighscore() {
        SharedPreferences prefs = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        highscore = prefs.getInt(KEY_HIGHSCORE, 0);
        textViewHighscore.setText("Highscore: " + highscore);
    }

    private void loadDifficultyLevels() {
        String[] difficultyLevels = Question.getAllDifficultyLevels();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, difficultyLevels);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerDiff.setAdapter(adapter);
    }

    private void loadCategories() {
        QuizAdapter quizAdapter = QuizAdapter.getInstance(this);
        List<Category> categories = quizAdapter.getAllCategories();
        ArrayAdapter<Category> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, categories);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCat.setAdapter(adapter);
    }

}