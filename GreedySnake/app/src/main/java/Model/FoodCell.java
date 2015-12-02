package Model;

/**
 * Created by tiantianxie on 11/11/15.
 */

public class FoodCell extends CellObject{

    private  int pointValue;
    private  int growthValue;
    private int timeLeft;

    public FoodCell(int pointValue, int growthValue, int timeLeft, int x,
                          int y) {
        super(x, y);
        this.pointValue = pointValue;
        this.growthValue = growthValue;
        this.timeLeft = timeLeft;
    }
    public void reduceTimeLeft(){
        if (timeLeft > 0) {
            timeLeft--;
        }
    }

    /**
     * returns true if timeLeft is bigger than 0 or equal to -1.
     *
     * @return true if timeLeft is bigger than 0 or equal to -1
     */

        public boolean isTimeLeft() {
            return timeLeft > 0 || timeLeft == -1;
        }
<<<<<<< HEAD


    /**
     * returns value of the bonus (for the players score).
     *
     * @return value of the bonus (for the players score)
     */
    public int getPointValue(){
        return pointValue;
    }

    /**
     * returns amount by which the snake will grow if bonus is consumed.
     *
     * @return amount by which the snake will grow if bonus is consumed
     */
    public int getGrowthValue(){
        return growthValue;
    }
    /**
     * sets time left to zero so this bonus can be deleted in the next turn
     */
    public void setTimeLeftZero() {
        timeLeft = 0;
    }

    public boolean isGood() {
        if(pointValue!=0){
            return true;
        }
            return false;

=======


    /**
     * returns value of the bonus (for the players score).
     *
     * @return value of the bonus (for the players score)
     */
    public int getPointValue(){
        return pointValue;
    }

    /**
     * returns amount by which the snake will grow if bonus is consumed.
     *
     * @return amount by which the snake will grow if bonus is consumed
     */
    public int getGrowthValue(){
        return growthValue;
    }
    /**
     * sets time left to zero so this bonus can be deleted in the next turn
     */
    public void setTimeLeftZero() {
        timeLeft = 0;
>>>>>>> 3c7c2dec60874596a7de517c512e6c01009684d2
    }
}
