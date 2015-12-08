package com.example.sorayyaniazi.greedysnake;

/**
 * Created by tiantianxie on 11/11/15.
 */
import android.content.Context;
<<<<<<< HEAD

import Model.FoodCell;
import View.IGui;
import snake.Utilities;

import android.graphics.Color;
=======
import View.IGui;
import snake.Utilities;

>>>>>>> 3c7c2dec60874596a7de517c512e6c01009684d2
import android.view.View;
import android.view.ViewGroup;

import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

<<<<<<< HEAD

public class TextAdapter extends BaseAdapter implements IGui  {

    private final Context context;
    private final String[] texts;


    private final int height;
    private final int width;

    private FoodCell food;

    Utilities util;

    public TextAdapter(Context context) {
        this.context = context;
        this.height = Utilities.getInstance().getHeight();
        this.width = Utilities.getInstance().getWidth();
        texts = new String[height * width];
        for (int i = 0; i < texts.length; i++) {
            texts[i] = " ";
        }
    }

    public int getCount() {
        return height * width;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        TextView tv;
        if (convertView == null) {
            tv = new TextView(context);
            tv.setLayoutParams(new GridView.LayoutParams(25, 25));
            tv.setTextSize(15);
        } else {
            tv = (TextView) convertView;
        }

        tv.setText(texts[position]);

        return tv;
    }

    /**
     * returns a two dimensional array with the x / y positions.
     *
     * @param position
     * @return
     */
    protected int[] transformPosition(int position) {
        int[] positionArr = new int[2];
        positionArr[0] = position % width;
        positionArr[1] = position / width;
        return positionArr;
    }

    protected int transformPosition(int x, int y) {
        return width * y + x;
    }

    @Override
    public void setSnake(int x, int y) {
      //  if( util.getColor() == Utilities.COLOR.RED ) {
            texts[transformPosition(x, y)] = "@";
      //  } else if(util.getColor() == Utilities.COLOR.GREEN ) {
     //       texts[transformPosition(x, y)] = "N";
       // } else {
        //    texts[transformPosition(x, y)] = "E";
        //}
    }

    @Override
    public void setgoodFood(int x, int y) {

            texts[transformPosition(x, y)] = "G";

    }

    @Override
    public void setbadFood(int x, int y) {

        texts[transformPosition(x, y)] = "B";


    }



    @Override
    public void setBorder(int x, int y) {
        texts[transformPosition(x, y)] = "#";
    }

    @Override
    public void setEmpty(int x, int y) {
        texts[transformPosition(x, y)] = " .";
    }

    @Override
    public void setScore(int score) {


    }

    //@Override
    public void sendMessage(String message) {

=======
public class TextAdapter extends BaseAdapter implements IGui  {

    private final Context context;
    private final String[] texts;


    private final int height;
    private final int width;

    public TextAdapter(Context context) {
        this.context = context;
        this.height = Utilities.getInstance().getHeight();
        this.width = Utilities.getInstance().getWidth();
        texts = new String[height * width];
        for (int i = 0; i < texts.length; i++) {
            texts[i] = " ";
        }
    }

    public int getCount() {
        return height * width;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        TextView tv;
        if (convertView == null) {
            tv = new TextView(context);
            tv.setLayoutParams(new GridView.LayoutParams(25, 25));
            tv.setTextSize(15);
        } else {
            tv = (TextView) convertView;
        }

        tv.setText(texts[position]);
        return tv;
    }

    /**
     * returns a two dimensional array with the x / y positions.
     *
     * @param position
     * @return
     */
    protected int[] transformPosition(int position) {
        int[] positionArr = new int[2];
        positionArr[0] = position % width;
        positionArr[1] = position / width;
        return positionArr;
    }

    protected int transformPosition(int x, int y) {
        return width * y + x;
    }

    @Override
    public void setSnake(int x, int y) {
        texts[transformPosition(x, y)] = "*";
    }

    @Override
    public void setFood(int x, int y) {
        texts[transformPosition(x, y)] = "F";
    }

    @Override
    public void setBorder(int x, int y) {
        texts[transformPosition(x, y)] = "#";
    }

    @Override
    public void setEmpty(int x, int y) {
        texts[transformPosition(x, y)] = " .";
    }

    @Override
    public void setScore(int score) {


    }

    //@Override
    public void sendMessage(String message) {

>>>>>>> 3c7c2dec60874596a7de517c512e6c01009684d2
    }

    @Override
    public void updateUI() {
    }
}
