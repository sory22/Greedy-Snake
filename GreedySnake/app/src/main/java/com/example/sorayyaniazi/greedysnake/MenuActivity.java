package com.example.sorayyaniazi.greedysnake;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MenuActivity extends Activity {




    private String username;

    @Override
    protected void onCreate (Bundle savedState){

        super.onCreate(savedState);


        setContentView(R.layout.menu_activity);


    }



    public void clickViewScore(View view){

        try{

            Class<?> myclass= Class.forName("com.example.sorayyaniazi.greedysnake.HighscoreActivity");
            Intent myintent= new Intent(this, myclass);
            startActivity(myintent);
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }
    public void clickHelp(View view){

        try{

            Class<?> myclass= Class.forName("com.example.sorayyaniazi.greedysnake.HelpActivity");
            Intent myintent= new Intent(this, myclass);
            startActivity(myintent);
        }
        catch(Exception e){
            e.printStackTrace();
        }


    }

    public void clickSetting(View view){

        try{

            Class<?> myclass= Class.forName("com.example.sorayyaniazi.greedysnake.SettingActivity");
            Intent myintent= new Intent(this, myclass);
            startActivity(myintent);
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }

    public void clickPlayGame(View view){

        try{

            Class<?> myclass= Class.forName("com.example.sorayyaniazi.greedysnake.SnakeActivity");
            Intent myintent= new Intent(view.getContext(), SnakeActivity.class);
            startActivity(myintent);
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }
    public void clickExitGame(View view){

        try{

            Class<?> myclass= Class.forName("com.example.sorayyaniazi.greedysnake.WelcomeActivity");
            Intent myintent= new Intent(this, myclass);
            startActivity(myintent);

            android.os.Process.killProcess(android.os.Process.myPid());
        }
        catch(Exception e){
            e.printStackTrace();
        }



    }

}