package com.example.android.quizapp;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    //global variable to keep the score
    int score=0;
    //when the submit button is clicked, the summitAnswer is performed
    String comment;
    public void summitAnswer(View view){
        /**
         * the next code create an object for question 1 and 5 answers
         */
        RadioButton firstRadio=(RadioButton) findViewById(R.id.radio_button1);
        boolean hasFirstRadio=firstRadio.isChecked();
        RadioButton SecondRadio=(RadioButton) findViewById(R.id.radio_button2);
        boolean hasSecondRadio=SecondRadio.isChecked();
        RadioButton ThirdRadio=(RadioButton) findViewById(R.id.radio_button3);
        boolean hasThirdRadio=ThirdRadio.isChecked();
        RadioButton FourthRadio=(RadioButton) findViewById(R.id.radio_button4);
        boolean hasFourthRadio=FourthRadio.isChecked();
        RadioButton fifthRadio=(RadioButton) findViewById(R.id.radio_button5);
        boolean hasFifthRadio=firstRadio.isChecked();
        RadioButton SixthRadio=(RadioButton) findViewById(R.id.radio_button6);
        boolean hasSixthRadio=SecondRadio.isChecked();

        String nameAnswer=naming();//the code gets the return value of question 2

       String name=Naming().trim();
       /**
         * the next code gets the object for question 3 answers
         * creating objects for the check boxes
         */
        //ghana checkbox
        CheckBox GhanacheckBox=(CheckBox) findViewById(R.id.ghanaCheckbox);
        boolean hasGhana= GhanacheckBox.isChecked();
        //cameroon checkbox
        CheckBox CamerooncheckBox=(CheckBox) findViewById(R.id.cameroonCheckbox);
        boolean hasCameroon= CamerooncheckBox.isChecked();
        //senegal checkbox
        CheckBox SenegalcheckBox=(CheckBox) findViewById(R.id.senegalCheckbox);
        boolean hasSenegal= SenegalcheckBox.isChecked();
        //nigeria checkbox
        CheckBox NigeriacheckBox=(CheckBox) findViewById(R.id.nigeriaCheckbox);
        boolean hasNigeria= NigeriacheckBox.isChecked();
        //egypt checkbox
        CheckBox EgyptcheckBox=(CheckBox) findViewById(R.id.egyptCheckbox);
        boolean hasEgyptcheckBox=EgyptcheckBox.isChecked();
        /**
         * create an object for the image radio buttons
         */
        RadioButton AfricaRadio=(RadioButton) findViewById(R.id.african_cup);
        boolean hasAfricaRadio=AfricaRadio.isChecked();
        RadioButton championsRadio=(RadioButton) findViewById(R.id.champions_league);
        boolean haschampionsRadio=championsRadio.isChecked();
        RadioButton worldcupRadio=(RadioButton) findViewById(R.id.world_cup);
        boolean hasworldcup=worldcupRadio.isChecked();

        /**
         * do the actual calculation of the score
         */
        calculateScore1_2_4(hasFirstRadio,hasSecondRadio,nameAnswer,hasAfricaRadio,haschampionsRadio,hasworldcup);
        calculateScore3(hasGhana,hasCameroon,hasSenegal,hasNigeria,hasEgyptcheckBox);
        calculatequestion5(hasThirdRadio,hasFourthRadio,hasFifthRadio,hasSixthRadio);
        commenting();
         Toast.makeText(this,name+" you scored "+score+", "+comment, Toast.LENGTH_LONG).show();
         score=0;
    }


    /**calculates the score for the first question
     *
     * returns the score
     *
     *
     */
    public void changecolor(View view){
        RadioButton AfricaRadio=(RadioButton) findViewById(R.id.african_cup);
        boolean hasAfricaRadio=AfricaRadio.isChecked();
        RadioButton championsRadio=(RadioButton) findViewById(R.id.champions_league);
        boolean haschampionsRadio=championsRadio.isChecked();
        RadioButton worldcupRadio=(RadioButton) findViewById(R.id.world_cup);
        boolean hasworldcup=worldcupRadio.isChecked();
        if(hasworldcup){
       worldcupRadio.setBackgroundDrawable(getDrawable(R.drawable.worldcup2));
        }
        if(!hasworldcup){
            worldcupRadio.setBackgroundDrawable(getDrawable(R.drawable.worldcup));
        }
        if(haschampionsRadio){
            championsRadio.setBackgroundDrawable(getDrawable(R.drawable.champions2));
        }
        if(!haschampionsRadio){
            championsRadio.setBackgroundDrawable(getDrawable(R.drawable.champions));
        }
        if(hasAfricaRadio){
            AfricaRadio.setBackgroundDrawable(getDrawable(R.drawable.africa2));
        }
        if(!hasAfricaRadio){
            AfricaRadio.setBackgroundDrawable(getDrawable(R.drawable.africa));
        }

    }
    /**
     * intents
     */

    public void calculateScore1_2_4(boolean first ,boolean second,String name,boolean africa,boolean champions,boolean world){
if(first){
    score+=1;
}
if(second){
    score+=0;
}
if(name.equalsIgnoreCase("brasil")){
    score+=1;
}
        if(name.equalsIgnoreCase("brazil")) {
            score += 1;
        }


if(world){
    score+=1;

}

         }

    /**
     * calculate the score for question 5
     * @return
     */
    public void calculatequestion5(boolean first,boolean second,boolean third,boolean forth){
        if(first){
            score+=1;
        }
    }
    //getting the answer for question 2
   private String naming(){
       EditText answerEdit=(EditText) findViewById(R.id.answer2);
       return answerEdit.getText().toString();
   }

    /**
     * takes the name of the user
     *
     */
    private String Naming(){
        EditText nameEdit=(EditText) findViewById(R.id.name);
        return nameEdit.getText().toString();
    }
    public void calculateScore3(boolean variable1,boolean variable2,boolean variable3,boolean variable4,boolean variable5){
        if(variable1&&variable2&&variable3&!variable4&!variable5){
            score+=1;
        }
       if(variable4&&variable5) {

        score+=0;}
       }
    /**
     * gives comment about you score
     */
    private void commenting(){
        if(score==5){
            comment="excellent";
        }
        if(score>=3&&score<=4){
            comment="good";
        }
        if(score<=2){
            comment="poor";
        }
    }
}



