package Model;


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
