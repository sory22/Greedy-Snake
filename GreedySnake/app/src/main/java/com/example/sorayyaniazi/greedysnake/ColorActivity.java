package com.example.sorayyaniazi.greedysnake;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import snake.Utilities;


public class ColorActivity extends Activity{
    Utilities util;

    @Override
    protected void onCreate(Bundle savedState){
        super.onCreate(savedState);
        setContentView(R.layout.color_activity);
        initButtons();
    }


    public void clickRed (View view){
        try{
            util.getInstance().setColor(0);
            util.getInstance().saveSettings();
            startActivity(new Intent(view.getContext(), MenuActivity.class));
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void clickGreen (View view){
        try{
            util.getInstance().setColor(1);
            util.getInstance().saveSettings();
            startActivity(new Intent(view.getContext(), MenuActivity.class));
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void clickYellow (View view){
        try{
            util.getInstance().setColor(2);
            util.getInstance().saveSettings();
            startActivity(new Intent(view.getContext(), MenuActivity.class));
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void clickBlue (View view){
        try{
            util.getInstance().setColor(3);
            util.getInstance().saveSettings();
            startActivity(new Intent(view.getContext(), MenuActivity.class));
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    private void initButtons(){
    }


}

