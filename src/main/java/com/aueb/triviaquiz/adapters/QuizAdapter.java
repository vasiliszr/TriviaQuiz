package com.aueb.triviaquiz.adapters;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.aueb.triviaquiz.categories.QuestionContainerGeography;
import com.aueb.triviaquiz.categories.QuestionContainerHistory;
import com.aueb.triviaquiz.categories.QuestionContainerPopCulture;
import com.aueb.triviaquiz.categories.QuestionContainerScience;
import com.aueb.triviaquiz.categories.QuestionContainerSports;
import com.aueb.triviaquiz.model.Category;
import com.aueb.triviaquiz.model.Question;
import com.aueb.triviaquiz.adapters.QuizContract.*;

import java.util.ArrayList;
import java.util.List;

public class QuizAdapter extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "TriviaQuiz.db";
    private static final int DATABASE_VERSION = 1;

    private static QuizAdapter instance;
    private SQLiteDatabase db;

    private QuizAdapter(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public static synchronized QuizAdapter getInstance(Context context) {
        if (instance == null)
            instance = new QuizAdapter(context.getApplicationContext());
        return  instance;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        db = sqLiteDatabase;

        final String SQL_CREATE_CATEGORIES_TABLE = "CREATE TABLE " + CategoriesTable.TABLE_NAME + "( " +
                CategoriesTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                CategoriesTable.COLUMN_NAME + " TEXT " +
                ")";

        final String SQL_CREATE_QUESTIONS_TABLE = "CREATE TABLE " + QuestionsTable.TABLE_NAME + " ( " +
                QuestionsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuestionsTable.COLUMN_QUESTION + " TEXT, " +
                QuestionsTable.COLUMN_OPTION1 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION2 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION3 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION4 + " TEXT, " +
                QuestionsTable.COLUMN_ANSWER_NUM + " INTEGER, " +
                QuestionsTable.COLUMN_DIFFICULTY + " TEXT, " +
                QuestionsTable.COLUMN_CATEGORY_ID + " INTEGER, " +
                "FOREIGN KEY(" + QuestionsTable.COLUMN_CATEGORY_ID + ") REFERENCES " +
                CategoriesTable.TABLE_NAME + "(" + CategoriesTable._ID + ")" + " ON DELETE CASCADE " +
                ")";

        db.execSQL(SQL_CREATE_CATEGORIES_TABLE);
        db.execSQL(SQL_CREATE_QUESTIONS_TABLE);
        fillCategoriesTable();
        fillQuestionsTable();
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + CategoriesTable.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + QuestionsTable.TABLE_NAME);
        onCreate(db);
    }

    @Override
    public void onConfigure(SQLiteDatabase db) {
        super.onConfigure(db);
        db.setForeignKeyConstraintsEnabled(true);
    }

    private void fillCategoriesTable() {
        Category c1 = new Category("Ιστορία");
        insertCategory(c1);
        Category c2 = new Category("Γεωγραφία");
        insertCategory(c2);
        Category c3 = new Category("Αθλητισμός");
        insertCategory(c3);
        Category c4 = new Category("Ποπ Κουλτούρα");
        insertCategory(c4);
        Category c5 = new Category("Επιστήμες");
        insertCategory(c5);
    }

    private void insertCategory(Category category) {
        ContentValues cv = new ContentValues();
        cv.put(CategoriesTable.COLUMN_NAME, category.getName());
        db.insert(CategoriesTable.TABLE_NAME, null, cv);
    }

    private void fillQuestionsTable() {
        QuestionContainerHistory qc1 = new QuestionContainerHistory();
        insertQuestions(qc1.getQuestions());
        QuestionContainerSports qc2 = new QuestionContainerSports();
        insertQuestions(qc2.getQuestions());
        QuestionContainerGeography qc3 = new QuestionContainerGeography();
        insertQuestions(qc3.getQuestions());
        QuestionContainerPopCulture qc4 = new QuestionContainerPopCulture();
        insertQuestions(qc4.getQuestions());
        QuestionContainerScience qc5 = new QuestionContainerScience();
        insertQuestions(qc5.getQuestions());
    }

    private void insertQuestions(List<Question> questions) {
        for (Question q : questions)
            insertQuestion(q);
    }

    private void insertQuestion(Question question) {
        ContentValues cv = new ContentValues();
        cv.put(QuestionsTable.COLUMN_QUESTION, question.getQuestion());
        cv.put(QuestionsTable.COLUMN_OPTION1, question.getOption1());
        cv.put(QuestionsTable.COLUMN_OPTION2, question.getOption2());
        cv.put(QuestionsTable.COLUMN_OPTION3, question.getOption3());
        cv.put(QuestionsTable.COLUMN_OPTION4, question.getOption4());
        cv.put(QuestionsTable.COLUMN_ANSWER_NUM, question.getAnswerNum());
        cv.put(QuestionsTable.COLUMN_DIFFICULTY, question.getDifficulty());
        cv.put(QuestionsTable.COLUMN_CATEGORY_ID, question.getCategoryID());
        db.insert(QuestionsTable.TABLE_NAME, null, cv);
    }

    public List<Category> getAllCategories() {
        List<Category> categoryList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + CategoriesTable.TABLE_NAME, null);

        if(c.moveToFirst()) {
            do {
                Category category = new Category();
                category.setId(c.getInt(c.getColumnIndex(CategoriesTable._ID)));
                category.setName(c.getString(c.getColumnIndex(CategoriesTable.COLUMN_NAME)));
                categoryList.add(category);
            } while (c.moveToNext());
        }

        c.close();
        return categoryList;
    }

    public ArrayList<Question> getQuestions(String difficulty, int categoryID) {
        ArrayList<Question> questionList = new ArrayList<>();
        db = getReadableDatabase();

        String selection = QuestionsTable.COLUMN_CATEGORY_ID + " = ? " + " AND " + QuestionsTable.COLUMN_DIFFICULTY + " = ? ";
        String[] selectionArgs = new String[] {String.valueOf(categoryID), difficulty};
        Cursor c = db.query(QuestionsTable.TABLE_NAME, null, selection, selectionArgs, null, null, null);

        if (c.moveToFirst()) {
            do {
                Question question = new Question();
                question.setId(c.getInt(c.getColumnIndex(QuestionsTable._ID)));
                question.setQuestion(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_QUESTION)));
                question.setOption1(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION1)));
                question.setOption2(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION2)));
                question.setOption3(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION3)));
                question.setOption4(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION4)));
                question.setAnswerNum(c.getInt(c.getColumnIndex(QuestionsTable.COLUMN_ANSWER_NUM)));
                question.setDifficulty(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_DIFFICULTY)));
                question.setCategoryID(c.getInt(c.getColumnIndex(QuestionsTable.COLUMN_CATEGORY_ID)));
                questionList.add(question);
            } while (c.moveToNext());
        }

        c.close();
        return questionList;
    }

}
