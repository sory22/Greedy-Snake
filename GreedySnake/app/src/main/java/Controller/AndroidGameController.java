package Controller;


import Controller.GameController;
import Controller.InputController;
import View.IGui;
import android.os.Handler;
import snake.Utilities;
import View.IGui;
import android.os.Handler;
import snake.Utilities;
public class AndroidGameController extends GameController {

    private final Handler handler;
    public volatile boolean isPaused = false;

    public AndroidGameController(IGui gui, InputController input,
                                Handler handler) {
        super(gui, input);
        this.handler = handler;
    }

    int nextMove = -1;
    public void setNextMove(int i) {
        nextMove = i;
    }

    @Override
    public void play() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                handler.sendEmptyMessage(3);
                while (isPlaying()) {
                   try {
                       if (isPaused) {
                           synchronized (this) {
                               while (isPaused) {
                                  Thread.sleep(100);
                               }
                           }
                       }
                            playOnce();
                            handler.sendEmptyMessage(1);
                        } catch (Exception e) {

                        }
                        try {

                            Thread.sleep(Utilities.getInstance().getSpeed());


                        } catch (InterruptedException ex) {
                        }

                }
                handler.sendEmptyMessage(2);
            }
        }).start();
    }



    @Override
    public void updateGui() {

    }

    public int[] getSnakeHeadPosition() {
        int[] headPosition = new int[2];
        headPosition[0] = super.snake.getHead().getX();
        headPosition[1] = super.snake.getHead().getY();
        return headPosition;
    }


    public void externalUpdateGui() {
        if (Utilities.debug) {
            Utilities.print(gameField.toString());
        }

        for (int i = 0; i < gameField.getWidth(); i++) {
            for (int j = 0; j < gameField.getHeight(); j++) {
                if (!gameField.isIsWalkable(i, j)) {
                    gui.setBorder(i, j);

                } else if (gameField.getFoodposition(i, j) != null && gameField.getFoodposition(i, j).isGood()) {
                    gui.setgoodFood(i, j);

                }else if(gameField.getFoodposition(i, j) != null && !gameField.getFoodposition(i, j).isGood()){
                    gui.setbadFood(i,j);
                } else if (snake.isAt(i, j)) {

                    gui.setSnake(i, j);
                } else {
                    gui.setEmpty(i, j);
                }
            }
        }

        gui.setScore(super.getScore());
        gui.updateUI();
    }
}
