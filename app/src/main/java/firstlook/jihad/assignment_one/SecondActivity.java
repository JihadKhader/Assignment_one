package firstlook.jihad.assignment_one;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import firstlook.jihad.assignment_one.model.Subject;
import firstlook.jihad.assignment_one.model.SubjectDAO;
import firstlook.jihad.assignment_one.model.TestSubject;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {

    TextView totalQuestionsTextView;
    TextView qTextView;
    Button ansA, ansB, ansC, ansD;
    Button submitBtn;

    int score = 0;
    int totalQuestion = TestSubject.mathArrayQuestions.length;
    int totalChoices = TestSubject.mathArrayChoices.length;
    int totalAnswers = TestSubject.mathArrayAnswers.length;
    int currentQuestionIndex = 0;
    String selectedAnswer = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("Birzeit Elementary School"); // set the title
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.DarkOliveGreen))); // set the background color
        setContentView(R.layout.activity_second);

        totalQuestionsTextView = findViewById(R.id.total_questions);
        qTextView = findViewById(R.id.question);
        ansA = findViewById(R.id.ansA);
        ansB = findViewById(R.id.ansB);
        ansC = findViewById(R.id.ansC);
        ansD = findViewById(R.id.ansD);
        submitBtn = findViewById(R.id.submit_btn);

        ansA.setOnClickListener(this);
        ansB.setOnClickListener(this);
        ansC.setOnClickListener(this);
        ansD.setOnClickListener(this);
        submitBtn.setOnClickListener(this);

        totalQuestionsTextView.setText("Total questions : " + totalQuestion);

        loadNewQuestion();
    }


    @Override
    public void onClick(View v) {
        ansA.setBackgroundColor(getResources().getColor(R.color.DarkOliveGreen));
        ansB.setBackgroundColor(getResources().getColor(R.color.DarkOliveGreen));
        ansC.setBackgroundColor(getResources().getColor(R.color.DarkOliveGreen));
        ansD.setBackgroundColor(getResources().getColor(R.color.DarkOliveGreen));

        Button clickedButton = (Button) v;
        if (clickedButton.getId() == R.id.submit_btn) {
            if (selectedAnswer.equals(TestSubject.mathArrayAnswers[currentQuestionIndex])) {
                score++;
            }
            currentQuestionIndex++;
            loadNewQuestion();
        } else {
            selectedAnswer = clickedButton.getText().toString();
            clickedButton.setBackgroundColor(Color.RED);
        }

    }

    private void loadNewQuestion() {

        if (currentQuestionIndex == totalQuestion) {
            finishQuiz();
            return;
        }
        qTextView.setText(TestSubject.mathArrayQuestions[currentQuestionIndex]);
        ansA.setText(TestSubject.mathArrayChoices[currentQuestionIndex][0]);
        ansB.setText(TestSubject.mathArrayChoices[currentQuestionIndex][1]);
        ansC.setText(TestSubject.mathArrayChoices[currentQuestionIndex][2]);
        ansD.setText(TestSubject.mathArrayChoices[currentQuestionIndex][3]);

    }

     void finishQuiz() {
        String passStatus = "";
        if (score > totalQuestion * 0.60) {
            passStatus = "Passed";
        } else {
            passStatus = "Failed";
        }
        new AlertDialog.Builder(this)
                .setTitle(passStatus)
                .setMessage("Score is " + score + " out of " + totalQuestion)
                .setPositiveButton("Restart", (dialogInterface, i) -> restartQuiz())
                .setCancelable(false)
                .show();
    }

     void restartQuiz() {
        score = 0;
        currentQuestionIndex =0;
        loadNewQuestion();
    }
}