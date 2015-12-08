package Controller;

<<<<<<< HEAD
import Controller.GameController;
import Controller.InputController;
import View.IGui;
import android.os.Handler;
import snake.Utilities;

public class AndroidGameController extends GameController {

=======
/**
 * Created by tiantianxie on 11/11/15.
 */
import View.IGui;
import android.os.Handler;
import snake.Utilities;
public class AndroidGameController extends GameController {
>>>>>>> 3c7c2dec60874596a7de517c512e6c01009684d2
    private final Handler handler;

    public AndroidGameController(IGui gui, InputController input,
                                Handler handler) {
        super(gui, input);
        this.handler = handler;
    }

    int nextMove = -1;
<<<<<<< HEAD

    /**
     * sets the next move.
     * <p>
     * Only to be used if it is not possible to implement Inputcontroller.
     *
     * @param i
     */
=======
>>>>>>> 3c7c2dec60874596a7de517c512e6c01009684d2
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
<<<<<<< HEAD

=======
                    long executingTime = System.currentTimeMillis();
>>>>>>> 3c7c2dec60874596a7de517c512e6c01009684d2
                    try {
                        playOnce();
                        handler.sendEmptyMessage(1);
                    } catch (Exception e) {
                        // guihandler.sendEmptyMessage(2);
                    }
                    try {
<<<<<<< HEAD
                        Thread.sleep(Utilities.getInstance().getSpeed());
=======
                        Thread.sleep(Utilities.getInstance().getSpeed()
                                - (System.currentTimeMillis() - executingTime));
>>>>>>> 3c7c2dec60874596a7de517c512e6c01009684d2
                    } catch (InterruptedException ex) {
                    }
                }
                // send game over message
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

    /**
     * android does not want the gui to be updated in the main loop, so it gets
     * its own method.
     */
    public void externalUpdateGui() {
        if (Utilities.debug) {
            Utilities.print(gameField.toString());
        }

        for (int i = 0; i < gameField.getWidth(); i++) {
            for (int j = 0; j < gameField.getHeight(); j++) {
                if (!gameField.isIsWalkable(i, j)) {
                    gui.setBorder(i, j);
<<<<<<< HEAD
                } else if (gameField.getFoodposition(i, j) != null && gameField.getFoodposition(i, j).isGood() == true) {
                    gui.setgoodFood(i, j);

                }else if(gameField.getFoodposition(i, j) != null && gameField.getFoodposition(i, j).isGood() == false){
                    gui.setbadFood(i,j);
                }
                else if (snake.isAt(i, j)) {
=======
                } else if (gameField.getFoodposition(i, j) != null) {
                    gui.setFood(i, j);
                } else if (snake.isAt(i, j)) {
>>>>>>> 3c7c2dec60874596a7de517c512e6c01009684d2
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
