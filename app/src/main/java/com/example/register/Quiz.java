package com.example.register;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Quiz extends AppCompatActivity implements View.OnClickListener {

    TextView totalQuestionsTextView;
    TextView questionTextView;

    Button ansA, ansB, ansC, ansD;
    Button submitBtn;

    int score = 0;
    int totalQuestion = QuestionAnswer.question.length;
    int currentQuestionIndex = 0;
    String selectedAnswer = "";

    List<Integer> shuffledQuestionIndices;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_layout);

        totalQuestionsTextView = findViewById(R.id.total_question);
        questionTextView = findViewById(R.id.question);
        ansA = findViewById(R.id.ans_A);
        ansB = findViewById(R.id.ans_B);
        ansC = findViewById(R.id.ans_C);
        ansD = findViewById(R.id.ans_D);
        submitBtn = findViewById(R.id.submit_btn);

        ansA.setOnClickListener(this);
        ansB.setOnClickListener(this);
        ansC.setOnClickListener(this);
        ansD.setOnClickListener(this);
        submitBtn.setOnClickListener(this);

        totalQuestionsTextView.setText("Total questions: " + totalQuestion);

        shuffledQuestionIndices = new ArrayList<>();
        for (int i = 0; i < totalQuestion; i++) {
            shuffledQuestionIndices.add(i);
        }
        Collections.shuffle(shuffledQuestionIndices); // Shuffle the questions

        loadNewQuestion();
    }

    @Override
    public void onClick(View view) {
        ansA.setBackgroundColor(Color.WHITE);
        ansB.setBackgroundColor(Color.WHITE);
        ansC.setBackgroundColor(Color.WHITE);
        ansD.setBackgroundColor(Color.WHITE);

        Button clickedButton = (Button) view;
        if (clickedButton.getId() == R.id.submit_btn) {
            if (selectedAnswer.equals(QuestionAnswer.correctAnswers[shuffledQuestionIndices.get(currentQuestionIndex)])) {
                score++;
            }
            currentQuestionIndex++;
            loadNewQuestion();
        } else {
            selectedAnswer = clickedButton.getText().toString();
            clickedButton.setBackgroundColor(Color.MAGENTA);
        }
    }

    void loadNewQuestion() {
        if (currentQuestionIndex == totalQuestion) {
            finishQuiz();
            return;
        }

        int questionNumber = currentQuestionIndex + 1; // Calculate the question number

        int randomQuestionIndex = shuffledQuestionIndices.get(currentQuestionIndex);

        // Display the question number along with the question text
        String questionText = "Question " + questionNumber + ": " + QuestionAnswer.question[randomQuestionIndex];
        questionTextView.setText(questionText);

        ansA.setText(QuestionAnswer.choices[randomQuestionIndex][0]);
        ansB.setText(QuestionAnswer.choices[randomQuestionIndex][1]);
        ansC.setText(QuestionAnswer.choices[randomQuestionIndex][2]);
        ansD.setText(QuestionAnswer.choices[randomQuestionIndex][3]);
    }


    void finishQuiz() {
        String passStatus = "";
        if (score > totalQuestion * 0.60) {
            passStatus = "Passed";
            // If passed, show a message without the option to restart
            new AlertDialog.Builder(this)
                    .setTitle(passStatus)
                    .setMessage("Congratulations! You passed. Your score is " + score + " out of " + totalQuestion)
                    .setPositiveButton("OK", null)
                    .setCancelable(false)
                    .show();
        } else {
            passStatus = "Failed";
            // If failed, show a message with the option to restart
            new AlertDialog.Builder(this)
                    .setTitle(passStatus)
                    .setMessage("Unfortunately, you did not pass. Your score is " + score + " out of " + totalQuestion)
                    .setPositiveButton("Resubmit Quiz", (dialogInterface, i) -> restartQuiz())
                    .setCancelable(false)
                    .show();
        }
    }


    void restartQuiz() {
        score = 0;
        currentQuestionIndex = 0;

        Collections.shuffle(shuffledQuestionIndices); // Shuffle the questions again

        loadNewQuestion();
    }
}
