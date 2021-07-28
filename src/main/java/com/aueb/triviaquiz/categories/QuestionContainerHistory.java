package com.aueb.triviaquiz.categories;

import com.aueb.triviaquiz.model.Category;
import com.aueb.triviaquiz.model.Question;

import java.util.ArrayList;
import java.util.List;

public class QuestionContainerHistory {

    private List<Question> questions;

    public QuestionContainerHistory() {
        questions = new ArrayList<>();
        questionsGenerator();
    }

    private void questionsGenerator() {
        generateEasyQuestions();
        generateMediumQuestions();
        generateHardQuestions();
    }

    private void generateEasyQuestions() {
        Question q1 = new Question("Πως λεγόταν η εχθρική συμμαχία του Β' Παγκοσμίου πολέμου;", " Δυνάμεις του Κακού",
                "Δυνάμεις του Άξονα", "Δύναμεις του Νότου", "Συμμαχία του Άξονα", 2, Question.EASY, Category.HISTORY);
        questions.add(q1);
        Question q2 = new Question("Ποιός ήταν ο πρώτος κυβερνήτης του Ελληνικού Κράτους;", "Ιωάννης Καποδήστριας","Ελευθέριος Βενιζέλος",
                "Ανδρέας Παπανδρέου" , "Ιωάννης Μεταξάς", 1,  Question.EASY, Category.HISTORY);
        questions.add(q2);
        Question q3 = new Question("Στη μάχη των Θερμοπυλών, πόσοι Θεσπιείς αγωνίστηκαν στο πλάι των 300 Σπαρτιατών;", "1000",
                "300" , "700", "500", 3, Question.EASY, Category.HISTORY);
        questions.add(q3);
        Question q4 = new Question("Το 1814, ο Εμμανουήλ Ξανθός, ο Νικόλαος Σκουφάς και Ο Αθανάσιος Τσακάλωφ ποιά μυστική οργάνωση ίδρυσαν για τη προετοιμασία την Ελληνικής Επανάστασης;",
                "Σύλλογος Επαναστατών Ελλάδας", "Επαναστατική Εταιρεία", "Φιλικό Κίνημα", "Φικική Εταιρεία", 4 ,Question.EASY, Category.HISTORY);
        questions.add(q4);
        Question q5 = new Question("Κατά την διάρκεια του Α' Παγκοσμίου Πολέμου, πως ονομάστηκε η διαμάχη του Ελ. Βενιζέλου με τον Βασιλιά Κωνσταντίνου;",
                "Εθνικός Διχασμός", "Εθνική Διαμάχη", "Διχασμός της Κυβέρνησης", "Η Μεγάλη Διαμάχη",1,Question.EASY, Category.HISTORY);
        questions.add(q5);
        Question q6 = new Question("Ποιός λαός κατέκτησε τα ελληνικά εδάφη, γεγονός που συνέβαλε το τέλος του Αρχαίου Ελληνιστικού Πολιτισμού;",
                "Οι Βαυαροί", "Οι Γαλάτες", "Οι Ρωμαίοι", "Οι Πέρσες", 3, Question.EASY, Category.HISTORY);
        questions.add(q6);
        Question q7 = new Question("Μετά το τέλος του Β' Παγκοσμίου Πολέμου, ποιός οργανισμός ιδρύθηκε για να αποτρέψει την έκρυξη ενός νέου πολέμου;",
                "ΝΑΤΟ", "ΟΗΕ", "Ευρωπαική Ένωση", "Ένωση κρατών", 2, Question.EASY, Category.HISTORY);
        questions.add(q7);
        Question q8 = new Question("Ποιά πόλη της Ρωμαικής Αυτοκρατορίας ήταν η 2η πρωτεύουσά της;",
                "Ρώμη", "Κων/πόλη", "Αλεξάνδρεια", "Αθήνα", 2, Question.EASY, Category.HISTORY);
        questions.add(q8);
        Question q9 = new Question("Πώς λεγόταν ο πατέρας του Μ. Αλεξάνδου;", "Φίλλιπος Β'", "Σοφοκλής",
                "Αλέξανδρος Α'", "Αριστοτέλης", 1, Question.EASY, Category.HISTORY);
        questions.add(q9);
        Question q10 = new Question("Ποιο ήταν το τελευταίο γεωγραφικό τμήμα που προσαρτήθηκε στο ελληνικό κράτος;",
                "Δυτ. Θράκη", "Κρήτη", "Επτάνησα", "Δωδεκάνησα", 4, Question.EASY, Category.HISTORY);
        questions.add(q10);
    }

