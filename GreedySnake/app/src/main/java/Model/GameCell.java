package Model;

import java.util.Random;

/**
 * Created by tiantianxie on 11/11/15.
 */
public class GameCell extends CellObject{


    private boolean isWalkable = true;
    public GameCell(int x, int y){
        super(x,y);

    }
    public boolean isIsWalkable()
    {
        return isWalkable;
    }
    public void setIsWalkable(boolean isWalkable) {
        this.isWalkable = isWalkable;
    }
}
