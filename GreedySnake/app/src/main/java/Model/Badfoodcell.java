package Model;

/**
 * Created by tiantianxie on 11/12/15.
 */
public class Badfoodcell extends CellObject {
    private  int pointValue = 10;
    private  int growthValue = 3;
    private int timeLeft= 30;
    public Badfoodcell(int pointValue, int growthValue, int timeLeft, int x,
    int y){
        super(x,y);
        this.pointValue =pointValue;
        this.growthValue = growthValue;
    }
    public void reduceTimeLeft() {
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

    /**
     * returns value of the bonus (for the players score).
     *
     * @return value of the bonus (for the players score)
     */
    public int getPointValue() {
        return pointValue;
    }

    /**
     * returns amount by which the snake will grow if bonus is consumed.
     *
     * @return amount by which the snake will grow if bonus is consumed
     */
    public int getGrowthValue() {
        return growthValue;
    }

    /**
     * sets time left to zero so this bonus can be deleted in the next turn
     */
    public void setTimeLeftZero() {
        timeLeft = 0;
    }
}