    private void generateMediumQuestions() {
        Question q1 = new Question("Ποια χρονολογία πραγματοποιήθηκε η μάχη των Θερμοπυλών;",
                "480 π.Χ.", "380 π.Χ.", "400 π.Χ.", "379 π.Χ.", 1, Question.MEDIUM, Category.HISTORY);
        questions.add(q1);
        Question q2 = new Question("Ποιός ήταν ο στρατηγός των Αθηναίων στην μάχη του Μαραθώνα;",
                "Περικλής", "Επαμεινώνδας", "Ικτήνιος", "Μιλτιάδης", 4, Question.MEDIUM, Category.HISTORY);
        questions.add(q2);
        Question q3 = new Question("Σε ποιά περιοχή της Γαλλίας έγινε η γνωστή απόβαση από τους Συμμάχους, η οποία αποτέλεσε σημαντικό παράγοντα για το τέλος του Β' Παγκοσμίου Πολέμους",
                "Μασσαλία", "Βρετανία", "Νορμανδία", "Δουνκέρκη", 3, Question.MEDIUM, Category.HISTORY);
        questions.add(q3);
        Question q4 = new Question("Ποια χρονολογία πραγματοποιήθηκε η ένταξη της Ελλάδας στην Ευρωπαική Ένωση;",
                "1993", "1981", "2002", "1977", 2, Question.MEDIUM, Category.HISTORY);
        questions.add(q4);
        Question q5 = new Question("Κατα την διάρκεια της Ελληνικής Επανάστασης, ποιά χρονολογία πραγματοποιήθηκε η ηρωική Έξοδος του Μεσολογγίου;",
                "1826", "1830", "1822", "1824", 1, Question.MEDIUM, Category.HISTORY);
        questions.add(q5);
        Question q6 = new Question("Σε ποιά πόλη της Σοβιετικής Ένωσης, ο Σοβιέτικος Στρατός κατατρόπωσε τον Γερμανικό Στρατό δίνοντας μία απο τις πιο φρικτές μάχες του πολέμου;",
                "Λένινγκραντ", "Μόσχα", "Στάλινγραντ", "Οδησσός", 3, Question.MEDIUM, Category.HISTORY);
        questions.add(q6);
        Question q7 = new Question("Ποιός ήταν ο τελευταίος Βυζαντινός Αυτοκράτορας;", "Ιουστινιανός",
                "Κωνσταντίνος Παλαιολόγος", "Ανδρόνικος", "Θεοδόσιος", 2, Question.MEDIUM, Category.HISTORY);
        questions.add(q7);
        Question q8 = new Question("Ποιό από τα παρακάτω δεν αποτελεί έργο του Ευριπίδη;",
                "Ηλέκτρα", "Ελένη", "Αντιγόνη", "Τρωάδες", 3, Question.MEDIUM, Category.HISTORY);
        questions.add(q8);
        Question q9 = new Question("Πόσοι τύραννοι κυβερνούσαν την Αθήνα το 404 π.Χ.;",
                "Τριακόσιοι", "Σαράντα", "Τριάντα", "Είκοσοι", 3, Question.MEDIUM, Category.HISTORY);
        questions.add(q9);
        Question q10 = new Question("Σε ποιά χώρα εισέβαλαν οι Γερμανοί το 1939 με αποτέλεσμα την έναρξη του Β΄ Παγκοσμίου Πολέμου;",
                "Πρωσία", "Γαλλία", "Αυστροουγγαρία", "Πολωνια", 4, Question.MEDIUM, Category.HISTORY);
        questions.add(q10);
    }

