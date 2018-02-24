package com.example.mamohamed.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button trueButton;
    Button falseButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // connect Buttons to my variables
        trueButton =(Button) findViewById(R.id.trueButton);
        falseButton =(Button) findViewById(R.id.falseButton);

        // toast : short msg to True Button

        View.OnClickListener myListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast myToast = Toast.makeText(getApplicationContext(),"True Pressed",Toast.LENGTH_SHORT);
                myToast.show();
            }
        };
        trueButton.setOnClickListener(myListener);


        // toast : short msg to False Button

        View.OnClickListener myListener2 = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast myToast = Toast.makeText(getApplicationContext(),"False Pressed",Toast.LENGTH_SHORT);
                myToast.show();
            }
        };
        falseButton.setOnClickListener(myListener2);
    }
}
