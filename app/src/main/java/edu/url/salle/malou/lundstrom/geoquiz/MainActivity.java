package edu.url.salle.malou.lundstrom.geoquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import edu.url.salle.malou.lundstrom.geoquiz.model.Question;

public class MainActivity extends AppCompatActivity {

    private Button mTrueButton;
    private Button mFalseButton;
    private Button mNextButton;
    private Button mBackButton;
    private TextView mQuestionTextView;
    private int mCurrentIndex = 0;

    private Question[] mQuestionBank = new Question[] {
            new Question(R.string.question_text, true),
            new Question(R.string.question_text_2, false),
            new Question(R.string.question_text_3, false),
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mQuestionTextView = findViewById(R.id.questionTextView);
        updateQuestion();

        mTrueButton = findViewById(R.id.trueButton);
        mTrueButton.setOnClickListener(v -> checkAnswer(true));

        mFalseButton = findViewById(R.id.falseButton);
        mFalseButton.setOnClickListener(v -> checkAnswer(false));

        mNextButton = findViewById(R.id.nextButton);
        mNextButton.setOnClickListener(v -> nextQ());

        mNextButton = findViewById(R.id.backButton);
        mNextButton.setOnClickListener(v -> backQ());
    }

    private void updateQuestion() {
        int questionTextResId = mQuestionBank[mCurrentIndex].getTextId();
        mQuestionTextView.setText(questionTextResId);
    }


    private void checkAnswer(boolean userAnswer) {
        boolean correctAnswer = mQuestionBank[mCurrentIndex].isAnswerTrue();
        int toastMessageId;

        if (userAnswer == correctAnswer) {
            toastMessageId = R.string.correct_toast;
        } else {
            toastMessageId = R.string.incorrect_toast;
        }

        Toast.makeText(MainActivity.this, toastMessageId, Toast.LENGTH_SHORT).show();

        // Move to the next question
        mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.length;
        updateQuestion();
    }

    private void nextQ(){
        mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.length;
        updateQuestion();
    }
    private void backQ(){
        mCurrentIndex = (mCurrentIndex - 1 + mQuestionBank.length) % mQuestionBank.length;
        updateQuestion();
    }

}