    private void generateHardQuestions() {
        Question q1 = new Question("Ποιά ήταν η αφορμή για την έναρξη του Α΄ Παγκοσμίου Πόλεμου;",
                "Η δολοφονία του αρχιδούκα διάδοχου της Αυστρίας στο Σαράγεβο", "Η υπογραφή της τριπλής Συμμαχίας",
                "Η εισβολή της Γερμανίας στην Αυστροουγγαρία", "Η επίθεση της Αυστίας στην Σερβία", 1, Question.HARD, Category.HISTORY);
        questions.add(q1);
        Question q2 = new Question("Πόσα χρόνια διήρκησε ο Πελοποννησιακός Πόλεμος; ",
                "40", "27", "30", "15", 2, Question.HARD, Category.HISTORY);
        questions.add(q2);
        Question q3 = new Question("Ποιό έτος η Ελλάδα εντάχτηκε στο πλευρό της Αντάντ στον Α' Παγκόσμιο Πόλεμο;",
                "1915", "1916", "1917", "1918", 3, Question.HARD, Category.HISTORY);
        questions.add(q3);
        Question q4 = new Question("Σε ποιά περιοχή του εξωτερικού πραγματοποιήθηκε η πρώτη επαναστατική ενέργεια της Ελληνικής Επανάστασης;",
                "Μολδοβλαχία", "Οδησσό", "Μόσχα", "Ανδριανούπολη", 1, Question.HARD, Category.HISTORY);
        questions.add(q4);
        Question q5 = new Question("Ποια απο τις παρακάτω χώρες δεν συμμετείχε στον Β΄ Παγκόσμιο Πόλεμο;",
                "Φιλανδία", "Δανία", "Ελβετία", "Βέλγιο", 3, Question.HARD, Category.HISTORY);
        questions.add(q5);
        Question q6 = new Question("Σε ποιά πόλη των Η.Π.Α. δολοφονήθηκε ο αμερικανός πρόεδρος Τζον Φ. Κέννεντυ;",
                "Ντάλλας", "Νέα Υόρκη", "Ουάσινγκτον", "Ατλάντα", 1, Question.HARD, Category.HISTORY);
        questions.add(q6);
        Question q7 = new Question("Ποιός ρωμαίος αυτοκράτορας είναι γνωστός για την μεγάλη πυρκαγιά της Ρώμης το 64 μ.Χ.;",
                "Ανδριανός", "Κόμμοδος", "Νέρων", "Τραϊανός", 3, Question.HARD, Category.HISTORY);
        questions.add(q7);
        Question q8 = new Question("Σε ποια συνθήκη οι περιοχές της Μ. Ασίας και την Ανατολικής Θράκης προσαρτήθηκαν στο Ελληνικό Κράτος;",
                "Λωζάνης", "Σερβών", "Βερσαλλιών", "Παρισιού",2 , Question.HARD, Category.HISTORY);
        questions.add(q8);
        Question q9 = new Question("Ποιος Αιγύπτιος στρατιώτικος στάλθηκε στην Πελοπόννησο για να βοηθήσει τους Οθωμανούς;",
                "Ιμπραήμ", "Ναχάς", "Φαρούκ", "Ναγκίμπ", 1, Question.HARD, Category.HISTORY);
        questions.add(q9);
        Question q10 = new Question("Ποιος άνρθωπος ήταν ο πρώτος που έφτασε στο διάστημα κατα τη διάρκεια του Ψυχρού Πολέμου;",
                "Νιλ Άμστρονγκ", "Γιούρι Γκαγκάριν", "Μπόρις Εγκόροφ ", "Σκοτ Κέλι", 2, Question.HARD, Category.HISTORY);
        questions.add(q10);
    }

    public List<Question> getQuestions() {
        return questions;
    }

}
