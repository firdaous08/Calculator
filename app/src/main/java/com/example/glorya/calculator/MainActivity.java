package com.example.glorya.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    //declaring buttons array (from 0 to 9)
    private Button numbersButtons[] = new Button[10];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //init button
        numbersButtons[0] = (Button) findViewById(R.id.b0);
        numbersButtons[1] = (Button) findViewById(R.id.b1);
        numbersButtons[2] = (Button) findViewById(R.id.b2);
        numbersButtons[3] = (Button) findViewById(R.id.b3);
        numbersButtons[4] = (Button) findViewById(R.id.b4);
        numbersButtons[5] = (Button) findViewById(R.id.b5);
        numbersButtons[6] = (Button) findViewById(R.id.b6);
        numbersButtons[7] = (Button) findViewById(R.id.b7);
        numbersButtons[8] = (Button) findViewById(R.id.b8);
        numbersButtons[9] = (Button) findViewById(R.id.b9);

        //adding listeners for buttons
        for(Button numberButton: numbersButtons){
            numberButton.setOnClickListener(this);
        }

    }

    @Override
    public void onClick(View v) {

        //checking which button is clicked
        for(Button numberButton: numbersButtons){
            if(v.getId() == numberButton.getId()){

                //logging the button value
                Log.v("Number clicked",numberButton.getText().toString());

            }
        }


    }
}
