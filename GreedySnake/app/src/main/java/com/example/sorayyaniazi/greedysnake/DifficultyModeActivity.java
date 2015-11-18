package com.example.sorayyaniazi.greedysnake;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by sorayyaniazi on 11/12/15.
 */



public class DifficultyModeActivity extends Activity {

// component Reference Variabes.



//class variable.


    @Override
    protected void onCreate (Bundle savedState){

        super.onCreate(savedState);

//sets the view for class to specify xml file.(Resources.Layout.WelcomeActivity)
        setContentView(R.layout.difficulty_mode_activity);

        //Assign component Reference variable.
        //Example: textBox= (TextView)findViewById(R.id.usernameTxt);

    }
//Action functions go here, click button,etc.
   /* public void enterClicked(View view){

        //get username from textBox object
        username= textBox.getText().toString();
        System.out.println(username);
    }
*/
}