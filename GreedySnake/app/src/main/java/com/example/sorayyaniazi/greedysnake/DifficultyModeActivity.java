package com.example.sorayyaniazi.greedysnake;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by sorayyaniazi on 11/12/15.
 */



public class DifficultyModeActivity extends Activity {

// component Reference Variabes.



//class variable.
  private  DifficultyLevel difficultyLevel;

    @Override
    protected void onCreate (Bundle savedState){

        super.onCreate(savedState);

//sets the view for class to specify xml file.(Resources.Layout.WelcomeActivity)
        setContentView(R.layout.difficulty_mode_activity);

        //Assign component Reference variable.

        difficultyLevel= DifficultyLevel.LOW;



        //Example: textBox= (TextView)findViewById(R.id.usernameTxt);

    }


    public void clickLow(View view){
        difficultyLevel= DifficultyLevel.LOW;
        goBackToSetting();

    }


    public void clickMedium(View view){
        difficultyLevel= DifficultyLevel.MEDIUM;
        goBackToSetting();

    }


    public void clickHigh(View view){
        difficultyLevel= DifficultyLevel.HIGH;
        goBackToSetting();
    }

   public void goBackToSetting(){
       try{

           Class<?> myclass= Class.forName("com.example.sorayyaniazi.greedysnake.SettingActivity");
           Intent myintent= new Intent(this, myclass);
           myintent.putExtra("DL", difficultyLevel);
           startActivity(myintent);
       }
       catch(Exception e){
           e.printStackTrace();
       }

   }



//Action functions go here, click button,etc.
   /* public void enterClicked(View view){

        //get username from textBox object
        username= textBox.getText().toString();
        System.out.println(username);
    }
*/
}