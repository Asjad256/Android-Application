package com.example.myapplication;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


import java.util.Locale;




public class TypeRacer extends AppCompatActivity {

    TextView question, textView2;
    EditText answer;
    String text;
    long startTime;
    long endTime;
    private static final long COUNTDOWN_IN_MILLS = 30000;
    private long timeLeftInMillis;
    private CountDownTimer countDownTimer;
    private TextView countDown;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_type_racer);
        question = (TextView) findViewById(R.id.questionTextView);
        answer = findViewById(R.id.answerEditText);
        text = question.getText().toString();
        textView2 = findViewById(R.id.textView2);
        countDown = findViewById(R.id.countDownTextView);
    //System.out.println("here");

        answer.addTextChangedListener( new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                String current = answer.getText().toString();
                if (current.length() ==1){
                    startTime = System.currentTimeMillis();
                    //textView2.setText("Started");
                    timeLeftInMillis = COUNTDOWN_IN_MILLS;
                    startCountDown();
                }
                if(current.equals(text)){
                    countDownTimer.cancel();
                    endTime = System.currentTimeMillis();
                    long currentTime = (endTime-startTime)/1000;
                    //textView2.setText("finished in" + " "+currentTime + " " + "seconds");
                    answer.setEnabled(false);
                    answer.clearFocus();

                    Intent goToNextQuestion = new Intent(getApplicationContext(), TypeRacerSecondQ.class);
                    startActivity(goToNextQuestion);

                }

            }

            @Override
            public void afterTextChanged(Editable s) {


            }
        });
    }

    private void startCountDown(){
        countDownTimer = new CountDownTimer(timeLeftInMillis, 1000){
            public void onTick(long millisUntilFinished){
                timeLeftInMillis = millisUntilFinished;
                updateCountDownText();
            }
            public void onFinish(){
                timeLeftInMillis = 0;
                updateCountDownText();
            }

        }.start();
    }

    private void updateCountDownText(){
        int minutes = (int)(timeLeftInMillis/1000)/60;
        int seconds = (int)(timeLeftInMillis/1000) % 60;

        String timeFormated = String.format(Locale.getDefault(),"%02d:%02d",minutes,seconds);

        countDown.setText(timeFormated);
    }






    public <T extends View> T findViewById(int id) {
        return super.findViewById(id);
    }

    protected void onDestroy(){
        super.onDestroy();
        if(countDownTimer != null){
            countDownTimer.cancel();
        }
    }
}