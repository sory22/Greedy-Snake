package Model;

/**
 * Created by tiantianxie on 11/11/15.
 */
public class GameCell extends CellObject{


    private boolean isWalkable;
    public GameCell(int x, int y){
        super(x,y);
        isWalkable = true;
    }
    public boolean isIsWalkable(){
        return isWalkable;
    }
    public void setIsWalkable(boolean isWalkable){
        this.isWalkable = isWalkable;
    }
}
