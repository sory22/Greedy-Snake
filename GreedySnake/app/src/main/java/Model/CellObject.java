package Model;

/**
 * Created by tiantianxie on 11/11/15.
 */
public class CellObject {
    private int x;
    private int y;
    public CellObject(int x, int y){
        this.x = x;
        this.y = y;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public void setX(int x){
        this.x=x;
    }
    public void setY(int y){
        this.y=y;
    }
}
