package snake;

<<<<<<< HEAD
import android.graphics.Color;
import android.media.MediaPlayer;

=======
>>>>>>> 3c7c2dec60874596a7de517c512e6c01009684d2
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;

/**
 * Created by tiantianxie on 11/12/15.
 */



public class Utilities implements Serializable {
     private static final long serialVersionUID = -8511088694802875554L;
    private static final String fileName = "settings";
    private static Utilities instance = null;

<<<<<<< HEAD

=======
>>>>>>> 3c7c2dec60874596a7de517c512e6c01009684d2
	/* SETTINGS */

    /** debug. */
    public static final boolean debug = false;

<<<<<<< HEAD
   // public enum SPEED {
     //    SLOW, AVERAGE, FAST
    //}

  //  private static final int VERY_SLOW = 1000; // very slow
   // private static final int SLOW = 1000; // slow
    //private static final int AVERAGE = 300; // average
    //private static final int FAST = 30; // fast
   // private static final int VERY_FAST = 50; // really fast
    /* number of different speeds. */
    //public static final int SPEED_LEVEL = 5;

    /** pause between game loops. */
    private int current_speed;
    private int DifficultyMode;
=======
    public enum SPEED {
        VERY_SLOW, SLOW, AVERAGE, FAST, VERY_FAST
    }

    private static final int VERY_SLOW = 1000; // very slow
    private static final int SLOW = 500; // slow
    private static final int AVERAGE = 250; // average
    private static final int FAST = 100; // fast
    private static final int VERY_FAST = 50; // really fast
    /* number of different speeds. */
    public static final int SPEED_LEVEL = 5;

    /** pause between game loops. */
    private int current_speed = AVERAGE;
>>>>>>> 3c7c2dec60874596a7de517c512e6c01009684d2

    private int bonusExistTime = 30;
    private int bonusGrows = 3;
    private int bonusValue = 100;

<<<<<<< HEAD
    private String playerName;

=======
    private String playerName = "TestPlayer";
>>>>>>> 3c7c2dec60874596a7de517c512e6c01009684d2

    private int width = 20;
    private int height = 20;

    private int numberOfHighScores = 10;
<<<<<<< HEAD
    private int nCurrColor = 0;


    private MediaPlayer mp;
=======
>>>>>>> 3c7c2dec60874596a7de517c512e6c01009684d2

    private Utilities() {
    }

    public static Utilities getInstance() {
        if (instance == null) { // first call
            instance = loadSettings();
            if (instance == null) { // could not load settings
                instance = new Utilities();
            }
        }
        return instance;
    }

<<<<<<< HEAD


    public int getColor() { return nCurrColor; }
    public void setColor(int c) { nCurrColor = c; }

    public int getSpeed() {
        if(DifficultyMode==0){
            current_speed = 1000;
        }else if(DifficultyMode == 1){
            current_speed = 500;
        }else {
            current_speed = 250;
        }
        return current_speed;

    }

