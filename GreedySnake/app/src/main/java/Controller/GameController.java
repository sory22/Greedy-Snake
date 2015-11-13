package Controller;

import Model.FoodCell;
import Model.GameField;
import Model.Snake;
import View.IGui;
import Model.CellObject;
import snake.Utilities;
/**
 * Created by tiantianxie on 11/11/15.
 */
public abstract class GameController {
    protected GameField gameField;
    protected Snake snake;
    private  InputController input;
    protected  IGui gui;
    private boolean playing = true;
    private int score;

    public GameController(IGui gui, InputController input){
        resetGame();
        this.gui = gui;
        this.input = input;
    }
/* constructs new game field and snake and resets score.*/
    public void resetGame(){
        gameField = new GameField(Utilities.getInstance().getWidth(), Utilities
                .getInstance().getHeight());
        gameField.setBorders();
        snake = new Snake(Utilities.getInstance().getWidth() / 2, Utilities
                .getInstance().getHeight() / 2);
        score =0;

    }

    protected void playOnce() {
        processInput(getInput());

        moveSnake();
        gui.sendMessage("boo!");
        addFood();
        gui.sendMessage("boo2!");
        checkFood();
        gameField.updateFood();

        if (isGameOver()) {
            playing = false;
            gui.sendMessage(" game over");
            //saveHighScore();
        }

        updateGui();
    }

    private boolean isGameOver() {
        CellObject head = snake.getHead();
        boolean walkable = gameField.isIsWalkable(head.getX(), head.getY());
        return !walkable || snake.isHit();
    }

    private void moveSnake() {
        snake.moveInCurrentDirection();
    }

    private void checkFood() {
        CellObject head = snake.getHead();
        FoodCell foodAt = gameField.getFoodposition(head.getX(), head.getY());
        if (foodAt != null) {
            score += snake.eat(foodAt);
        }
    }

    private void addFood() {
        if (gameField.hasNoFood()) {
            gameField.addfoods(100, 3, 30, snake);
        }
    }

    public abstract void updateGui();
    public abstract void play();
    public int getScore() {
        return score;
    }

    public boolean isPlaying() {
        return playing;
    }

    public void setIsPlaying() {
        playing = true;
    }

    public void stopPlaying() {
        playing = false;
    }
    public int getWidth() {
        return gameField.getWidth();
    }
    public int getHight() {
        return gameField.getHeight();
    }
    private int getInput() {
        return input.getInput();
    }
    private void processInput(int inputMove) {
        switch (inputMove) {
            case 1:
                snake.moveUp();
                break;
            case 2:
                snake.moveRight();
                break;
            case 3:
                snake.moveDown();
                break;
            case 4:
                snake.moveLeft();
                break;
            default:
                break;
        }
    }

}
