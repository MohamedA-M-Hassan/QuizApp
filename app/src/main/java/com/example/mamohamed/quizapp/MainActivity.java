package com.example.mamohamed.quizapp;

import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Variable to connect with XML

    Button trueButton;
    Button falseButton;
    TextView questionView;
    TextView scoreView;
    ProgressBar mProgressBar;

    //Progress Bar difference
    final int   PROGRESS_BAR_INCREMENT = 8;
    int index =0;
    int score = 0;


    // String of Question with ID from XML
    private TrueFalse questions[] = new TrueFalse[]{new TrueFalse(R.string.q1,true)
            ,new TrueFalse(R.string.q2,false),
            new TrueFalse(R.string.q3,true)};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // added in last part of app
        // Added to avoid any bugs when Rotating
        if(savedInstanceState != null)
        {
            score = savedInstanceState.getInt("ScoreKey");
            index = savedInstanceState.getInt("IndexKey");
        }
        else
        {
            index = 0;
            score = 0;
        }


        if(score == questions.length)
        {score = 0;}



        // connect Buttons to my variables
        trueButton =(Button) findViewById(R.id.trueButton);
        falseButton =(Button) findViewById(R.id.falseButton);
        questionView= (TextView) findViewById(R.id.question_text);
        scoreView = (TextView) findViewById(R.id.score);
        scoreView.setText("Score is " + score + " /3");
        mProgressBar = (ProgressBar) findViewById(R.id.progressBar);
        questionView.setText(questions[index].getmQuestionId());


        // True Button effect when you click
        View.OnClickListener myListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // toast : short msg to True Button
                Toast myToast = Toast.makeText(getApplicationContext(),"True Pressed",Toast.LENGTH_SHORT);
                myToast.show();


                if(questions[index].ismAnswer()){

                    score++;
                    scoreView.setText("Score is " + score + "/" + questions.length);
                    mProgressBar.incrementProgressBy(PROGRESS_BAR_INCREMENT); // PROGRESS_BAR_INCREMENT = 8
                }
                updateQuestion();
            }
        };
        trueButton.setOnClickListener(myListener);




        // False Button effect when you click
        View.OnClickListener myListener2 = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // toast : short msg to False Button
                Toast myToast = Toast.makeText(getApplicationContext(),"False Pressed",Toast.LENGTH_SHORT);
                myToast.show();
                if(!questions[index].ismAnswer()){
                    score++;
                    mProgressBar.incrementProgressBy(8);
                    scoreView.setText("Score is " + score + " /3");
                }
                updateQuestion();
            }
        };
        falseButton.setOnClickListener(myListener2);
    }

    private void updateQuestion()
    {
        index = (index + 1) % questions.length;
        questionView.setText(questions[index].getmQuestionId());
    }

    // what we need to save it's state when make Rotate
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("ScoreKey",score);
        outState.putInt("IndexKey",index);
    }
}
