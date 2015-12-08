package View;

public interface IGui {
    void setSnake(int x, int y);
    void setgoodFood(int x, int y);
    void setbadFood(int x, int y);
    void setBorder(int x, int y);
    void setEmpty(int x, int y);
    void setScore(int score);
    void sendMessage(String message);
    void updateUI();


}
