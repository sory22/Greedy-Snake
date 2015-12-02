package View;

/**
 * Created by tiantianxie on 11/11/15.
 */
public interface IGui {
    void setSnake(int x, int y);
<<<<<<< HEAD
    void setgoodFood(int x, int y);
    void setbadFood(int x, int y);
=======
    void setFood(int x, int y);
>>>>>>> 3c7c2dec60874596a7de517c512e6c01009684d2
    void setBorder(int x, int y);
    void setEmpty(int x, int y);
    void setScore(int score);
    void sendMessage(String message);
    void updateUI();


}
