package View;

/**
 * Created by tiantianxie on 11/11/15.
 */
public interface IGui {
    void setSnake(int x, int y);
    void setFood(int x, int y);
    void setBorder(int x, int y);
    void setEmpty(int x, int y);
    void setScore(int score);
    void sendMessage(String message);
    void updateUI();


}