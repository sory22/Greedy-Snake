package Model;

import java.util.Random;
import java.util.Iterator;
/**
 * Created by tiantianxie on 11/11/15.
 */
public class GameField {

    private int width;
    private int height;
    private GameCell[][] gameField;
    private FoodCell food;




    //construct new GameField
    public GameField(int width, int height){
        this.width = width;
        this.height = height;

        initGameField();

    }

    public int getWidth(){
        return width;
    }
    public int getHeight(){
        return height;
    }



    // initiate the game field
    public void initGameField(){
        gameField = new GameCell[width][height];
        for(int i =0 ; i< width; i++)
            for(int j=0;j<height;j++){
                gameField[i][j] = new GameCell(i,j);
            }
    }




    public void addfoods(int scorevalue, int timeLeft){

        Random r= new Random();
        int x = r.nextInt(width);
        int y = r.nextInt(height);
        food = new FoodCell(, timeLeft,x,y);
        if(isIsWalkable(x,y)&& (getFoodposition(x,y)==null)){
            food.add(new FoodCell(scorevalue, timeLeft, x, y));

        }
    }


    //update food
    public void updateFood(){
        for (Iterator<FoodCell> it = food.getFoods().iterator(); it.hasNext();) {
            FoodCell food = it.next();
            food.reduceTimeLeft();
            if (!food.isTimeLeft()) {
                it.remove();
            }
        }
    }


    //check is the gamesquare walkable
    public boolean isIsWalkable(int x, int y){
        return isOutsideGame(x,y)?false:gameField[x][y].isIsWalkable();
    }
    //check is gamesquare outside the gamefield
    public boolean isOutsideGame(int x, int y){
        return x < 0 || y < 0 || x > width - 1 || y > height - 1;
    }

    //get food position
    public FoodCell getFoodposition(int x, int y){
        if(!isIsWalkable(x,y)){
            return null;
        }
        for(FoodCell f : food.getFoods()){
            if(f.getX()==x && f.getY()==y){
                return f;
            }
        }
        return null;
    }


    //check if there is food in the gamefield
    public boolean hasFood(){
        return food.getFoods().isEmpty();
    }

}
