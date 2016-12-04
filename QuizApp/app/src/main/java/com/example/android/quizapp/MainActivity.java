package com.example.android.quizapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Submit Answer and display score
     *
     * @param view
     */
    public void submitAnswers(View view) {
        /*Reset the score to 0 whenever submit button is clicked*/
        score = 0;
        /*Collect the value for First Question  */
        RadioButton questionOneRadioSelect = (RadioButton) findViewById(R.id.opt1_quest1);
        /*Collect the value for Fourth Question  */
        RadioButton questionFourRadioSelect = (RadioButton) findViewById(R.id.opt1_quest4);
        /*Collect the score of Questions answered for Radio buttons */
        score = questionsRadioSelection(questionOneRadioSelect, questionFourRadioSelect);
        /*Collect the value for Second Question  */
        CheckBox questionTwoOpt1Checked = (CheckBox) findViewById(R.id.opt1_quest2);
        CheckBox questionTwoOpt2Checked = (CheckBox) findViewById(R.id.opt2_quest2);
        CheckBox questionTwoOpt3Checked = (CheckBox) findViewById(R.id.opt3_quest2);
        CheckBox questionTwoOpt4Checked = (CheckBox) findViewById(R.id.opt4_quest2);
        /*Collect the score of Questions answered for Checkboxes */
        score = questionsCheckedSelection(questionTwoOpt1Checked, questionTwoOpt2Checked, questionTwoOpt3Checked, questionTwoOpt4Checked);
        /*Collect the value for Fifth Question */
        CheckBox questionFifthOpt1Checked = (CheckBox) findViewById(R.id.opt1_quest5);
        CheckBox questionFifthOpt2Checked = (CheckBox) findViewById(R.id.opt2_quest5);
        CheckBox questionFifthOpt3Checked = (CheckBox) findViewById(R.id.opt3_quest5);
        CheckBox questionFifthOpt4Checked = (CheckBox) findViewById(R.id.opt4_quest5);
        /*Collect the score of Questions answered for Checkboxes */
        score = questionsCheckedSelection(questionFifthOpt1Checked, questionFifthOpt2Checked, questionFifthOpt3Checked, questionFifthOpt4Checked);
         /*Collect the value for Third Question */
        EditText questionFourthAnswered = (EditText) findViewById(R.id.ans_quest3);
        String answerEditText = questionFourthAnswered.getText().toString();
          /*Collect the score of Questions answered for EditText*/
        score = questionsEditTextAnswered(answerEditText);
        displayScore(score);

    }

    /**
     * Check for score of answer for EditView
     * @param hasEditTextAnswered
     * @return
     */

    public int questionsEditTextAnswered(String hasEditTextAnswered) {
        boolean stringEquals;
        hasEditTextAnswered = hasEditTextAnswered.trim();
        if (stringEquals = hasEditTextAnswered.equals("A R Rehman")) {
            score = score + 1;
        } else {
            score = score + 0;
        }
        return score;
    }


    /**
     * Check for the score of answers selected for Radio Button View
     *
     * @param isRadioOneSelected
     * @param isRadioTwoSelected
     * @return
     */


    public int questionsRadioSelection(View isRadioOneSelected, View isRadioTwoSelected) {
        boolean isRadioOneChecked = ((RadioButton) isRadioOneSelected).isChecked();
        boolean isRadioTwoChecked = ((RadioButton) isRadioTwoSelected).isChecked();
        if (isRadioOneChecked == true && isRadioTwoChecked == true && isRadioOneSelected.getId() == R.id.opt1_quest1 && isRadioTwoSelected.getId() == R.id.opt1_quest4) {
            score =+ 2;
        } else if (isRadioOneChecked == true && isRadioOneSelected.getId() == R.id.opt1_quest1) {
            score = score + 1;
        } else if (isRadioTwoChecked == true && isRadioTwoSelected.getId() == R.id.opt1_quest4) {
            score = score + 1;
        } else {
            score =score + 0;
        }
        return score;
    }

    /**
     * Check for the score of answers selected for Checkbox View
     *
     * @param isOpt1Checked
     * @param isOpt2Checked
     * @param isOpt3Checked
     * @param isOpt4Checked
     * @return
     */
    public int questionsCheckedSelection(View isOpt1Checked, View isOpt2Checked, View isOpt3Checked, View isOpt4Checked) {
        boolean isCheckboxOptOneChecked = ((CheckBox) isOpt1Checked).isChecked();
        boolean isCheckboxOptTwoChecked = ((CheckBox) isOpt2Checked).isChecked();
        boolean isCheckboxOptThreeChecked = ((CheckBox) isOpt3Checked).isChecked();
        boolean isCheckboxOptFourChecked = ((CheckBox) isOpt4Checked).isChecked();
        if (isCheckboxOptOneChecked == true && isCheckboxOptTwoChecked == true && isCheckboxOptThreeChecked == true && isCheckboxOptFourChecked == false) {
            score =score + 1;
        } else {
            score =score + 0;
        }
        return score;
    }

    /**
     * This method displays the score on the screen.
     * Toast shows correct answers for all the questions
     */
    private void displayScore(int finalScore) {
        TextView finalScoreView = (TextView) findViewById(R.id.display_score);
        finalScoreView.setText("" + finalScore);
        String correctAnswers = "1.United States\n2.Colorado\n3.India,Bangladesh,Iran\n";
        correctAnswers = correctAnswers + "4.Virat Kohli,Mahendra Singh Dhoni,Ajinkya Rahane\n";
        correctAnswers = correctAnswers + "5.A R Rehman\n";
        Toast.makeText(MainActivity.this, correctAnswers, Toast.LENGTH_LONG).show();
    }

}