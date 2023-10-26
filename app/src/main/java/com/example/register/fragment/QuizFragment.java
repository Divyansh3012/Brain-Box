package com.example.register.fragment;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.register.QuestionAnswer;
import com.example.register.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link QuizFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class QuizFragment extends Fragment implements View.OnClickListener{

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    TextView totalQuestionsTextView;
    Context context;
    private View view;
    TextView questionTextView, hh;

    Button ansA, ansB, ansC, ansD;
    Button submitBtn;

    int score = 0;
    int totalQuestion = QuestionAnswer.question.length;
    int currentQuestionIndex = 0;
    String selectedAnswer = "";

    List<Integer> shuffledQuestionIndices;
    public QuizFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment QuizFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static QuizFragment newInstance(String param1, String param2) {
        QuizFragment fragment = new QuizFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        context = container.getContext();
        view = inflater.inflate(R.layout.quiz_layout, container, false);

        totalQuestionsTextView = view.findViewById(R.id.total_question);
        questionTextView = view.findViewById(R.id.question);
        ansA = view.findViewById(R.id.ans_A);
        ansB = view.findViewById(R.id.ans_B);
        ansC = view.findViewById(R.id.ans_C);
        ansD = view.findViewById(R.id.ans_D);
        submitBtn = view.findViewById(R.id.submit_btn);

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
        return view;
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
            new AlertDialog.Builder(context)
                    .setTitle(passStatus)
                    .setMessage("Congratulations! You passed. Your score is " + score + " out of " + totalQuestion)
                    .setPositiveButton("OK", null)
                    .setCancelable(false)
                    .show();
        } else {
            passStatus = "Failed";
            // If failed, show a message with the option to restart
            new AlertDialog.Builder(context)
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
        // Inflate the layout for this fragment


}