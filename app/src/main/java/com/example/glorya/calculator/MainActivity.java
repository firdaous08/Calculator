package com.example.glorya.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    //declaring buttons array (from 0 to 9)
    private Button numbersButtons[] = new Button[10], operatorButtons[] = new Button[7];
    private TextView inputTextView, resultTextView;

    //values variables
    private String inputString = "", resultString;
    private int resultNumber = 0, tempNumber = 0;

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

        /*
        * 0 = Clear button
        * 1 = Plus button
        * 2 = Minus button
        * 3 = Division button
        * 4 = Multiplication button
        * 5 = Dot button
        * */

        operatorButtons[0] = (Button) findViewById(R.id.bClear);
        operatorButtons[1] = (Button) findViewById(R.id.bAdd);
        operatorButtons[2] = (Button) findViewById(R.id.bSub);
        operatorButtons[3] = (Button) findViewById(R.id.bDiv);
        operatorButtons[4] = (Button) findViewById(R.id.bMult);
        operatorButtons[5] = (Button) findViewById(R.id.bDot);
        operatorButtons[6] = (Button) findViewById(R.id.bEqual);

        //init text views
        inputTextView = (TextView) findViewById(R.id.inputTextView);
        resultTextView = (TextView) findViewById(R.id.resultTextView);


        //adding listeners for numbers buttons
        for(Button numberButton: numbersButtons){
            numberButton.setOnClickListener(this);
        }

        //adding listeners for operators buttons
        for(Button operatorButton: operatorButtons){
            operatorButton.setOnClickListener(this);
        }

    }

    @Override
    public void onClick(View v) {

        //checking which button is clicked
        for(Button numberButton: numbersButtons){
            if(v.getId() == numberButton.getId()){

                String buttonText = numberButton.getText().toString();

                //logging the button value ---IGNORE THIS LINE---.
                Log.v("Number clicked",buttonText);

                /* check if input has only a 0 in it, if it does then it can only
                 * be replaced with numbers from 1 to 9
                 */
                if(inputString.equals("0") && buttonText.equals("0")){
                    inputString = buttonText;
                }
                else{
                    inputString = inputString.concat(buttonText);
                }
            }
        }

        for(Button operatorButton: operatorButtons){
            if(v.getId() == operatorButton.getId()){

                Log.v("button text:" , operatorButton.getText().toString());

                if(operatorButton.getText().toString().equals("+") && !inputString.equals("") ){
                    tempNumber += Integer.parseInt(inputString);
                    inputString = "";
                }

                if(operatorButton.getText().toString().equals("=")){
                    resultNumber += tempNumber;
                    tempNumber = 0;
                    resultNumber += Integer.parseInt(inputString);
                    resultTextView.setText(Integer.toString(resultNumber));
                    inputTextView.setText("0");
                }

                if(operatorButton.getText().toString().equals("C")){
                    inputString = "";
                    resultNumber = 0;
                    resultTextView.setText("");
                }
            }
        }

        //this allows the textview to be refreshed whenever is any button is clicked.
        inputTextView.setText(inputString);
    }

    private static String removeLastChar(String str) {
        return str.substring(0, str.length() - 1);
    }


}
