package com.example.android.scandalquizzapp;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    //KEY VALUES TO HANDLE SCREEN ROTATION
    private static final String QUESTION_ONE = "";
    private static final String QUESTION_TWO = "";
    private static final String QUESTION_THREE = "";
    private static final String QUESTION_FOUR = "";
    //question five is already saved on rotation?
    private static final String QUESTION_SIX = "";
    private static final String QUESTION_SEVEN = "";
    private static final String SCORE_COMMENT = "";
    private static final String BONUS_QUESTION = "";
    private static final String IMAGE_INDICATOR = "";


    int scoreCount = 0;
    int answers = 0;
    //QUESTIONS
    RadioGroup question1;
    RadioGroup question2;
    EditText question3;
    RadioGroup question4;
    CheckBox question5_1;
    CheckBox questions5_2;
    CheckBox questions5_3;
    CheckBox questions5_4;
    RadioGroup question6;
    RadioGroup question7;
    EditText bonusQuestion;
    //ANSWERS
    int chosenAnswer1;
    int chosenAnswer2;
    String chosenAnswer3;
    int chosenAnswer4;
    boolean chosenAnswer5_1;
    boolean chosenAnswer5_2;
    boolean chosenAnswer5_a;
    boolean chosenAnswer5_b;
    int chosenAnswer6;
    int chosenAnswer7;
    String chosenAnswerBonus;

    TextView scoreComment;
    ImageView correspondingImage;
    Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        question1 = (RadioGroup) findViewById(R.id.options_1);
        question2 = (RadioGroup) findViewById(R.id.options_2);
        question3 = (EditText) findViewById(R.id.answer_3);
        question4 = (RadioGroup) findViewById(R.id.options_4);
        question5_1 = (CheckBox) findViewById(R.id.answer_5_1);
        questions5_2 = (CheckBox) findViewById(R.id.answer_5_2);
        questions5_3 = (CheckBox) findViewById(R.id.options_5_a);
        questions5_4 = (CheckBox) findViewById(R.id.options_5_b);
        question6 = (RadioGroup) findViewById(R.id.options_6);
        question7 = (RadioGroup) findViewById(R.id.options_7);
        bonusQuestion = (EditText) findViewById(R.id.bonus_answer);
        scoreComment = (TextView) findViewById(R.id.score_comment);
        correspondingImage = (ImageView) findViewById(R.id.bonus_indictaor);
        correspondingImage.setImageBitmap(bitmap);

    }


    public void onSaveInstanceState(Bundle savedInstanceState) {
        //to save current value of variable
        savedInstanceState.putInt(QUESTION_ONE, chosenAnswer1);
        savedInstanceState.putInt(QUESTION_TWO, chosenAnswer2);
        savedInstanceState.putString(QUESTION_THREE, chosenAnswer3);
        savedInstanceState.putInt(QUESTION_FOUR, chosenAnswer4);
        savedInstanceState.putInt(QUESTION_SIX, chosenAnswer6);
        savedInstanceState.putInt(QUESTION_SEVEN, chosenAnswer7);
        savedInstanceState.putString(SCORE_COMMENT, scoreComment.getText().toString());


        savedInstanceState.putString(BONUS_QUESTION, chosenAnswerBonus);
        savedInstanceState.putParcelable(IMAGE_INDICATOR, bitmap);


//call superclass to save state of view hierachy
        super.onSaveInstanceState(savedInstanceState);
    }


    public void onRestoreInstanceState(Bundle savedInstanceState) {
        //calling superclass to restore hierachy state
        super.onRestoreInstanceState(savedInstanceState);


//linking variables with corresponding key values
        chosenAnswer1 = savedInstanceState.getInt(QUESTION_ONE);
        chosenAnswer2 = savedInstanceState.getInt(QUESTION_TWO);
        chosenAnswer3 = savedInstanceState.getString(QUESTION_THREE);
        chosenAnswer4 = savedInstanceState.getInt(QUESTION_FOUR);
        chosenAnswer6 = savedInstanceState.getInt(QUESTION_SIX);
        chosenAnswer7 = savedInstanceState.getInt(QUESTION_SEVEN);
        chosenAnswerBonus = savedInstanceState.getString(BONUS_QUESTION);
        bitmap = savedInstanceState.getParcelable(IMAGE_INDICATOR);


        displayComment(savedInstanceState.getString(SCORE_COMMENT));
    }


    private void chosenVScorrect() {
//for question 1

        chosenAnswer1 = question1.getCheckedRadioButtonId();
        if (chosenAnswer1 == -1) {
        } else {
            View radioButton1 = question1.findViewById(chosenAnswer1);
            if (radioButton1.getId() == R.id.answer_1) {
                scoreCount += 1;
            }
        }
        //for question 2
        chosenAnswer2 = question2.getCheckedRadioButtonId();
        if (chosenAnswer2 == -1) {

        } else {
            View radioButton2 = question2.findViewById(chosenAnswer2);
            if (radioButton2.getId() == R.id.answer_2) {
                scoreCount++;
            }
        }
        //for question 3
        question3.setMaxLines(1);
        chosenAnswer3 = question3.getText().toString();
        if (chosenAnswer3.equals("1")) {
            scoreCount++;
        }
        if (chosenAnswer3.equalsIgnoreCase("one")) {
            scoreCount++;
        }
        //for question 4
        chosenAnswer4 = question4.getCheckedRadioButtonId();
        if (chosenAnswer4 == -1) {

        } else {
            View radioButton4 = question4.findViewById(chosenAnswer4);
            if (radioButton4.getId() == R.id.answer_4) {
                scoreCount++;
            }
        }
        //for question 5
        chosenAnswer5_1 = question5_1.isChecked();
        chosenAnswer5_2 = questions5_2.isChecked();
        chosenAnswer5_a = questions5_3.isChecked();
        chosenAnswer5_b = questions5_4.isChecked();
        if (chosenAnswer5_1 == true && chosenAnswer5_2 == true && chosenAnswer5_a == false && chosenAnswer5_b == false) {
            scoreCount++;
        }
        // for question 6
        chosenAnswer6 = question6.getCheckedRadioButtonId();
        if (chosenAnswer6 == -1) {

        } else {
            View radioButton6 = question6.findViewById(chosenAnswer6);
            if (radioButton6.getId() == R.id.answer_6) {
                scoreCount++;
            }
        }
        // for question 7
        chosenAnswer7 = question7.getCheckedRadioButtonId();
        if (chosenAnswer7 == -1) {

        } else {
            View radioButton7 = question7.findViewById(chosenAnswer7);
            if (radioButton7.getId() == R.id.answer_7) {
                scoreCount++;
            }
        }


    }


    public void answerChecker() {
        chosenVScorrect();
        //for q1
        if (chosenAnswer1 != -1) {
            answers++;

        }

        //for q2
        if (chosenAnswer2 != -1) {
            answers++;
        }

        //for q3
        if (chosenAnswer3 != null) {
            answers++;
        }

        //for q4
        if (chosenAnswer4 != -1) {
            answers++;
        }

        //for q5
        boolean A = chosenAnswer5_a;
        boolean B = chosenAnswer5_b;
        boolean C = chosenAnswer5_1;
        boolean D = chosenAnswer5_2;
        //conditions
        if (A && B && C && D) {
            answers++;
            //if 3 options selected
        } else if (A && B && C) {
            answers++;
        } else if (A && B && D) {
            answers++;
        } else if (A && C && D) {
            answers++;
        } else if (B && C && D) {
            answers++;
            //if 2 options selected
        } else if (A && B) {
            answers++;
        } else if (A && C) {
            answers++;
        } else if (A && D) {
            answers++;
        } else if (B && C) {
            answers++;
        } else if (B && D) {
            answers++;
        } else if (C && D) {
            answers++;
            //if an option selected
        } else if (A) {
            answers++;
        } else if (B) {
            answers++;
        } else if (C) {
            answers++;
        } else if (D) {
            answers++;
        }

        //for q6
        if (chosenAnswer6 != -1) {
            answers++;
        }

        //for q7
        if (chosenAnswer7 != -1) {
            answers++;
        }


    }


    public void finalScore(View v) {

        //to prevent score and answer from updating despite there being no changes all because the button is clicked
        scoreCount = 0;
        answers = 0;
        answerChecker();

//determining what toast appear + displaying total score
        if (answers < 7) {
            Toast.makeText(this, getString(R.string.error_message), Toast.LENGTH_SHORT).show();
            Log.i("score", "score is " + scoreCount + " answer is " + answers);
        } else {
            Toast.makeText(this, +scoreCount + " " + getString(R.string.final_score), Toast.LENGTH_SHORT).show();
            Log.i("score", "score is " + scoreCount + " answer is " + answers);
            scoreComments();

            //SOUND
            Button submitButton = (Button) findViewById(R.id.submit_button);
            final MediaPlayer mp = MediaPlayer.create(this, R.raw.button_sound);
            mp.start();


        }
    }

    //method to display score comment
    public void displayComment(String comment) {

        scoreComment.setText(String.valueOf(comment));

    }


    public void scoreComments() {


        //score 1-2
        if (scoreCount == 0 | scoreCount == 1 | scoreCount == 2) {
            String comment = getString(R.string.one_two);
            displayComment(comment);

        }

//score 3-4
        if (scoreCount == 3 | scoreCount == 4) {
            String comment = getString(R.string.three_four);
            displayComment(comment);
        }
        //score 5-6
        if (scoreCount == 5 | scoreCount == 6) {
            String comment = getString(R.string.five_six);
            displayComment(comment);


        }
//score 7
        if (scoreCount == 7) {
            String comment = getString(R.string.full_score);
            displayComment(comment);


        }
    }


    public void bonusScore(View v) {

        // bonus question score is displayed with either a tick or cross depending on answer provided

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

        //FOR SOUND

        Button bonusSubmitButton = (Button) findViewById(R.id.bonus_submit_button);
        final MediaPlayer mp = MediaPlayer.create(this, R.raw.button_sound);
        mp.start();

    }


    public void reset(View v) {
        scoreCount = 0;
        answers = 0;
        question1.clearCheck();
        question2.clearCheck();
        question3.setText("");
        question4.clearCheck();

        if (question5_1.isChecked()) {
            question5_1.toggle();
        }
        ;
        if (questions5_2.isChecked()) {
            questions5_2.toggle();
        }
        ;
        if (questions5_3.isChecked()) {
            questions5_3.toggle();
        }
        ;
        if (questions5_4.isChecked()) {
            questions5_4.toggle();
        }
        ;

        question6.clearCheck();
        question7.clearCheck();
        String comment = "";
        displayComment(comment);
    }


}
