package Model;

import java.util.Random;
import java.util.Iterator;
import java.util.ArrayList;

public class GameField {

    private int width;
    private int height;
    private GameCell[][] gameField;
    private ArrayList<FoodCell> foods;


    public GameField(int width, int height){
        this.width = width;
        this.height = height;

        initGameField();
        initFood();


    }

    public int getWidth(){
        return width;
    }
    public int getHeight(){
        return height;
    }
    public void initFood(){
        foods = new ArrayList<FoodCell>();
    }


    // initiate the game field
    public void initGameField(){
        gameField = new GameCell[width][height];
        for(int i =0 ; i< width; i++)
            for(int j=0;j<height;j++){
                gameField[i][j] = new GameCell(i,j);
            }
    }


    public void addfoods(int pointValue, int growthValue, int timeLeft, Snake snake){

        boolean added = false;

          Random r = new Random();
        while(!added) {
            int x = r.nextInt(width);
            int y = r.nextInt(height);

            if (isIsWalkable(x, y) && (getFoodposition(x, y) == null)&& !snake.isAt(x,y)) {

                foods.add(new FoodCell(pointValue, growthValue, timeLeft, x, y));

                added = true;
            }
        }

    }




    public void updateFood(){
        for (Iterator<FoodCell> it = foods.iterator(); it.hasNext();) {
            FoodCell food = it.next();
            food.reduceTimeLeft();
            if (!food.isTimeLeft()) {
                it.remove();
            }
        }
    }


    public boolean isIsWalkable(int x, int y){
        return isOutsideGame(x,y)?false:gameField[x][y].isIsWalkable();
    }

    public boolean isOutsideGame(int x, int y){
        return x < 0 || y < 0 || x > width - 1 || y > height - 1;
    }


    public FoodCell getFoodposition(int x, int y){
        if(!isIsWalkable(x,y)){
            return null;
        }
        for(FoodCell f : foods){
            if(f.getX()==x && f.getY()==y){
                return f;
            }
        }
        return null;
    }


    public void setBorders() {
        for (int i = 0; i < width; i++) {
            gameField[i][0].setIsWalkable(false);
            gameField[i][height - 1].setIsWalkable(false);
        }

        for (int j = 0; j < height; j++) {
            gameField[0][j].setIsWalkable(false);
            gameField[width - 1][j].setIsWalkable(false);
        }
    }


    public boolean hasNoFood(){


        return foods.isEmpty();
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();

        for (int j = 0; j < height; j++) {
            for (int i = 0; i < width; i++) {
                if (gameField[i][j].isIsWalkable()) {
   //                  if (snake.isAt(i, j)) {
  //                      sb.append("@");
   //                  } else
                    if (getFoodposition(i, j) != null) {

                        sb.append('0');
                    } else {
                        sb.append(' ');
                    }
                } else {
                    sb.append('#');
                }
            }
            sb.append('\n');
        }
        return sb.toString();
    }

}
