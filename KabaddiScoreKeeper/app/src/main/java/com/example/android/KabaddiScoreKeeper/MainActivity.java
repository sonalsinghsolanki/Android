package com.example.android.KabaddiScoreKeeper;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int scoreTeamA = 0;
    int scoreTeamB = 0;
    int foulTeamA = 0;
    int foulTeamB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    /**
     * The side that scores the highest number of points when the play ends shall be the winning team.
     *
     */

    /**
     * Increases the score of Team A by 1 points for one opponent put out.
     */
    public void AddOneForTeamA(View view) {
        scoreTeamA = scoreTeamA + 1;
        displayForTeamA(scoreTeamA);
    }
    /**
     * Increases the score of Team A by 3 points ie. if Team A manages to put out the entire opponent Team B,
     * two points shall be awarded in addition to the points scored by putting out individual players ie plus 1.
     */
    public void AddIonaForTeamA(View view) {
        scoreTeamA = scoreTeamA + 1 + 2;
        displayForTeamA(scoreTeamA);
    }
    /**
     * Increases the score of Team B by 1 point as well as increases count of foul for team A,
     * in second half if the team does not enter the court within 10 seconds,referee shall award one point to the opponents
     */
    public void AddLateEntryPenaltyForTeamA(View view) {
        scoreTeamB = scoreTeamB + 1;
        displayForTeamB(scoreTeamB);
        AddFoulForTeamA(view);
    }
    /**
     * Increases the score of Team B by 3 point for 3 players left of Team A ,during the game
     * and captain of the team A declares them out, in order to bring full team in for another game
     * the opponents ie team B will score as many points as players left just before declaring,
     * as well as 2 points for Iona.
     * Here i am hard coding number of players left as currently not implementing count of players left assumuing it
     * to be 3 left
     */
    public void AddTeamOutForTeamA(View view) {
        scoreTeamB = scoreTeamB + 2 + 3;
        displayForTeamB(scoreTeamB);
    }
    /**
     * Increases the foul count of Team A by 1 whenever team comes late to field or plays harsh game or argue with refree,
     * and also decreases the score of Team A. In actual game, I am not sure if this scoring exist but to implement for project needs
     * i am adding this functionality.
     */
    public void AddFoulForTeamA(View view) {
        foulTeamA = foulTeamA + 1;
        displayFoulForTeamA(foulTeamA);
        scoreTeamA = scoreTeamA - 1;
        displayForTeamA(scoreTeamA);
    }
    /**
     * Increases the score of Team B by 1 points for one opponent put out.
     */
    public void AddOneForTeamB(View view) {
        scoreTeamB = scoreTeamB + 1;
        displayForTeamB(scoreTeamB);
    }
    /**
     * Increases the score of Team B by 3 points ie. if a team manages to put out the entire opponent team,
     * two points shall be awarded in addition to the points scored by putting out individual players ie plus 1.
     */
    public void AddIonaForTeamB(View view) {
        scoreTeamB = scoreTeamB + 1 + 2;
        displayForTeamB(scoreTeamB);
    }
    /**
     * Increases the score of Team A by 1 point as well as increases the foul of team B by 1,
     * in second half , if the team does not enter the court within 10 seconds,
     * referee shall award one point to the opponents
     */
    public void AddLateEntryPenaltyForTeamB(View view) {
        scoreTeamA = scoreTeamA + 1;
        displayForTeamA(scoreTeamA);
        AddFoulForTeamB(view);
    }
    /**
     * Increases the score of Team A by 3 point for 3 players left of Team B ,during the game
     * and captain of the Team B declares them out, in order to bring full team in ,the opponents ie team A
     * will score as many points as players left just before declaring as well as 2 points for Iona.
     * Here i am hard coding number of players left as currently not implementing count of players left assumuing it
     * to be 3 left
     */
    public void AddTeamOutForTeamB(View view) {
        scoreTeamA = scoreTeamA + 2 + 3;
        displayForTeamA(scoreTeamA);
    }
    /**
     * Increases the foul count of Team B by 1 whenever team comes late to field or plays harsh game or argue with refree,
     * and decreases the score of Team B. In actual game, I am not sure if this scoring exist but to implement for project needs
     * i am adding this functionality.
     */
    public void AddFoulForTeamB(View view) {
        foulTeamB = foulTeamB + 1;
        displayFoulForTeamB(foulTeamB);
        scoreTeamB = scoreTeamB - 1;
        displayForTeamB(scoreTeamB);
    }
    /**
     * Resets the score and foul for Team A and Team B.
     */
    public void resetScore(View view) {
        scoreTeamA = 0;
        scoreTeamB = 0;
        foulTeamA = 0;
        foulTeamB = 0;
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
        displayFoulForTeamA(foulTeamA);
        displayFoulForTeamB(foulTeamB);
    }
    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }
    /**
     * Displays the given score for Team B.
     */
    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }
    /**
     * Displays the given foul for Team A
     */
    public void displayFoulForTeamA(int foul) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_foul);
        scoreView.setText(String.valueOf(foul));
    }
    /**
     * Displays the given foul for Team B
     */
    public void displayFoulForTeamB(int foul) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_foul);
        scoreView.setText(String.valueOf(foul));
    }
}
