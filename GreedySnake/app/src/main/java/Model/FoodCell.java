package Model;

/**
 * Created by tiantianxie on 11/11/15.
 */
import java.util.ArrayList;
public class FoodCell extends CellObject  {
    //private boolean isGoodFood;
    private int scorevalue;
    private int timeleft;
    private ArrayList<FoodCell> Foods;


//Constructor
    public FoodCell(int scorevalue, int timeleft, int x, int y){
        super(x,y);
        this.scorevalue = scorevalue;
        this.timeleft = timeleft;
        Foods = new ArrayList<FoodCell>();

    }

    public void reduceTimeLeft(){
        if(timeleft >0){
            timeleft--;
        }
    }

    public boolean isTimeLeft(){
        if(timeleft==0){
            return true;
        }
        else {
            return false;
        }
    }



    public void setTimeLeftZero() {
        timeleft = 0;
    }


    public boolean isGoodFood(){
    if(scorevalue!=0){
        return true;
    }
        return false;
    }


    public ArrayList<FoodCell> getFoods(){
        return Foods;
    }

    public void add(FoodCell f){
        Foods.add(f);
    }


    @Override
    public int getX() {
        return super.getX();
    }

    @Override
    public int getY() {
        return super.getY();
    }
}
