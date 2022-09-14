package ru.synergy.androidstartproj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.RadioButton;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

public class Calculator extends AppCompatActivity {

    private static final String LogcatTag = "CALCULATOR_ACTIVITY";
    private static final String LifecycleTag = "LIFECYCLE";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(LifecycleTag, "I'm onCreate(), and I'm started");
        setContentView(R.layout.activity_calculator);

        final Button calculate = (Button) findViewById(R.id.calc);


        // Context training
//        TextView textView = new TextView(this);
//        ListAdapter adapter = new SimpleCursorAdapter(getApplicationContext(),);
//
                //Доступ из класса активити -- наследник контекст
//        getSystemService(LAYOUT_INFLATER_SERVICE);

                // Shared prefs доступ с использованием контекста приложения

//        SharedPreferences prefs = getApplicationContext().getSharedPreferences("PREFS", MODE_PRIVATE);


        //// Intent - посылка (намерение) класс как механизм передачи сообщений как в одном приложении так и в сторонних






        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(LogcatTag, "Button have been pushed");
                try {
                    calculateAnswer();
                }
                catch (Exception e){
                    // Прерывание
//                    e.printStackTrace();
//                    Toast.makeText(Calculator.this,e.getMessage(), Toast.LENGTH_LONG).show();
//                    finish();

                    // Восстановление
                    e.printStackTrace();
                    e.toString(); // распечатает на косоль наше сообщение

                    Toast.makeText(Calculator.this,e.getMessage() + "of class " + e.getClass(), Toast.LENGTH_LONG).show();
                    dropFields();

                }

//                catch (IOException e){
//                    Toast.makeText(Calculator.this,e.getMessage(), Toast.LENGTH_LONG).show();
//                    finish();
//                }
//
//                catch (ArithmeticException e){
//                    Toast.makeText(Calculator.this,e.getMessage(), Toast.LENGTH_LONG).show();
//                    finish();
//                }


                Intent i =new Intent(Calculator.this, MainActivity.class); // Написать письмо
                //startActivity(i); // отправить его
            }

        });
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.d(LifecycleTag, "I'm onStart(), and I'm started");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(LifecycleTag, "I'm onStop(), and I'm started");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(LifecycleTag, "I'm onDestroy(), and I'm started");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(LifecycleTag, "I'm onPause(), and I'm started");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(LifecycleTag, "I'm onResume(), and I'm started");
    }
    private void dropFields(){
        EditText numOne = (EditText) findViewById(R.id.editTextNumberDecimal);
        EditText numTwo = (EditText) findViewById(R.id.editTextNumberDecimal2);

        RadioButton add = (RadioButton) findViewById(R.id.add);
        RadioButton sub = (RadioButton) findViewById(R.id.subtract);
        RadioButton multiply = (RadioButton) findViewById(R.id.multiple);
        RadioButton divide = (RadioButton) findViewById(R.id.divide);

        numOne.setText("0");
        numTwo.setText("0");
        add.setChecked(true);

        TextView answer = (TextView) findViewById(R.id.result);

        answer.setText("How we have problems. Try again later");
    }

    private void calculateAnswer() throws ArithmeticException, IOException {
        EditText numOne = (EditText) findViewById(R.id.editTextNumberDecimal);
        EditText numTwo = (EditText) findViewById(R.id.editTextNumberDecimal2);

        RadioButton add = (RadioButton) findViewById(R.id.add);
        RadioButton sub = (RadioButton) findViewById(R.id.subtract);
        RadioButton multiply = (RadioButton) findViewById(R.id.multiple);
        RadioButton divide = (RadioButton) findViewById(R.id.divide);

        numOne.setText("0");
        numTwo.setText("0");
        add.setChecked(true);

        TextView answer = (TextView) findViewById(R.id.result);

        Log.d(LogcatTag, "all views have been founded");

//        try {
//           // int a = 25 / 0;
//            throw new ArithmeticException("I am generated exception");
//        } catch (ArithmeticException e) {
//            Toast.makeText(this, "There is a problem inside the app", Toast.LENGTH_SHORT).show();
//            finish();
//        }

        float numone=0;
        float numtwo=0;
        String num1 = numOne.getText().toString();
        String num2 = numTwo.getText().toString();

        if(!num1.equals("") && num1 != null){

        numone = Integer.parseInt(numOne.getText().toString());}
        if(!num2.equals("") && num2 != null){
        numtwo = Integer.parseInt(numTwo.getText().toString());
        }

        Log.d(LogcatTag, "Successfully grabbed from input fields");
        Log.d(LogcatTag, "numone is: " + numone + " ; " + " numtwo is: " + numtwo);

        float solution = 0;

        if(add.isChecked()){
            Log.d(LogcatTag, "Operation is add");
            solution = numone + numtwo;
        }
        if(sub.isChecked()){
            Log.d(LogcatTag, "Operation is sub");
            solution = numone - numtwo;
        }
        if(multiply.isChecked()){
            Log.d(LogcatTag, "Operation is multiply");
            solution = numone * numtwo;
        }
        if(divide.isChecked()){
            Log.d(LogcatTag, "Operation is divide");
            if (numtwo == 0){
                Toast.makeText(this,"Number two Cannot be zero", Toast.LENGTH_SHORT).show();
                return;
            }

            solution = numone / numtwo;
        }
        Log.d(LogcatTag, "The result operations is: " + solution);

        // Log.wtf() // What a Terrible Failure == error

        answer.setText("The answer is "+ solution);

//        Context contextApp = getApplicationContext();
//        Context context = getBaseContext();


        switch ( (int) (Math.random()*3)) {
            case 0:
                throw new ArithmeticException("I am generated arithmetical exception");
            case 1:
                throw new IOException("I am generated ioexception");

        }

    }
}