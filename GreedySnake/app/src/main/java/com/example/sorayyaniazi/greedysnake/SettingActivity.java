package com.example.sorayyaniazi.greedysnake;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;



public class SettingActivity extends Activity {



    @Override
    protected void onCreate (Bundle savedState){

        super.onCreate(savedState);


        setContentView(R.layout.setting_activity);



    }

    public void clickVolume (View view){
        try{

            Class<?> myclass= Class.forName("com.example.sorayyaniazi.greedysnake.volumeActivity");
            Intent myintent= new Intent(this, myclass);
            startActivity(myintent);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }


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