    public void setDifficultyMode(int difficultyMode){
        DifficultyMode = difficultyMode;
=======
    public void setSpeed(SPEED speed) {
        switch (speed) {
            case VERY_SLOW:
                current_speed = VERY_SLOW;
                break;
            case SLOW:
                current_speed = SLOW;
                break;
            case AVERAGE:
                current_speed = AVERAGE;
                break;
            case FAST:
                current_speed = FAST;
                break;
            case VERY_FAST:
                current_speed = VERY_FAST;
                break;
            default:
                current_speed = AVERAGE;
                break;
        }
    }

    public SPEED transformSpeedLevel(int speed) {
        switch (speed) {
            case 1:
                return SPEED.VERY_SLOW;
            case 2:
                return SPEED.SLOW;
            case 3:
                return SPEED.AVERAGE;
            case 4:
                return SPEED.FAST;
            case 5:
                return SPEED.VERY_FAST;
            default:
                return SPEED.AVERAGE;
        }
    }

    public int transformSpeedLevel(SPEED speed) {
        switch (speed) {
            case VERY_SLOW:
                return 1;
            case SLOW:
                return 2;
            case AVERAGE:
                return 3;
            case FAST:
                return 4;
            case VERY_FAST:
                return 5;
            default:
                return 3;
        }
    }

    public SPEED getSpeedLevel() {
        switch (current_speed) {
            case VERY_SLOW:
                return SPEED.VERY_SLOW;
            case SLOW:
                return SPEED.SLOW;
            case AVERAGE:
                return SPEED.AVERAGE;
            case FAST:
                return SPEED.FAST;
            case VERY_FAST:
                return SPEED.VERY_FAST;
            default:
                return SPEED.AVERAGE;
        }
    }

    public int getSpeed() {
        return current_speed;
>>>>>>> 3c7c2dec60874596a7de517c512e6c01009684d2
    }

    /**
     * @return the bonusExistTime
     */
    public int getBonusExistTime() {
        return bonusExistTime;
    }

    /**
     * @param bonusExistTime
     *            the bonusExistTime to set
     */
    public void setBonusExistTime(int bonusExistTime) {
        this.bonusExistTime = bonusExistTime;
    }

    /**
     * @return the bonusGrows
     */
    public int getBonusGrows() {
        return bonusGrows;
    }

    /**
     * @param bonusGrows
     *            the bonusGrows to set
     */
    public void setBonusGrows(int bonusGrows) {
        this.bonusGrows = bonusGrows;
    }

    /**
     * @return the bonusValue
     */
    public int getBonusValue() {
        return bonusValue;
    }

    /**
     * @param bonusValue
     *            the bonusValue to set
     */
    public void setBonusValue(int bonusValue) {
        this.bonusValue = bonusValue;
    }

    /**
     * @return the playerName
     */
    public String getPlayerName() {
        return playerName;
    }

    /**
     * @param playerName
     *            the playerName to set
     */
    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    /**
     * @return the width
     */
<<<<<<< HEAD

    public void setSound(boolean sound){

    }
=======
>>>>>>> 3c7c2dec60874596a7de517c512e6c01009684d2
    public int getWidth() {
        return width;
    }

    /**
     * @param width
     *            the width to set
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * @return the height
     */
    public int getHeight() {
        return height;
    }

    /**
     * @param height
     *            the height to set
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * @return the numberOfHighScores
     */
    public int getNumberOfHighScores() {
        return numberOfHighScores;
    }

    /**
     * @param numberOfHighScores
     *            the numberOfHighScores to set
     */
    public void setNumberOfHighScores(int numberOfHighScores) {
        this.numberOfHighScores = numberOfHighScores;
    }

    public static void saveSettings() {
        ObjectOutputStream oop = null;
        OutputStream os = null;
        try {
            os = new FileOutputStream(fileName);
            oop = new ObjectOutputStream(os);
            oop.writeObject(instance);
        } catch (IOException ex) {
            print("saveSettings: " + ex);
        } finally {
            if (oop != null) {
                try {
                    oop.close();
                } catch (IOException ex) {
                }
            }
            if (os != null) {
                try {
                    os.close();
                } catch (IOException ex) {
                }
            }
        }
    }

    private static Utilities loadSettings() {
        InputStream is = null;
        ObjectInputStream ois = null;
        try {
            is = new FileInputStream(fileName);
            ois = new ObjectInputStream(is);
            return (Utilities) ois.readObject();
        } catch (FileNotFoundException fnf) {
            print("loadSettings (file not found): " + fnf);
            saveSettings();
        } catch (Exception ioe) {
            print("loadSettings: " + ioe);
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException ex) {
                }
            }
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException ex) {
                }
            }
        }
        return null;
    }

    /**
     * prints to sto.
     *
     * @param s
     *            string
     */
    public static void print(String s) {
        System.out.println(s);
    }

    public static void main(String[] args) {

        Utilities.print(Utilities.getInstance().getPlayerName());
        Utilities.getInstance().setPlayerName("bla");
        Utilities.print(Utilities.getInstance().getPlayerName());
        Utilities.getInstance().setPlayerName("other bla");
        Utilities.saveSettings();
        Utilities.print(Utilities.getInstance().getPlayerName());

    }
}


