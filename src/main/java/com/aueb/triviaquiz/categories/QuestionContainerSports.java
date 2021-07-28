package com.aueb.triviaquiz.categories;

import com.aueb.triviaquiz.model.Category;
import com.aueb.triviaquiz.model.Question;

import java.util.ArrayList;
import java.util.List;

public class QuestionContainerSports {

    private List<Question> questions;

    public QuestionContainerSports() {
        questions = new ArrayList<>();
        questionsGenerator();
    }

    private void questionsGenerator() {
        generateEasyQuestions();
        generateMediumQuestions();
        generateHardQuestions();
    }

    private void generateEasyQuestions() {
        Question q1 = new Question("Ποιά ποδοσφαιρική ομάδα έχει κατακτήσει τα περισσότερα Champions League στην ιστορία;",
                "Μπαρτσελόνα", "Μίλαν", "Λίβερπουλ", "Ρέαλ Μαδρίτης", 4, Question.EASY, Category.SPORTS);
        questions.add(q1);
        Question q2 = new Question("Σε ποιά αγγλική ομάδα έχει δωθεί το παρατσούκλι 'Οι Κόκκινοι Διάβολοι'; ",
                "Μάντσεστερ Γιουνάιτεντ", "Λίβερπουλ", "Σάντερλαντ", "Σαουθάμπτον",1 , Question.EASY, Category.SPORTS);
        questions.add(q2);
        Question q3 = new Question("Σε ποιά ομάδα ξεκίνησε την καριέρα του ο Κριστιάνο Ρονάλντο;",
                "Γκιμαράες", "Μάντσεστερ Γιουνάιτεντ", "Σπόρτινγκ Λισαβώνας", "Μπενφίκα",3 , Question.EASY, Category.SPORTS);
        questions.add(q3);
        Question q4 = new Question("Σε ποιό Μουντομπάσκετ η εθνική μας ομάδα μπάσκετ θριάμβευσε, αποκλείοντας την Team USA και κατακτώντας το αργυρό μετάλλιο; ",
                "Αθήνα - 1998", "Ιντιανάπολις - 2002", "Ιαπωνία - 2006", "Τουρκία - 2010", 3, Question.EASY, Category.SPORTS);
        questions.add(q4);
        Question q5 = new Question("Πόσες φορές έχουν διεξαγχθεί οι σύγρχονοι Ολυμπιακοί Αγώνες στην χώρα μας;",
                "Μία", "Δύο", "Τρείς", "Τέσσερις", 2, Question.EASY, Category.SPORTS);
        questions.add(q5);
        Question q6 = new Question("Ποιό από τα παρακάτω αγωνίσματα δεν αποτελεί μέρος του Τριάθλου;",
                "Κολύμβυση", "Ποδηλασία", "Ιππασία", "Τρέξιμο", 3, Question.EASY, Category.SPORTS);
        questions.add(q6);
        Question q7 = new Question("Ποιά από τις παρακάτω ομάδες δεν υπάρχει πλέον στο NBA;",
                "Atlanta Hawks", "New Orleans Hornets", "Orlando Magic", "Brooklyn Nets", 2, Question.EASY, Category.SPORTS);
        questions.add(q7);
        Question q8 = new Question("Πότε έλαβε χώρα η παρθενική εμφάνιση της εθνικής μας ομάδας ποδοσφαίρου στο Παγκόσμιο Κύπελο;",
                "Η.Π.Α. - 1994", "Ν. Κορέα - 2002", "Γερμανία - 2006", "Ν. Αφρική - 2010", 1, Question.EASY, Category.SPORTS);
        questions.add(q8);
        Question q9 = new Question("Σε ποιο άθλημα έχει κατακτήσει το χρύσο μετάλλιο ο Νίκος Κακλαμανάκης;",
                "Ιστιοπλοΐα", "Κανό\\Καγιάκ", "Κωπηλασία", "Ιστιοσανίδα", 1, Question.EASY, Category.SPORTS);
        questions.add(q9);
        Question q10 = new Question("Ποιος είναι ο σκόρερ του νικητήριου τέρματος στον τελικό του Ευρωπαϊκού Πρωταθλήματος του 2004, όπου η εθνική μας στέφθηκε πρωταθλήτρια Ευρώπης;",
                "Γιώργος Καραγκούνης", "Τραϊανός Δέλλας", "Θοδωρής Ζαγοράκης", "Άγγελος Χαριστέας", 4, Question.EASY, Category.SPORTS);
        questions.add(q10);
    }

    //TODO FILL THE QUESTIONS FOR EACH CATEGORY
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
