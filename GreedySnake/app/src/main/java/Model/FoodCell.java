package Model;



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


        public boolean isTimeLeft() {
            return timeLeft > 0 || timeLeft == -1;
        }


    public int getPointValue(){
        return pointValue;
    }

    public boolean isGood() {
        if (pointValue != 0) {
            return true;
        }
        return false;

    }

    public void setTimeLeftZero() {
        timeLeft = 0;

    }
}
