package com.example.myapplication.TypeRacer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.TypeRacer.TypeRacerEnd;

import java.util.Locale;

public class TypeRacerSecondQ extends AppCompatActivity {

    TextView question, message;
    private TextView countDown;
    EditText answer;
    String questionInString;
    long startTime, endTime;
    private static final long COUNTDOWN_IN_MILLS = 30000;
    private long timeLeftInMillis;
    private CountDownTimer countDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_type_racer_second_q);
        question = (TextView) findViewById(R.id.questionTextView);
        answer = findViewById(R.id.answerEditText);
        questionInString = question.getText().toString();
        message = findViewById(R.id.messageTextView);
        countDown = findViewById(R.id.countDownTextView);
        //System.out.println("here");

        answer.addTextChangedListener( new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                String current = answer.getText().toString();
                if (current.length() == 1){
                    startTime = System.currentTimeMillis();
                    message.setText("Started");
                    timeLeftInMillis = COUNTDOWN_IN_MILLS;
                    startCountDown();
                }
                if(current.equals(questionInString)){
                    countDownTimer.cancel();
                    endTime = System.currentTimeMillis();
                    long currentTime = (endTime-startTime)/1000;
                    message.setText("Completed in" + " "+ currentTime + " " + "seconds");
                    answer.setEnabled(false);
                    answer.clearFocus();

                    Intent goToEndGame = new Intent(getApplicationContext(), TypeRacerEnd.class);
                    startActivity(goToEndGame);

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