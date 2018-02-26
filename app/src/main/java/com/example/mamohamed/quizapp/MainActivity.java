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
    Button trueButton;
    Button falseButton;

    TextView questionView;
    TextView scoreView;
    ProgressBar mProgressBar;
    final int   PROGRESS_BAR_INCREMENT = 8;
    int index =0;
    int scoer = 0;
    // String of Question with ID from XML
    private TrueFalse questions[] = new TrueFalse[]{new TrueFalse(R.string.q1,true)
            ,new TrueFalse(R.string.q2,false),
            new TrueFalse(R.string.q3,true)};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        if(savedInstanceState !=null)
        {
            scoer = savedInstanceState.getInt("ScoreKey");
            index = savedInstanceState.getInt("IndexKey");
        }
        else
        {
            index = 0;
            scoer = 0;
        }
        if(scoer == questions.length)
        {scoer = 0;}
        // connect Buttons to my variables
        trueButton =(Button) findViewById(R.id.trueButton);
        falseButton =(Button) findViewById(R.id.falseButton);
        questionView= (TextView) findViewById(R.id.question_text);
        scoreView = (TextView) findViewById(R.id.score);
        scoreView.setText("Score is " + scoer + " /3");
        mProgressBar = (ProgressBar) findViewById(R.id.progressBar);
        // toast : short msg to True Button
        questionView.setText(questions[index].getmQuestionId());



        View.OnClickListener myListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast myToast = Toast.makeText(getApplicationContext(),"True Pressed",Toast.LENGTH_SHORT);

                myToast.show();
                if(questions[index].ismAnswer()){

                    scoer++;
                    scoreView.setText("Score is " + scoer + " /3");
                    mProgressBar.incrementProgressBy(8);
                }
                updateQuestion();
            }
        };
        trueButton.setOnClickListener(myListener);


        // toast : short msg to False Button

        View.OnClickListener myListener2 = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast myToast = Toast.makeText(getApplicationContext(),"False Pressed",Toast.LENGTH_SHORT);
                myToast.show();
                if(!questions[index].ismAnswer()){
                    scoer++;
                    mProgressBar.incrementProgressBy(8);
                    scoreView.setText("Score is " + scoer + " /3");
                }
                updateQuestion();
            }
        };
        falseButton.setOnClickListener(myListener2);
    }
    private void updateQuestion()
    {
        index = (index + 1)%questions.length;
        questionView.setText(questions[index].getmQuestionId());
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("ScoreKey",scoer);
        outState.putInt("IndexKey",index);
    }
}
