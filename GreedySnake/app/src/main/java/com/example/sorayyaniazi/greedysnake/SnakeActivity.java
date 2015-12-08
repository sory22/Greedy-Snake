package com.example.sorayyaniazi.greedysnake;

import Controller.AndroidGameController;
import Controller.InputController;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;
import snake.Utilities;
import android.view.Gravity;



public class SnakeActivity extends Activity implements InputController  {
    AndroidGameController c;
    TextAdapter textAdapter;
    int lastInput = -1;
    GridView gridview;
    TextView scoreView;
    Utilities util;

    public enum color {
        RED,GREEN,YELLOW,BLUE
    }

    private void setInput(int input) {
        lastInput = input;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.snake_activity);


        textAdapter = new TextAdapter(this);
        // handler for updating gui
        final Handler guihandler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                if (msg.what == 1) {
                    c.externalUpdateGui();
                    textAdapter.notifyDataSetChanged();
                    scoreView.setText("Score: " + c.getScore());
                } else if (msg.what == 2) {
                    Toast toast = Toast.makeText(gridview.getContext(), "Boo! Game is Over",
                            Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER_VERTICAL|Gravity.CENTER_HORIZONTAL, 0, 0);
                    toast.show();

                    Toast toast2 = Toast.makeText(gridview.getContext(), Utilities.getInstance().getPlayerName()+":" + c.getScore(),
                            Toast.LENGTH_SHORT);
                    toast2.setGravity(Gravity.CENTER_VERTICAL|Gravity.CENTER_HORIZONTAL, 0, 0);
                    toast2.show();
                }
            }
        };
        c = new AndroidGameController(textAdapter, this, guihandler);

        initGridView();
        initButtonsLabels();

        startGame();
    }

    private void initButtonsLabels() {
        scoreView = (TextView) findViewById(R.id.Score);

        Button returnButton = (Button) findViewById(R.id.Exit);
        returnButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                c.stopPlaying();
                startActivity(new Intent(v.getContext(), MenuActivity.class));
            }
        });

        Button restartButton = (Button) findViewById(R.id.Restart);
        restartButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                c.stopPlaying();
                c.resetGame();
                startGame();
            }
        });

        final Button pauseButton = (Button)findViewById(R.id.pause);
        pauseButton.setTag(1);
        pauseButton.setText("Pause");
        pauseButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                final int status = (Integer)v.getTag();
                if(status ==1)
                {
                    pauseButton.setText("Resume");
                    v.setTag(0);
                }else{
                    pauseButton.setText("Pause");
                    v.setTag(1);
                }
                c.isPaused = !c.isPaused;
            }
        });
    }

    private void startGame() {
        lastInput = -1;
        c.setIsPlaying();
        c.play();
    }

    private void initGridView() {
        gridview = (GridView) findViewById(R.id.GridView1);
        gridview.setAdapter(textAdapter);
        gridview.setNumColumns(Utilities.getInstance().getWidth());
        if( util.getInstance().getColor() == 0 ) {
            gridview.setBackgroundColor(Color.RED);
        } else if( util.getInstance().getColor() == 1 ) {
            gridview.setBackgroundColor(Color.GREEN);
        } else if(util.getInstance().getColor() == 2){
            gridview.setBackgroundColor(Color.YELLOW);
        } else if(util.getInstance().getColor() == 3){
            gridview.setBackgroundColor(Color.BLUE);
        }


        gridview.setOnKeyListener(new OnKeyListener() {

            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                // 1 = up, 2 = right, 3 = down, 4 = left, other is ignored
                if (keyCode == 19) {
                    setInput(1);
                } else if (keyCode == 22) {
                    setInput(2);
                } else if (keyCode == 20) {
                    setInput(3);
                } else if (keyCode == 21) {
                    setInput(4);
                } else {
                    setInput(-1);
                }
                return true;
            }
        });


        gridview.setOnTouchListener(new OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                float x = event.getX();
                float y = event.getY();

                int[] snakeHead = c.getSnakeHeadPosition();
                int snakeHeadTransformed = textAdapter.transformPosition(
                        snakeHead[0], snakeHead[1]);
                View snakeview = gridview.getChildAt(snakeHeadTransformed);
                int[] snakeHeadOnScreen = new int[2];
                snakeview.getLocationOnScreen(snakeHeadOnScreen);

                float xDiff = x - snakeHeadOnScreen[0];
                float yDiff = y - snakeHeadOnScreen[1];

                if (Math.abs(xDiff) > Math.abs(yDiff)) {
                    if (xDiff < 0) {
                        setInput(4);
                    } else {
                        setInput(2);
                    }
                } else {
                    if (yDiff < 0) {
                        setInput(1);
                    } else {
                        setInput(3);
                    }
                }
                return true;
            }
        });
    }

@Override
    public int getInput() {
        return lastInput;
    }

    @Override
    protected void onStop() {
        super.onStop();
        c.stopPlaying();
    }
}
