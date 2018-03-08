package com.example.android.scandalquizzapp;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class BonusQPageActivity extends AppCompatActivity {


    String chosenAnswerBonus;
    EditText bonusQuestion;
    ImageView correspondingImage;
    TextView backToQuiz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bonus_q_page);
        bonusQuestion = (EditText) findViewById(R.id.bonus_answer);
        correspondingImage = (ImageView) findViewById(R.id.bonus_indictaor);
        backToQuiz = (TextView) findViewById(R.id.back_to_quiz);
        backToQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainPage = new Intent(BonusQPageActivity.this, MainActivity.class);
                startActivity(mainPage);
            }
        });


    }


    public void bonusScore(View v) {

        // bonus question score is displayed with either a tick or cross depending on answer provided
        // correspondingImage = (ImageView) findViewById(R.id.bonus_indictaor);
        bonusQuestion.setMaxLines(1);
        chosenAnswerBonus = bonusQuestion.getText().toString();

        if (chosenAnswerBonus.equalsIgnoreCase("Olivia Pope")) {
            correspondingImage.setImageResource(R.drawable.right_button);
        } else if (chosenAnswerBonus.equalsIgnoreCase("Olivia")) {
            correspondingImage.setImageResource(R.drawable.right_button);
        } else if (chosenAnswerBonus.equalsIgnoreCase("olivia ")) {
            correspondingImage.setImageResource(R.drawable.right_button);
        } else if (chosenAnswerBonus.equalsIgnoreCase("olivia pope ")) {
            correspondingImage.setImageResource(R.drawable.right_button);
        } else {
            correspondingImage.setImageResource(R.drawable.wrong_button);
        }

        //correspondingImage.setImageResource(bonusImage);
        //FOR SOUND

        Button bonusSubmitButton = (Button) findViewById(R.id.bonus_submit_button);
        final MediaPlayer mp = MediaPlayer.create(this, R.raw.button_sound);
        mp.start();

    }
}
