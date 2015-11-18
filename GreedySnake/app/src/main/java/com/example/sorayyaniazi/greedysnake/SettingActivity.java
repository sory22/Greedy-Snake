package com.example.sorayyaniazi.greedysnake;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
/**
 * Created by sorayyaniazi on 11/10/15.
 */


public class SettingActivity extends Activity {

// component Reference Variabes.



//class variable.


    @Override
    protected void onCreate (Bundle savedState){

        super.onCreate(savedState);

//sets the view for class to specify xml file.(Resources.Layout.WelcomeActivity)
        setContentView(R.layout.setting_activity);

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

    public void clickColor (View view){
        try{

            Class<?> myclass= Class.forName("com.example.sorayyaniazi.greedysnake.ColorActivity");
            Intent myintent= new Intent(this, myclass);
            startActivity(myintent);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void clickDifficultyMode (View view){
        try{

            Class<?> myclass= Class.forName("com.example.sorayyaniazi.greedysnake.DifficultyModeActivity");
            Intent myintent= new Intent(this, myclass);
            startActivity(myintent);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}


