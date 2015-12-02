package com.example.sorayyaniazi.greedysnake;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import snake.Utilities;

/**
 * Created by sorayyaniazi on 11/6/15.
 */
public class WelcomeActivity extends Activity {
    private String username;
    private TextView textBox;
    Utilities util;

    @Override
    protected void onCreate (Bundle savedState){
        super.onCreate(savedState);
        setContentView(R.layout.welcome_activity);

        //get textBox object from views
        textBox= (TextView)findViewById(R.id.usernameTxt);
        username="";
    }

    public void enterClicked(View view){

        //get username from textBox object
        username= textBox.getText().toString();
        util.getInstance().setPlayerName(username);

        try{

            Class<?> myclass= Class.forName("com.example.sorayyaniazi.greedysnake.MenuActivity");
            Intent myintent= new Intent(this, myclass);
            startActivity(myintent);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}