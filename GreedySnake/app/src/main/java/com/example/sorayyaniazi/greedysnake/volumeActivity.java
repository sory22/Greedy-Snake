package com.example.sorayyaniazi.greedysnake;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.media.MediaPlayer;

public class volumeActivity extends Activity {
    MediaPlayer mp;
    @Override
    protected void onCreate(Bundle savedState){
        super.onCreate(savedState);
        setContentView(R.layout.volume_activity);
        mp = MediaPlayer.create(this, R.raw.bass);

        initButtons();
    }



    public void clickSoundOn (View view){
        try{
            mp.start();
            mp.setLooping(true);
            startActivity(new Intent(view.getContext(), MenuActivity.class));
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void clickSoundOff (View view){
        try{
            mp.pause();
            startActivity(new Intent(view.getContext(), MenuActivity.class));
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    private void initButtons(){
    }

}
