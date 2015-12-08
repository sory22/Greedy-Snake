package com.example.sorayyaniazi.greedysnake;

import snake.Utilities;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;




public class DifficultyModeActivity extends Activity{

    Utilities util;

    @Override
    protected void onCreate(Bundle savedState){
        super.onCreate(savedState);
        setContentView(R.layout.difficulty_mode_activity);
        initButtons();
    }

    public void clickLow (View view){
        try{
            util.getInstance().setDifficultyMode(0);
            util.getInstance().saveSettings();
            startActivity(new Intent(view.getContext(), MenuActivity.class));
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void clickMedium (View view){
        try{
            util.getInstance().setDifficultyMode(1);
            util.getInstance().saveSettings();
            startActivity(new Intent(view.getContext(), MenuActivity.class));
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void clickHigh (View view){
        try{
            util.getInstance().setDifficultyMode(2);
            util.getInstance().saveSettings();
            startActivity(new Intent(view.getContext(), MenuActivity.class));
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public void initButtons(){

    }
}
